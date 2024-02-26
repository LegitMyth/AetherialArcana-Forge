package net.legitmyth.aetherialarcana.item;

import net.legitmyth.aetherialarcana.AetherialArcana;
import net.legitmyth.aetherialarcana.item.custom.FuelItem;
import net.legitmyth.aetherialarcana.item.custom.MagicDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AetherialArcana.MOD_ID);

    public static final RegistryObject<Item> AQUA = ITEMS.register("aqua",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AQUA = ITEMS.register("raw_aqua",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_DETECTOR = ITEMS.register("magic_detector",
            () -> new MagicDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> MAGIBERRIES = ITEMS.register("magiberries",
            () -> new Item(new Item.Properties().food(ModFoods.MAGIBERRIES)));
    public static final RegistryObject<Item> MAGIFUEL = ITEMS.register("magifuel",
            () -> new FuelItem(new Item.Properties(), 10000));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
