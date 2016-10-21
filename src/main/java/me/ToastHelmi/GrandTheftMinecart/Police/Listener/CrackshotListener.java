/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.ToastHelmi.GrandTheftMinecart.Police.Listener;

import org.bukkit.entity.Damageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

import me.ToastHelmi.GrandTheftMinecart.Police.CrimeManager;

public class CrackshotListener implements Listener {

	public CrimeManager m;

	public CrackshotListener() {
		m = CrimeManager.getInstance();
	}

	@EventHandler
	public void hurtEntity(WeaponDamageEntityEvent e) {
		if (e.getVictim() instanceof Damageable) {
			CrimeListener.hurtEntity(e.getPlayer(), (Damageable) e.getVictim(), e.getDamage());
		}
	}
}
