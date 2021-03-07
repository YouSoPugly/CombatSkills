package myriad.combatskills.Skills;

import myriad.combatskills.Inputs.Input;
import myriad.core.Utils.GUIUtils.GUIItem;
import myriad.core.Utils.GUIUtils.GUIWindow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static myriad.core.Utils.ItemUtils.createItem;

public class SkillHandler {

    public static Map<WeaponType, List<Skill>> skills = new HashMap<>();
    private static GUIWindow window;

    public static void register(WeaponType t, Skill s) {
        List<Skill> skillList = skills.getOrDefault(t, new ArrayList<>());
        skillList.add(s);

        skills.put(t, skillList);
    }

    public static List<Skill> getSkills(WeaponType t) {
        return skills.get(t);
    }

    public static void show(Player p) {
        if (window == null)
            window = getWindow();
        window.show(p);
    }

    public static GUIWindow getWindow() {
        GUIWindow window = new GUIWindow("\u00a78\u00a7lSkill Information", 3);
        GUIItem border = GUIItem.getBorder(Material.GRAY_STAINED_GLASS_PANE);

        for (int i = 0; i < 27; i++) {
            window.setItem(i, border);
        }

        window.setItem(10, getWeaponTypeGUIItem(WeaponType.LONGSWORD));
        window.setItem(12, getWeaponTypeGUIItem(WeaponType.SHORTSWORD));
        window.setItem(14, getWeaponTypeGUIItem(WeaponType.AXE));
        window.setItem(16, getWeaponTypeGUIItem(WeaponType.SPEAR));

        window.setItem(4, new GUIItem(createItem(Material.EXPERIENCE_BOTTLE, 1, "\u00a7e\u00a7lCombo Inputs",
                new String[]{
                        ChatColor.DARK_GREEN + "╔ ———————— ╗",
                        ChatColor.WHITE + "➲ Start Combo [Offhand]",
                        ChatColor.WHITE + "➤ L [Left Mouse Click]",
                        ChatColor.WHITE + "➤ R [Right Mouse Click]",
                        ChatColor.WHITE + "➤ C [Crouch]",
                        ChatColor.DARK_GREEN + "╚ ———————— ╝",
                }),
                (e) -> {
            e.setCancelled(true);
        }));

        return window;
    }

    public static GUIItem getWeaponTypeGUIItem(WeaponType type) {
        ItemStack is = new ItemStack(Material.BARRIER, 1);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.DARK_GREEN + "╔ ———————— ╗");

        for (Skill s : skills.get(type)) {

            lore.add(ChatColor.GREEN + "✜ " + s.getName() + ":");
            StringBuilder string = new StringBuilder(ChatColor.GREEN + "✜ ");

            for (Input i : s.getInputs()) {
                switch (i) {
                    case RCLICK:
                        string.append("\u00a7f\u00a7lR\u00a7a➨");
                        break;
                    case LCLICK:
                        string.append("\u00a7f\u00a7lL\u00a7a➨");
                        break;
                    case CROUCH:
                        string.append("\u00a7f\u00a7lC\u00a7a➨");
                        break;
                }
            }

            lore.add(string.substring(0, string.length()-2));
        }

        lore.add(ChatColor.DARK_GREEN + "╚ ———————— ╝");

        switch (type) {
            case AXE:
                is = createItem(Material.WOODEN_AXE, 1, "\u00a7e\u00a7lAxe Combos", lore.toArray(new String[0]));
                break;
            case SPEAR:
                is = createItem(Material.STICK, 1, "\u00a7e\u00a7lSpear Combos", lore.toArray(new String[0]));
                break;
            case SHORTSWORD:
                is = createItem(Material.GOLDEN_SWORD, 1, "\u00a7e\u00a7lShort Sword Combos", lore.toArray(new String[0]));
                break;
            case LONGSWORD:
                is = createItem(Material.IRON_SWORD, 1, "\u00a7e\u00a7lLong Sword Combos", lore.toArray(new String[0]));
                break;
        }

        return new GUIItem(is, (e) -> {
            e.setCancelled(true);
            //show((Player) e.getWhoClicked(), type);
        });
    }

    public static GUIItem getBackToMain() {
        ItemStack is = createItem(Material.BARRIER, 1, "\u00a7cBack to Main Menu");

        return new GUIItem(is, (e) -> {
            e.setCancelled(true);
            show((Player) e.getWhoClicked());
        });
    }


}
