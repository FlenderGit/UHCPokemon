package fr.flender.main;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import net.minecraft.server.v1_8_R1.ChatComponentText;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerListHeaderFooter;

public class Packet {
	
	private PacketPlayOutPlayerListHeaderFooter packet;
	private ChatComponentText head;
	private ChatComponentText foot;
	
	private List<String> lsHead = Arrays.asList("      §4────§c────§e────[  §lUHC Pokemon  §e]────§c────§4────\n\n§eOnline : ",
			"" ,"/" + Bukkit.getServer().getMaxPlayers() + "\n" , "" , "\n§e------------------------");
	private List<String> lsFoot = Arrays.asList("§e------------------------\n§7", "" , "\n\n     §4────§c────§e────[ §7§lPar §5§lFlender §e]────§c────§4────");
	
	public Packet(String head,String foot) {
		
		this.packet = new PacketPlayOutPlayerListHeaderFooter();
		this.head = new ChatComponentText(head);
		this.foot = new ChatComponentText(foot);
		
	}
	
	
	
	public PacketPlayOutPlayerListHeaderFooter getPacket() {
		return packet;
	}



	public void setPacket(PacketPlayOutPlayerListHeaderFooter packet) {
		this.packet = packet;
	}
	
	public void changePacket(String head , String foot) {
		this.head = new ChatComponentText(head);
		this.foot = new ChatComponentText(foot);
	}
	
	public void update( Handler handler ) {
		lsHead.set(1, String.valueOf(Bukkit.getOnlinePlayers().size()));
		lsHead.set(3, handler.getHours() + ":" + handler.getMinutes() + ":" + handler.getSeconds());
		lsFoot.set(1, null);
		changePacket(StringUtils.join(lsHead, "") , StringUtils.join(lsFoot, "") );
	}


	public void testPacket() {
		
		try {
			java.lang.reflect.Field a = packet.getClass().getDeclaredField("a");
			a.setAccessible(true);
			java.lang.reflect.Field b = packet.getClass().getDeclaredField("b");
			b.setAccessible(true);
			
			a.set(packet, head);
			b.set(packet, foot);
			
			if(Bukkit.getOnlinePlayers().size() == 0) {
				return;
			}
			
			
		}catch (NoSuchFieldException | IllegalAccessException e){
			e.printStackTrace();
			
		}
		
	}

}
