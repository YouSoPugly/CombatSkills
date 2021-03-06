package myriad.combatskills.Skills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillHandler {

    public static Map<WeaponType, List<Skill>> skills = new HashMap<>();

    public static void register(WeaponType t, Skill s) {
        List<Skill> skillList = skills.getOrDefault(t, new ArrayList<>());
        skillList.add(s);

        skills.put(t, skillList);
    }

    public static List<Skill> getSkills(WeaponType t) {
        return skills.get(t);
    }
}
