package me.trae.api.champions.skill;

import me.trae.api.champions.skill.abstracts.types.SkillPlayerEvent;
import me.trae.api.champions.skill.interfaces.ISkillLevelEvent;
import me.trae.champions.skill.Skill;
import org.bukkit.entity.Player;

public class SkillLevelEvent extends SkillPlayerEvent implements ISkillLevelEvent {

    private int level;

    public SkillLevelEvent(final Skill<?, ?> skill, final Player player, final int level) {
        super(skill, player);

        this.level = level;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(final int level) {
        this.level = level;
    }
}