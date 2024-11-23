package me.trae.api.champions.role.events;

import me.trae.core.event.CustomCancellableEvent;
import me.trae.core.event.types.IPlayerEvent;
import org.bukkit.entity.Player;

public class RoleCheckEvent extends CustomCancellableEvent implements IPlayerEvent {

    private final Player player;

    public RoleCheckEvent(final Player player) {
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }
}