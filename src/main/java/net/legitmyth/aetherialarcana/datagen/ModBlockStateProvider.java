package net.legitmyth.aetherialarcana.datagen;

import net.legitmyth.aetherialarcana.AetherialArcana;
import net.legitmyth.aetherialarcana.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AetherialArcana.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AQUA_BLOCK);
        blockWithItem(ModBlocks.RAW_AQUA_BLOCK);

        blockWithItem(ModBlocks.AQUA_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AQUA_ORE);
        blockWithItem(ModBlocks.NETHER_AQUA_ORE);
        blockWithItem(ModBlocks.END_STONE_AQUA_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
