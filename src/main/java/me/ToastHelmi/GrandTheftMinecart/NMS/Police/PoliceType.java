package me.ToastHelmi.GrandTheftMinecart.NMS.Police;

import net.minecraft.server.v1_10_R1.EntityLiving;

public enum PoliceType {
	POLICEOFFICER(PoliceOfficer.class), SNIPER(Sniper.class), SWAT(Swat.class);

	private Class<? extends EntityLiving> s;

	PoliceType(Class<? extends EntityLiving> s) {
		this.s = s;
	}
	public Class<? extends EntityLiving> getTypeClass() {
		return s;
	}
}