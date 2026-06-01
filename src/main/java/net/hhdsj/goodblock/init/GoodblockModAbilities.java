/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 *                  变体能力
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.abilities.BetterHypnosisAbility;
import net.hhdsj.goodblock.abilities.CreateBlueCrystalEntityAbility;
import net.hhdsj.goodblock.abilities.ShootCrystalArrowAbility;
import net.hhdsj.goodblock.abilities.TurnFeraLatexDarkPurpleAbility;
import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.ability.*;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GoodblockModAbilities{
    public static final DeferredRegister<AbstractAbility<?>> REGISTRY = ChangedRegistry.ABILITY.createDeferred(GoodblockMod.MODID);
    public static RegistryObject<TurnFeraLatexDarkPurpleAbility> TURN_FERA_LATEX_DARK_PURPLE;
    public static RegistryObject<SimpleCreateItemAbility> CREATE_DRAGON_FRUIT;
    public static RegistryObject<BetterHypnosisAbility> BERRER_HYPNOSIE;
    public static RegistryObject<CreateBlueCrystalEntityAbility> CREATEBLUECRYSTALENTITYABILITY;
    public static RegistryObject<ShootCrystalArrowAbility> SHOOT_CRYSTAL_ARROW;


    static {
        CREATEBLUECRYSTALENTITYABILITY = REGISTRY.register("create_blue_crystal", CreateBlueCrystalEntityAbility::new);
        //更好的眩晕
        BERRER_HYPNOSIE = REGISTRY.register("better_hypnosie", BetterHypnosisAbility::new);
        //变体切换
        TURN_FERA_LATEX_DARK_PURPLE = REGISTRY.register("turn_fera_latex_dark_purple", TurnFeraLatexDarkPurpleAbility::new);
        //创作火龙果
        CREATE_DRAGON_FRUIT = REGISTRY.register("create_dragon_fruit", () -> new SimpleCreateItemAbility(() -> new ItemStack(GoodblockModItems.DRAGONFRUIT.get()), 1.0f, 1.0f));
        //水晶箭
        SHOOT_CRYSTAL_ARROW = REGISTRY.register("shoot_crystal_arrow", ShootCrystalArrowAbility::new);
    }

    public static AbstractAbility<?> getAbility(ResourceLocation location) {
        return ChangedRegistry.ABILITY.get().getValue(location);
    }
}