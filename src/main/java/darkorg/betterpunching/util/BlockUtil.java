package darkorg.betterpunching.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;

public class BlockUtil {
    public static boolean isCactus(BlockState state) {
        return state.getMaterial() == Material.CACTUS;
    }

    public static boolean isGlass(BlockState state) {
        return state.getMaterial() == Material.GLASS;
    }

    public static boolean isWood(BlockState state) {
        return state.getMaterial() == Material.WOOD || state.getMaterial() == Material.NETHER_WOOD;
    }
}
