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

package com.tamrielnetwork.randomspawntp.utils.commands;

import com.google.common.collect.ImmutableMap;
import com.tamrielnetwork.randomspawntp.RandomSpawnTp;
import com.tamrielnetwork.randomspawntp.utils.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class CmdSpec {

	private static final RandomSpawnTp main = JavaPlugin.getPlugin(RandomSpawnTp.class);
	private static final HashMap<UUID, Long> cooldownMap = new HashMap<>();

	public static String getWorld() {

		List<String> keys = new ArrayList<>(Objects.requireNonNull(main.getConfig().getStringList("worlds")));
		Random randomNumber = new Random();
		return keys.get(randomNumber.nextInt(0, keys.size()));
	}

	public static boolean isInvalidCmd(@NotNull CommandSender sender, @NotNull String perm) {

		if (Cmd.isInvalidSender(sender)) {
			return true;
		}
		if (Cmd.isNotPermitted(sender, perm)) {
			return true;
		}
		return isOnCooldown(sender);

	}

	private static void clearMap(@NotNull CommandSender sender) {

		Player senderPlayer = (Player) sender;
		cooldownMap.remove(senderPlayer.getUniqueId());
	}

	private static void doTiming(@NotNull CommandSender sender) {

		new BukkitRunnable() {

			@Override
			public void run() {

				clearMap(sender);
			}
		}.runTaskLaterAsynchronously(main, (main.getConfig().getLong("cooldown.time") * 20L));
	}

	private static boolean isOnCooldown(@NotNull CommandSender sender) {

		Player senderPlayer = (Player) sender;

		boolean isOnCooldown = main.getConfig().getBoolean("cooldown.enabled") && !sender.hasPermission("randomspawntp.cooldown.bypass") && cooldownMap.containsKey(senderPlayer.getUniqueId());

		if (isOnCooldown) {
			String timeRemaining = String.valueOf(cooldownMap.get(senderPlayer.getUniqueId()) - System.currentTimeMillis() / 1000);
			Chat.sendMessage(sender, ImmutableMap.of("%time-left%", timeRemaining), "cooldown-active");
			return true;
		}
		cooldownMap.put(senderPlayer.getUniqueId(), main.getConfig().getLong("cooldown.time") + System.currentTimeMillis() / 1000);
		doTiming(sender);
		return false;
	}

}
