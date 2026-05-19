package net.hhdsj.goodblock.entity;

import net.hhdsj.goodblock.init.GoodblockModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;

public class ThrownCrystalJavelinTrident extends ThrownTrident {

    // 构造器 A：用于实体注册，Forge 要求必须有
    public ThrownCrystalJavelinTrident(EntityType<? extends ThrownCrystalJavelinTrident> type, Level level) {
        super(type, level);
    }

    // 构造器 B：玩家投掷时调用
    public ThrownCrystalJavelinTrident(Level level, LivingEntity shooter, ItemStack thrownStack) {
        super(level, shooter, thrownStack);
    }

     @Override
     protected void onHitEntity(@NotNull EntityHitResult result) {
         // 在这里添加自定义逻辑
         super.onHitEntity(result);
    }
}