package me.pugly.combatskills;

import me.pugly.combatskills.Listeners.onCrouch;
import me.pugly.combatskills.Listeners.onInteract;
import me.pugly.combatskills.Listeners.onOffhand;
import me.pugly.combatskills.Skills.Axe.Smash;
import me.pugly.combatskills.Skills.Axe.Spin;
import me.pugly.combatskills.Skills.LongSword.Slash;
import me.pugly.combatskills.Skills.ShortSword.Dodge;
import me.pugly.combatskills.Skills.ShortSword.HighJump;
import me.pugly.combatskills.Skills.ShortSword.Leap;
import me.pugly.combatskills.Skills.Spear.Pierce;
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
        new Smash();
        new Spin();

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
