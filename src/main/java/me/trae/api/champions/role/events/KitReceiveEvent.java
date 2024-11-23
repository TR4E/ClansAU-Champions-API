package me.trae.api.champions.role.events;

import me.trae.api.champions.role.Role;
import me.trae.api.champions.role.events.interfaces.IKitReceiveEvent;
import me.trae.core.event.CustomEvent;
import org.bukkit.entity.Player;

public class KitReceiveEvent extends CustomEvent implements IKitReceiveEvent {

    private final Player player;
    private final Role role;

    private boolean overpowered;

    public KitReceiveEvent(final Player player, final Role role) {
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

    @Override
    public boolean isOverpowered() {
        return this.overpowered;
    }

    @Override
    public void setOverpowered(final boolean overpowered) {
        this.overpowered = overpowered;
    }
}