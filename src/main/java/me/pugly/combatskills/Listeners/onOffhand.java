package me.pugly.combatskills.Listeners;

import me.pugly.combatskills.Inputs.Inputs;
import me.pugly.combatskills.PlayerHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class onOffhand implements Listener {

    @EventHandler
    public void listen(PlayerSwapHandItemsEvent e) {
        PlayerHandler.registerPlayer(e.getPlayer());

        e.setCancelled(true);
    }

}
