/*
 * RandomSpawnTp is a Spigot Plugin that gives players the ability to teleport to a random world spawn.
 * Copyright © 2022 Leopold Meinel & contributors
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

import com.tamrielnetwork.randomspawntp.utils.Chat;
import com.tamrielnetwork.randomspawntp.utils.commands.Cmd;
import com.tamrielnetwork.randomspawntp.utils.commands.CmdSpec;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RandomSpawnTpCmd implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (Cmd.isArgsLengthNotEqualTo(sender, args, 0)) {
			return true;
		}
		doRandomSpawnTp(sender);
		return true;
	}

	private void doRandomSpawnTp(@NotNull CommandSender sender) {

		if (CmdSpec.isInvalidCmd(sender, "randomspawntp.rstp")) {
			return;
		}
		Player senderPlayer = (Player) sender;
		String world = CmdSpec.getWorld();

		if (Bukkit.getWorld(world) == null) {
			Chat.sendMessage(sender, "invalid-world");
			return;
		}

		Bukkit.createWorld(new WorldCreator(world));
		senderPlayer.teleport(Objects.requireNonNull(Bukkit.getWorld(world)).getSpawnLocation());

	}

}