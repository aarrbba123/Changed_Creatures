package net.hhdsj.goodblock.entity.simple;

import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;

public class LatexLuoLongDragonSharkEntity extends ChangedEntity {


    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(1.05);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.5);
        attributes.getInstance(Attributes.MAX_HEALTH).setBaseValue(40);
    }

    public LatexLuoLongDragonSharkEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#ffda00");
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public LatexLuoLongDragonSharkEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(GoodblockModEntities.LATEXIQGOLDDRAGON.get(), world);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }
}
