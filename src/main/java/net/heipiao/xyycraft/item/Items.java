package net.heipiao.xyycraft.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "xyycraft");
    public static final RegistryObject<Item> ICE_GUN = ITEMS.register("ice_gun", ()->new IceGunItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> ICE_CHARGE = ITEMS.register("ice_charge", ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPATULA = ITEMS.register("spatula", ()->new SpatulaItem(new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> BRAVE_BELT = ITEMS.register("brave_belt", ()->new ArmorItem(ArmorMaterial.NETHERITE, EquipmentSlotType.LEGS, new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(20).saturationMod(1).build())));
}
