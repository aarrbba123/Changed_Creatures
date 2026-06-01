package net.hhdsj.goodblock.client.renderer.projectile;

import net.hhdsj.goodblock.entity.CrystalArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class CrystalArrowRenderer extends ArrowRenderer<CrystalArrow> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/projectiles/arrow.png");

    public CrystalArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalArrow entity) {
        return TEXTURE;
    }
}