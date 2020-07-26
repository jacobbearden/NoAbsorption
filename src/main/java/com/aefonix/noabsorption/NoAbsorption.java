package com.aefonix.noabsorption;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public class NoAbsorption extends JavaPlugin implements Listener {
  @Override
  public void onEnable() {
    this.getServer().getPluginManager().registerEvents(this, this);
  }

  @Override
  public void onDisable() {}

  @EventHandler
  public void onConsume(PlayerItemConsumeEvent event) {
    if (!event.isCancelled()) {
      Player player = event.getPlayer();

      if (event.getItem().getType() == Material.GOLDEN_APPLE) {
        getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
          public void run(){
            if (player.hasPotionEffect(PotionEffectType.ABSORPTION)){
              player.removePotionEffect(PotionEffectType.ABSORPTION);
            }
          }
        }, 1L);
      }
    }
  }
}
