package net.hhdsj.changed_creatures.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.hhdsj.changed_creatures.entity.simple.ThrownCrystalJavelinTrident;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class CrystalJavelinTridentItem extends TridentItem {

    private final Multimap<Attribute, AttributeModifier> customModifiers;

    public CrystalJavelinTridentItem(Properties properties) {
        super(properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        // 自定义伤害：比如 10.0
        builder.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 10.0, AttributeModifier.Operation.ADDITION));
        // 自定义攻速：比如 -2.4（值越大攻击越快，-2.9 很慢）
        builder.put(Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.4, AttributeModifier.Operation.ADDITION));
        this.customModifiers = builder.build();
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (!(entity instanceof Player player)) return;

        int useDuration = this.getUseDuration(stack) - timeLeft;
        if (useDuration < 10) return; // 蓄力不足 10 tick，不投掷

        int riptideLevel = EnchantmentHelper.getRiptide(stack);

        // 激流附魔只在水中/雨中生效
        if (riptideLevel > 0 && !player.isInWaterOrRain()) return;

        if (!level.isClientSide) {
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(entity.getUsedItemHand()));

            if (riptideLevel == 0) {
                // === 关键修改：这里生成你自己的实体 ===
                ThrownCrystalJavelinTrident trident = new ThrownCrystalJavelinTrident(level, player, stack);
                trident.shootFromRotation(player,
                        player.getXRot(),
                        player.getYRot(),
                        0.0F,
                        2.5F,   // 原版速度
                        1.0F    // 偏移
                );

                if (player.getAbilities().instabuild) {
                    trident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }

                level.addFreshEntity(trident);
                level.playSound(null, trident, SoundEvents.TRIDENT_THROW,
                        SoundSource.PLAYERS, 1.0F, 1.0F);

                if (!player.getAbilities().instabuild) {
                    player.getInventory().removeItem(stack);
                }
            }
        }

        player.awardStat(Stats.ITEM_USED.get(this));

        // 处理激流冲刺（保持原版逻辑，或者你也可以自定义）
        if (riptideLevel > 0) {
            // ... 这里的激流冲刺逻辑你可以直接复用原版的
            float yRot = player.getYRot();
            float xRot = player.getXRot();
            float x = -Mth.sin(yRot * 0.017453292F) * Mth.cos(xRot * 0.017453292F);
            float y = -Mth.sin(xRot * 0.017453292F);
            float z = Mth.cos(yRot * 0.017453292F) * Mth.cos(xRot * 0.017453292F);
            float magnitude = Mth.sqrt(x * x + y * y + z * z);
            float power = 3.0F * ((1.0F + (float) riptideLevel) / 4.0F);
            x *= power / magnitude;
            y *= power / magnitude;
            z *= power / magnitude;
            player.push(x, y, z);
            player.startAutoSpinAttack(20);
            if (player.onGround()) {
                player.move(MoverType.SELF, new Vec3(0.0, 1.1999999F, 0.0));
            }
            // 音效
            SoundEvent sound = switch (riptideLevel) {
                case 3 -> SoundEvents.TRIDENT_RIPTIDE_3;
                case 2 -> SoundEvents.TRIDENT_RIPTIDE_2;
                default -> SoundEvents.TRIDENT_RIPTIDE_1;
            };
            level.playSound(null, player, sound, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.customModifiers : super.getDefaultAttributeModifiers(slot);
    }
}
