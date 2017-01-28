package nl.dyrhonetwork.bungee.BungeeCord.JoinEvents;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import nl.dyrhonetwork.bungee.BungeeCord.Main;

public class ProxyJoinListener implements Listener {
	//@SuppressWarnings("deprecation")
	@EventHandler
	public void onPostLogin(PostLoginEvent e) {
		//if(!e.getPlayer().hasPermission("bungee.builder")) {
		//	e.getPlayer().disconnect("§cDe server is helaas nog niet open!");
		//}
		
		ProxiedPlayer p = e.getPlayer();
		
		ServerInfo target = ProxyServer.getInstance().getServerInfo("lobby");
		p.connect(target);
		
		//LINE 1
		TextComponent line1 = new TextComponent("-----------------------------------------------------");
		line1.setColor(ChatColor.DARK_AQUA);
		
		p.sendMessage(line1);
		
		//LINE 2
		TextComponent line2part1 = new TextComponent("Welcome ");
		line2part1.setColor(ChatColor.AQUA);
		
		TextComponent line2part2 = new TextComponent(p.getName());
		line2part2.setColor(ChatColor.DARK_AQUA);
		
		TextComponent line2part3 = new TextComponent(" on our server!");
		line2part1.setColor(ChatColor.AQUA);
		
		line2part1.addExtra(line2part2);
		line2part1.addExtra(line2part3);
		
		p.sendMessage(line2part1);
		
		//LINE 3
		if(p.hasPermission("bungee.moderator")) {
			Main.staffChatMembers.add(p);
			
			TextComponent line3 = new TextComponent("You have been added to the staff-chat! You can talk there by starting your messages " + 
			"with a '@'!");
			line3.setColor(ChatColor.AQUA);
			
			p.sendMessage(line3);
		}
		
		//LINE 4
		TextComponent line4 = new TextComponent("-----------------------------------------------------");
		line4.setColor(ChatColor.DARK_AQUA);
		
		p.sendMessage(line4);
	}
}
