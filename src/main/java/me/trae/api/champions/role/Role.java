package me.trae.api.champions.role;

import me.trae.api.champions.role.interfaces.IRole;
import me.trae.api.champions.skill.Skill;
import me.trae.champions.Champions;
import me.trae.champions.build.BuildManager;
import me.trae.champions.build.data.RoleBuild;
import me.trae.champions.build.data.types.DefaultRoleBuild;
import me.trae.champions.role.RoleManager;
import me.trae.champions.skill.enums.SkillType;
import me.trae.champions.skill.skills.global.Swim;
import me.trae.core.framework.SpigotModule;
import me.trae.core.utility.UtilServer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public abstract class Role extends SpigotModule<Champions, RoleManager> implements IRole {

    public Role(final RoleManager manager) {
        super(manager);
    }

    @Override
    public void registerSubModules() {
        // Global Skills
        addSubModule(new Swim(this));
    }

    @Override
    public <E extends Skill<?, ?>> List<E> getSkillsByClass(final Class<E> clazz) {
        return this.getSubModulesByClass(clazz);
    }

    @Override
    public <E extends Skill<?, ?>> List<E> getSkillsByType(final Class<E> clazz, final SkillType skillType) {
        final List<E> list = new ArrayList<>();

        for (final E skill : this.getSkillsByClass(clazz)) {
            if (skill.getType() != skillType) {
                continue;
            }

            list.add(skill);
        }

        return list;
    }

    @Override
    public <E extends Skill<?, ?>> E getSkillByType(final Class<E> clazz, final SkillType skillType) {
        for (final E skill : this.getSubModulesByClass(clazz)) {
            if (skill.getType() != skillType) {
                continue;
            }

            return skill;
        }

        return null;
    }

    @Override
    public RoleBuild getDefaultRoleBuildByPlayer(final Player player) {
        final BuildManager buildManager = this.getInstance().getManagerByClass(BuildManager.class);

        RoleBuild roleBuild = buildManager.getBuildByID(player, this, 0);
        if (roleBuild == null) {
            roleBuild = new DefaultRoleBuild(player, this);
            buildManager.addBuild(roleBuild);
        }

        return roleBuild;
    }

    @Override
    public RoleBuild getActiveRoleBuildByPlayer(final Player player) {
        for (final RoleBuild roleBuild : this.getInstance().getManagerByClass(BuildManager.class).getBuildsByRole(player, this).values()) {
            if (!(roleBuild.isActive())) {
                continue;
            }

            return roleBuild;
        }

        return null;
    }

    @Override
    public RoleBuild getRoleBuildByPlayer(final Player player) {
        RoleBuild roleBuild = this.getActiveRoleBuildByPlayer(player);
        if (roleBuild == null) {
            roleBuild = this.getDefaultRoleBuildByPlayer(player);
        }

        return roleBuild;
    }

    @Override
    public List<Player> getUsers() {
        if (!(this.isEnabled())) {
            return Collections.emptyList();
        }

        return UtilServer.getOnlinePlayers(player -> {
            final Role playerRole = this.getManager().getPlayerRole(player);

            if (playerRole == null) {
                return false;
            }

            return playerRole == this;
        });
    }

    @Override
    public boolean isUserByPlayer(final Player player) {
        return this.getManager().getPlayerRole(player) == this;
    }

    @Override
    public String getPrefix() {
        return this.getName().substring(0, 1);
    }

    @Override
    public void reset(final Player player) {
        for (final Skill<?, ?> skill : this.getSkillsByClass(Skill.class)) {
            skill.reset(player);

            if (skill.isUserByPlayer(player)) {
                skill.removeUser(player);
            }
        }
    }

    @Override
    public void onShutdown() {
        for (final Map.Entry<UUID, Role> entry : this.getManager().getPlayerRoles().entrySet()) {
            if (entry.getValue() != this) {
                continue;
            }

            final Player player = Bukkit.getPlayer(entry.getKey());
            if (player == null) {
                continue;
            }

            this.reset(player);
        }
    }
}