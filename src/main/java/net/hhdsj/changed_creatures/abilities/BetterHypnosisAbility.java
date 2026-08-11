package net.hhdsj.changed_creatures.abilities;

import net.ltxprogrammer.changed.ability.HypnosisAbility;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.WeakHashMap;
import java.util.Map;

public class BetterHypnosisAbility extends HypnosisAbility {
    static final Map<LivingEntity, Long> ACTIVE_USERS = new WeakHashMap<>();
    private static final double DAMAGE_BLOCK_RANGE = 15.0D;
    private static final boolean BLOCK_PLAYER_DAMAGE = true;
    private static final boolean BLOCK_PROJECTILE_DAMAGE = true;

    public BetterHypnosisAbility() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void tick(IAbstractChangedEntity entity) {
        LivingEntity self = entity.getEntity();
        Level level = entity.getLevel();

        ACTIVE_USERS.put(self, level.getGameTime());
        super.tick(entity);
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        if (!BLOCK_PLAYER_DAMAGE) return;
        if (isAbilityUser(event.getEntity()) && event.getSource().getEntity() instanceof Player) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (!BLOCK_PLAYER_DAMAGE) return;
        if (isAbilityUser(event.getEntity()) && event.getSource().getEntity() instanceof Player) {
            var entity = event.getEntity();
            hurt_entity_effect(entity);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onProjectileImpact(ProjectileImpactEvent event) {
        if (!BLOCK_PROJECTILE_DAMAGE) return;
        Projectile projectile = event.getProjectile();
        if (projectile.getOwner() instanceof Player &&
                event.getRayTraceResult().getType() == net.minecraft.world.phys.HitResult.Type.ENTITY) {

            net.minecraft.world.phys.EntityHitResult entityResult =
                    (net.minecraft.world.phys.EntityHitResult) event.getRayTraceResult();

            if (entityResult.getEntity() instanceof LivingEntity target && isAbilityUser(target) && target.distanceTo(projectile) <= DAMAGE_BLOCK_RANGE) {
                hurt_entity_effect((LivingEntity) projectile.getOwner());
            }
        }
    }

    private boolean isAbilityUser(LivingEntity entity) {
        if (!ACTIVE_USERS.containsKey(entity)) return false;
        Level level = entity.level();
        return level.getGameTime() - ACTIVE_USERS.get(entity) <= 5;
    }

    public void hurt_entity_effect(LivingEntity entity) {
        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 6000, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 420, 2));
    }
}