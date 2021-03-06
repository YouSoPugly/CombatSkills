package me.pugly.combatskills.Skills;

import me.pugly.combatskills.Inputs.Input;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Skill {

    private final Queue<Input> inputs;

    protected Skill(Queue<Input> i, WeaponType type) {
        inputs = i;
        SkillHandler.register(type, this);
    }

    public abstract void trigger(Player player);

    public Queue<Input> getInputs() {
        Queue<Input> out = new LinkedList<>();
        out.addAll(inputs);
        return out;
    }

}
