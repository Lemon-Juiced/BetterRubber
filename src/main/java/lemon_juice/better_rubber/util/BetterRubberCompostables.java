package lemon_juice.better_rubber.util;

import lemon_juice.better_rubber.block.BetterRubberBlocks;
import lemon_juice.better_rubber.item.BetterRubberItems;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES;

public class BetterRubberCompostables {
    public static void setup(final FMLCommonSetupEvent event) {

        add(0.1F, BetterRubberItems.RESIN.get());
        add(0.3F, BetterRubberBlocks.RUBBER_LEAVES.get());
        add(0.3F, BetterRubberBlocks.RUBBER_SAPLING.get());
        add(0.9F, BetterRubberBlocks.RESIN_BLOCK.get());
    }

    public static void add(float quantity, ItemLike itemLike) {
        COMPOSTABLES.put(itemLike.asItem(), quantity);
    }
}
