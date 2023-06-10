package lemon_juice.better_rubber.block;

import lemon_juice.better_rubber.BetterRubber;
import lemon_juice.better_rubber.block.custom.FullRubberWoodBlock;
import lemon_juice.better_rubber.block.custom.RubberWoodBlock;
import lemon_juice.better_rubber.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterRubber.MOD_ID);

    // Blocks
    public static final RegistryObject<Block> RESIN_BLOCK = registerBlock("resin_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).strength(1.0F, 1.0F)));
    public static final RegistryObject<Block> RUBBER_BLOCK = registerBlock("rubber_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3.0F, 3.0F)));

    // Empty Rubber Wood
    public static final RegistryObject<Block> RUBBER_LOG = registerBlock("rubber_log", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> RUBBER_WOOD = registerBlock("rubber_wood", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_RUBBER_LOG = registerBlock("stripped_rubber_log", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final RegistryObject<Block> STRIPPED_RUBBER_WOOD = registerBlock("stripped_rubber_wood", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));

    // Full Rubber Wood
    public static final RegistryObject<Block> FULL_RUBBER_LOG = registerBlock("full_rubber_log", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> FULL_RUBBER_WOOD = registerBlock("full_rubber_wood", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> FULL_STRIPPED_RUBBER_LOG = registerBlock("full_stripped_rubber_log", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final RegistryObject<Block> FULL_STRIPPED_RUBBER_WOOD = registerBlock("full_stripped_rubber_wood", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));

    /******************************** Registry ********************************/
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
