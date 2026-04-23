package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.GoodblockMod;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GoodBlockModGameRules {
    public static final GameRules.Key<GameRules.BooleanValue> TEST_RULE;

    // 静态初始化块中注册
    static {
        TEST_RULE = GameRules.register(
                "goodblock:test",
                GameRules.Category.MISC,             // 分类
                GameRules.BooleanValue.create(false) // 默认值
        );
    }
}
