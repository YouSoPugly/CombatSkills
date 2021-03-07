package myriad.combatskills.Skills.Axe;

import myriad.combatskills.Inputs.Input;
import myriad.combatskills.Skills.Skill;
import myriad.combatskills.Skills.WeaponType;
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

    public String getName() {
        return "Smash";
    }
}
