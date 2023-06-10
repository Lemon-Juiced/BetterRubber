package lemon_juice.better_rubber.item;

import lemon_juice.better_rubber.BetterRubber;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterRubber.MOD_ID);

    public static final RegistryObject<Item> RESIN = ITEMS.register("resin", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBBER_BAR = ITEMS.register("rubber_bar", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PLASTIC = ITEMS.register("raw_plastic", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLASTIC_SHEETS = ITEMS.register("plastic_sheets", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
