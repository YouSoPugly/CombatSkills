package myriad.combatskills.Skills.ShortSword;

import myriad.combatskills.CombatSkills;
import myriad.combatskills.Inputs.Input;
import myriad.combatskills.Skills.Skill;
import myriad.combatskills.Skills.WeaponType;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;

public class HighJump extends Skill {


    public HighJump() {
        super(new LinkedList<>(Arrays.asList(
                Input.CROUCH, Input.CROUCH, Input.LCLICK, Input.RCLICK, Input.LCLICK, Input.RCLICK
        )), WeaponType.SHORTSWORD);
    }

    @Override
    public void trigger(Player player) {
        player.setVelocity(player.getVelocity().setY(1.2));
        for (double i = 0; i < 2*Math.PI; i += Math.PI/20)
            player.getWorld().spawnParticle(Particle.CRIT, player.getLocation().add(Math.cos(i)/2.7,0,Math.sin(i)/2.7), 0, 0, 0.3, 0, 0);

        Bukkit.getScheduler().runTaskLater(CombatSkills.getPlugin(), ()-> {
            if (player.getVelocity().getY() < 1) {
                player.setVelocity(player.getVelocity().setY(1.2));
            }
        }, 1L);
    }

    public String getName() {
        return "High Jump";
    }
}
