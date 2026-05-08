package net.hhdsj.goodblock.mixin.no_use;

import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@Mixin(CustomEyesLayer.HeadShape.class)
public class HeadShapeMixin {

    @Inject(method = "values", at = @At("RETURN"), cancellable = true)
    private static void addCustomHeadShape(CallbackInfoReturnable<CustomEyesLayer.HeadShape[]> cir) {
        CustomEyesLayer.HeadShape[] original = cir.getReturnValue();

        // 检查是否已经添加过
        for (CustomEyesLayer.HeadShape shape : original) {
            if (shape.getSerializedName().equals("goodblocks")) {
                return;
            }
        }

        try {
            // 获取枚举的构造函数
            java.lang.reflect.Constructor<CustomEyesLayer.HeadShape> constructor =
                    CustomEyesLayer.HeadShape.class.getDeclaredConstructor(
                            String.class,      // serializedName
                            int.class,         // texX
                            int.class,         // texY
                            int.class,         // x
                            int.class,         // y
                            int.class,         // z
                            int.class,         // width
                            int.class,         // height
                            int.class,         // depth
                            CubeDeformation.class  // deformation
                    );
            constructor.setAccessible(true);

            // 创建新的枚举实例（需要先创建枚举实例，然后通过反射添加到枚举数组中）
            CustomEyesLayer.HeadShape newShape = constructor.newInstance(
                    "goodblocks",    // serializedName
                    0,               // texX
                    0,               // texY
                    -4,              // x
                    -6,              // y (向下移动2格)
                    -4,              // z
                    8,               // width
                    8,               // height
                    8,               // depth
                    new CubeDeformation(0.0025F)  // deformation
            );

            // 由于枚举不能直接创建实例，我们需要使用更底层的方式
            // 通过反射创建枚举实例
            CustomEyesLayer.HeadShape enumInstance = createEnumInstance(
                    CustomEyesLayer.HeadShape.class,
                    "GOODBLOCKS",     // 枚举名称
                    new Object[]{"goodblocks", 0, 0, -4, -6, -4, 8, 8, 8, new CubeDeformation(0.0025F)}
            );

            if (enumInstance != null) {
                // 扩展枚举数组
                CustomEyesLayer.HeadShape[] newArray = Arrays.copyOf(original, original.length + 1);
                newArray[original.length] = enumInstance;

                // 更新枚举类的内部数组
                Field valuesField = CustomEyesLayer.HeadShape.class.getDeclaredField("$VALUES");
                valuesField.setAccessible(true);
                valuesField.set(null, newArray);

                cir.setReturnValue(newArray);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static <T extends Enum<T>> T createEnumInstance(Class<T> enumClass, String enumName, Object[] constructorArgs) {
        try {
            // 获取枚举的构造函数（String, int, 以及其他的参数）
            Class<?>[] paramTypes = new Class[constructorArgs.length + 2];
            paramTypes[0] = String.class;  // 枚举名称
            paramTypes[1] = int.class;     // 枚举序号
            for (int i = 0; i < constructorArgs.length; i++) {
                paramTypes[i + 2] = constructorArgs[i].getClass();
                // 处理基本类型
                if (constructorArgs[i] instanceof Integer) paramTypes[i + 2] = int.class;
                else if (constructorArgs[i] instanceof Boolean) paramTypes[i + 2] = boolean.class;
                else if (constructorArgs[i] instanceof Float) paramTypes[i + 2] = float.class;
                else if (constructorArgs[i] instanceof Double) paramTypes[i + 2] = double.class;
            }

            java.lang.reflect.Constructor<T> constructor = enumClass.getDeclaredConstructor(paramTypes);
            constructor.setAccessible(true);

            // 获取当前枚举值数量作为新枚举的序号
            int ordinal = enumClass.getEnumConstants().length;

            // 构建完整的参数列表
            Object[] fullArgs = new Object[constructorArgs.length + 2];
            fullArgs[0] = enumName;
            fullArgs[1] = ordinal;
            System.arraycopy(constructorArgs, 0, fullArgs, 2, constructorArgs.length);

            return constructor.newInstance(fullArgs);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}