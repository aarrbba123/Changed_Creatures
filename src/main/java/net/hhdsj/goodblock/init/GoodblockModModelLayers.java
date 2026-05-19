package net.hhdsj.goodblock.init;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class GoodblockModModelLayers {
    // 模型层位置（放在普通的工具类中，而不是Mixin中）
    public static final ModelLayerLocation TAIL_LAYER =
            new ModelLayerLocation(new ResourceLocation("goodblock", "tail"), "main");
}