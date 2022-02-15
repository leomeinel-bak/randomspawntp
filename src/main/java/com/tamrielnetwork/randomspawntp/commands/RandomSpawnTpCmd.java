/*
 * RandomSpawnTp is a Spigot Plugin that gives players the ability to teleport to a random world spawn.
 * Copyright © 2022 Leopold Meinel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://github.com/TamrielNetwork/RandomSpawnTp/blob/main/LICENSE
 */

package com.tamrielnetwork.randomspawntp.commands;

import com.google.common.collect.ImmutableMap;
import com.tamrielnetwork.randomspawntp.RandomSpawnTp;
import com.tamrielnetwork.randomspawntp.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class RandomSpawnTpCmd implements CommandExecutor {

	private final RandomSpawnTp main = JavaPlugin.getPlugin(RandomSpawnTp.class);

	private final HashMap<UUID, Long> cooldown = new HashMap<>();

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		// Check args length
		if (args.length == 0) {
			executeTeleport(sender);
		} else {
			Utils.sendMessage(sender, "invalid-option");
		}

		return true;
	}

	private void executeTeleport(CommandSender sender) {
		// Check if command sender is a player
		if (!(sender instanceof Player)) {
			Utils.sendMessage(sender, "player-only");
			return;
		}
		// Check permissions
		if (!sender.hasPermission("randomspawntp.teleport")) {
			Utils.sendMessage(sender, "no-perms");
			return;
		}
		if (!cooldownTimer(sender)) {
			Utils.sendMessage(sender, ImmutableMap.of("%time-left%", String.valueOf((main.getConfig().getLong("cooldown.time") - (System.currentTimeMillis() - cooldown.get(((Player) sender).getUniqueId()))) / 1000)), "cooldown-active");
			return;
		}
		// Teleport player to random world
		List<String> keys = new ArrayList<>(Objects.requireNonNull(main.getConfig().getStringList("worlds")));
		Random randomNumber = new Random();
		String world = keys.get(randomNumber.nextInt(0, keys.size()));

		if (Bukkit.getWorld(world) != null) {
			Bukkit.createWorld(new WorldCreator(world));
			((Player) sender).teleport(Objects.requireNonNull(Bukkit.getWorld(world)).getSpawnLocation());
		} else {
			Utils.sendMessage(sender, "world-nonexistent");
		}

	}

	private boolean cooldownTimer(CommandSender sender) {
		if (!main.getConfig().getBoolean("cooldown.enabled") || !this.cooldown.containsKey(((Player) sender).getUniqueId()) || System.currentTimeMillis() - cooldown.get(((Player) sender).getUniqueId()) >= main.getConfig().getLong("cooldown.time") || sender.hasPermission("randomspawntp.cooldown.bypass")) {
			this.cooldown.put(((Player) sender).getUniqueId(), System.currentTimeMillis());
			return true;
		}
		return false;
	}
}