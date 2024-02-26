package net.legitmyth.aetherialarcana.item;

import net.legitmyth.aetherialarcana.AetherialArcana;
import net.legitmyth.aetherialarcana.block.ModBlocks;
import net.legitmyth.aetherialarcana.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AetherialArcana.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AETHERIAL_TAB = CREATIVE_MODE_TABS.register("aetherial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AQUA.get()))
                    .title(Component.translatable("creativetab.aetherial_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.AQUA.get());
                        output.accept(ModItems.RAW_AQUA.get());

                        output.accept(ModItems.MAGIBERRIES.get());

                        output.accept(ModItems.MAGIC_DETECTOR.get());

                        output.accept(ModBlocks.SOUND_BLOCK.get());

                        output.accept(ModBlocks.AQUA_BLOCK.get());
                        output.accept(ModBlocks.RAW_AQUA_BLOCK.get());

                        output.accept(ModBlocks.AQUA_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_AQUA_ORE.get());
                        output.accept(ModBlocks.NETHER_AQUA_ORE.get());
                        output.accept(ModBlocks.END_STONE_AQUA_ORE.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
