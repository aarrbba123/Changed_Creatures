
package net.hhdsj.goodblock.entity.simple;


import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.util.Color3;

import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.Difficulty;
import net.minecraft.network.protocol.Packet;

import net.minecraftforge.common.ForgeMod;

import java.util.Objects;

import net.hhdsj.goodblock.init.GoodblockModEntities;

@Mod.EventBusSubscriber
public class LatexOrangeFoxEntity extends ChangedEntity {
	@Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        Objects.requireNonNull(attributes.getInstance(Attributes.MOVEMENT_SPEED)).setBaseValue(1.1);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.SWIM_SPEED.get())).setBaseValue(0.93);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }

	@Override
    public HairStyle getDefaultHairStyle() {
        return HairStyle.SHORT_MESSY.get();
    }

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#FF8001");
    }

	public LatexOrangeFoxEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(GoodblockModEntities.LATEX_ORANGE_FOX.get(), world);
	}

	public LatexOrangeFoxEntity(EntityType<LatexOrangeFoxEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	public static void init() {
		SpawnPlacements.register(GoodblockModEntities.LATEX_ORANGE_FOX.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}
}
