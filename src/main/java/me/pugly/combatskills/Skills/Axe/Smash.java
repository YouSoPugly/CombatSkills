package me.pugly.combatskills.Skills.Axe;

import me.pugly.combatskills.Inputs.Input;
import me.pugly.combatskills.Skills.Skill;
import me.pugly.combatskills.Skills.WeaponType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;

public class Smash extends Skill {

    public Smash() {
        super(new LinkedList<>(Arrays.asList(
                Input.CROUCH, Input.LCLICK, Input.LCLICK, Input.CROUCH, Input.CROUCH, Input.LCLICK
        )), WeaponType.AXE);
    }

    @Override
    public void trigger(Player player) {
        player.sendMessage("Smash");
    }
}
