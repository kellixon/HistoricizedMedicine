package seraphaestus.historicizedmedicine;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictRegister {
	
	private static String meatName = "itemMeatRaw";
	private static String honeyName = "itemHoney";
	
	private static List<Item> meats = new ArrayList<Item>();
	private static List<Item> honey = new ArrayList<Item>();
	
	public static void initializeConstants() {
		meats.add(Item.getByNameOrId("minecraft:beef"));
		meats.add(Item.getByNameOrId("minecraft:chicken"));
		meats.add(Item.getByNameOrId("minecraft:mutton"));
		meats.add(Item.getByNameOrId("minecraft:porkchop"));
		meats.add(Item.getByNameOrId("minecraft:rabbit"));
		
		if(Config.implementHoney) {
			honey.add(Item.getByNameOrId("historicizedMedicine:honey"));
		}
		if(Loader.isModLoaded("harvestcraft")) {
			honey.add(Item.getByNameOrId("harvestcraft:honeyitem"));
		}
	}
	
	public static void initOreDict() {
		initializeConstants();
		for(Item i : meats) {
			OreDictionary.registerOre(meatName, i);
		}
		for(Item i : honey) {
			OreDictionary.registerOre(honeyName, i);
		}
	}
	
}
