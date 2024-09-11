package me.trae.api.champions.skill;

import me.trae.api.champions.skill.abstracts.types.SkillPlayerCancellableEvent;
import me.trae.champions.skill.Skill;
import org.bukkit.entity.Player;

public class SkillActivateEvent extends SkillPlayerCancellableEvent {

    public SkillActivateEvent(final Skill<?, ?> skill, final Player player) {
        super(skill, player);
    }
}