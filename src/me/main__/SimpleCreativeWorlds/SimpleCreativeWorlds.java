package me.main__.SimpleCreativeWorlds;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class SimpleCreativeWorlds extends JavaPlugin {
	
	public static List<String> worlds = new ArrayList<String>();

	@Override
	public void onEnable() {
		//read worlds from config
		Configuration c = this.getConfiguration();
		worlds = c.getStringList("worlds", null);
		
		if (worlds.isEmpty())
		{
			Util.log("No creative worlds are configured so SimpleCreativeWorlds is useless! - Disabling...", Level.WARNING);
			this.getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Type.PLAYER_TELEPORT, null, Priority.Monitor, this);
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub

	}

}
