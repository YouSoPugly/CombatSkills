package myriad.combatskills.Skills.Spear;

import myriad.combatskills.CombatSkills;
import myriad.combatskills.Inputs.Input;
import myriad.combatskills.Skills.Skill;
import myriad.combatskills.Skills.WeaponType;
import myriad.core.Utils.ParticleUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.LinkedList;

public class Pierce extends Skill {

    public Pierce() {

        super(new LinkedList<>(Arrays.asList(
                Input.LCLICK, Input.RCLICK, Input.CROUCH, Input.LCLICK, Input.LCLICK, Input.RCLICK
        )), WeaponType.SPEAR, "Pierce");
    }

    @Override
    public void trigger(Player player) {
        double yaw = player.getLocation().getYaw();
        player.setVelocity(player.getVelocity().add(new Vector(-Math.sin(Math.toRadians(yaw)) * 0.7, 0, Math.cos(Math.toRadians(yaw))*0.7)).setY(0.3));
        Bukkit.getScheduler().runTaskTimer(CombatSkills.getPlugin(), (BukkitTask) -> {

        }, 0L, 1L);
    }

    public String getName() {
        return "Pierce";
    }
}
