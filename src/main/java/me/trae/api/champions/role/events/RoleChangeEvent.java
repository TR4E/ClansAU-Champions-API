package me.trae.api.champions.role.events;

import me.trae.api.champions.role.Role;
import me.trae.api.champions.role.events.abstracts.RoleEvent;
import org.bukkit.entity.Player;

public class RoleChangeEvent extends RoleEvent {

    public RoleChangeEvent(final Role role, final Player player) {
        super(role, player);
    }
}