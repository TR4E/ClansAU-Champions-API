package me.trae.api.champions.skill;

import me.trae.api.champions.skill.abstracts.types.SkillPlayerCancellableEvent;
import me.trae.champions.skill.Skill;
import org.bukkit.entity.Player;

public class SkillUsingEvent extends SkillPlayerCancellableEvent {

    public SkillUsingEvent(final Skill<?> skill, final Player player) {
        super(skill, player);
    }
}