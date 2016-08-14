package me.vik1395.LagReducer;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MainVanish extends JavaPlugin implements Listener
{
	private HashMap<String, Boolean> shown = new HashMap<String, Boolean>();
	private HashMap<String, Boolean> showcmd = new HashMap<String, Boolean>();
	
	public void onEnable()
	{
		shown.clear();
		showcmd.clear();
		getServer().getPluginManager().registerEvents(this, this);
		String vanpl = getConfig().getString("Vanish Players at");
		vpli = Integer.parseInt(vanpl);
		getLogger().info("PlayerLagReducer has successfully started!");
		getLogger().info("Created by Vik1395");
		saveDefaultConfig();
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent pje)
	{
		Player p = pje.getPlayer();
		if(Bukkit.getServer().getOnlinePlayers().length<=vpli)
		{
			shown.put(p.getName(), false);
		}
		else
		{
			for(Player pall: Bukkit.getServer().getOnlinePlayers())
			{
				pall.hidePlayer(p);
				p.hidePlayer(pall);
				if(!shown.isEmpty())
				{
					if(shown.containsKey(pall.getName()))
					{
						for (Player pfall: Bukkit.getServer().getOnlinePlayers())
						{
							pall.hidePlayer(pfall);
							pfall.hidePlayer(pall);
						}
						shown.remove(pall.getName());
					}
				}
				if(!showcmd.isEmpty())
				{
					if(showcmd.containsKey(pall.getName()))
					{
						pall.showPlayer(p);
					}
				}
			}
		}
	}
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
	{
		
		if(cmd.getName().equalsIgnoreCase("showall"))
		{
			if(s instanceof Player)
			{
				Player p = (Player) s;
				if(p.hasPermission("playerlagreducer.showall"))
				{
					showcmd.put(p.getName(), false);
					Player[] pall = Bukkit.getServer().getOnlinePlayers();
					int j = pall.length;
					
					for(int i = 0; i < j; i++)
					{
						p.showPlayer(pall[i]);
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("hideall"))
		{
			if(s instanceof Player)
			{
				Player p = (Player) s;
				if(p.hasPermission("playerlagreducer.hideall"))
				{
					Player[] pall = Bukkit.getServer().getOnlinePlayers();
					int j = pall.length;
					showcmd.remove(p.getName());
					for(int i = 0; i < j; i++)
					{
						p.hidePlayer(pall[i]);
					}
				}
			}
		}
		return true;
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent pqe)
	{
		Player p = pqe.getPlayer();
		
		if(!showcmd.isEmpty())
		{
			if(showcmd.containsKey(p.getName()))
			{
				showcmd.remove(p.getName());
			}
		}
		
		if(!shown.isEmpty())
		{
			if(shown.containsKey(p.getName()))
			{
				shown.remove(p.getName());
			}
		}
	}
	
	private int vpli = 0;
}
