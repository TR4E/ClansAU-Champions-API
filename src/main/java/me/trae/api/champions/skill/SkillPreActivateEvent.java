package me.trae.api.champions.skill;

import me.trae.api.champions.skill.abstracts.types.SkillPlayerCancellableEvent;
import me.trae.champions.skill.Skill;
import org.bukkit.entity.Player;

public class SkillPreActivateEvent extends SkillPlayerCancellableEvent {

    public SkillPreActivateEvent(final Skill<?, ?> skill, final Player player) {
        super(skill, player);
    }
}