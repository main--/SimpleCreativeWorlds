package me.main__.SimpleCreativeWorlds;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;

public class Util {
	public static final Logger logger = Logger.getLogger("Minecraft");
	private static SimpleCreativeWorlds plugin = null;
	
	public static void log(String message)
	{
		log(message, Level.INFO);
	}
	public static void log(String message, Level loglevel)
	{
		logger.log(loglevel, "[SimpleCreativeWorlds] message".replace("message", message));
	}
	
	public static void setParent(SimpleCreativeWorlds instance)
	{
		plugin = instance;
	}
	
	public static SimpleCreativeWorlds getParent()
	{
		if (plugin != null)
			return plugin;
		else {
			Util.log("I was trying to get the plugin-instance, but it's null! Please report this!", Level.WARNING);
			try {
				plugin = (SimpleCreativeWorlds) Bukkit.getServer().getPluginManager().getPlugin("SimpleCreativeWorlds");
			} catch (Exception e) {
				e.printStackTrace();
				Util.log("Sorry, it's impossible for me to get my hands on a instance of the plugin. I can't even disable it so you'll get spammed with these errors. :( Sorry...", Level.SEVERE);
			}
			return null;
		}
	}
}
