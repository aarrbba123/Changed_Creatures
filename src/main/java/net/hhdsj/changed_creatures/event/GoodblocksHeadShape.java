package net.hhdsj.changed_creatures.event;

import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public class GoodblocksHeadShape {

    public enum HeadShape implements StringRepresentable {
        // 基础形状
        NORMAL("normal", 0, 0, -4, -6, -4, 8, 8, 8, new CubeDeformation(0.0025F));
        final String serializedName;
        final int texX;
        final int texY;
        final int x;
        final int y;
        final int z;
        final int width;
        final int height;
        final int depth;
        final CubeDeformation deformation;

        private HeadShape(String serializedName, int texX, int texY, int x, int y, int z,
                          int width, int height, int depth) {
            this(serializedName, texX, texY, x, y, z, width, height, depth, CubeDeformation.NONE);
        }

        private HeadShape(String serializedName, int texX, int texY, int x, int y, int z,
                          int width, int height, int depth, CubeDeformation deformation) {
            this.serializedName = serializedName;
            this.texX = texX;
            this.texY = texY;
            this.x = x;
            this.y = y;
            this.z = z;
            this.width = width;
            this.height = height;
            this.depth = depth;
            this.deformation = deformation;
        }

        public CubeListBuilder create() {
            return CubeListBuilder.create()
                    .texOffs(this.texX, this.texY)
                    .addBox((float) this.x, (float) this.y, (float) this.z,
                            (float) this.width, (float) this.height, (float) this.depth,
                            this.deformation);
        }

        @NotNull
        @Override
        public String getSerializedName() {
            return this.serializedName;
        }
    }
}