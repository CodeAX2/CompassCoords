package dev.jd.compasscoords;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class App extends JavaPlugin {

	@Override
	public void onEnable() {

		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {

			Player[] players = new Player[getServer().getOnlinePlayers().size()];
			getServer().getOnlinePlayers().toArray(players);

			// Loop over every online player
			for (int i = 0; i < players.length; i++) {

				Player curPlayer = players[i];

				// Check if the player is holding a compass in either hand
				if (curPlayer.getInventory().getItemInMainHand().getType() == Material.COMPASS
						|| curPlayer.getInventory().getItemInOffHand().getType() == Material.COMPASS) {

					// Get the player's XYZ
					double x = curPlayer.getLocation().getX();
					double y = curPlayer.getLocation().getY();
					double z = curPlayer.getLocation().getZ();

					// Get the player's yaw
					double yaw = curPlayer.getLocation().getYaw();

					DecimalFormat formatter = new DecimalFormat("#0.0");

					// Create the message to send
					String message = ChatColor.WHITE
							+ FacingUtil.getDirectionFacing(yaw) + " " + ChatColor.RED + formatter.format(x) + " " + ChatColor.GREEN + formatter.format(y)
							+ " " + ChatColor.AQUA + formatter.format(z);

					// Send the message to the player
					ActionBarMessage.sendMessageToPlayer(curPlayer, message);

				}

			}

		}, 0, 5L);

	}

	@Override
	public void onDisable() {

	}

}
