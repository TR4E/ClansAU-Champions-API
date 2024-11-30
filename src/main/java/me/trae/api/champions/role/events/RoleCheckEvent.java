package me.trae.api.champions.role.events;

import me.trae.api.champions.role.Role;
import me.trae.api.champions.role.events.interfaces.IGetRoleEvent;
import me.trae.api.champions.role.events.interfaces.ISetRoleEvent;
import me.trae.core.event.CustomCancellableEvent;
import me.trae.core.event.types.IPlayerEvent;
import org.bukkit.entity.Player;

public class RoleCheckEvent extends CustomCancellableEvent implements IPlayerEvent, IGetRoleEvent, ISetRoleEvent {

    private final Player player;

    private Role role;

    public RoleCheckEvent(final Player player) {
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public Role getRole() {
        return this.role;
    }

    @Override
    public void setRole(final Role role) {
        this.role = role;
    }
}