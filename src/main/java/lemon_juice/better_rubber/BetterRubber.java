package lemon_juice.better_rubber;

import lemon_juice.better_rubber.block.BetterRubberBlocks;
import lemon_juice.better_rubber.creativetab.BetterRubberCreativeTab;
import lemon_juice.better_rubber.event.BetterRubberEvents;
import lemon_juice.better_rubber.item.BetterRubberItems;
import lemon_juice.better_rubber.util.BetterRubberCompostables;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(BetterRubber.MOD_ID)
public class BetterRubber {
    public static final String MOD_ID = "better_rubber";

    public BetterRubber(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

        // Register Items
        BetterRubberItems.register(modEventBus);
        BetterRubberBlocks.register(modEventBus);

        // Register Creative Tab
        BetterRubberCreativeTab.register(modEventBus);
        modEventBus.addListener(BetterRubberCreativeTab::registerTabs);

        // Register Events
        BetterRubberEvents.registerEvents();

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BetterRubberBlocks.RUBBER_SAPLING.getId(), BetterRubberBlocks.POTTED_RUBBER_SAPLING);

            //Register Compostables
            BetterRubberCompostables.setup(event);
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
