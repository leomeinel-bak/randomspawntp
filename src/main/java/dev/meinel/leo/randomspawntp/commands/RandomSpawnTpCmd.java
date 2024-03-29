/*
 * File: RandomSpawnTpCmd.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2023 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.randomspawntp.commands;

import dev.meinel.leo.randomspawntp.utils.Chat;
import dev.meinel.leo.randomspawntp.utils.commands.Cmd;
import dev.meinel.leo.randomspawntp.utils.commands.CmdSpec;
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
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
            @NotNull String label, @NotNull String[] args) {
        if (!Cmd.isArgsLengthEqualTo(sender, args, 0)) {
            return false;
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
