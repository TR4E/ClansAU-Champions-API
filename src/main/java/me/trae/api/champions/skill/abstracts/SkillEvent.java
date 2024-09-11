package me.trae.api.champions.skill.abstracts;

import me.trae.api.champions.skill.abstracts.interfaces.ISkillEvent;
import me.trae.champions.skill.Skill;
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