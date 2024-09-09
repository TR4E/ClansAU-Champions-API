package me.trae.api.champions.role;

import me.trae.api.champions.role.interfaces.IRoleChangeEvent;
import me.trae.champions.role.Role;
import me.trae.core.event.CustomEvent;
import org.bukkit.entity.Player;

public class RoleChangeEvent extends CustomEvent implements IRoleChangeEvent {

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