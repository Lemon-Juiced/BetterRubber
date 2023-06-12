package lemon_juice.better_rubber.block;

import lemon_juice.better_rubber.BetterRubber;
import lemon_juice.better_rubber.block.custom.FullRubberWoodBlock;
import lemon_juice.better_rubber.block.custom.RubberLeavesBlock;
import lemon_juice.better_rubber.block.custom.RubberWoodBlock;
import lemon_juice.better_rubber.item.ModItems;
import lemon_juice.better_rubber.item.custom.RubberWoodBlockItem;
import lemon_juice.better_rubber.worldgen.tree.RubberTreeGrower;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
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
    public static final RegistryObject<Block> PLASTIC_BLOCK = registerBlock("plastic_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3.0F, 3.0F)));

    // Empty Rubber Wood
    public static final RegistryObject<Block> RUBBER_LOG = registerRubberWoodBlock("rubber_log", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> RUBBER_WOOD = registerRubberWoodBlock("rubber_wood", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_RUBBER_LOG = registerRubberWoodBlock("stripped_rubber_log", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final RegistryObject<Block> STRIPPED_RUBBER_WOOD = registerRubberWoodBlock("stripped_rubber_wood", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));

    // Full Rubber Wood
    public static final RegistryObject<Block> FULL_RUBBER_LOG = registerRubberWoodBlock("full_rubber_log", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> FULL_RUBBER_WOOD = registerRubberWoodBlock("full_rubber_wood", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> FULL_STRIPPED_RUBBER_LOG = registerRubberWoodBlock("full_stripped_rubber_log", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final RegistryObject<Block> FULL_STRIPPED_RUBBER_WOOD = registerRubberWoodBlock("full_stripped_rubber_wood", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));

    // Other Rubber Tree Pieces
    public static final RegistryObject<Block> RUBBER_LEAVES = registerBlock("rubber_leaves", () -> new RubberLeavesBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LEAVES).strength(.2f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> RUBBER_SAPLING = registerBlock("rubber_sapling", () -> new SaplingBlock(new RubberTreeGrower(), BlockBehaviour.Properties.copy(Blocks.JUNGLE_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_RUBBER_SAPLING = BLOCKS.register("potted_rubber_sapling", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.RUBBER_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));


    /******************************** Registry ********************************/
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    /**************************** Specific Registry ****************************/
    public static <T extends Block> RegistryObject<T> registerRubberWoodBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerRubberWoodBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerRubberWoodBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new RubberWoodBlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
