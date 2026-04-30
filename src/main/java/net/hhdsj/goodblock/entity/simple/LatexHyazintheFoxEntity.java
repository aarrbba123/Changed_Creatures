package net.hhdsj.goodblock.entity.simple;

import net.foxyas.changedaddon.entity.advanced.AbstractKitsuneEntity;
import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.Gender;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.PlayMessages;

import java.util.Objects;

public class LatexHyazintheFoxEntity extends AbstractKitsuneEntity {
    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        Objects.requireNonNull(attributes.getInstance(Attributes.MOVEMENT_SPEED)).setBaseValue(1.1);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.SWIM_SPEED.get())).setBaseValue(0.85);
        Objects.requireNonNull(attributes.getInstance(Attributes.MAX_HEALTH)).setBaseValue(40);
    }

    public LatexHyazintheFoxEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public LatexHyazintheFoxEntity(PlayMessages.SpawnEntity ignoredPacket, Level world) {
        this(GoodblockModEntities.LATEX_HYAZINTHE_FOX.get(), world);
    }

    public Gender getGender() {
        return Gender.MALE;
    }
}
