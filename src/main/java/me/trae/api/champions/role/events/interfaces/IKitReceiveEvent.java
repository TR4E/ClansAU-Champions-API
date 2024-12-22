package me.trae.api.champions.role.events.interfaces;

public interface IKitReceiveEvent {

    boolean isOverpowered();

    void setOverpowered(final boolean overpowered);
}