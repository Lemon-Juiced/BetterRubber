package lemon_juice.better_rubber.creativetab;

import lemon_juice.better_rubber.BetterRubber;
import lemon_juice.better_rubber.block.ModBlocks;
import lemon_juice.better_rubber.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterRubber.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BETTER_RUBBER_TAB = CREATIVE_MODE_TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.better_rubber"))
            .icon(() -> new ItemStack(ModItems.RESIN.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event){
        if(event.getTab() == BETTER_RUBBER_TAB.get()){
            event.accept(ModItems.RESIN.get());
            event.accept(ModItems.RUBBER_BAR.get());
            event.accept(ModItems.RAW_PLASTIC.get());
            event.accept(ModItems.PLASTIC_SHEETS.get());

            event.accept(ModBlocks.RESIN_BLOCK.get());
            event.accept(ModBlocks.RUBBER_BLOCK.get());
            event.accept(ModBlocks.PLASTIC_BLOCK.get());

            event.accept(ModBlocks.RUBBER_LOG.get());
            event.accept(ModBlocks.RUBBER_WOOD.get());
            event.accept(ModBlocks.STRIPPED_RUBBER_LOG.get());
            event.accept(ModBlocks.STRIPPED_RUBBER_WOOD.get());

            event.accept(ModBlocks.FULL_RUBBER_LOG.get());
            event.accept(ModBlocks.FULL_RUBBER_WOOD.get());
            event.accept(ModBlocks.FULL_STRIPPED_RUBBER_LOG.get());
            event.accept(ModBlocks.FULL_STRIPPED_RUBBER_WOOD.get());
        }
    }

    /******************************** Registry ********************************/
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
