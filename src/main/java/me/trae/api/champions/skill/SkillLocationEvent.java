package me.trae.api.champions.skill;

import me.trae.api.champions.skill.abstracts.types.SkillPlayerCancellableEvent;
import me.trae.champions.skill.Skill;
import me.trae.core.event.types.IGetLocationEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SkillLocationEvent extends SkillPlayerCancellableEvent implements IGetLocationEvent {

    private final Location location;

    public SkillLocationEvent(final Skill<?> skill, final Player player, final Location location) {
        super(skill, player);

        this.location = location;
    }

    public SkillLocationEvent(final Skill<?> skill, final Location location) {
        this(skill, null, location);
    }

    @Override
    public Location getLocation() {
        return this.location;
    }
}