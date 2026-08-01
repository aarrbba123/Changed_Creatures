package net.hhdsj.goodblock.Enchantments;

import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class LatexAttackEnchantments extends Enchantment {
    public LatexAttackEnchantments() {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    public void doPostAttack(@NotNull LivingEntity attacker, @NotNull Entity target, int level) {

        if (target instanceof Player player) {
            if (ProcessTransfur.isPlayerTransfurred(player)) {
                float currentProgress = ProcessTransfur.getPlayerTransfurProgress(player);
                if (currentProgress < 1.0f) {
                    ProcessTransfur.setPlayerTransfurProgress(player, Math.min(1.0f, currentProgress + 0.1f * level));
                }
            }
        }
        super.doPostAttack(attacker, target, level);
    }
}
