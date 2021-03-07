package myriad.combatskills.Events;

import myriad.combatskills.Skills.Skill;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CombatSkillEvent extends Event implements Cancellable {

    private final Player player;
    private final Skill skill;
    private boolean cancelled = false;
    private static final HandlerList HANDLERS = new HandlerList();

    public CombatSkillEvent(Player p, Skill s) {
        player = p;
        skill = s;
    }


    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public Skill getSkill() {
        return skill;
    }

    public Player getPlayer() {
        return player;
    }
}
