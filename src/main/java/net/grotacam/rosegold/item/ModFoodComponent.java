package net.grotacam.rosegold.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponent {

    public static final FoodComponent ROSEGOLD_APPLE = new FoodComponent.Builder().hunger(3).saturationModifier(9f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,100),1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,100),1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE,1000,2),1f).build();


    public static final FoodComponent ROSEGOLD_CARROT = new FoodComponent.Builder().hunger(5).saturationModifier(14f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE,300, 1),1f).build();

}
