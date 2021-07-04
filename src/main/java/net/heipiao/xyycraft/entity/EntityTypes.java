package net.heipiao.xyycraft.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, "xyycraft");
    public static final RegistryObject<EntityType<IceChargeEntity>> ICE_CHARGE = ENTITIES.register("ice_charge", ()->EntityType.Builder.<IceChargeEntity>of(IceChargeEntity::new, EntityClassification.MISC).fireImmune().sized(0.25F, 0.25F).build("ice_charge"));
    public static final RegistryObject<EntityType<PlantArrowEntity>> PLANT_ARROW = ENTITIES.register("plant_arrow", ()->EntityType.Builder.<PlantArrowEntity>of(PlantArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("plant_arrow"));
}
