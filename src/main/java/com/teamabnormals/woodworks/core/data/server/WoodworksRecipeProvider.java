package com.teamabnormals.woodworks.core.data.server;

import com.google.common.collect.Maps;
import com.teamabnormals.blueprint.core.api.conditions.ConfigValueCondition;
import com.teamabnormals.woodworks.core.Woodworks;
import com.teamabnormals.woodworks.core.WoodworksConfig;
import com.teamabnormals.woodworks.core.registry.WoodworksBlocks;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static com.teamabnormals.woodworks.core.WoodworksConfig.COMMON;


public class WoodworksRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public WoodworksRecipeProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	public void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		this.conditionalRecipe(consumer, config(COMMON.woodenChests, "wooden_chests", true), ShapedRecipeBuilder.shaped(Blocks.CHEST).define('#', ItemTags.PLANKS).pattern("###").pattern("# #").pattern("###").unlockedBy("has_lots_of_items", new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, new ItemPredicate[0])));

		this.baseRecipes(consumer, Blocks.OAK_PLANKS, WoodworksBlocks.OAK_BOARDS.get(), Blocks.BOOKSHELF, Blocks.LADDER, Blocks.BEEHIVE, WoodworksBlocks.OAK_CHEST.get(), WoodworksBlocks.OAK_TRAPPED_CHEST.get());
		this.baseRecipes(consumer, Blocks.SPRUCE_PLANKS, WoodworksBlocks.SPRUCE_BOARDS.get(), WoodworksBlocks.SPRUCE_BOOKSHELF.get(), WoodworksBlocks.SPRUCE_LADDER.get(), WoodworksBlocks.SPRUCE_BEEHIVE.get(), WoodworksBlocks.SPRUCE_CHEST.get(), WoodworksBlocks.SPRUCE_TRAPPED_CHEST.get());
		this.baseRecipes(consumer, Blocks.BIRCH_PLANKS, WoodworksBlocks.BIRCH_BOARDS.get(), WoodworksBlocks.BIRCH_BOOKSHELF.get(), WoodworksBlocks.BIRCH_LADDER.get(), WoodworksBlocks.BIRCH_BEEHIVE.get(), WoodworksBlocks.BIRCH_CHEST.get(), WoodworksBlocks.BIRCH_TRAPPED_CHEST.get());
		this.baseRecipes(consumer, Blocks.JUNGLE_PLANKS, WoodworksBlocks.JUNGLE_BOARDS.get(), WoodworksBlocks.JUNGLE_BOOKSHELF.get(), WoodworksBlocks.JUNGLE_LADDER.get(), WoodworksBlocks.JUNGLE_BEEHIVE.get(), WoodworksBlocks.JUNGLE_CHEST.get(), WoodworksBlocks.JUNGLE_TRAPPED_CHEST.get());
		this.baseRecipes(consumer, Blocks.ACACIA_PLANKS, WoodworksBlocks.ACACIA_BOARDS.get(), WoodworksBlocks.ACACIA_BOOKSHELF.get(), WoodworksBlocks.ACACIA_LADDER.get(), WoodworksBlocks.ACACIA_BEEHIVE.get(), WoodworksBlocks.ACACIA_CHEST.get(), WoodworksBlocks.ACACIA_TRAPPED_CHEST.get());
		this.baseRecipes(consumer, Blocks.DARK_OAK_PLANKS, WoodworksBlocks.DARK_OAK_BOARDS.get(), WoodworksBlocks.DARK_OAK_BOOKSHELF.get(), WoodworksBlocks.DARK_OAK_LADDER.get(), WoodworksBlocks.DARK_OAK_BEEHIVE.get(), WoodworksBlocks.DARK_OAK_CHEST.get(), WoodworksBlocks.DARK_OAK_TRAPPED_CHEST.get());
		this.baseRecipes(consumer, Blocks.CRIMSON_PLANKS, WoodworksBlocks.CRIMSON_BOARDS.get(), WoodworksBlocks.CRIMSON_BOOKSHELF.get(), WoodworksBlocks.CRIMSON_LADDER.get(), WoodworksBlocks.CRIMSON_BEEHIVE.get(), WoodworksBlocks.CRIMSON_CHEST.get(), WoodworksBlocks.CRIMSON_TRAPPED_CHEST.get());
		this.baseRecipes(consumer, Blocks.WARPED_PLANKS, WoodworksBlocks.WARPED_BOARDS.get(), WoodworksBlocks.WARPED_BOOKSHELF.get(), WoodworksBlocks.WARPED_LADDER.get(), WoodworksBlocks.WARPED_BEEHIVE.get(), WoodworksBlocks.WARPED_CHEST.get(), WoodworksBlocks.WARPED_TRAPPED_CHEST.get());

		this.leafPile(consumer, Blocks.OAK_LEAVES, WoodworksBlocks.OAK_LEAF_PILE.get());
		this.leafPile(consumer, Blocks.SPRUCE_LEAVES, WoodworksBlocks.SPRUCE_LEAF_PILE.get());
		this.leafPile(consumer, Blocks.BIRCH_LEAVES, WoodworksBlocks.BIRCH_LEAF_PILE.get());
		this.leafPile(consumer, Blocks.JUNGLE_LEAVES, WoodworksBlocks.JUNGLE_LEAF_PILE.get());
		this.leafPile(consumer, Blocks.ACACIA_LEAVES, WoodworksBlocks.ACACIA_LEAF_PILE.get());
		this.leafPile(consumer, Blocks.DARK_OAK_LEAVES, WoodworksBlocks.DARK_OAK_LEAF_PILE.get());
		this.leafPile(consumer, Blocks.AZALEA_LEAVES, WoodworksBlocks.AZALEA_LEAF_PILE.get());
		this.leafPile(consumer, Blocks.FLOWERING_AZALEA_LEAVES, WoodworksBlocks.FLOWERING_AZALEA_LEAF_PILE.get());
	}

	public void baseRecipes(Consumer<FinishedRecipe> consumer, Block planks, Block boards, Block bookshelf, Block ladder, Block beehive, Block chest, Block trappedChest) {
		this.conditionalRecipe(consumer, config(COMMON.woodenBoards, "wooden_boards"), ShapedRecipeBuilder.shaped(boards, 3).define('#', planks).pattern("#").pattern("#").pattern("#").group("wooden_boards").unlockedBy(getHasName(planks), has(planks)));
		this.conditionalRecipe(consumer, config(COMMON.woodenBookshelves, "wooden_bookshelves"), ShapedRecipeBuilder.shaped(bookshelf).define('#', planks).define('X', Items.BOOK).pattern("###").pattern("XXX").pattern("###").group("wooden_bookshelf").unlockedBy("has_book", has(Items.BOOK)));
		this.conditionalRecipe(consumer, config(COMMON.woodenLadders, "wooden_ladders"), ShapedRecipeBuilder.shaped(ladder, 4).define('#', planks).define('S', Items.STICK).pattern("S S").pattern("S#S").pattern("S S").group("wooden_ladder").unlockedBy("has_stick", has(Items.STICK)));
		this.conditionalRecipe(consumer, config(COMMON.woodenBeehives, "wooden_beehives"), ShapedRecipeBuilder.shaped(beehive).define('#', planks).define('H', Items.HONEYCOMB).pattern("###").pattern("HHH").pattern("###").group("wooden_beehive").unlockedBy("has_honeycomb", has(Items.HONEYCOMB)));
		this.conditionalRecipe(consumer, config(COMMON.woodenChests, "wooden_chests"), ShapedRecipeBuilder.shaped(chest).define('#', planks).pattern("###").pattern("# #").pattern("###").group("wooden_chest").unlockedBy("has_lots_of_items", new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, new ItemPredicate[0])));
		this.conditionalRecipe(consumer, config(COMMON.woodenChests, "wooden_chests"), ShapelessRecipeBuilder.shapeless(trappedChest).requires(chest).requires(Blocks.TRIPWIRE_HOOK).group("wooden_trapped_chest").unlockedBy("has_tripwire_hook", has(Blocks.TRIPWIRE_HOOK)));
	}

	public void conditionalRecipe(Consumer<FinishedRecipe> consumer, ICondition condition, RecipeBuilder recipe) {
		ResourceLocation id = RecipeBuilder.getDefaultRecipeId(recipe.getResult());
		ConditionalRecipe.builder().addCondition(condition).addRecipe(recipe::save).generateAdvancement(new ResourceLocation(id.getNamespace(), "recipes/" + recipe.getResult().getItemCategory().getRecipeFolderName() + "/" + id.getPath())).build(consumer, id);
	}

	public void leafPile(Consumer<FinishedRecipe> consumer, Block leaves, Block leafPile) {
		this.conditionalRecipe(consumer, config(COMMON.leafPiles, "leaf_piles"), ShapedRecipeBuilder.shaped(leafPile, 3).define('#', leaves).pattern("##").group("leaf_pile").unlockedBy(getHasName(leaves), has(leaves)));
	}

	private static ConfigValueCondition config(ForgeConfigSpec.ConfigValue<?> value, String key, boolean inverted) {
		return new ConfigValueCondition(new ResourceLocation(Woodworks.MOD_ID, "config"), value, key, Maps.newHashMap(), inverted);
	}

	private static ConfigValueCondition config(ForgeConfigSpec.ConfigValue<?> value, String key) {
		return config(value, key, false);
	}

	private static String getHasName(ItemLike item) {
		return "has_" + getItemName(item);
	}

	private static String getItemName(ItemLike item) {
		return Registry.ITEM.getKey(item.asItem()).getPath();
	}
}