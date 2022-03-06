package darkorg.betterpunching.util;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class BlockUtil {
    public static boolean isCactus(BlockState state) {
        return state.getMaterial() == Material.CACTUS;
    }

    public static boolean isWood(BlockState state) {
        return state.getMaterial() == Material.WOOD || state.getMaterial() == Material.NETHER_WOOD;
    }

    public static boolean isGlass(BlockState state) {
        return state.getMaterial() == Material.GLASS || state.getMaterial() == Material.BUILDABLE_GLASS;
    }
}
