package com.ashim.solution2.army;

import com.ashim.solution2.behaviour.IRefillBehaviour;
import com.ashim.solution2.behaviour.IRepairBehaviour;
import com.ashim.solution2.weapon.IWeapon;

public class Soldier {

	IWeapon weapon;
	IRefillBehaviour refillBehavior;
	IRepairBehaviour repairBehavior;

	public Soldier(IWeapon weapon, IRefillBehaviour refillBehavior, IRepairBehaviour repairBehavior) {
		this.weapon = weapon;
		this.repairBehavior = repairBehavior;
		this.refillBehavior = refillBehavior;
	}

	public void changeWeapon(IWeapon weapon) {
		this.weapon = weapon;
	}

	public void changeRefill(IRefillBehaviour refillBehavior) {
		this.refillBehavior = refillBehavior;
	}

	public void attack() {
		weapon.attack();
	}

	public void refill() {
		refillBehavior.refill();
	}

	public void repair() {
		repairBehavior.repair();
	}

}
