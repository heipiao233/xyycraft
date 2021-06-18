package net.heipiao.xyycraft.item;

import net.heipiao.xyycraft.entity.IceChargeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class IceGunItem extends Item{
    public IceGunItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(!player.getItemInHand(hand).getOrCreateTag().contains("lastUse")){
            player.getItemInHand(hand).getOrCreateTag().putLong("lastUse", 0L);
        }
        if(!player.getItemInHand(hand).getOrCreateTag().contains("used")){
            player.getItemInHand(hand).getOrCreateTag().putBoolean("used", false);
        }
        if(world.getDayTime()<player.getItemInHand(hand).getOrCreateTag().getLong("lastUse")){
            player.getItemInHand(hand).getOrCreateTag().putBoolean("used", false);
        }
        if(!(player.getItemInHand(hand).getOrCreateTag().getBoolean("used"))||player.abilities.instabuild){
            player.getItemInHand(hand).getOrCreateTag().putLong("lastUse", world.getDayTime());
            player.getItemInHand(hand).getOrCreateTag().putBoolean("used", true);
            IceChargeEntity entity = new IceChargeEntity(world, player);
            entity.setOwner(player);
            entity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(entity);
            return ActionResult.sidedSuccess(player.getItemInHand(hand), world.isClientSide);
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }
}
