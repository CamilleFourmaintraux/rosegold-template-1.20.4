package net.grotacam.rosegold.item;

import net.grotacam.rosegold.Rosegold;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    ROSEGOLD("rosegold", 12, new int[]{2,4,5,2},21, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0, () -> Ingredient.ofItems(ModItems.ROSEGOLD_INGOT))
    ;

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmouts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final int toughness;
    private final int knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;


    private static final int[] BASE_DURABILITY = {11,16,15,13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmouts, int enchantability, SoundEvent equipSound, int toughness, int knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmouts = protectionAmouts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()];
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmouts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        //A ne pas oublier
        return Rosegold.MOD_ID+":"+this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
