package net.hhdsj.goodblock.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.hhdsj.goodblock.GoodblockMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockModVariables {

	public static double _Progress = 0;

	// ========== 网络初始化 ==========
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		GoodblockMod.addNetworkMessage(PlayerVariablesSyncMessage.class,
				PlayerVariablesSyncMessage::buffer,
				PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	// 注册能力类型
	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	// ========== 能力定义 ==========
	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY =
			CapabilityManager.get(new CapabilityToken<PlayerVariables>() {});

	// ========== 玩家数据类 ==========
	public static class PlayerVariables {
		public double Player_die = 0.0;           // 死亡次数
		public long Player_Infection_tick = 0;    // 感染刻数
		public Float Crystal_Jelly_Infection_Progress = 0f;
		public boolean Crystal_Jelly_Infection = false;
		public boolean Player_Is_Infection = false;

		// 同步到客户端
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				GoodblockMod.PACKET_HANDLER.send(
						PacketDistributor.PLAYER.with(() -> serverPlayer),
						new PlayerVariablesSyncMessage(this));
		}

		// 保存到NBT
		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Player_die", Player_die);
			nbt.putLong("Player_Infection_tick", Player_Infection_tick);
			nbt.putBoolean("Player_Is_Infection", Player_Is_Infection);
			nbt.putFloat("Crystal_Jelly_Infection_Progress", Crystal_Jelly_Infection_Progress);
			nbt.putBoolean("Crystal_Jelly_Infection", Crystal_Jelly_Infection);
			return nbt;
		}

		// 从NBT读取
		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Player_die = nbt.getDouble("Player_die");
			Player_Infection_tick = nbt.getLong("Player_Infection_tick");
			Player_Is_Infection = nbt.getBoolean("Player_Is_Infection");
			Crystal_Jelly_Infection_Progress = nbt.getFloat("Crystal_Jelly_Infection_Progress");
			Crystal_Jelly_Infection = nbt.getBoolean("Crystal_Jelly_Infection");
		}
	}

	// ========== 能力提供者 ==========
	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {

		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("goodblock", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	// ========== 事件处理器 ==========
	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {

		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		// 玩家克隆时复制数据
		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();

			PlayerVariables original = event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables());
			PlayerVariables clone = event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables());

			clone.Player_die = original.Player_die;
			clone.Player_Infection_tick = original.Player_Infection_tick;
			clone.Player_Is_Infection = original.Player_Is_Infection;
		}
	}

	// ========== 网络同步消息 ==========
	public static class PlayerVariablesSyncMessage {

		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = Minecraft.getInstance().player
							.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables());
					variables.Player_die = message.data.Player_die;
					variables.Player_Infection_tick = message.data.Player_Infection_tick;
					variables.Player_Is_Infection = message.data.Player_Is_Infection;
				}
			});
			context.setPacketHandled(true);
		}
	}
}