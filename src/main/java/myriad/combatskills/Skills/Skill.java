package myriad.combatskills.Skills;

import myriad.combatskills.Inputs.Input;
import myriad.core.Utils.GUIUtils.GUIItem;
import myriad.core.Utils.GUIUtils.GUIWindow;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.Queue;

import static myriad.core.Utils.ItemUtils.createItem;

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

    public String getName() {
        return "Old Man";
    }

}
