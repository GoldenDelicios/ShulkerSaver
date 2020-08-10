package org.slabserver.plugin.shulkersaver;

import java.io.File;
import java.util.Arrays;
import java.util.EnumSet;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

public final class ShulkerSaver extends JavaPlugin implements Listener {

	private static EnumSet<Material> shulkerBoxes = EnumSet.copyOf(Arrays.asList(
			Material.SHULKER_BOX,
			Material.WHITE_SHULKER_BOX,
			Material.ORANGE_SHULKER_BOX,
			Material.MAGENTA_SHULKER_BOX,
			Material.LIGHT_BLUE_SHULKER_BOX,
			Material.YELLOW_SHULKER_BOX,
			Material.LIME_SHULKER_BOX,
			Material.PINK_SHULKER_BOX,
			Material.GRAY_SHULKER_BOX,
			Material.LIGHT_GRAY_SHULKER_BOX,
			Material.CYAN_SHULKER_BOX,
			Material.PURPLE_SHULKER_BOX,
			Material.BLUE_SHULKER_BOX,
			Material.BROWN_SHULKER_BOX,
			Material.GREEN_SHULKER_BOX,
			Material.RED_SHULKER_BOX,
			Material.BLACK_SHULKER_BOX
	));
	
	public ShulkerSaver() {
		
	}

	public ShulkerSaver(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
		super(loader, description, dataFolder, file);
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onSwitch(PlayerPortalEvent event) {
		if (event.getCause() == TeleportCause.END_PORTAL) {
			World world = event.getTo().getWorld();
			if (world.getEnvironment() == Environment.THE_END) {
				for (int i = 98; i <= 102; i++) {
					for (int j = -2; j <= 2; j++) {
						for (int k = 48; k <= 51; k++) {
							Block block = world.getBlockAt(i, k, j);
							if (shulkerBoxes.contains(block.getType()))
								block.breakNaturally();
						}
					}
				}
			}
		}
	}

}
