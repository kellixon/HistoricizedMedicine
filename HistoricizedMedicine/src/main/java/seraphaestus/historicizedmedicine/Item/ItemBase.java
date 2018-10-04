package seraphaestus.historicizedmedicine.Item;


import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import seraphaestus.historicizedmedicine.Config;
import seraphaestus.historicizedmedicine.HMedicineMod;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBase extends Item implements IItemBaseData {

	String id;
	String name;
	int stackSize = 64;
	String oreDictName = null;
	String[] tooltip = null;

	public ItemBase(String id) {
		this.id = id;
		this.name = HMedicineMod.MODID + "." + id;
		if (Config.enableCreativeTab) {
			setCreativeTab(HMedicineMod.creativeTab);
		}
	}

	public ItemBase(String id, int stackSize) {
		this(id);
		this.stackSize = stackSize;
	}

	public ItemBase(String id, int stackSize, String oreDictName) {
		this(id, stackSize);
		this.oreDictName = oreDictName;
	}

	public ItemBase(String id, int stackSize, String oreDictName, String[] tooltip) {
		this(id, stackSize, oreDictName);
		this.tooltip = tooltip;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getStackSize() {
		return this.stackSize;
	}

	public void init() {
		if (oreDictName != null) {
			OreDictionary.registerOre(oreDictName, this);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
		if (this.tooltip != null) {
			for (String s : this.tooltip) {
				tooltip.add(s);
			}
		}
	}
}
