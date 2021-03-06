package me.pugly.combatskills.Skills.ShortSword;

import me.pugly.combatskills.Inputs.Input;
import me.pugly.combatskills.Skills.Skill;
import me.pugly.combatskills.Skills.WeaponType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.LinkedList;

public class Leap extends Skill {


    public Leap() {
        super(new LinkedList<>(Arrays.asList(
                Input.LCLICK, Input.LCLICK, Input.LCLICK, Input.RCLICK, Input.CROUCH, Input.RCLICK
        )), WeaponType.SHORTSWORD);
    }

    @Override
    public void trigger(Player player) {
        double yaw = player.getLocation().getYaw();

        player.setVelocity(player.getVelocity().add(new Vector(-Math.sin(Math.toRadians(yaw)) * 0.7, 0.8, Math.cos(Math.toRadians(yaw))*0.7)));
    }
}
