package me.trae.api.champions.skill;

import me.trae.api.champions.skill.events.SkillLevelEvent;
import me.trae.champions.Champions;
import me.trae.api.champions.role.Role;
import me.trae.champions.skill.data.SkillData;
import me.trae.champions.skill.enums.SkillType;
import me.trae.api.champions.skill.interfaces.ISkill;
import me.trae.core.framework.SpigotSubModule;
import me.trae.core.utility.UtilServer;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Skill<R extends Role, D extends SkillData> extends SpigotSubModule<Champions, R> implements ISkill<D> {

    private final SkillType skillType;
    private final ConcurrentHashMap<UUID, D> users;

    public Skill(final R module, final SkillType skillType) {
        super(module);

        this.skillType = skillType;
        this.users = new ConcurrentHashMap<>();
    }

    @Override
    public SkillType getType() {
        return this.skillType;
    }

    @Override
    public ConcurrentHashMap<UUID, D> getUsers() {
        return this.users;
    }

    @Override
    public void addUser(final D data) {
        this.getUsers().put(data.getUUID(), data);
    }

    @Override
    public void removeUser(final Player player) {
        this.getUsers().remove(player.getUniqueId());
    }

    @Override
    public D getUserByUUID(final UUID uuid) {
        return this.getUsers().getOrDefault(uuid, null);
    }

    @Override
    public D getUserByPlayer(final Player player) {
        return this.getUserByUUID(player.getUniqueId());
    }

    @Override
    public boolean isUserByUUID(final UUID uuid) {
        return this.getUsers().containsKey(uuid);
    }

    @Override
    public boolean isUserByPlayer(final Player player) {
        return this.isUserByUUID(player.getUniqueId());
    }

    @Override
    public int getLevel(final Player player) {
        final int level = 1;

        final SkillLevelEvent event = new SkillLevelEvent(this, player, level);
        UtilServer.callEvent(event);

        return event.getLevel();
    }

    @Override
    public String getDisplayName(final int level) {
        return String.format("%s %s", this.getName(), level);
    }

    @Override
    public void reset(final Player player) {
    }

    @Override
    public void onExpire(final Player player, final D data) {
    }
}