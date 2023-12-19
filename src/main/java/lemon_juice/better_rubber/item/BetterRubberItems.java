package lemon_juice.better_rubber.item;

import lemon_juice.better_rubber.BetterRubber;
import lemon_juice.better_rubber.item.custom.armor.ScubaChestplateItem;
import lemon_juice.better_rubber.item.custom.armor.ScubaHelmetItem;
import lemon_juice.better_rubber.item.custom.tiers.BetterRubberArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BetterRubberItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BetterRubber.MOD_ID);

    public static final DeferredItem<Item> RESIN = ITEMS.register("resin", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUBBER_BAR = ITEMS.register("rubber_bar", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_PLASTIC = ITEMS.register("raw_plastic", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLASTIC_SHEETS = ITEMS.register("plastic_sheets", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SCUBA_HELMET = ITEMS.register("rubber_helmet", () -> new ScubaHelmetItem(new Item.Properties()));
    public static final DeferredItem<Item> RUBBER_CHESTPLATE = ITEMS.register("rubber_chestplate", () -> new ScubaChestplateItem(new Item.Properties()));
    public static final DeferredItem<Item> RUBBER_LEGGINGS = ITEMS.register("rubber_leggings", () -> new ArmorItem(BetterRubberArmorMaterials.RUBBER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> RUBBER_BOOTS = ITEMS.register("rubber_boots", () -> new ArmorItem(BetterRubberArmorMaterials.RUBBER, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
