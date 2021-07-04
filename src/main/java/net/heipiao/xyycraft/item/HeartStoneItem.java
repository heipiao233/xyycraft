package net.heipiao.xyycraft.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class HeartStoneItem extends Item{
    public HeartStoneItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.addEffect(new EffectInstance(Effects.REGENERATION, 400, 2));
        return ActionResult.consume(player.getItemInHand(hand));
    }
}
