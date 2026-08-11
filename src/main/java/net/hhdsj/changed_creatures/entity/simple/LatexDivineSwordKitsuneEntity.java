package net.hhdsj.changed_creatures.entity.simple;

import net.foxyas.changedaddon.entity.advanced.AbstractKitsuneEntity;
import net.hhdsj.changed_creatures.init.ChangedCreatureModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.Gender;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.PlayMessages;

import java.util.Objects;

public class LatexDivineSwordKitsuneEntity extends AbstractKitsuneEntity {
    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        Objects.requireNonNull(attributes.getInstance(Attributes.MOVEMENT_SPEED)).setBaseValue(1.1);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.SWIM_SPEED.get())).setBaseValue(1.1);
    }

    public LatexDivineSwordKitsuneEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public LatexDivineSwordKitsuneEntity(PlayMessages.SpawnEntity ignoredPacket, Level world) {
        this(ChangedCreatureModEntities.LATEX_DIVINE_SWORD_KITSUNE.get(), world);
    }

    public Gender getGender() {
        return Gender.MALE;
    }
}
