package me.ToastHelmi.GrandTheftMinecart.NMS.PathFinderGoals;

import java.util.Collections;
import java.util.List;

import net.minecraft.server.v1_10_R1.EntityCreature;
import net.minecraft.server.v1_10_R1.EntityLiving;
import net.minecraft.server.v1_10_R1.IEntitySelector;
import net.minecraft.server.v1_10_R1.PathfinderGoalNearestAttackableTarget.DistanceComparator;
import net.minecraft.server.v1_10_R1.PathfinderGoalTarget;

public class PathfinderGoalNearestAttackableGangster extends PathfinderGoalTarget {

	private final Class<?> clazz;
	private final int i;
	private final DistanceComparator comparator;
	private final IEntitySelector selector;
	private EntityLiving entity;

	public PathfinderGoalNearestAttackableGangster(EntityCreature entitycreature, Class<?> clazz, int i, boolean flag,
			int minLevel) {
		this(entitycreature, clazz, i, flag, false, minLevel);
	}

	public PathfinderGoalNearestAttackableGangster(EntityCreature entitycreature, Class<?> clazz, int i, boolean flag,
			boolean flag1, int minLevel) {
		this(entitycreature, clazz, i, flag, flag1, (IEntitySelector) null, minLevel);
	}

	public PathfinderGoalNearestAttackableGangster(EntityCreature entitycreature, Class<?> clazz, int i, boolean flag,
			boolean flag1, IEntitySelector ientityselector, int minLevel) {
		super(entitycreature, flag, flag1);
		this.clazz = clazz;
		this.i = i;
		this.comparator = new DistanceComparator(entitycreature);
		this.a(1);
		this.selector = new EntitySelectorNearestAttackableGangster(this, ientityselector, minLevel);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public boolean a() {
		if (this.i > 0 && e.getRandom().nextInt(this.i) != 0) {
			return false;
		} else {
			double d0 = this.i();
			List list = e.world.getEntities(this.e, e.getBoundingBox().grow(d0, 4.0D, d0), this.selector);

			Collections.sort(list, this.comparator);
			if (list.isEmpty()) {
				return false;
			} else {
				this.entity = (EntityLiving) list.get(0);
				return true;
			}
		}
	}

	public void c() {
		this.e.setGoalTarget(this.entity);
		super.c();
	}
	public boolean a(EntityLiving e, boolean flag) {
		return super.a(e, flag);
	}
}