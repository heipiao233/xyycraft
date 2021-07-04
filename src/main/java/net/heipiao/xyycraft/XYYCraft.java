package net.heipiao.xyycraft;

import net.heipiao.xyycraft.entity.EntityTypes;
import net.heipiao.xyycraft.entity.PlantArrowEntity;
import net.heipiao.xyycraft.item.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("xyycraft")
public class XYYCraft
{
    private final IEventBus modBus;

    public XYYCraft() {
        modBus = FMLJavaModLoadingContext.get().getModEventBus();
        Items.ITEMS.register(modBus);
        EntityTypes.ENTITIES.register(modBus);
        modBus.addListener(this::onClientSetup);
    }
    private void onClientSetup(FMLClientSetupEvent event){
        ItemModelsProperties.register(Items.PLANT_BOW.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemModelsProperties.register(Items.PLANT_BOW.get(), new ResourceLocation("pulling"), (stack, world, entity) -> {
            return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
        });
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(EntityTypes.ICE_CHARGE.get(), (dispacher)->new SpriteRenderer<>(dispacher, itemRenderer));
        RenderingRegistry.registerEntityRenderingHandler(EntityTypes.PLANT_ARROW.get(), (dispacher)->new ArrowRenderer<PlantArrowEntity>(dispacher){
            private final ResourceLocation TIPPED_ARROW_LOCATION = new ResourceLocation("xyycraft", "textures/entity/plant_arrow.png");
            @Override
            public ResourceLocation getTextureLocation(PlantArrowEntity p_110775_1_) {
                return TIPPED_ARROW_LOCATION;
            }
        });
    }
}
