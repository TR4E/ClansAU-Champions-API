package me.trae.api.champions.utility;

import me.trae.core.utility.UtilMessage;
import me.trae.core.utility.UtilString;
import me.trae.core.utility.objects.SoundCreator;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class UtilRole {

    public static void playEffect(final Player player, final String name, final boolean equip) {
        if (equip) {
            new SoundCreator(Sound.HORSE_ARMOR, 5.0F, 5.09F).play(player.getLocation());

            UtilMessage.simpleMessage(player, "Class", UtilString.pair("Armor Class", String.format("<green>%s", name)));
        } else {
            new SoundCreator(Sound.HORSE_ARMOR, 2.0F, 1.09F).play(player.getLocation());

            UtilMessage.simpleMessage(player, "Class", UtilString.pair("Armor Class", String.format("<red>%s", name)));
        }
    }
}