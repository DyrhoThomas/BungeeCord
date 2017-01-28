package nl.dyrhonetwork.bungee.BungeeCord;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import nl.dyrhonetwork.bungee.BungeeCord.StaffChat.Command;

public class Main extends Plugin {
	
	public static List<ProxiedPlayer> staffChatMembers = new ArrayList<ProxiedPlayer>();
	
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerListener(this, 
				new nl.dyrhonetwork.bungee.BungeeCord.JoinEvents.ProxyJoinListener());
		getProxy().getPluginManager().registerListener(this, 
				new nl.dyrhonetwork.bungee.BungeeCord.StaffChat.Listeners());
		getProxy().getPluginManager().registerListener(this, 
				new nl.dyrhonetwork.bungee.BungeeCord.MOTD.Listeners());
		
		getProxy().getPluginManager().registerCommand(this, new Command());
	}
}
