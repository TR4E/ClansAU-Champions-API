package me.trae.api.champions.skill.abstracts.interfaces;

import me.trae.champions.skill.Skill;
import me.trae.core.utility.UtilJava;

public interface ISkillEvent {

    Skill<?, ?> getSkill();

    default <E extends Skill<?, ?>> E getSkillByClass(final Class<E> clazz) {
        return UtilJava.cast(clazz, this.getSkill());
    }
}