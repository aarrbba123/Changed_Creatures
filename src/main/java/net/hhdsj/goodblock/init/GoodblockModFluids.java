
/*
 * 这些为注册类,请将注册写在这里,而不是其它地方!
 * 				液体类
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.fluid.gas.LatexCrystalJellyGas;
import net.ltxprogrammer.changed.fluid.SkunkGas;
import net.ltxprogrammer.changed.fluid.TransfurGas;
import net.ltxprogrammer.changed.init.ChangedFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.material.Fluid;
import net.hhdsj.goodblock.GoodblockMod;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GoodblockModFluids {
	public static final RegistryObject<TransfurGas> LATEX_CRYSTAL_JELLY_GAS;
	public static final RegistryObject<TransfurGas> LATEX_CRYSTAL_JELLY_GAS_FLOWING;

	public static final RegistryObject<FluidType> LATEX_CRYSTAL_JELLY_TRANSFUR_GAS;

	public static final DeferredRegister<FluidType> REGISTRY_TYPES;

	public static final DeferredRegister<Fluid> REGISTRY_FLUIDS;

	public static final Collection<Runnable> APPLY_RENDER_LAYERS;

	static {
		REGISTRY_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, "goodblock");
		REGISTRY_FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, "goodblock");
		APPLY_RENDER_LAYERS = new ArrayList<>();
		LATEX_CRYSTAL_JELLY_TRANSFUR_GAS = REGISTRY_TYPES.register("latex_crystal_jelly_transfur_gas", LatexCrystalJellyGas::createFluidType);
		LATEX_CRYSTAL_JELLY_GAS = register("latex_crystal_jelly_gas",LatexCrystalJellyGas.Source::new, ChangedFluids::translucentRenderer);
		LATEX_CRYSTAL_JELLY_GAS_FLOWING = register("latex_crystal_jelly_gas_flowing", LatexCrystalJellyGas.Flowing::new, ChangedFluids::translucentRenderer);
	}

	public static void cutoutRenderer(Fluid fluid) {
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () ->
				ItemBlockRenderTypes.setRenderLayer(fluid, net.minecraft.client.renderer.RenderType.cutout()));
	}

	public static void translucentRenderer(Fluid fluid) {
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () ->
				ItemBlockRenderTypes.setRenderLayer(fluid, net.minecraft.client.renderer.RenderType.translucent()));
	}

	public static <T extends Fluid, F extends T> RegistryObject<T> register(String name, Supplier<F> fluid) {
		return register(name, fluid, null);
	}

	public static <T extends Fluid, F extends T> RegistryObject<T> register(String name, Supplier<F> fluid, @Nullable Consumer<T> renderLayer) {
		var obj = REGISTRY_FLUIDS.<T>register(name, fluid);
		if (renderLayer != null)
			APPLY_RENDER_LAYERS.add(() -> renderLayer.accept(obj.get()));
		return obj;
	}
}
