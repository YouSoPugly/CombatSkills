package myriad.combatskills.Skills;

import myriad.combatskills.Inputs.Input;
import myriad.core.Utils.GUIUtils.GUIItem;
import myriad.core.Utils.GUIUtils.GUIWindow;
import myriad.core.Utils.TextUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static myriad.core.Utils.ItemUtils.createItem;

public abstract class Skill {

    private final Queue<Input> inputs;
    private String description = "";

    protected Skill(Queue<Input> i, WeaponType type, String description) {
        this.description = description;
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

    public List<String> getDescription() {
        return TextUtils.splitIntoLine(this.description, 15, ChatColor.WHITE + "");
    }
}
