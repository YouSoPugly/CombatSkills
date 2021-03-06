package myriad.combatskills;

import myriad.combatskills.Listeners.onCrouch;
import myriad.combatskills.Listeners.onInteract;
import myriad.combatskills.Listeners.onOffhand;
import myriad.combatskills.Skills.Axe.Smash;
import myriad.combatskills.Skills.Axe.Spin;
import myriad.combatskills.Skills.LongSword.Slash;
import myriad.combatskills.Skills.ShortSword.Dodge;
import myriad.combatskills.Skills.ShortSword.HighJump;
import myriad.combatskills.Skills.ShortSword.Leap;
import myriad.combatskills.Skills.Spear.Pierce;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CombatSkills extends JavaPlugin {

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        Bukkit.getPluginManager().registerEvents(new onCrouch(), this);
        Bukkit.getPluginManager().registerEvents(new onInteract(), this);
        Bukkit.getPluginManager().registerEvents(new onOffhand(), this);

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
