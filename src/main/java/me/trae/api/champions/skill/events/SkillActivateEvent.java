package me.trae.api.champions.skill.events;

import me.trae.api.champions.skill.Skill;
import me.trae.api.champions.skill.events.abstracts.types.SkillPlayerCancellableEvent;
import org.bukkit.entity.Player;

public class SkillActivateEvent extends SkillPlayerCancellableEvent {

    public SkillActivateEvent(final Skill<?, ?> skill, final Player player) {
        super(skill, player);
    }
}