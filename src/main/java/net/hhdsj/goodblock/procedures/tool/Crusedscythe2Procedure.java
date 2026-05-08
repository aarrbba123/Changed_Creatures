package net.hhdsj.goodblock.procedures.tool;

import net.hhdsj.goodblock.init.GoodblockModItems;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;



public class Crusedscythe2Procedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		//进行判断实体是否为null
		if (entity == null) {
			return false;
		}

		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GoodblockModItems.CURSED_SCYTHE.get() && entity.isShiftKeyDown()) {
			//给自己伤害15,凋零
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.WITHER)), 15);

			for (Entity entityiterator : world.getEntities(entity, new AABB((x - 7), (y - 7), (z - 7), (x + 7), (y + 7), (z + 7)))) {
				if (entity instanceof LivingEntity _entity){
					_entity.swing(InteractionHand.MAIN_HAND, true);
					}
				entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.WITHER_SKULL)), 80);
				//在实体上创建闪电实体
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                    if (entityToSpawn != null) {
                        entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
                    }
					//设置为无伤害
                    entityToSpawn.setVisualOnly(true);
					//实体生成
					_level.addFreshEntity(entityToSpawn);
				}
				//消耗提供物品的耐久
				if (itemstack.hurt(1, RandomSource.create(), null)) {
					itemstack.shrink(1);
					itemstack.setDamageValue(0);
				}
			}
			//给物品400tick的冷却
			if (entity instanceof Player _player) {
				_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
			}
		}
		//成功运行返回true
		return true;
	}
}