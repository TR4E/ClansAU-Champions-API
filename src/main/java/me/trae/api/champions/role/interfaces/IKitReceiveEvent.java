package me.trae.api.champions.role.interfaces;

import me.trae.core.event.types.IPlayerEvent;

public interface IKitReceiveEvent extends IPlayerEvent, IRoleEvent {

    boolean isOverpowered();

    void setOverpowered(final boolean overpowered);
}