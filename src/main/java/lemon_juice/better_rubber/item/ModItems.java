package lemon_juice.better_rubber.item;

import lemon_juice.better_rubber.BetterRubber;
import lemon_juice.better_rubber.item.custom.armor.ScubaChestplateItem;
import lemon_juice.better_rubber.item.custom.armor.ScubaHelmetItem;
import lemon_juice.better_rubber.item.custom.tiers.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
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

    public static final RegistryObject<Item> SCUBA_HELMET = ITEMS.register("rubber_helmet", () -> new ScubaHelmetItem(new Item.Properties()));
    public static final RegistryObject<Item> RUBBER_CHESTPLATE = ITEMS.register("rubber_chestplate", () -> new ScubaChestplateItem(new Item.Properties()));
    public static final RegistryObject<Item> RUBBER_LEGGINGS = ITEMS.register("rubber_leggings", () -> new ArmorItem(ModArmorMaterials.RUBBER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBBER_BOOTS = ITEMS.register("rubber_boots", () -> new ArmorItem(ModArmorMaterials.RUBBER, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
