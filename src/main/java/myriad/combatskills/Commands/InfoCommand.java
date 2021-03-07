package myriad.combatskills.Commands;

import myriad.combatskills.Skills.Skill;
import myriad.combatskills.Skills.SkillHandler;
import myriad.combatskills.Skills.WeaponType;
import myriad.core.Utils.Commands.Command;
import myriad.core.Utils.GUIUtils.GUIItem;
import myriad.core.Utils.GUIUtils.GUIWindow;
import myriad.core.Utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static myriad.core.Utils.ItemUtils.createItem;

public class InfoCommand extends Command {

    public InfoCommand() {
        super(Arrays.asList("info"), "Info command", "myriad.info", true);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {

        Player p;

        if (commandSender instanceof Player)
            p = (Player) commandSender;
        else
            return;

        SkillHandler.show(p);
    }

    @Override
    public List<String> TabComplete(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        return null;
    }



}
