package me.trae.api.champions.role.events;

import me.trae.api.champions.role.Role;
import me.trae.api.champions.role.events.interfaces.IRoleEvent;
import me.trae.core.event.CustomEvent;
import me.trae.core.event.types.IPlayerEvent;
import org.bukkit.entity.Player;

public class RoleUpdaterEvent extends CustomEvent implements IRoleEvent, IPlayerEvent {

    private final Role role;
    private final Player player;

    public RoleUpdaterEvent(final Role role, final Player player) {
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