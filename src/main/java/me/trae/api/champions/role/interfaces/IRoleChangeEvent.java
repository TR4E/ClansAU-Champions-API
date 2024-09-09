package me.trae.api.champions.role.interfaces;

import me.trae.champions.role.Role;
import me.trae.core.event.types.IPlayerEvent;

public interface IRoleChangeEvent extends IPlayerEvent {

    Role getRole();
}