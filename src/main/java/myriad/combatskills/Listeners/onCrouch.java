package myriad.combatskills.Listeners;

import myriad.combatskills.Inputs.Input;
import myriad.combatskills.PlayerHandler;
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
