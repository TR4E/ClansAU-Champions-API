package me.trae.api.champions.skill.events.interfaces;

import me.trae.core.event.types.ITargetEvent;
import org.bukkit.entity.Player;

public interface ISkillFriendlyFireEvent extends ITargetEvent<Player> {

    boolean isVulnerable();

    void setVulnerable(final boolean vulnerable);

    String getPlayerName();

    String getTargetName();
}