package fr.flender.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import fr.flender.ability.Ability;
import fr.flender.ability.AbilityCooldown;
import fr.flender.ability.AbilityUnique;
import fr.flender.ability.AbilityWithDuration;
import fr.flender.data.ElectricData;
import fr.flender.data.Error;
import fr.flender.data.FightingData;
import fr.flender.data.FireData;
import fr.flender.data.GrassData;
import fr.flender.data.MessageData;
import fr.flender.data.PoisonData;
import fr.flender.data.PsychicData;
import fr.flender.data.SteelData;
import fr.flender.data.TypeData;
import fr.flender.functions.Minecraft;
import fr.flender.loader.Recipe;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;
import fr.flender.main.Type;
import fr.flender.type.Electric;
import fr.flender.type.Fire;
import fr.flender.type.Neutral;


public class ItemsListeners implements Listener {
	
	private Main main;
	public ItemsListeners(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
				
		CustomPlayer player = main.getCustomPlayer(event.getPlayer());
		
		if ( player != null ) {
						
			ItemStack item = event.getItem();
			Action action = event.getAction();
			Type type = player.getType();
						
			if ( item != null && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK ) ) {
										
				switch ( type.getName() ) {
				
				case "Feu" :
					
					if ( item.getType() == Material.BLAZE_POWDER && item.getItemMeta().getDisplayName() == FireData.ability1Name) {
												
						AbilityWithDuration ability = (AbilityWithDuration) type.getAbility(0);
						ability.testAbilityCooldown(player.getPlayer(), FireData.ability1Cooldown + FireData.ability1lenght);
					
					}
					
					if ( item.getType() == Material.FIREBALL && item.getItemMeta().getDisplayName() == FireData.ability2Name) {
						
						AbilityCooldown ability = (AbilityCooldown) type.getAbility(1);

						if ( ability.getCooldown() == 0 ) {
							ability.setCooldown(FireData.ability2Cooldown);
							player.getPlayer().sendMessage("Activation de la competence : ");
							Minecraft.spawnFireball(player);
						}else {
							player.getPlayer().sendMessage(TypeData.cooldown(ability.getCooldown()));
						}
						
						
						
					}
					break;
					
				case "Psy":
					
					if ( item.getType() == Material.STICK && item.getItemMeta().getDisplayName() == PsychicData.ability1Name) {
						
						AbilityCooldown ability = (AbilityCooldown) type.getAbility(0);

						if ( ability.getCooldown() == 0 ) {
							
							Player p = player.getPlayer();
							
							Location loc = p.getLocation();
				            Vector dir = loc.getDirection().multiply(10);
				            Location teleportTo = loc.clone().add(dir);

					        if(teleportTo.getBlock().getType() == Material.AIR) {
					            Location loc2 = teleportTo;
					            p.teleport(loc2);
								p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10*20, 0, false,false));
								p.getWorld().spawnEntity(loc.add(0,1,0), EntityType.CREEPER);
								ability.setCooldown(PsychicData.ability1Cooldown);
					        }
				            
						}else {
							player.getPlayer().sendMessage(TypeData.cooldown(ability.getCooldown()));
						}
						
					} if ( item.getType() == Material.EYE_OF_ENDER && item.getItemMeta().getDisplayName() == PsychicData.ability2Name) {
						
						event.setCancelled(true);
						
						AbilityWithDuration ability = (AbilityWithDuration) type.getAbility(1);
						ability.testAbilityCooldown(player.getPlayer(), PsychicData.ability2Cooldown + PsychicData.ability2lenght);
						
					}
					break;
					
				
				case "Neutre":
										
					if (item.hasItemMeta()){
						
						player.getPlayer().sendMessage(""+item.getTypeId());
						
						switch ( item.getTypeId()) {
						
						
						
						
						case 372 :
							player.setType(new Electric(player));
							break;
							
						case 378 :
							player.setType(new Fire(player));
							break;

						}
						
					

					
						player.getType().getItems(player);
						player.getPlayer().sendMessage(MessageData.evolution(player.getType().getName()));
						if ( player.getMate() != null ) player.getMate().getPlayer().sendMessage(MessageData.evolutionMate(player.getType().getName()));

					}
					
				case "Eau":
					
					if ( item.getType() == Material.RAW_FISH) {
						
						AbilityCooldown ability = (AbilityCooldown) type.getAbility(0);
						
						if ( ability.getCooldown() == 0 ) {
							ability.setCooldown(FireData.ability1Cooldown);
							player.getPlayer().sendMessage("Activation de la competence : ");

							// A Faire
							
						}else {
							player.getPlayer().sendMessage(TypeData.cooldown(ability.getCooldown()));
						}
						
					}
					
				case "Plante":
					
					if ( item.getType() == Material.SEEDS) {
						
						AbilityCooldown ability = (AbilityCooldown) type.getAbility(0);

						if ( ability.getCooldown() == 0 ) {
							ability.setCooldown(GrassData.ability1Cooldown);
							player.getPlayer().sendMessage("Activation de la competence : ");
							
							player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10*20, 0, false,false));
							if (player.getMate() == null) return;
							player.getMate().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10*20, 0, false,false));							
							
						}else {
							player.getPlayer().sendMessage(TypeData.cooldown(ability.getCooldown()));
						}
						
						
						
					}
					
				case "Poison":
					
					if ( item.getType() == Material.BROWN_MUSHROOM) {
						
						AbilityCooldown ability = (AbilityCooldown) type.getAbility(0);

						if ( ability.getCooldown() == 0 ) {
							ability.setCooldown(PoisonData.ability1Cooldown);
							player.getPlayer().sendMessage("Activation de la competence : ");
							
							for ( Entity entity : player.getPlayer().getNearbyEntities(10, 10, 10)) {
								if ( entity instanceof Player) {
									((Player)entity).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 1, false,false));
								}
							}
							
							
						}else {
							player.getPlayer().sendMessage(TypeData.cooldown(ability.getCooldown()));
						}
						
					}
					
					
					if ( item.getType() == Material.RED_MUSHROOM) {
						
						AbilityCooldown ability = (AbilityCooldown) type.getAbility(1);

						if ( ability.getCooldown() == 0 ) {
							ability.setCooldown(PoisonData.ability2Cooldown);
							player.getPlayer().sendMessage("Activation de la competence : ");
							
							for ( Entity entity : player.getPlayer().getNearbyEntities(10, 10, 10)) {
								if ( entity instanceof Player) {
									((Player)entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 10, false,false));
								}
							}
							
							
						}else {
							player.getPlayer().sendMessage(TypeData.cooldown(ability.getCooldown()));
						}
						
					}
				case "Fée":
					
					if ( item.getType() == Material.RED_ROSE) {
						
						Player mate = player.getMate().getPlayer();

						
						if ( mate == null) return;

						
						if ( mate.getGameMode() == GameMode.SPECTATOR) {
							
							if ( !((AbilityUnique) player.getType().getAbility(0)).getUse()) {
								mate.setGameMode(GameMode.SURVIVAL);
								mate.teleport(player.getPlayer().getLocation());
								mate.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 120*20, 1, false,false));
								((AbilityUnique) player.getType().getAbility(0)).setUse(true);
							}else {
								player.getPlayer().sendMessage(Error.abilityUniqueUse);
							}
							
						}else {
							player.getPlayer().sendMessage(Error.abilityUniqueMateNotSpec);
						}
						
						
						
					}
					
				case "Electrique":
					
					
					if ( item.getType() == Material.GOLD_BLOCK) {
						event.setCancelled(true);
						if (item.getItemMeta().getDisplayName().equals(ElectricData.ability1Name)) {
							AbilityWithDuration ability = (AbilityWithDuration) type.getAbility(0);
							ability.testAbilityCooldown(player.getPlayer(), ElectricData.ability1Cooldown + ElectricData.ability1lenght);
							
						}
					}
					
					
						
				case "Combat":
					
					if ( item.getType() == Material.STICK && item.getItemMeta().getDisplayName() == FightingData.ability1Name) {
						
						AbilityCooldown ability = (AbilityCooldown) type.getAbility(0);
						
						if ( ability.getCooldown() == 0 ) {
							ability.setCooldown(FightingData.ability1Cooldown);
							player.getPlayer().sendMessage("Activation de la competence : ");
							player.getPlayer().setVelocity(player.getPlayer().getLocation().getDirection().multiply(2));
						}else {
							player.getPlayer().sendMessage(TypeData.cooldown(ability.getCooldown()));
						}
						
						
					}
					
					if ( item.getType() == Material.BONE && item.getItemMeta().getDisplayName() == FightingData.ability2Name) {
						
						AbilityWithDuration ability = (AbilityWithDuration) type.getAbility(1);
						if ( ability.testAbilityCooldown(player.getPlayer(), FightingData.ability2Cooldown + FightingData.ability2lenght)) {
							player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60*20, 0, false,false));
							player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60*20, 0, false,false));
						}
					
					}
					
				
				case "Acier":
					
					if ( item.getType() == Material.IRON_BLOCK && item.getItemMeta().getDisplayName() == SteelData.ability1Name) {
						
						event.setCancelled(true);
						
						AbilityWithDuration ability = (AbilityWithDuration) type.getAbility(0);					
						boolean test = ability.testAbilityCooldown(player.getPlayer(), SteelData.ability1Cooldown + SteelData.ability1lenght);
						if ( test ) {
							player.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, SteelData.ability1lenght*20, 1, false,false));
						}
					}
				
				}
				
			}
			
		}
		
		
	}

}
