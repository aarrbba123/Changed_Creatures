package net.hhdsj.goodblock.entity;

import net.hhdsj.goodblock.init.GoodblockModItems;
import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

public class CrystalArrow extends AbstractArrow {
    public CrystalArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public CrystalArrow(Level level, LivingEntity shooter) {
        super(GoodblockModEntities.CRYSTAL_ARROW.get(), shooter, level);
    }


    @Override
    protected ItemStack getPickupItem() {
        return null;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}