package com.darkorg.betterpunching.features;

import com.darkorg.betterpunching.BetterPunching;
import com.darkorg.betterpunching.util.HarvestCheck;
import com.darkorg.betterpunching.util.ToolCheck;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

//Known bugs: Punching blocks with -1 hardness (Bedrock for example) won't cause you any damage.

import java.util.Set;

@Mod.EventBusSubscriber(modid = BetterPunching.MODID, value = Side.CLIENT)
public class WrongTool {
    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed event) {

        //Get everything we need
        EntityPlayer player = event.getEntityPlayer();
        ItemStack stack = player.getHeldItemMainhand();
        IBlockState state = event.getState();
        World world = player.getEntityWorld();
        Block block = state.getBlock();
        BlockPos pos = event.getPos();

        //DamageSources and PotionEffects for the wood, glass and invalidpunching handling.
        DamageSource splinter = new DamageSource("splinter");
        PotionEffect splintered = new PotionEffect(MobEffects.WEAKNESS, 60*20, 0);
        DamageSource cutbyglass = new DamageSource("cutbyglass");
        PotionEffect bleeding = new PotionEffect(MobEffects.WITHER, 10*20,0);
        DamageSource invalidpunching = new DamageSource("invalidpunching");

        //If the block is INSTANT_BREAK, then just do nothing.
        if(state.getBlockHardness(world,pos) == 0f) {return;}

        //Glass now breaks instantaneous with any item, open hand hurts like hell.
        if((block instanceof BlockGlass)     ||
        (block == Blocks.GLASS_PANE)         ||
        (block instanceof BlockStainedGlass) ||
        (block instanceof BlockStainedGlassPane)
        && (!stack.isEmpty())) {
            event.setNewSpeed(Float.MAX_VALUE);
        }
        if((block instanceof BlockGlass) ||
        (block == Blocks.GLASS_PANE) ||
        (block instanceof BlockStainedGlass) ||
        (block instanceof BlockStainedGlassPane)
        && (stack.isEmpty())) {
            player.addPotionEffect(bleeding);
            player.attackEntityFrom(cutbyglass, 6.0F);
            event.setNewSpeed(Float.MAX_VALUE);
        }

        //Vanilla wooden stairs bugfix - might be incompatible with most mods adding wooden stairs based on vanilla ones.
        //Should be compatible if they add valid harvest tools.
        if ((block instanceof BlockWoodSlab)       ||
                (block == Blocks.ACACIA_STAIRS)    ||
                (block == Blocks.BIRCH_STAIRS)     ||
                (block == Blocks.DARK_OAK_STAIRS)  ||
                (block == Blocks.JUNGLE_STAIRS)    ||
                (block == Blocks.OAK_STAIRS)       ||
                (block == Blocks.SPRUCE_STAIRS)){
            Set<String> toolType = stack.getItem().getToolClasses(stack);
            if (!toolType.contains("axe")) {
                if (stack.isEmpty()) {
                    event.setNewSpeed(-1.0F);
                    player.attackEntityFrom(splinter, 4.0F);
                }
                event.setNewSpeed(-1.0F);
            }
        }

        //If you are using an invalid tool, and you can't harvest the block...
        if(ToolCheck.isInvalidTool(state,stack) && !HarvestCheck.canHarvest(block,player,world,pos)) {

            //Some needed exceptions.
            if(block instanceof BlockSnow || block instanceof BlockSnowBlock || block instanceof BlockWeb) {return;}
            //If barehanded, you can't break the block, and you take damage.
            if(stack.isEmpty()) {
                //If the block is wood...
                if(block.isWood(world,pos)) {
                    event.setNewSpeed(-1.0F);
                    player.addPotionEffect(splintered);
                    player.attackEntityFrom(splinter, 4.0F);
                }
            event.setNewSpeed(-1.0F);
            player.attackEntityFrom(invalidpunching, 2.0F);
            }

            //If else, you just can't harvest the block.
        event.setNewSpeed(-1.0F);
        }
    }
}