package me.main__.SimpleCreativeWorlds;

import org.bukkit.GameMode;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class SimpleCreativeWorldsPlayerListener extends PlayerListener {

	@Override
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		//check if the player was teleported to one of the creative worlds
		if (SimpleCreativeWorlds.worlds.contains(event.getTo().getWorld().getName()))
		{
			//yes? then go on and set his gamemode to creative!
			event.getPlayer().setGameMode(GameMode.CREATIVE);
		}
		else
		{
			//no.... Send him back to survival mode immediately!
			event.getPlayer().setGameMode(GameMode.SURVIVAL);
		}
	}
	
}
