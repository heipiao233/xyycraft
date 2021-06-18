package net.heipiao.xyycraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "xyycraft");
    public static final RegistryObject<Item> ICE_GUN = ITEMS.register("ice_gun", ()->new IceGunItem(new Item.Properties().durability(2).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> ICE_CHARGE = ITEMS.register("ice_charge", ()->new Item(new Item.Properties()));
}
