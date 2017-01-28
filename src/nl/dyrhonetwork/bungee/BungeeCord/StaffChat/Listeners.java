package nl.dyrhonetwork.bungee.BungeeCord.StaffChat;

import java.util.List;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import nl.dyrhonetwork.bungee.BungeeCord.Main;

public class Listeners implements Listener {
	
	private static List<ProxiedPlayer> staffChatMembers = Main.staffChatMembers;
	
	@EventHandler
	public void onChatEvent(ChatEvent e) {
		if(!(e.getSender() instanceof ProxiedPlayer)) {
			return;
		}
		if(!e.getMessage().startsWith("@")) {
			return;
		}
		ProxiedPlayer sender = (ProxiedPlayer) e.getSender();
		if(staffChatMembers.contains(sender)) {
			e.setCancelled(true);
			for(ProxiedPlayer staffPlayer : staffChatMembers) {
				TextComponent part1 = new TextComponent("[STAFF]");
				part1.setColor(ChatColor.GREEN);
				TextComponent part2 = new TextComponent(" " + sender.getName() + " >> ");
				part2.setColor(ChatColor.AQUA);
				TextComponent part3 = new TextComponent(e.getMessage().replaceFirst("@", ""));
				part3.setColor(ChatColor.GREEN);
				part1.addExtra(part2);
				part1.addExtra(part3);
				staffPlayer.sendMessage(part1);
				//TextComponent line2 = new TextComponent("Je bent toegevoegd aan de staff-chat!");
				//line1.setColor(ChatColor.AQUA);
			}
		}
	}
}
