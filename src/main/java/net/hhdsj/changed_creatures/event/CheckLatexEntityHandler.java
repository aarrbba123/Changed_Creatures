package net.hhdsj.changed_creatures.event;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.hhdsj.changed_creatures.init.ChangedCreatureModItems;
import net.hhdsj.changed_creatures.item.LatexFilledAllMugItem;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedBlocks;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangedCreature.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CheckLatexEntityHandler {

    private static final String NBT_FORM_VARIANT = "form_variant";

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack heldStack = player.getItemInHand(hand);

        if (!heldStack.is(ChangedBlocks.MUG.get().asItem())) {
            return;
        }

        if (!(event.getTarget() instanceof LivingEntity target)) {
            return;
        }

        if (player.level().isClientSide) {
            return;
        }

        TransfurVariant<?> variant = TransfurVariant.getEntityVariant(target);
        if (variant == null) {
            return;
        }

        String variantId = variant.getFormId().toString();

        heldStack.shrink(1);

        ItemStack filledMug = new ItemStack(ChangedCreatureModItems.LATEX_FILLED_ALL_MUG_ITEM.get());
        CompoundTag tag = filledMug.getOrCreateTag();
        tag.putString(NBT_FORM_VARIANT, variantId);

        if (!player.getInventory().add(filledMug)) {
            player.drop(filledMug, false);
        }

        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);
    }
}