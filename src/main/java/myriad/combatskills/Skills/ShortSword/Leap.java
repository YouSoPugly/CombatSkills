package myriad.combatskills.Skills.ShortSword;

import myriad.combatskills.Inputs.Input;
import myriad.combatskills.Skills.Skill;
import myriad.combatskills.Skills.WeaponType;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.LinkedList;

public class Leap extends Skill {


    public Leap() {
        super(new LinkedList<>(Arrays.asList(
                Input.LCLICK, Input.LCLICK, Input.LCLICK, Input.RCLICK, Input.CROUCH, Input.RCLICK
        )), WeaponType.SHORTSWORD, "Leap");
    }

    @Override
    public void trigger(Player player) {
        double yaw = player.getLocation().getYaw();
        player.getWorld().spawnParticle(Particle.SQUID_INK, player.getLocation().add(0, 1, 0), 10, 0.3, 0.7, 0.3, 0);
        player.setVelocity(player.getVelocity().add(new Vector(-Math.sin(Math.toRadians(yaw)) * 0.7, 0.8, Math.cos(Math.toRadians(yaw))*0.7)));
    }

    public String getName() {
        return "Leap";
    }
}
