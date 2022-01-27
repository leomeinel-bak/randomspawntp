/*
 RandomSpawnTp is a Spigot Plugin that gives players the ability to teleport to a random world spawn.
 Copyright (C) 2022  Leopold Meinel

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program. If not, see https://github.com/TamrielNetwork/RandomSpawnTp/blob/main/LICENSE.
 */
package com.tamrielnetwork.randomspawntp.commands;

import com.tamrielnetwork.randomspawntp.RandomSpawnTp;
import com.tamrielnetwork.randomspawntp.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class RandomSpawnTpCmd implements CommandExecutor {

    private final RandomSpawnTp main = JavaPlugin.getPlugin(RandomSpawnTp.class);

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
        // Teleport player to random world
        List<String> keys = new ArrayList<>(Objects.requireNonNull(main.getConfig().getStringList("worlds")));
        Random randomNumber = new Random();
        String world = keys.get(randomNumber.nextInt(0,keys.size()));
        /*
        if (main.getServer().getWorld(world) != null) {
            ((Player) sender).teleport(Objects.requireNonNull(main.getServer().getWorld(world)).getSpawnLocation());
        }
         */
    }
}
