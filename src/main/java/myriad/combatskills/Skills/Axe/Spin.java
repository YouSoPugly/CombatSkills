package myriad.combatskills.Skills.Axe;

import myriad.combatskills.Inputs.Input;
import myriad.combatskills.Skills.Skill;
import myriad.combatskills.Skills.WeaponType;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;

public class Spin extends Skill {

    public Spin() {
        super(new LinkedList<>(Arrays.asList(
                Input.CROUCH, Input.RCLICK, Input.LCLICK, Input.CROUCH, Input.CROUCH, Input.LCLICK
        )), WeaponType.AXE, "Spin");
    }

    @Override
    public void trigger(Player player) {
        player.sendMessage("Spin");
        player.getWorld().spawnParticle(Particle.FLAME, player.getEyeLocation(), 1);
        player.sendMessage("Dang man thats kinda cool though");
    }

    public String getName() {
        return "Spin";
    }
}
