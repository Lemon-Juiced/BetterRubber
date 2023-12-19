package lemon_juice.better_rubber.creativetab;

import lemon_juice.better_rubber.BetterRubber;
import lemon_juice.better_rubber.block.BetterRubberBlocks;
import lemon_juice.better_rubber.item.BetterRubberItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BetterRubberCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterRubber.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BETTER_RUBBER_TAB = CREATIVE_MODE_TABS.register("better_rubber", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.better_rubber"))
            .icon(() -> new ItemStack(BetterRubberItems.RESIN.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event){
        if(event.getTab() == BETTER_RUBBER_TAB.get()){
            event.accept(BetterRubberItems.RESIN.get());
            event.accept(BetterRubberItems.RUBBER_BAR.get());
            event.accept(BetterRubberItems.RAW_PLASTIC.get());
            event.accept(BetterRubberItems.PLASTIC_SHEETS.get());

            event.accept(BetterRubberItems.SCUBA_HELMET.get());
            event.accept(BetterRubberItems.RUBBER_CHESTPLATE.get());
            event.accept(BetterRubberItems.RUBBER_LEGGINGS.get());
            event.accept(BetterRubberItems.RUBBER_BOOTS.get());

            event.accept(BetterRubberBlocks.RESIN_BLOCK.get());
            event.accept(BetterRubberBlocks.RUBBER_BLOCK.get());
            event.accept(BetterRubberBlocks.PLASTIC_BLOCK.get());

            event.accept(BetterRubberBlocks.RUBBER_LOG.get());
            event.accept(BetterRubberBlocks.RUBBER_WOOD.get());
            event.accept(BetterRubberBlocks.STRIPPED_RUBBER_LOG.get());
            event.accept(BetterRubberBlocks.STRIPPED_RUBBER_WOOD.get());

            event.accept(BetterRubberBlocks.FULL_RUBBER_LOG.get());
            event.accept(BetterRubberBlocks.FULL_RUBBER_WOOD.get());
            event.accept(BetterRubberBlocks.FULL_STRIPPED_RUBBER_LOG.get());
            event.accept(BetterRubberBlocks.FULL_STRIPPED_RUBBER_WOOD.get());

            event.accept(BetterRubberBlocks.RUBBER_LEAVES.get());
            event.accept(BetterRubberBlocks.RUBBER_SAPLING.get());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
