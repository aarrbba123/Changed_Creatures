package net.hhdsj.goodblock.item;


import net.ltxprogrammer.changed.item.LoopedRecordItem;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class MusicRecordItem extends LoopedRecordItem {
    public MusicRecordItem(int comparatorValue, Supplier<SoundEvent> soundSupplier, Item.Properties properties) {
        super(comparatorValue, soundSupplier, properties);
    }
}

