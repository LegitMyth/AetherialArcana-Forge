package net.legitmyth.aetherialarcana.datagen.loot;

import net.legitmyth.aetherialarcana.block.ModBlocks;
import net.legitmyth.aetherialarcana.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.AQUA_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_AQUA_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.AQUA_ORE.get(),
        block -> createCopperLikeOreDrops(ModBlocks.AQUA_ORE.get(), ModItems.RAW_AQUA.get()));
        this.add(ModBlocks.DEEPSLATE_AQUA_ORE.get(),
        block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_AQUA_ORE.get(), ModItems.RAW_AQUA.get()));
        this.add(ModBlocks.NETHER_AQUA_ORE.get(),
        block -> createCopperLikeOreDrops(ModBlocks.NETHER_AQUA_ORE.get(), ModItems.RAW_AQUA.get()));
        this.add(ModBlocks.END_STONE_AQUA_ORE.get(),
        block -> createCopperLikeOreDrops(ModBlocks.END_STONE_AQUA_ORE.get(), ModItems.RAW_AQUA.get()));

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
