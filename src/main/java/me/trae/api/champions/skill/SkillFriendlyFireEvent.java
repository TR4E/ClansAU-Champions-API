package me.trae.api.champions.skill;

import me.trae.api.champions.skill.abstracts.types.SkillPlayerCancellableEvent;
import me.trae.api.champions.skill.interfaces.ISkillFriendlyFireEvent;
import me.trae.champions.skill.Skill;
import org.bukkit.entity.Player;

public class SkillFriendlyFireEvent extends SkillPlayerCancellableEvent implements ISkillFriendlyFireEvent {

    private final Player target;

    private boolean vulnerable;

    public SkillFriendlyFireEvent(final Skill<?> skill, final Player player, final Player target) {
        super(skill, player);

        this.target = target;
        this.vulnerable = true;
    }

    @Override
    public Player getTarget() {
        return this.target;
    }

    @Override
    public boolean isVulnerable() {
        return this.vulnerable;
    }

    @Override
    public void setVulnerable(final boolean vulnerable) {
        this.vulnerable = vulnerable;
    }
}