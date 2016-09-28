PlayerLagReducer is a simple vanishing plugin that hides all the players that are on. It is useful for Bungee servers since, when a server crashes and everyone is pushed to the lobby, the sudden spike of the number of players in the same chunk often causes clients of players with low end computers to crash. This plugin helps decrease this as it hides all the players upon joining the server. There are certain commands that can let people see those who are online, useful for OPs/Staff. The plugin also has an option that allows you to set a limit so that, if the number of players online goes above that limit, everyone gets vanished. Otherwise they are visible. When vanish is active, the players can still chat, just that they cannot see each other.

Please report any issues with this plugin [HERE](https://github.com/vik1395/PlayerLagReducer-Minecraft/issues)

If you like my work, please consider donating, I would greatly appreciate it. [![Image](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=vik1395lp%40gmail%2ecom&lc=US&item_name=Spigot%20Plugins&item_number=LegitPlay%2enet%20Plugin%20Dev&no_note=0&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest)

**Commands:**
-------------
    /showall, /show, /sa - Shows all hidden players to the command executor. The Executor remains hidden to the players.
    
    /hideall, /hide, /ha - Hides all players that had been shown by the /showall command.

**Permissions:**
-------------
    playerlagreducer.showall - Grants use of /showall command
    
    playerlagreducer.hideall - Grants use of /hideall command

**Config File:**
-------------
    Vanish Players at: 5
    
    # The plugin vanishes all players if the number of players online goes above the given limit.

This plugin is licensed under [CC Attribution-NonCommercial-ShareAlike 4.0 International](http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en_US). 

In very basic terms, Do whatever you want with the code of this plugin, as long as you give credits to the author and/or the plugin itself.
