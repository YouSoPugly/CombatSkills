package me.pugly.combatskills;

import me.pugly.combatskills.Inputs.Input;
import me.pugly.combatskills.Inputs.Inputs;
import me.pugly.combatskills.Skills.Skill;
import me.pugly.combatskills.Skills.SkillHandler;
import me.pugly.combatskills.Skills.WeaponType;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
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

    public static void checkPlayer(Player p) {
        for (Skill s : SkillHandler.getSkills(WeaponType.AXE)) {
            if (inputMap.get(p).isMatch(s.getInputs())) {
                s.trigger(p);
                unregisterPlayer(p);
                return;
            }
        }
        for (Skill s : SkillHandler.getSkills(WeaponType.SHORTSWORD)) {
            if (inputMap.get(p).isMatch(s.getInputs())) {
                s.trigger(p);
                unregisterPlayer(p);
                return;
            }
        }
        for (Skill s : SkillHandler.getSkills(WeaponType.LONGSWORD)) {
            if (inputMap.get(p).isMatch(s.getInputs())) {
                s.trigger(p);
                unregisterPlayer(p);
                return;
            }
        }
        for (Skill s : SkillHandler.getSkills(WeaponType.SPEAR)) {
            if (inputMap.get(p).isMatch(s.getInputs())) {
                s.trigger(p);
                unregisterPlayer(p);
                return;
            }
        }
        if (inputMap.get(p).size() > 9)
            unregisterPlayer(p);
    }

}
