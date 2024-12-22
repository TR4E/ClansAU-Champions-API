package me.trae.api.champions.role.events;

import me.trae.api.champions.role.Role;
import me.trae.api.champions.role.events.abstracts.RoleEvent;
import me.trae.api.champions.role.events.interfaces.IKitReceiveEvent;
import org.bukkit.entity.Player;

public class KitReceiveEvent extends RoleEvent implements IKitReceiveEvent {

    private boolean overpowered;

    public KitReceiveEvent(final Role role, final Player player) {
        super(role, player);
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