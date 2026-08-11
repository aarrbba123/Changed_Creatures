package net.hhdsj.changed_creatures.entity.simple;

import net.hhdsj.changed_creatures.init.ChangedCreatureModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.entity.beast.AbstractLatexWolf;
import net.ltxprogrammer.changed.init.ChangedAttributes;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.PlayMessages;

import java.util.Objects;

public class LatexEtanKindEntity extends AbstractLatexWolf {

    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        Objects.requireNonNull(attributes.getInstance(Attributes.MOVEMENT_SPEED)).setBaseValue(1.16);
        Objects.requireNonNull(attributes.getInstance(Attributes.MAX_HEALTH)).setBaseValue(36);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.SWIM_SPEED.get())).setBaseValue(1.1);
    }

    public LatexEtanKindEntity(EntityType<? extends AbstractLatexWolf> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.ABSORPTION ;
    }

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#3c6a7d");
    }

    public LatexEtanKindEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(ChangedCreatureModEntities.LATEX_ETAN_KIND.get(), world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = ChangedEntity.createLatexAttributes();
        builder.add(ChangedAttributes.TRANSFUR_DAMAGE.get(), 3);
        builder = builder.add(Attributes.JUMP_STRENGTH, 1.5);
        builder = builder.add(ChangedAttributes.TRANSFUR_DAMAGE.get(), 3.0);
        builder = builder.add(ChangedAttributes.SPRINT_SPEED.get(), 1.0);
        builder = builder.add(ChangedAttributes.SNEAK_SPEED.get(), 1.0);
        builder = builder.add(ChangedAttributes.AIR_CAPACITY.get(), 15.0);
        builder = builder.add(ChangedAttributes.FALL_RESISTANCE.get(), 1.0);
        return builder;
    }
}