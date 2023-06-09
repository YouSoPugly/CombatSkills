package myriad.combatskills.Skills.LongSword;

import myriad.combatskills.Inputs.Input;
import myriad.combatskills.Skills.Skill;
import myriad.combatskills.Skills.WeaponType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;

public class Slash extends Skill {

    public Slash() {
        super(new LinkedList<>(Arrays.asList(
                Input.RCLICK, Input.RCLICK, Input.CROUCH, Input.LCLICK, Input.LCLICK, Input.RCLICK
        )), WeaponType.LONGSWORD, "Slash");
    }

    @Override
    public void trigger(Player player) {
        player.sendMessage("Slash");
        //do something
    }

    public String getName() {
        return "Slash";
    }

}