package lemon_juice.better_rubber.util;

import lemon_juice.better_rubber.block.ModBlocks;
import lemon_juice.better_rubber.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES;

public class ModCompostables {
    public static void setup(final FMLCommonSetupEvent event) {

        add(0.1F, ModItems.RESIN.get());
        add(0.3F, ModBlocks.RUBBER_LEAVES.get());
        add(0.3F, ModBlocks.RUBBER_SAPLING.get());
        add(0.9F, ModBlocks.RESIN_BLOCK.get());
    }

    public static void add(float quantity, ItemLike itemLike) {
        COMPOSTABLES.put(itemLike.asItem(), quantity);
    }
}
