package net.heipiao.xyycraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "xyycraft");
    public static final RegistryObject<Item> ICE_GUN = ITEMS.register("ice_gun", ()->new IceGunItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT).stacksTo(1)));
    public static final RegistryObject<Item> PLANT_BOW = ITEMS.register("plant_bow", ()->new PlantBowItem(new Item.Properties().tab(ItemGroup.TAB_TOOLS).stacksTo(1)));
    // public static final RegistryObject<Item> ICE_CHARGE = ITEMS.register("ice_charge", ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPATULA = ITEMS.register("spatula", ()->new SpatulaItem(new Item.Properties().tab(ItemGroup.TAB_TOOLS).stacksTo(1)));
    public static final RegistryObject<Item> BRAVE_BELT = ITEMS.register("brave_belt", ()->new SwordItem(ItemTier.NETHERITE, 20, 0, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> HEART_STONE = ITEMS.register("heart_stone", ()->new HeartStoneItem(new Item.Properties().tab(ItemGroup.TAB_BREWING).stacksTo(1)));
}
