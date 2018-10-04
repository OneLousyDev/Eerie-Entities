package com.jarhax.spooky;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabSpooky extends CreativeTabs {
    
    public CreativeTabSpooky() {
        
        super(SpookyMod.MODID);
    }
    
    @Override
    public ItemStack createIcon () {
        
        return new ItemStack(Blocks.LIT_PUMPKIN);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems (NonNullList<ItemStack> itemList) {
        
        super.displayAllRelevantItems(itemList);
        
        for (final ResourceLocation id : SpookyMod.REGISTRY.getEntityIds()) {
            
            final ItemStack spawner = new ItemStack(Items.SPAWN_EGG);
            ItemMonsterPlacer.applyEntityIdToItemStack(spawner, id);
            itemList.add(spawner);
        }
    }
}