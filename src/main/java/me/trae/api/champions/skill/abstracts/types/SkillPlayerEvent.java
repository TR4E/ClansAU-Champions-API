package me.trae.api.champions.skill.abstracts.types;

import me.trae.api.champions.skill.abstracts.SkillEvent;
import me.trae.champions.skill.Skill;
import me.trae.core.event.types.IPlayerEvent;
import org.bukkit.entity.Player;

public class SkillPlayerEvent extends SkillEvent implements IPlayerEvent {

    private final Player player;

    public SkillPlayerEvent(final Skill<?> skill, final Player player) {
        super(skill);

        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }
}