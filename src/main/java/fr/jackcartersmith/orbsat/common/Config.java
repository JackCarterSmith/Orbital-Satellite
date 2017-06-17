package fr.jackcartersmith.orbsat.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;

import fr.jackcartersmith.orbsat.common.util.OSLogger;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
	public static HashMap<String, Boolean> manual_bool = new HashMap<String, Boolean>();
	public static HashMap<String, Integer> manual_int = new HashMap<String, Integer>();
	public static HashMap<String, int[]> manual_intA = new HashMap<String, int[]>();
	public static HashMap<String, Double> manual_double = new HashMap<String, Double>();
	public static HashMap<String, double[]> manual_doubleA = new HashMap<String, double[]>();

	public static boolean seaonal_festive = false;

	@net.minecraftforge.common.config.Config(modid="orbsat")
	public static class OSConfig
	{
		//Wire Stuff
		@Comment({"Drop connections with non-existing endpoints when loading the world. Use with care and backups and only when suspecting corrupted data.", "This option will check and load all connection endpoints and may slow down the world loading process."})
		public static boolean validateConnections = false;
		@Comment({"The transfer rates in Flux/t for the wire tiers (copper, electrum, HV, Structural Rope, Cable & Redstone(no transfer) )"})
		@Mapped(mapClass = Config.class, mapName = "manual_intA")
		public static int[] wireTransferRate = new int[]{2048, 8192, 32768, 0, 0, 0};
		@Comment({"The percentage of power lost every 16 blocks of distance for the wire tiers (copper, electrum, HV, Structural Rope, Cable & Redstone(no transfer) )"})
		public static double[] wireLossRatio = new double[]{.05, .025, .025, 1, 1, 1};
		@Comment({"The RGB colourate of the wires."})
		public static int[] wireColouration = new int[]{0xb36c3f, 0xeda045, 0x6f6f6f, 0x967e6d, 0x6f6f6f, 0xff2f2f};
		@Comment({"The maximum length wire can have. Copper and Electrum should be similar, Steel is meant for long range transport, Structural Rope & Cables are purely decorational"})
		public static int[] wireLength = new int[]{16, 16, 32, 32, 32, 32};

		@Comment({"By default all devices that accept cables have increased renderbounds to show cables even if the block itself is not in view.", "Disabling this reduces them to their minimum sizes, which might improve FPS on low-power PCs"})
		public static boolean increasedRenderboxes = true;
		@Comment({"Support for colourblind people, gives a text-based output on capacitor sides"})
		public static boolean colourblindSupport = false;
		@Comment({"Set this to false to disable the super awesome looking nixie tube front for the voltmeter and other things"})
		public static boolean nixietubeFont = true;
		@Comment({"Set this to false to disable the manual's forced change of GUI scale"})
		public static boolean adjustManualScale = false;
		@Comment({"Set this to true if you suffer from bad eyesight. The Engineer's manual will be switched to a bold and darker text to improve readability.", "Note that this may lead to a break of formatting and have text go off the page in some instances. This is unavoidable."})
		public static boolean badEyesight = false;
		@Comment({"Controls if item tooltips should contain the OreDictionary names of items. These tooltips are only visible in advanced tooltip mod (F3+H)"})
		public static boolean oreTooltips = true;
		@Comment({"Increase the distance at which certain TileEntities (specifically windmills) are still visible. This is a modifier, so set it to 1 for default render distance, to 2 for doubled distance and so on."})
		public static double increasedTileRenderdistance = 1.5;
		@Comment({"Set this to false to hide the update news in the manual"})
		public static boolean showUpdateNews = true;
		@Comment({"Set this to false to stop the IE villager house from spawning"})
		public static boolean villagerHouse = true;
		@Comment({"Set this to false to remove IE villagers from the game"})
		public static boolean enableVillagers = true;
		@Comment({"The weight that hempseeds have when breaking tall grass. 5 by default, set to 0 to disable drops"})
		public static int hempSeedWeight = 5;


		public static Machines machines = new Machines();
		public static Ores ores = new Ores();
		public static Tools tools = new Tools();


		public static class Machines
		{
			//Connectors
			@Comment({"In- and output rates of LV,MV and HV Wire Conenctors. This is independant of the transferrate of the wires."})
			@Mapped(mapClass = Config.class, mapName = "manual_intA")
			public static int[] wireConnectorInput = new int[]{256, 1024, 4096};
			//Capacitors
			@Comment({"The maximum amount of Flux that can be stored in a low-voltage capacitor"})
			public static int capacitorLV_storage = 100000;
			@Comment({"The maximum amount of Flux that can be input into a low-voltage capacitor (by IE net or other means)"})
			public static int capacitorLV_input = 256;
			@Comment({"The maximum amount of Flux that can be output from a low-voltage capacitor (by IE net or other means)"})
			public static int capacitorLV_output = 256;
			@Comment({"The maximum amount of Flux that can be stored in a medium-voltage capacitor"})
			public static int capacitorMV_storage = 1000000;
			@Comment({"The maximum amount of Flux that can be input into a medium-voltage capacitor (by IE net or other means)"})
			public static int capacitorMV_input = 1024;
			@Comment({"The maximum amount of Flux that can be output from a medium-voltage capacitor (by IE net or other means)"})
			public static int capacitorMV_output = 1024;
			@Comment({"The maximum amount of Flux that can be stored in a high-voltage capacitor"})
			public static int capacitorHV_storage = 4000000;
			@Comment({"The maximum amount of Flux that can be input into a high-voltage capacitor (by IE net or other means)"})
			public static int capacitorHV_input = 4096;
			@Comment({"The maximum amount of Flux that can be output from a high-voltage capacitor (by IE net or other means)"})
			public static int capacitorHV_output = 4096;

			//Generators
			@Comment({"The base Flux that is output by the dynamo. This will be modified by the rotation modifier of the attached water- or windmill"})
			public static double dynamo_output = 3d;
			@Comment({"Output modifier for the energy created by the Thermoelectric Generator"})
			public static double thermoelectric_output = 1d;
			@Comment({"The Flux that will be output by the lightning rod when it is struck"})
			public static int lightning_output = 4 * 4000000;
			@Comment({"The Flux per tick that the Diesel Generator will output. The burn time of the fuel determines the total output"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int dieselGen_output = 4096;

			//Simple Machines
			@Comment({"The Flux per tick consumed to add one heat to a furnace. Creates up to 4 heat in the startup time and then 1 heat per tick to keep it running"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int heater_consumption = 8;
			@Comment({"The Flux per tick consumed to double the speed of the furnace. Only happens if furnace is at maximum heat."})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int heater_speedupConsumption = 24;
			@Comment({"The Flux per tick the Blast Furnace Preheater will consume to speed up the Blast Furnace"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int preheater_consumption = 32;
			@Comment({"The length in ticks it takes for the Core Sample Drill to figure out which mineral is found in a chunk"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int coredrill_time = 200;
			@Comment({"The Flux per tick consumed by the Core Sample Drill"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int coredrill_consumption = 40;
			@Comment({"The Flux the Fluid Pump will consume to pick up a fluid block in the world"})
			public static int pump_consumption = 250;
			@Comment({"The Flux the Fluid Pump will consume pressurize+accellerate fluids, increasing the transferrate"})
			public static int pump_consumption_accelerate = 5;
			@Comment({"Set this to false to disable the fluid pump being able to draw infinite water from sources"})
			@Mapped(mapClass = Config.class, mapName = "manual_bool")
			public static boolean pump_infiniteWater = true;
			@Comment({"If this is set to true (default) the pump will replace fluids it picks up with cobblestone in order to reduce lag caused by flowing fluids."})
			@Mapped(mapClass = Config.class, mapName = "manual_bool")
			public static boolean pump_placeCobble = true;
			@Comment({"The Flux per tick the Charging Station can insert into an item"})
			public static int charger_consumption = 256;
			@Comment({"The Flux per tick the Tesla Coil will consume, simply by being active"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int teslacoil_consumption = 256;
			@Comment({"The amount of Flux the Tesla Coil will consume when shocking an entity"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int teslacoil_consumption_active = 512;
			@Comment({"The amount of damage the Tesla Coil will do when shocking an entity"})
			public static float teslacoil_damage = 6;
			@Comment({"The Flux per tick any turret consumes to monitor the area"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int turret_consumption = 64;
			@Comment({"The Flux per tick the chemthrower turret consumes to shoot"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int turret_chem_consumption = 32;
			@Comment({"The Flux per tick the gun turret consumes to shoot"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int turret_gun_consumption = 32;
			@Comment({"The Flux per tick the belljar consumes to grow plants"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int belljar_consumption = 8;
			@Comment({"The amount of ticks one dose of fertilizer lasts in the belljar"})
			public static int belljar_fertilizer = 6000;
			@Comment({"The amount of fluid the belljar uses per dose of fertilizer"})
			public static int belljar_fluid = 250;

			//Lights
			@Comment({"Set this to false to disable the mob-spawn prevention of the Powered Lantern"})
			public static boolean lantern_spawnPrevent = true;
			@Comment({"How much Flux the powered lantern draws per tick"})
			public static int lantern_energyDraw = 1;
			@Comment({"How much Flux the powered lantern can hold (should be greater than the power draw)"})
			public static int lantern_maximumStorage = 10;
			@Comment({"Set this to false to disable the mob-spawn prevention of the Floodlight"})
			public static boolean floodlight_spawnPrevent = true;
			@Comment({"How much Flux the floodlight draws per tick"})
			public static int floodlight_energyDraw = 5;
			@Comment({"How much Flux the floodlight can hold (must be at least 10x the power draw)"})
			public static int floodlight_maximumStorage = 80;


			//Multiblock Recipes
			@Comment({"A modifier to apply to the energy costs of every MetalPress recipe"})
			public static float metalPress_energyModifier = 1;
			@Comment({"A modifier to apply to the time of every MetalPress recipe"})
			public static float metalPress_timeModifier = 1;
			@Comment({"A modifier to apply to the energy costs of every Crusher recipe"})
			public static float crusher_energyModifier = 1;
			@Comment({"A modifier to apply to the time of every Crusher recipe"})
			public static float crusher_timeModifier = 1;
			@Comment({"A modifier to apply to the energy costs of every Squeezer recipe"})
			public static float squeezer_energyModifier = 1;
			@Comment({"A modifier to apply to the time of every Squeezer recipe"})
			public static float squeezer_timeModifier = 1;
			@Comment({"A modifier to apply to the energy costs of every Fermenter recipe"})
			public static float fermenter_energyModifier = 1;
			@Comment({"A modifier to apply to the time of every Fermenter recipe"})
			public static float fermenter_timeModifier = 1;
			@Comment({"A modifier to apply to the energy costs of every Refinery recipe"})
			public static float refinery_energyModifier = 1;
			@Comment({"A modifier to apply to the time of every Refinery recipe. Can't be lower than 1"})
			public static float refinery_timeModifier = 1;
			@Comment({"A modifier to apply to the energy costs of every Arc Furnace recipe"})
			public static float arcFurnace_energyModifier = 1;
			@Comment({"A modifier to apply to the time of every Arc Furnace recipe"})
			public static float arcFurnace_timeModifier = 1;
			@Comment({"The maximum amount of damage Graphite Electrodes can take. While the furnace is working, electrodes sustain 1 damage per tick, so this is effectively the lifetime in ticks. The default value of 96000 makes them last for 8 consecutive ingame days"})
			public static int arcfurnace_electrodeDamage = 96000;
			@Comment({"Set this to true to make the blueprint for graphite electrodes craftable in addition to villager/dungeon loot"})
			@Mapped(mapClass = Config.class, mapName = "manual_bool")
			public static boolean arcfurnace_electrodeCrafting = false;
			@Comment({"Set this to false to disable the Arc Furnace's recycling of armors and tools"})
			public static boolean arcfurnace_recycle = true;
			@Comment({"A modifier to apply to the energy costs of every Automatic Workbench recipe"})
			public static float autoWorkbench_energyModifier = 1;
			@Comment({"A modifier to apply to the time of every Automatic Workbench recipe"})
			public static float autoWorkbench_timeModifier = 1;
			@Comment({"A modifier to apply to the energy costs of every Bottling Machine's process"})
			public static float bottlingMachine_energyModifier = 1;
			@Comment({"A modifier to apply to the time of every Bottling Machine's process"})
			public static float bottlingMachine_timeModifier = 1;
			@Comment({"A modifier to apply to the energy costs of every Mixer's process"})
			public static float mixer_energyModifier = 1;
			@Comment({"A modifier to apply to the time of every Mixer's process"})
			public static float mixer_timeModifier = 1;

			//Other Multiblock machines
			@Comment({"The Flux the Assembler will consume to craft an item from a recipe"})
			public static int assembler_consumption = 80;
			//@Comment({"The Flux the Bottling Machine will consume per tick, when filling items"})
			//public static int bottlingMachine_consumption = 8;
			@Comment({"The Flux per tick the Excavator will consume to dig"})
			@Mapped(mapClass = Config.class, mapName = "manual_int")
			public static int excavator_consumption = 4096;
			@Comment({"The speed of the Excavator. Basically translates to how many degrees per tick it will turn."})
			public static double excavator_speed = 1d;
			@Comment({"Set this to false to disable the ridiculous amounts of particles the Excavator spawns"})
			public static boolean excavator_particles = true;
			@Comment({"The chance that a given chunk will contain a mineral vein."})
			public static double excavator_chance = .2d;
			@Comment({"The chance that the Excavator will not dig up an ore with the currently downward-facing bucket."})
			public static double excavator_fail_chance = .05d;
			@Comment({"The maximum amount of yield one can get out of a chunk with the excavator. Set a number smaller than zero to make it infinite"})
			public static int excavator_depletion = 38400;
			@Comment({"List of dimensions that can't contain minerals. Default: The End."})
			public static int[] excavator_dimBlacklist = new int[]{1};

		}

		public static class Ores
		{
			@Comment({"Generation config for Copper Ore.", "Parameters: Vein size, lowest possible Y, highest possible Y, veins per chunk, chance for vein to spawn (out of 100). Set vein size to 0 to disable the generation"})
			@Mapped(mapClass = Config.class, mapName = "manual_intA")
			public static int[] ore_copper = new int[]{8, 40, 72, 8, 100};
			@Comment({"Generation config for Bauxite Ore.", "Parameters: Vein size, lowest possible Y, highest possible Y, veins per chunk, chance for vein to spawn (out of 100). Set vein size to 0 to disable the generation"})
			@Mapped(mapClass = Config.class, mapName = "manual_intA")
			public static int[] ore_bauxite = new int[]{4, 40, 85, 8, 100};
			@Comment({"Generation config for Lead Ore.", "Parameters: Vein size, lowest possible Y, highest possible Y, veins per chunk, chance for vein to spawn (out of 100). Set vein size to 0 to disable the generation"})
			@Mapped(mapClass = Config.class, mapName = "manual_intA")
			public static int[] ore_lead = new int[]{6, 8, 36, 4, 100};
			@Comment({"Generation config for Silver Ore.", "Parameters: Vein size, lowest possible Y, highest possible Y, veins per chunk, chance for vein to spawn (out of 100). Set vein size to 0 to disable the generation"})
			@Mapped(mapClass = Config.class, mapName = "manual_intA")
			public static int[] ore_silver = new int[]{8, 8, 40, 4, 80};
			@Comment({"Generation config for Nickel Ore.", "Parameters: Vein size, lowest possible Y, highest possible Y, veins per chunk, chance for vein to spawn (out of 100). Set vein size to 0 to disable the generation"})
			@Mapped(mapClass = Config.class, mapName = "manual_intA")
			public static int[] ore_nickel = new int[]{6, 8, 24, 2, 100};
			@Comment({"Generation config for Uranium Ore.", "Parameters: Vein size, lowest possible Y, highest possible Y, veins per chunk, chance for vein to spawn (out of 100). Set vein size to 0 to disable the generation"})
			@Mapped(mapClass = Config.class, mapName = "manual_intA")
			public static int[] ore_uranium = new int[]{4, 8, 24, 2, 60};
			@Comment({"A blacklist of dimensions in which IE ores won't spawn. By default this is Nether (-1) and End (1)"})
			public static int[] oreDimBlacklist = new int[]{-1, 1};
			@Comment({"Set this to false to disable the logging of the chunks that were flagged for retrogen."})
			public static boolean retrogen_log_flagChunk = true;
			@Comment({"Set this to false to disable the logging of the chunks that are still left to retrogen."})
			public static boolean retrogen_log_remaining = true;
			@Comment({"The retrogeneration key. Basically IE checks if this key is saved in the chunks data. If it isn't, it will perform retrogen on all ores marked for retrogen.", "Change this in combination with the retrogen booleans to regen only some of the ores."})
			public static String retrogen_key = "DEFAULT";
		}


		public static class Tools
		{
			@Comment({"Set this to true to completely disable the ore-crushing recipes with the Engineers Hammer"})
			public static boolean disableHammerCrushing = false;
			@Comment({"The maximum durability of the Engineer's Hammer. Used up when hammering ingots into plates."})
			public static int hammerDurabiliy = 100;
			@Comment({"The maximum durability of the Wirecutter. Used up when cutting plates into wire."})
			public static int cutterDurabiliy = 250;
			//@Comment({"Enable this to use the old, harder bullet recipes(require one ingot per bullet)"});
			//public static boolean hardmodeBulletRecipes = false;
			@Comment({"The amount of base damage a Casull Cartridge inflicts"})
			public static float bulletDamage_Casull = 10f;
			@Comment({"The amount of base damage an ArmorPiercing Cartridge inflicts"})
			public static float bulletDamage_AP = 10f;
			@Comment({"The amount of base damage a single part of Buckshot inflicts"})
			public static float bulletDamage_Buck = 2f;
			@Comment({"The amount of base damage a DragonsBreath Cartridge inflicts"})
			public static float bulletDamage_Dragon = 3f;
			@Comment({"The amount of base damage a Homing Cartridge inflicts"})
			public static float bulletDamage_Homing = 10f;
			@Comment({"The amount of base damage a Wolfpack Cartridge inflicts"})
			public static float bulletDamage_Wolfpack = 6f;
			@Comment({"The amount of damage the sub-projectiles of the Wolfpack Cartridge inflict"})
			public static float bulletDamage_WolfpackPart = 4f;
			@Comment({"The amount of damage a silver bullet inflicts"})
			public static float bulletDamage_Silver = 10f;
			@Comment({"The amount of base damage a Phial Cartridge inflicts"})
			public static float bulletDamage_Potion = 1f;

			@Comment({"A list of sounds that should not be muffled by the Ear Defenders. Adding to this list requires knowledge of the correct sound resource names."})
			public static String[] earDefenders_SoundBlacklist = new String[]{};
			@Comment({"The mb of fluid the Chemical Thrower will consume per tick of usage"})
			public static int chemthrower_consumption = 10;
			@Comment({"The base amount of Flux consumed per shot by the Railgun"})
			public static int railgun_consumption = 800;
			@Comment({"A modifier for the damage of all projectiles fired by the Railgun"})
			public static float railgun_damage = 1f;
		}
	}

	static Configuration config;
	public static void preInit(FMLPreInitializationEvent event)
	{
		if(OSConfig.validateConnections)
			OSLogger.warn("Connection validation enabled");

		Calendar calendar = Calendar.getInstance();
		seaonal_festive = calendar.get(Calendar.MONTH)+1==12;//December

		checkMappedValues(OSConfig.class);
	}

	public static void checkMappedValues(Class confClass)
	{
		for(Field f : confClass.getDeclaredFields())
		{
			Mapped mapped = f.getAnnotation(Mapped.class);
			if(mapped!=null)
				try
				{
					Class c = mapped.mapClass();
					if(c!=null)
					{
						Field mapField = c.getDeclaredField(mapped.mapName());
						if(mapField!=null)
						{
							Map map = (Map)mapField.get(null);
							if(map!=null)
								map.put(f.getName(),f.get(null));
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			else if(f.getType().getSuperclass()==Object.class) //Only support classes that are one level below Object.
			{
				checkMappedValues(f.getType());
			}
		}
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface Mapped
	{
		Class mapClass();
		String mapName();
	}
}