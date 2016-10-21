package me.ToastHelmi.GrandTheftMinecart.NMS.PathFinderGoals;

import org.bukkit.entity.Player;

import me.ToastHelmi.GrandTheftMinecart.Police.CrimeManager;
import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.EntityLiving;
import net.minecraft.server.v1_10_R1.EntityPlayer;
import net.minecraft.server.v1_10_R1.IEntitySelector;

public class EntitySelectorNearestAttackableGangster implements PathfinderGoalNearestAttackableTarget  {

	final IEntitySelector c;
	final PathfinderGoalNearestAttackableGangster d;
	final int minLevel;

	EntitySelectorNearestAttackableGangster(PathfinderGoalNearestAttackableGangster goal,
			IEntitySelector ientityselector, int minLevel) {
		this.d = goal;
		this.c = ientityselector;
		this.minLevel = minLevel;
	}

	public boolean a(Entity entity) {
		return !(entity instanceof EntityPlayer) ? false : (this.c != null && !this.c.a(entity)
				? false
				: (!checkWantedlevel((EntityPlayer) entity) ? false : this.d.a((EntityLiving) entity, false)));
	}

	public boolean checkWantedlevel(EntityPlayer e) {
		return CrimeManager.getInstance().getWantedLevel((Player) e.getBukkitEntity()) >= minLevel;

	}
}
