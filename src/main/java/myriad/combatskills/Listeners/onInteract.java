package myriad.combatskills.Listeners;

import myriad.combatskills.Inputs.Input;
import myriad.combatskills.PlayerHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class onInteract implements Listener {

    @EventHandler
    public void listener(PlayerInteractEvent e) {

        switch (e.getAction()) {
            case LEFT_CLICK_BLOCK:
            case LEFT_CLICK_AIR:
                PlayerHandler.addInput(e.getPlayer(), Input.LCLICK);
                break;
            case RIGHT_CLICK_AIR:
            case RIGHT_CLICK_BLOCK:
                PlayerHandler.addInput(e.getPlayer(), Input.RCLICK);
                break;
        }

    }

}
