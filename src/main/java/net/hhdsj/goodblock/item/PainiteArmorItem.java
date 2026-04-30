package net.hhdsj.goodblock.item;

import net.hhdsj.goodblock.client.models.armor.GoodBlockModelMaleWingedDragonArmor;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public abstract class PainiteArmorItem extends ArmorItem {

    // ==================== 材质定义 ====================
    private static final ArmorMaterial PAINITE_MATERIAL = new ArmorMaterial() {
        @Override public int getDurabilityForType(ArmorItem.@NotNull Type type) {
            return switch (type) {
                case HELMET -> 13 * 45;
                case CHESTPLATE -> 15 * 45;
                case LEGGINGS -> 16 * 45;
                case BOOTS -> 11 * 45;
                default -> 0;
            };
        }
        @Override public int getDefenseForType(ArmorItem.@NotNull Type type) {
            return switch (type) {
                case HELMET -> 3;
                case CHESTPLATE -> 6;
                case LEGGINGS -> 8;
                case BOOTS -> 3;
                default -> 0;
            };
        }
        @Override public int getEnchantmentValue() { return 50; }
        @Override public @NotNull SoundEvent getEquipSound() {
            SoundEvent sound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("goodblock:item.armor.equip_netherite"));
            return sound != null ? sound : SoundEvents.ARMOR_EQUIP_NETHERITE;
        }
        @Override public @NotNull Ingredient getRepairIngredient() { return Ingredient.of(Items.NETHERITE_INGOT); }
        @Override public @NotNull String getName() { return "painite_armor"; }
        @Override public float getToughness() { return 3f; }
        @Override public float getKnockbackResistance() { return 0.1f; }
    };

    public PainiteArmorItem(ArmorItem.Type type, Item.Properties properties) {
        super(PAINITE_MATERIAL, type, properties);
    }

    @Override public @NotNull EquipmentSlot getEquipmentSlot() { return this.type.getSlot(); }

    // ==================== 模型缓存与动画 ====================
    private static GoodBlockModelMaleWingedDragonArmor<ChangedEntity> cachedModel;
    private static final ModelPart EMPTY_PART = new ModelPart(Collections.emptyList(), Collections.emptyMap());

    private static GoodBlockModelMaleWingedDragonArmor<ChangedEntity> getModel() {
        if (cachedModel == null) {
            cachedModel = new GoodBlockModelMaleWingedDragonArmor<>(
                    Minecraft.getInstance().getEntityModels().bakeLayer(GoodBlockModelMaleWingedDragonArmor.LAYER_LOCATION),
                    ArmorModel.ARMOR_OUTER
            );
        }
        return cachedModel;
    }

    private static void animate(LivingEntity entity) {
        if (entity instanceof ChangedEntity changed) {
            var model = getModel();
            float age = entity.tickCount + Minecraft.getInstance().getFrameTime();
            float limbSwing = entity.walkAnimation.position();
            float limbSwingAmount = Math.min(entity.walkAnimation.speed(), 1.5F);

            model.getAnimator(changed).setupAnim(changed,
                    limbSwing,
                    limbSwingAmount,
                    age,
                    entity.yHeadRot,
                    entity.getXRot()
            );
        }
    }

    // ==================== 盔甲模型构建器 ====================
    private static HumanoidModel<?> buildModel(LivingEntity entity, HumanoidModel<?> original, Map<String, ModelPart> parts) {
        animate(entity);
        var model = new HumanoidModel<>(new ModelPart(Collections.emptyList(), parts));
        model.crouching = entity.isShiftKeyDown();
        model.riding = original.riding;
        model.young = entity.isBaby();
        return model;
    }

    private static Map<String, ModelPart> fullParts() {
        Map<String, ModelPart> parts = new HashMap<>();
        parts.put("head", EMPTY_PART);
        parts.put("hat", EMPTY_PART);
        parts.put("body", EMPTY_PART);
        parts.put("right_arm", EMPTY_PART);
        parts.put("left_arm", EMPTY_PART);
        parts.put("right_leg", EMPTY_PART);
        parts.put("left_leg", EMPTY_PART);
        return parts;
    }

    // ==================== 头盔 ====================
    public static class Helmet extends PainiteArmorItem {
        public Helmet() { super(Type.HELMET, new Properties().fireResistant().stacksTo(1)); }
        @Override public String getArmorTexture(ItemStack s, Entity e, EquipmentSlot slot, String t) {
            return "goodblock:textures/models/armor/painite_male_winged_dragon_armor_1.png";
        }
        @Override public void initializeClient(Consumer<IClientItemExtensions> c) {
            c.accept(new IClientItemExtensions() {
                @Override public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity e, ItemStack s, EquipmentSlot slot, HumanoidModel<?> o) {
                    var parts = fullParts();
                    parts.put("head", getModel().Head);
                    return buildModel(e, o, parts);
                }
            });
        }
    }

    // ==================== 胸甲 ====================
    public static class Chestplate extends PainiteArmorItem {
        public Chestplate() { super(Type.CHESTPLATE, new Properties().fireResistant().stacksTo(1)); }
        @Override public String getArmorTexture(ItemStack s, Entity e, EquipmentSlot slot, String t) {
            return "goodblock:textures/models/armor/painite_male_winged_dragon_armor_1.png";
        }
        @Override public void initializeClient(Consumer<IClientItemExtensions> c) {
            c.accept(new IClientItemExtensions() {
                @Override public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity e, ItemStack s, EquipmentSlot slot, HumanoidModel<?> o) {
                    var parts = fullParts();
                    var m = getModel();

                    m.Tail.visible = false;
                    parts.put("body", m.Torso);
                    parts.put("right_arm", m.RightArm);
                    parts.put("left_arm", m.LeftArm);
                    return buildModel(e, o, parts);
                }
            });
        }
    }

    // ==================== 护腿 ====================
    public static class Leggings extends PainiteArmorItem {
        public Leggings() { super(Type.LEGGINGS, new Properties().fireResistant().stacksTo(1)); }
        @Override public String getArmorTexture(ItemStack s, Entity e, EquipmentSlot slot, String t) {
            return "goodblock:textures/models/armor/painite_male_winged_dragon_armor_1.png";
        }
        @Override public void initializeClient(Consumer<IClientItemExtensions> c) {
            c.accept(new IClientItemExtensions() {
                @Override public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity e, ItemStack s, EquipmentSlot slot, HumanoidModel<?> o) {
                    var parts = fullParts();
                    var m = getModel();

                    m.RightLowerLeg.visible = true;
                    m.RightFoot.visible = true;
                    m.RightPad.visible = false;
                    m.LeftLowerLeg.visible = true;
                    m.LeftFoot.visible = true;
                    m.LeftPad.visible = false;

                    parts.put("right_leg", m.RightLeg);
                    parts.put("left_leg", m.LeftLeg);

                    var model = buildModel(e, o, parts);
                    model.rightLeg.visible = true;
                    model.leftLeg.visible = true;
                    return model;
                }
            });
        }
    }

    // ==================== 靴子 ====================
    public static class Boots extends PainiteArmorItem {
        public Boots() { super(Type.BOOTS, new Properties().fireResistant().stacksTo(1)); }
        @Override public String getArmorTexture(ItemStack s, Entity e, EquipmentSlot slot, String t) {
            return "goodblock:textures/models/armor/painite_male_winged_dragon_armor_2.png";
        }

        @Override public void initializeClient(Consumer<IClientItemExtensions> c) {
            c.accept(new IClientItemExtensions() {
                @Override public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity e, ItemStack s, EquipmentSlot slot, HumanoidModel<?> o) {
                    var parts = fullParts();
                    var m = getModel();

                    m.RightLowerLeg.visible = true;
                    m.RightFoot.visible = true;
                    m.RightPad.visible = true;
                    m.LeftLowerLeg.visible = true;
                    m.LeftFoot.visible = true;
                    m.LeftPad.visible = true;

                    parts.put("right_leg", m.RightLeg);
                    parts.put("left_leg", m.LeftLeg);

                    var model = buildModel(e, o, parts);
                    model.rightLeg.visible = true;
                    model.leftLeg.visible = true;
                    return model;
                }
            });
        }
    }
}