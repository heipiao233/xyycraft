package net.heipiao.xyycraft.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.item.Items;

public class SpatulaItem extends Item {
    public SpatulaItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        super.use(world, player, hand);
        if(null != player.getOffhandItem().getItem().getFoodProperties()){
            player.setItemInHand(Hand.OFF_HAND, new ItemStack(Items.GOLDEN_APPLE, player.getOffhandItem().getCount()));
            return ActionResult.consume(player.getItemInHand(hand));
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }
}
