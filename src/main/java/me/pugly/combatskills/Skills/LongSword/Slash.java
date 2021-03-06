package me.pugly.combatskills.Skills.LongSword;

import me.pugly.combatskills.Inputs.Input;
import me.pugly.combatskills.Skills.Skill;
import me.pugly.combatskills.Skills.WeaponType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;

public class Slash extends Skill {

    public Slash() {

        super(new LinkedList<>(Arrays.asList(
                Input.RCLICK, Input.RCLICK, Input.CROUCH, Input.LCLICK, Input.LCLICK, Input.RCLICK
        )), WeaponType.LONGSWORD);
    }

    @Override
    public void trigger(Player player) {
        player.sendMessage("Slash");
    }

}
