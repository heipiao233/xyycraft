package net.heipiao.xyycraft.item;

import java.util.function.Predicate;

import net.heipiao.xyycraft.entity.PlantArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PlantBowItem extends BowItem{
    public PlantBowItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }
    @Override
    public void releaseUsing(ItemStack item, World world, LivingEntity player, int time) {
        PlantArrowEntity entity = new PlantArrowEntity(world, player);
        entity.setOwner(player);
        entity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
        world.addFreshEntity(entity);
    }
    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (ItemStack stack)->true;
    }
}
