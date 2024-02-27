package net.legitmyth.aetherialarcana.util;

import net.legitmyth.aetherialarcana.AetherialArcana;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MAGIC_DETECTOR_DETECTABLE_BLOCKS = tag("magic_detector_detectable_blocks");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(AetherialArcana.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(AetherialArcana.MOD_ID, name));
        }

    }

}
