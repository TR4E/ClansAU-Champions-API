package me.trae.api.champions.role.events.interfaces;

import me.trae.core.event.types.IPlayerEvent;

public interface IKitReceiveEvent extends IPlayerEvent, IGetRoleEvent {

    boolean isOverpowered();

    void setOverpowered(final boolean overpowered);
}