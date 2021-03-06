package me.pugly.combatskills.Skills.Spear;

import me.pugly.combatskills.Inputs.Input;
import me.pugly.combatskills.Skills.Skill;
import me.pugly.combatskills.Skills.WeaponType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pierce extends Skill {

    public Pierce() {

        super(new LinkedList<>(Arrays.asList(
                Input.LCLICK, Input.RCLICK, Input.CROUCH, Input.LCLICK, Input.LCLICK, Input.RCLICK
        )), WeaponType.SPEAR);
    }

    @Override
    public void trigger(Player player) {
        player.sendMessage("Pierce");
        // This'll fix it
    }
}
