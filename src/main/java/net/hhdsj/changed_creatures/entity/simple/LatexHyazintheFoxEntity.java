package net.hhdsj.changed_creatures.entity.simple;

import net.foxyas.changedaddon.entity.advanced.AbstractKitsuneEntity;
import net.hhdsj.changed_creatures.init.ChangedCreatureModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.Gender;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.util.Color3;
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

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#FF62FF");
    }

    public LatexHyazintheFoxEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public LatexHyazintheFoxEntity(PlayMessages.SpawnEntity ignoredPacket, Level world) {
        this(ChangedCreatureModEntities.LATEX_HYAZINTHE_FOX.get(), world);
    }

    public Gender getGender() {
        return Gender.MALE;
    }
}
