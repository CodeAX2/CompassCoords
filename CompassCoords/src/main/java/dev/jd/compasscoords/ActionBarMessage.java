package dev.jd.compasscoords;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.TextComponent;

public class ActionBarMessage {

	public static void sendMessageToPlayer(Player p, String message) {
		p.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
	}

}
