package me.trae.api.champions.role.events.abstracts;

import me.trae.api.champions.role.Role;
import me.trae.api.champions.role.events.abstracts.interfaces.IGetRoleEvent;
import me.trae.core.event.CustomCancellableEvent;
import me.trae.core.event.types.IPlayerEvent;
import org.bukkit.entity.Player;

public class RoleCancellableEvent extends CustomCancellableEvent implements IPlayerEvent, IGetRoleEvent {

    private final Player player;
    private final Role role;

    public RoleCancellableEvent(final Player player, final Role role) {
        this.player = player;
        this.role = role;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public Role getRole() {
        return this.role;
    }
}