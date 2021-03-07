package myriad.combatskills;

import myriad.combatskills.Events.CombatSkillEvent;
import myriad.combatskills.Inputs.Input;
import myriad.combatskills.Inputs.Inputs;
import myriad.combatskills.Skills.Skill;
import myriad.combatskills.Skills.SkillHandler;
import myriad.combatskills.Skills.WeaponType;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerHandler {

    private static Map<Player, Inputs> inputMap = new HashMap<>();

    public static void registerPlayer(Player p) {
        inputMap.put(p, new Inputs());
    }

    public static void unregisterPlayer(Player p) {
        p.sendMessage(inputMap.get(p).toString());
        inputMap.remove(p);
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
    }

    public static boolean addInput(Player p, Input i) {
        if (inputMap.containsKey(p)) {
            inputMap.get(p).addInput(i);
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(inputMap.get(p).toString()));
            checkPlayer(p);
        }

        return inputMap.containsKey(p);
    }

    public static void checkSkill(Player p, Inputs inputs, Skill skill) {
        if (inputMap.get(p).isMatch(skill.getInputs())) {
            CombatSkillEvent e = new CombatSkillEvent(p, skill);
            Bukkit.getPluginManager().callEvent(e);
            if (!e.isCancelled())
                skill.trigger(p);
            unregisterPlayer(p);
        }
    }

    public static void checkPlayer(Player p) {
        for (Skill s : SkillHandler.getSkills(WeaponType.AXE)) {
            checkSkill(p, inputMap.get(p), s);
        }
        for (Skill s : SkillHandler.getSkills(WeaponType.SHORTSWORD)) {
            checkSkill(p, inputMap.get(p), s);
        }
        for (Skill s : SkillHandler.getSkills(WeaponType.LONGSWORD)) {
            checkSkill(p, inputMap.get(p), s);
        }
        for (Skill s : SkillHandler.getSkills(WeaponType.SPEAR)) {
            checkSkill(p, inputMap.get(p), s);
        }
        if (inputMap.get(p).size() > 9)
            unregisterPlayer(p);
    }

}
