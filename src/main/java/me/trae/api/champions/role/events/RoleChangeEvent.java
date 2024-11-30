package me.trae.api.champions.role.events;

import me.trae.api.champions.role.Role;
import me.trae.api.champions.role.events.interfaces.IGetRoleEvent;
import me.trae.core.event.CustomEvent;
import me.trae.core.event.types.IPlayerEvent;
import org.bukkit.entity.Player;

public class RoleChangeEvent extends CustomEvent implements IGetRoleEvent, IPlayerEvent {

    private final Role role;
    private final Player player;

    public RoleChangeEvent(final Role role, final Player player) {
        this.role = role;
        this.player = player;
    }

    @Override
    public Role getRole() {
        return this.role;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }
}