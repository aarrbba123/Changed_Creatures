package net.hhdsj.goodblock.init;

import net.minecraft.world.level.GameRules;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.hhdsj.goodblock.GoodblockMod;

@Mod.EventBusSubscriber(modid = GoodblockMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodBlockModGameRules {

    public static GameRules.Key<GameRules.BooleanValue> TEST_RULE;

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            TEST_RULE = GameRules.register(
                    "goodblock:test",
                    GameRules.Category.MISC,
                    GameRules.BooleanValue.create(false)
            );
        });
    }

    public static void init() {}
}