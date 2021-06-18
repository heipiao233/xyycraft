package net.heipiao.xyycraft.entity;

import net.heipiao.xyycraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class IceChargeEntity extends ProjectileItemEntity {
    public IceChargeEntity(World world, LivingEntity entity) {
        super(EntityTypes.ICE_CHARGE.get(), entity, world);
    }
    public IceChargeEntity(EntityType<? extends IceChargeEntity> type, World world){
        super(type, world);
    }
    @Override
    public Item getDefaultItem() {
        return Items.ICE_CHARGE.get();
    }
    @Override
    public void onHitBlock(BlockRayTraceResult result) {
        super.onHitBlock(result);
        int x = result.getDirection().getNormal().getX()+result.getBlockPos().getX();
        int y = result.getDirection().getNormal().getY()+result.getBlockPos().getY();
        int z = result.getDirection().getNormal().getZ()+result.getBlockPos().getZ();
        BlockPos pos = new BlockPos(x, y, z);
        LootContext.Builder builder = new LootContext.Builder((ServerWorld)level)
            .withRandom(level.random)
            .withParameter(LootParameters.TOOL, new ItemStack(Items.ICE_GUN.get()))
            .withParameter(LootParameters.ORIGIN, Vector3d.atCenterOf(pos));
        this.level.getBlockState(pos).getBlockState().getDrops(builder).forEach((ItemStack stack)->{this.spawnAtLocation(stack);});
        this.level.setBlockAndUpdate(pos, Blocks.ICE.defaultBlockState());
        this.remove();
    }
    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        super.onHitEntity(result);
        if(result.getEntity() instanceof LivingEntity){
            ((LivingEntity)result.getEntity()).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200, 200));
            result.getEntity().hurt(new EntityDamageSource("ice_gun", this.getOwner()), result.getEntity() instanceof BlazeEntity?5:3);
        }
        this.remove();
    }
}
