package me.trae.api.champions.skill.interfaces;

import me.trae.champions.skill.data.SkillData;
import me.trae.champions.skill.enums.SkillType;
import me.trae.core.utility.UtilJava;
import me.trae.core.utility.UtilTime;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public interface ISkill<D extends SkillData> {

    SkillType getType();

    Class<D> getClassOfData();

    ConcurrentHashMap<UUID, D> getUsers();

    void addUser(final D data);

    void removeUser(final Player player);

    D getUserByUUID(final UUID uuid);

    D getUserByPlayer(final Player player);

    boolean isUserByUUID(final UUID uuid);

    boolean isUserByPlayer(final Player player);

    List<Player> getPlayers();

    int getLevel(final Player player);

    String getDisplayName(final int level);

    String[] getDescription(final int level);

    void reset(final Player player);

    void onExpire(final Player player, final D data);

    default boolean canActivate(final Player player) {
        return true;
    }

    default int getTokenCost() {
        return 1;
    }

    default int getDefaultLevel() {
        return 0;
    }

    default int getMaxLevel() {
        return 5;
    }

    default <T> String getValueString(final Class<T> clazz, final Function<Integer, T> function, final int level) {
        final T currentValue = function.apply(level);
        final T nextValue = function.apply(level + 1);

        final String currentValueString = clazz.equals(Long.class) ? UtilTime.getTime(UtilJava.cast(Long.class, currentValue)) : String.valueOf(currentValue);

        ChatColor chatColor = ChatColor.GREEN;

        if (currentValue.equals(nextValue)) {
            chatColor = ChatColor.YELLOW;
        }

        return chatColor + currentValueString + "<reset>";
    }

    default <T> String getValueString(final Class<T> clazz, final T currentValue) {
        final String currentValueString = clazz.equals(Long.class) ? UtilTime.getTime(UtilJava.cast(Long.class, currentValue)) : String.valueOf(currentValue);

        return ChatColor.YELLOW + currentValueString + "<reset>";
    }
}