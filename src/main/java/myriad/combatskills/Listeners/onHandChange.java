package myriad.combatskills.Listeners;

import myriad.combatskills.PlayerHandler;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class onHandChange implements Listener {

    @EventHandler
    public void listen(PlayerItemHeldEvent e) {
        if (PlayerHandler.isRegistered(e.getPlayer())) {
            PlayerHandler.unregisterPlayer(e.getPlayer());
            e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
        }
    }

}
