package me.trae.api.champions.skill.events;

import me.trae.api.champions.skill.Skill;
import me.trae.api.champions.skill.events.abstracts.types.SkillPlayerCancellableEvent;
import org.bukkit.entity.Player;

public class SkillUsingEvent extends SkillPlayerCancellableEvent {

    public SkillUsingEvent(final Skill<?, ?> skill, final Player player) {
        super(skill, player);
    }
}