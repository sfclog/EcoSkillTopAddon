package ecoskillstopaddon.papi;

import com.willfp.ecoskills.api.EcoSkillsAPI;
import com.willfp.ecoskills.skills.Skills;
import com.willfp.ecoskills.util.LeaderboardEntry;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PAPI_Hook extends PlaceholderExpansion {

    public String onPlaceholderRequest(Player p, String identifier) {






        //ecoskillstopaddon_name_1

        // 2 : _

        // value in 2

        if (identifier.contains("name_")) {
            int i = getFix(identifier);
            if(i > 0) {
                return getTopName(i);
            }
        }

        //ecoskillstopaddon_value_1

        if (identifier.contains("value_")) {
            int i = getFix(identifier);
            if(i > 0) {
             return getTopValue(i);
            }

        }

        if (identifier.equals("value")) {
            int level = EcoSkillsAPI.getTotalSkillLevel(p);
            return String.valueOf(level);
        }
        return "...";
    }

    private int getFix(String identifier) {
        if(identifier.contains("_")) {
            String[] leg = identifier.split("_");
            if (leg.length == 2) {
                String number = leg[1];
                if(number != null) {
                    return Integer.parseInt(number);
                }
            }
        }
        return -1;
    }


    public static String getTopName(int i) {
        LeaderboardEntry e = Skills.INSTANCE.getTop(i);
        return e.getPlayer().getName();
    }

    public static String getTopValue(int i) {
        LeaderboardEntry e = Skills.INSTANCE.getTop(i);
        return String.valueOf(e.getLevel());
    }

    /*
    The identifier, shouldn't contain any _ or %
     */
    public String getIdentifier() {
        return "ecoskillstopaddon";
    }
    /*
     The author of the Placeholder
     This cannot be null
     */
    public String getAuthor() {
        return "SFC_Log";
    }
    /*
     Same with #getAuthor() but for versioon
     This cannot be null
     */
    public String getVersion() {
        return "EcoSkillsTopAddon";
}
}
