package myriad.combatskills.Listeners;

import myriad.combatskills.PlayerHandler;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class onInventoryInteract implements Listener {

    @EventHandler
    public void listen(InventoryClickEvent e) {
        if (PlayerHandler.isRegistered((Player) e.getWhoClicked())) {
            PlayerHandler.unregisterPlayer((Player) e.getWhoClicked());
            ((Player) e.getWhoClicked()).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
        }
    }

}
