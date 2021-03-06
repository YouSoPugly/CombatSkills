package myriad.combatskills.Skills.Spear;

import myriad.combatskills.Inputs.Input;
import myriad.combatskills.Skills.Skill;
import myriad.combatskills.Skills.WeaponType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;

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
