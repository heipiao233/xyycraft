package net.heipiao.xyycraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PlantArrowEntity extends AbstractArrowEntity implements IRendersAsItem{
    public PlantArrowEntity(World world, LivingEntity entity) {
        super(EntityTypes.PLANT_ARROW.get(), entity, world);
    }
    public PlantArrowEntity(EntityType<? extends PlantArrowEntity> type, World world){
        super(type, world);
    }
    @Override
    public ItemStack getItem() {
        return new ItemStack(Items.SPECTRAL_ARROW);
    }
    @Override
    public void onHitBlock(BlockRayTraceResult result) {
        super.onHitBlock(result);
        if(!BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), level, result.getBlockPos(), (PlayerEntity)getOwner())){
            int x = result.getBlockPos().getX() + result.getDirection().getStepX();
            int y = result.getBlockPos().getY() + result.getDirection().getStepY();
            int z = result.getBlockPos().getZ() + result.getDirection().getStepZ();
            BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), level, new BlockPos(x, y, z), (PlayerEntity)getOwner());
        }
        this.remove();
    }
    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(Items.AIR);
    }
    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
    }
    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
