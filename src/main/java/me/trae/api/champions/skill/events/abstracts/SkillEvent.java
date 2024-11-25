package me.trae.api.champions.skill.events.abstracts;

import me.trae.api.champions.skill.Skill;
import me.trae.api.champions.skill.events.abstracts.interfaces.ISkillEvent;
import me.trae.core.event.CustomEvent;

public class SkillEvent extends CustomEvent implements ISkillEvent {

    private final Skill<?, ?> skill;

    public SkillEvent(final Skill<?, ?> skill) {
        this.skill = skill;
    }

    @Override
    public Skill<?, ?> getSkill() {
        return this.skill;
    }
}