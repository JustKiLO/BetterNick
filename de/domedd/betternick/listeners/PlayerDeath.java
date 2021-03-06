/*
 * All rights by DomeDD
 * You are allowed to modify this code
 * You are allowed to use this code in your plugins for private projects
 * You are allowed to publish your plugin including this code as long as your plugin is for free 
 * You are NOT allowed to claim this plugin as your own
 * You are NOT allowed to publish this plugin or your modified version of this plugin
 * 
 */
package de.domedd.betternick.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.domedd.betternick.BetterNick;
import de.domedd.betternick.api.nickedplayer.NickedPlayer;

public class PlayerDeath implements Listener {

	private BetterNick pl;
	
	public PlayerDeath(BetterNick main) {
		this.pl = main;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if(pl.getConfig().getBoolean("Config.Skin Self Update")) {
			NickedPlayer np = new NickedPlayer(p);
			if(np.exists()) {
				e.setKeepInventory(true);
				e.setDeathMessage(null);
			}
		}
	}
}
