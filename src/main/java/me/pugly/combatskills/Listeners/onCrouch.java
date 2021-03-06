package me.pugly.combatskills.Listeners;

import me.pugly.combatskills.Inputs.Input;
import me.pugly.combatskills.PlayerHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class onCrouch implements Listener {

    @EventHandler
    public void listener(PlayerToggleSneakEvent e) {
        if (e.isSneaking())
            PlayerHandler.addInput(e.getPlayer(), Input.CROUCH);
    }

}
