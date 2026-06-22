package net.hhdsj.goodblock.entity;

import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.hhdsj.goodblock.util.ProgressTransfurExt;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.client.model.PufferfishMidModel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

public class LatexFishEntity extends ChangedEntity {

    public LatexFishEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
        this(GoodblockModEntities.LATEX_FISH.get(), level);
    }

    public LatexFishEntity(EntityType<? extends ChangedEntity> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new FishMoveControl(this);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.NONE;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, true));
        this.goalSelector.addGoal(4, new FishSwimGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true) {
            @Override
            public boolean canUse() {
                LivingEntity target = this.target;
                if (target == null) return false;
                if (!(target instanceof Player player)) return false;
                TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
                if (variant != null) return false;
                return super.canUse();
            }
        });
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 1.2D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.ATTACK_SPEED, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hurt = super.doHurtTarget(target);
        if (hurt && target instanceof Player player) {
            TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
            if (variant == null) {
                ProgressTransfurExt.tf(player, 2.0f, "goodblock:form_latex_frost_scale_dragon_taur", TransfurCause.FACE_HAZARD);
                player.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));
            }
        }
        return hurt;
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new WaterBoundPathNavigation(this, level);
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.01F, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }
    }

    @Override
    public void aiStep() {
        if (!this.isInWater() && this.onGround() && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add(
                    (this.random.nextFloat() * 2.0F - 1.0F) * 0.05F,
                    0.4D,
                    (this.random.nextFloat() * 2.0F - 1.0F) * 0.05F
            ));
            this.setOnGround(false);
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }
        super.aiStep();
    }

    protected boolean canRandomSwim() {
        return true;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.COD_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    static class FishMoveControl extends MoveControl {
        private final LatexFishEntity fish;

        FishMoveControl(LatexFishEntity fish) {
            super(fish);
            this.fish = fish;
        }

        @Override
        public void tick() {
            if (this.fish.isEyeInFluid(FluidTags.WATER)) {
                this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
            }

            if (this.operation == MoveControl.Operation.MOVE_TO && !this.fish.getNavigation().isDone()) {
                float speed = (float) (this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.fish.setSpeed(Mth.lerp(0.125F, this.fish.getSpeed(), speed));

                double d0 = this.wantedX - this.fish.getX();
                double d1 = this.wantedY - this.fish.getY();
                double d2 = this.wantedZ - this.fish.getZ();

                if (d1 != 0.0D) {
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, this.fish.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
                }

                if (d0 != 0.0D || d2 != 0.0D) {
                    float yRot = (float) (Mth.atan2(d2, d0) * (180F / (float) Math.PI)) - 90.0F;
                    this.fish.setYRot(this.rotlerp(this.fish.getYRot(), yRot, 90.0F));
                    this.fish.yBodyRot = this.fish.getYRot();
                }
            } else {
                this.fish.setSpeed(0.0F);
            }
        }
    }

    static class FishSwimGoal extends RandomSwimmingGoal {
        private final LatexFishEntity fish;

        public FishSwimGoal(LatexFishEntity fish) {
            super(fish, 1.0D, 40);
            this.fish = fish;
        }

        @Override
        public boolean canUse() {
            return this.fish.canRandomSwim() && super.canUse();
        }
    }
}