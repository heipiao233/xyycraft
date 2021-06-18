package net.heipiao.xyycraft;

import net.heipiao.xyycraft.entity.EntityTypes;
import net.heipiao.xyycraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("xyycraft")
public class XYYCraft
{
    private final IEventBus modBus;

    public XYYCraft() {
        modBus = FMLJavaModLoadingContext.get().getModEventBus();
        Items.ITEMS.register(modBus);
        EntityTypes.ENTITIES.register(modBus);
    }
}
