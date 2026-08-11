package net.hhdsj.changed_creatures.entity.simple;

import net.hhdsj.changed_creatures.init.ChangedCreatureModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.Gender;
import net.ltxprogrammer.changed.entity.beast.AbstractPooltoy;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.PlayMessages;

import java.util.Objects;

public class LatexEnkangDragonSharkEntity extends AbstractPooltoy {

    public static final float SCALE = 1.3F;
    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        Objects.requireNonNull(attributes.getInstance(Attributes.MOVEMENT_SPEED)).setBaseValue(1.1);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.SWIM_SPEED.get())).setBaseValue(1.1);
        Objects.requireNonNull(attributes.getInstance(Attributes.MAX_HEALTH)).setBaseValue(10);
        Objects.requireNonNull(attributes.getInstance(Attributes.ARMOR)).setBaseValue(5);
    }

    public LatexEnkangDragonSharkEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public LatexEnkangDragonSharkEntity(PlayMessages.SpawnEntity ignoredPacket, Level world) {
        this(ChangedCreatureModEntities.LATEX_ENKANG_DRAGON_SHARK.get(), world);
    }

    public Gender getGender() {
        return Gender.MALE;
    }
}
