package myriad.combatskills.Commands;

import myriad.core.Utils.Commands.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class TestCommand extends Command {

    public TestCommand() {
        super(Arrays.asList("test"), "Test command", "myriad.staff", true);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        //test
    }

    @Override
    public List<String> TabComplete(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        return null;
    }
}
