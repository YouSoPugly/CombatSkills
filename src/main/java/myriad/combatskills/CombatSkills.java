package myriad.combatskills;

import myriad.combatskills.Commands.InfoCommand;
import myriad.combatskills.Commands.TestCommand;
import myriad.combatskills.Listeners.*;
import myriad.combatskills.Skills.Axe.Smash;
import myriad.combatskills.Skills.Axe.Spin;
import myriad.combatskills.Skills.LongSword.Slash;
import myriad.combatskills.Skills.ShortSword.Dodge;
import myriad.combatskills.Skills.ShortSword.HighJump;
import myriad.combatskills.Skills.ShortSword.Leap;
import myriad.combatskills.Skills.Spear.Pierce;
import myriad.core.Utils.Commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CombatSkills extends JavaPlugin {

    private static JavaPlugin plugin;
    private static CommandHandler skillsCommand;

    @Override
    public void onEnable() {
        // Plugin startup logic
        // test comment
        plugin = this;

        Bukkit.getPluginManager().registerEvents(new onCrouch(), this);
        Bukkit.getPluginManager().registerEvents(new onInteract(), this);
        Bukkit.getPluginManager().registerEvents(new onOffhand(), this);
        Bukkit.getPluginManager().registerEvents(new onInventoryInteract(), this);
        Bukkit.getPluginManager().registerEvents(new onHandChange(), this);

        skillsCommand = new CommandHandler("skills", this);
        skillsCommand.registerCommand(new InfoCommand());
        skillsCommand.registerCommand(new TestCommand());

        registerSkills();
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerSkills() {
        // Axe Skills
        new Spin();
        new Smash();

        // Longsword Skills
        new Slash();

        // Spear Skills
        new Pierce();

        // Shortsword Skills
        new Leap();
        new HighJump();
        new Dodge();
    }
}
