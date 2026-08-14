package net.hhdsj.changed_creatures.init;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.hhdsj.changed_creatures.block.CryoSubjectChamberBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangedCreatureBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ChangedCreature.MODID);
    public static final RegistryObject<BlockEntityType<CryoSubjectChamberBlockEntity>> CRYO_SUBJECT_CHAMBER_BE =
            BLOCK_ENTITIES.register("cryo_subject_chamber_be", () -> {
                // 延迟获取 Block 引用
                return BlockEntityType.Builder.of(
                        CryoSubjectChamberBlockEntity::new,
                        ChangedCreatureModBlocks.CRYO_SUBJECT_CHAMBER.get()
                ).build(null);
            });
}
