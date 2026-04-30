package net.hhdsj.goodblock.abilities;

import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.minecraft.resources.ResourceLocation;
import net.hhdsj.goodblock.GoodblockMod;

import java.util.function.BiFunction;

public class CreateBlueCrystalEntityAbilityType extends AbstractAbility<CreateBlueCrystalEntityAbility> {

    // 靜態的創建函數
    public static final BiFunction<AbstractAbility<CreateBlueCrystalEntityAbility>, IAbstractChangedEntity, CreateBlueCrystalEntityAbility> FACTORY =
            (ability, entity) -> new CreateBlueCrystalEntityAbility(ability, entity);

    public CreateBlueCrystalEntityAbilityType() {
        super(FACTORY);
    }

    @Override
    public boolean canUse(IAbstractChangedEntity entity) {
        CreateBlueCrystalEntityAbility instance = entity.getAbilityInstance(this);
        if (instance == null) return false;
        return instance.canUse();
    }

    @Override
    public boolean canKeepUsing(IAbstractChangedEntity entity) {
        CreateBlueCrystalEntityAbility instance = entity.getAbilityInstance(this);
        if (instance == null) return false;
        return instance.canKeepUsing();
    }

    @Override
    public void startUsing(IAbstractChangedEntity entity) {
        CreateBlueCrystalEntityAbility instance = entity.getAbilityInstance(this);
        if (instance != null) {
            instance.startUsing();
        }
    }

    @Override
    public void tick(IAbstractChangedEntity entity) {
        CreateBlueCrystalEntityAbility instance = entity.getAbilityInstance(this);
        if (instance != null) {
            instance.tick();
        }
    }

    @Override
    public void stopUsing(IAbstractChangedEntity entity) {
        CreateBlueCrystalEntityAbility instance = entity.getAbilityInstance(this);
        if (instance != null) {
            instance.stopUsing();
        }
    }

    @Override
    public void onRemove(IAbstractChangedEntity entity) {
        CreateBlueCrystalEntityAbility instance = entity.getAbilityInstance(this);
        if (instance != null) {
            instance.onRemove();
        }
    }

    @Override
    public UseType getUseType(IAbstractChangedEntity entity) {
        // INSTANT: 按下立即使用
        // HOLD: 需要按住
        // CHARGE_TIME: 需要充能
        // CHARGE_RELEASE: 充能后釋放
        return UseType.INSTANT;
    }

    @Override
    public int getChargeTime(IAbstractChangedEntity entity) {
        return 0; // 無需充能
    }

    @Override
    public int getCoolDown(IAbstractChangedEntity entity) {
        return 30; // 1.5秒冷卻 (20 ticks = 1秒)
    }

    @Override
    public boolean shouldApplyCoolDown(IAbstractChangedEntity entity) {
        return true; // 使用後需要冷卻
    }
}