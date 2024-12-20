package me.trae.api.champions.skill.events;

import me.trae.api.champions.skill.Skill;
import me.trae.api.champions.skill.events.abstracts.types.SkillPlayerCancellableEvent;
import me.trae.api.champions.skill.events.interfaces.ISkillFriendlyFireEvent;
import me.trae.core.player.events.PlayerDisplayNameEvent;
import me.trae.core.utility.UtilServer;
import org.bukkit.entity.Player;

public class SkillFriendlyFireEvent extends SkillPlayerCancellableEvent implements ISkillFriendlyFireEvent {

    private final Player target;

    private boolean vulnerable;
    private final String playerName;
    private final String targetName;

    public SkillFriendlyFireEvent(final Skill<?, ?> skill, final Player player, final Player target) {
        super(skill, player);

        this.target = target;
        this.vulnerable = player != target;

        this.playerName = UtilServer.getEvent(new PlayerDisplayNameEvent(player, target)).getPlayerName();
        this.targetName = UtilServer.getEvent(new PlayerDisplayNameEvent(target, player)).getPlayerName();
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

    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public String getTargetName() {
        return this.targetName;
    }
}