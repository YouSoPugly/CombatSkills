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
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("\u00a74『 \u00a7f" + " \u00a74』"));
    }

    public static void unregisterPlayer(Player p) {
        inputMap.remove(p);
    }

    public static boolean isRegistered(Player p) {
        return inputMap.containsKey(p);
    }

    public static boolean addInput(Player p, Input i) {
        if (inputMap.containsKey(p)) {
            inputMap.get(p).addInput(i);
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("\u00a74『\u00a7f" + inputMap.get(p).toString() + "\u00a74』"));
            checkPlayer(p);
        }

        return inputMap.containsKey(p);
    }

    public static boolean checkSkill(Player p, Inputs inputs, Skill skill) {
        if (inputMap.get(p).isMatch(skill.getInputs())) {
            CombatSkillEvent e = new CombatSkillEvent(p, skill);
            Bukkit.getPluginManager().callEvent(e);
            if (!e.isCancelled()) {
                skill.trigger(p);
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("\u00a74『\u00a7f\u00a7o " + skill.getName() + " \u00a74』"));

            }
            unregisterPlayer(p);
            return true;
        }
        return false;
    }

    public static void checkPlayer(Player p) {
        for (Skill s : SkillHandler.getSkills(WeaponType.AXE)) {
            if (checkSkill(p, inputMap.get(p), s))
                return;
        }
        for (Skill s : SkillHandler.getSkills(WeaponType.SHORTSWORD)) {
            if (checkSkill(p, inputMap.get(p), s))
                return;
        }
        for (Skill s : SkillHandler.getSkills(WeaponType.LONGSWORD)) {
            if (checkSkill(p, inputMap.get(p), s))
                return;
        }
        for (Skill s : SkillHandler.getSkills(WeaponType.SPEAR)) {
            if (checkSkill(p, inputMap.get(p), s))
                return;
        }
        if (inputMap.get(p).size() > 9)
            unregisterPlayer(p);
    }

}
