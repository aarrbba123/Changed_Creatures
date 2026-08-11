/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 *                  附魔类
 */
package net.hhdsj.changed_creatures.init;

import net.hhdsj.changed_creatures.Enchantments.LatexAttackEnchantments;
import net.hhdsj.changed_creatures.Enchantments.ThreeMonthArrowEnchantments;
import net.hhdsj.changed_creatures.ChangedCreature;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ChangedCreatureModEnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,  ChangedCreature.MODID);
    //LatexAttackEnchantments
    public static final RegistryObject<ThreeMonthArrowEnchantments> ThreeMonthArrow = ENCHANTMENTS.register("three_month_latex", ThreeMonthArrowEnchantments::new);
    public static final RegistryObject<LatexAttackEnchantments> LatexAttack = ENCHANTMENTS.register("latex_attack", LatexAttackEnchantments::new);
}
