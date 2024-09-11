package me.trae.api.champions.skill.abstracts.types;

import me.trae.api.champions.skill.abstracts.SkillCancellableEvent;
import me.trae.champions.skill.Skill;
import me.trae.core.event.types.IPlayerEvent;
import org.bukkit.entity.Player;

public class SkillPlayerCancellableEvent extends SkillCancellableEvent implements IPlayerEvent {

    private final Player player;

    public SkillPlayerCancellableEvent(final Skill<?, ?> skill, final Player player) {
        super(skill);

        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }
}