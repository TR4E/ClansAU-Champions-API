package me.trae.api.champions.skill.events;

import me.trae.api.champions.skill.Skill;
import me.trae.api.champions.skill.events.abstracts.types.SkillPlayerCancellableEvent;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class SkillPreActivateEvent extends SkillPlayerCancellableEvent {

    public SkillPreActivateEvent(final Skill<?, ?> skill, final Player player) {
        super(skill, player);
    }

    @Nullable
    @Override
    public Skill<?, ?> getSkill() {
        return super.getSkill();
    }
}