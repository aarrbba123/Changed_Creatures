package net.hhdsj.goodblock.init;

import net.minecraft.world.level.GameRules;

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

    public static void init() {}
}
