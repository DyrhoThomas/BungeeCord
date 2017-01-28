package nl.dyrhonetwork.bungee.BungeeCord.MOTD;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.Favicon;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.ServerPing.Protocol;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Listeners implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onServerPing(ProxyPingEvent e) {
		ServerPing response = e.getResponse();
		
		String description = "§9§l[§bDyrhoNetwork§9§l] §9§l[§b1.8, 1.9, §l1.10§b & 1.11§9§l]\n§9§lStatus: §bWaiting for grand opening!";
		Protocol protocol = new Protocol("§9§lBest version: §b1.10", response.getVersion().getProtocol());
		Favicon favicon = response.getFaviconObject();
		
		Players players = response.getPlayers();
		
		int maxPlayers =players.getOnline();
		if(maxPlayers >= BungeeCord.getInstance().config.getPlayerLimit()) {
			maxPlayers= BungeeCord.getInstance().config.getPlayerLimit();
		} else {
			maxPlayers = maxPlayers + 1;
		}
		
		players = new Players(maxPlayers, players.getOnline(), players.getSample());
		
		ServerPing ping = new ServerPing(protocol, players, description, favicon);
		
		e.setResponse(ping);
	}
}
