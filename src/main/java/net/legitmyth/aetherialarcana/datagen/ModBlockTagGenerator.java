package net.legitmyth.aetherialarcana.datagen;

import net.legitmyth.aetherialarcana.AetherialArcana;
import net.legitmyth.aetherialarcana.block.ModBlocks;
import net.legitmyth.aetherialarcana.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AetherialArcana.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.MAGIC_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.AQUA_ORE.get()).addTag(Tags.Blocks.ORES);

                 this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AQUA_BLOCK.get(),
                        ModBlocks.RAW_AQUA_BLOCK.get(),

                        ModBlocks.AQUA_ORE.get(),
                        ModBlocks.DEEPSLATE_AQUA_ORE.get(),
                        ModBlocks.NETHER_AQUA_ORE.get());

                        ModBlocks.SOUND_BLOCK.get();

                this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AQUA_BLOCK.get(),
                        ModBlocks.RAW_AQUA_BLOCK.get(),

                        ModBlocks.AQUA_ORE.get(),
                        ModBlocks.DEEPSLATE_AQUA_ORE.get(),
                        ModBlocks.NETHER_AQUA_ORE.get());



                this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

                this.tag(BlockTags.NEEDS_STONE_TOOL);

                this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                        .add(ModBlocks.END_STONE_AQUA_ORE.get());


    }
}
