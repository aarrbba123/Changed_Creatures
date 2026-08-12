package net.hhdsj.changed_creatures.event;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.hhdsj.changed_creatures.init.ChangedCreatureModItems;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedEntities;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChangedCreature.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetupHandler {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
            if (tintIndex == 0) {
                return 0xFFFFFFFF;
            }
            if (tintIndex == 1) {
                CompoundTag tag = stack.getTag();
                if (tag != null && tag.contains("form_variant")) {
                    String variantId = tag.getString("form_variant");
                    if (!variantId.isEmpty()) {
                        int color = getChangedModColor(variantId);
                        if (color != -1) {
                            return color;
                        }
                    }
                }
                return 0xFFFFFFFF;
            }
            return 0xFFFFFFFF;
        }, ChangedCreatureModItems.LATEX_FILLED_ALL_MUG_ITEM.get());
    }

    private static int getChangedModColor(String variantId) {
        ResourceLocation id = ResourceLocation.tryParse(variantId);
        if (id == null) return -1;

        TransfurVariant<?> variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(id);
        if (variant != null) {
            ResourceLocation entityId = ForgeRegistries.ENTITY_TYPES.getKey(variant.getEntityType());
            if (entityId != null) {
                var colors = ChangedEntities.getEntityColor(entityId);
                if (colors != null) {
                    int baseColor = colors.getFirst();
                    return 0xFF000000 | baseColor;
                }
            }
        }

        return 0xFFFFFFFF;
    }
}