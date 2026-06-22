package net.hhdsj.goodblock.world.inventory;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;
import net.hhdsj.goodblock.network.GoodblockModVariables;
import net.hhdsj.goodblock.util.PlayerDataGetHelper;

import com.mojang.blaze3d.systems.RenderSystem;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class CrystalJellyInfectionOverlay {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(ScreenEvent.Render.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player == null) return;

        GoodblockModVariables.PlayerVariables data = PlayerDataGetHelper.get(player);

        if (!data.Crystal_Jelly_Infection) return;

        float infectionProgress = data.Crystal_Jelly_Infection_Progress;
        if (infectionProgress <= 0f) return;

        // 获取屏幕尺寸
        int screenWidth = event.getScreen().width;
        int screenHeight = event.getScreen().height;

        // 计算透明度 (0-255)
        int alpha = (int) (Math.min(1.0f, infectionProgress / 100.0f) * 255);

        // 计算颜色分量 (0-255)
        int red = (int) ((infectionProgress / 100.0f) * 0.5f * 255);
        int green = (int) ((0.5f + (infectionProgress / 100.0f) * 0.5f) * 255);
        int blue = (int) ((0.8f + (infectionProgress / 100.0f) * 0.2f) * 255);

        // 组合成 ARGB 格式
        int color = (alpha << 24) | (red << 16) | (green << 8) | blue;

        // 设置渲染状态
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);

        // 绘制全屏纯色矩形
        event.getGuiGraphics().fill(0, 0, screenWidth, screenHeight, color);

        // 重置渲染状态
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }
}