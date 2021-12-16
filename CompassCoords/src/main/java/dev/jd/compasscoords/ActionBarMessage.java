package dev.jd.compasscoords;

import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.network.chat.ChatMessageType;
import net.minecraft.network.chat.IChatBaseComponent.ChatSerializer;
import net.minecraft.network.protocol.game.PacketPlayOutChat;

public class ActionBarMessage {

	private PacketPlayOutChat packet;

	public ActionBarMessage(String text) {

		packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + text + "\"}"), ChatMessageType.c,
				new java.util.UUID(0, 0));

	}

	public void sendToPlayer(Player p) {
		((CraftPlayer) p).getHandle().b.sendPacket(packet);
	}

}
