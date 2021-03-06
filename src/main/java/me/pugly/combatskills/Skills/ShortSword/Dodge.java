package me.pugly.combatskills.Skills.ShortSword;

import me.pugly.combatskills.CombatSkills;
import me.pugly.combatskills.Inputs.Input;
import me.pugly.combatskills.Skills.Skill;
import me.pugly.combatskills.Skills.WeaponType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.LinkedList;

public class Dodge extends Skill {


    public Dodge() {
        super(new LinkedList<>(Arrays.asList(
                Input.LCLICK, Input.CROUCH, Input.LCLICK
        )), WeaponType.SHORTSWORD);
    }

    @Override
    public void trigger(Player player) {
        Location pos1 = player.getLocation();
        Bukkit.getScheduler().runTaskLater(CombatSkills.getPlugin(), ()-> {
            player.getWorld().spawnParticle(Particle.SPIT, player.getLocation().add(0, 1, 0), 30, 0.3, 0.7, 0.3, 0);
            Vector move = player.getLocation().toVector().subtract(pos1.toVector()).normalize();
            player.setVelocity(player.getVelocity().add(move.multiply(0.7)).setY(0.3));
        }, 1L);
    }
}
