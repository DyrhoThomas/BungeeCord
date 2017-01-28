package nl.dyrhonetwork.bungee.BungeeCord.StaffChat;

import java.util.List;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import nl.dyrhonetwork.bungee.BungeeCord.Main;

public class Command extends net.md_5.bungee.api.plugin.Command  {
	
	private static List<ProxiedPlayer> staffChatMembers = Main.staffChatMembers;
	
	public Command() {
		super("staffchat", "", new String[0]);
	}
	
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof ProxiedPlayer)) {
			return;
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if(staffChatMembers.contains(p)) {
			staffChatMembers.remove(p);
			TextComponent line1 = new TextComponent("You left the staff-chat! Use /staffchat again to join it!");
			line1.setColor(ChatColor.AQUA);
			p.sendMessage(line1);
		} else {
			if(p.hasPermission("bungee.moderator")) {
				staffChatMembers.add(p);
				TextComponent line1 = new TextComponent("From now on you can talk in staff-chat! Wanna leave? Use /staffchat again!");
				line1.setColor(ChatColor.AQUA);
				p.sendMessage(line1);
			} else {
				TextComponent line1 = new TextComponent("You don't have permission for this!");
				line1.setColor(ChatColor.RED);
				p.sendMessage(line1);
			}
		}
	}
}
