package com.ashim.solution2.diagram;

import com.ashim.solution2.behaviour.IRefillBehaviour;
import com.ashim.solution2.behaviour.IRepairBehaviour;
import com.ashim.solution2.weapon.IWeapon;

public class Gunman extends Soldier implements IRefillBehaviour, IRepairBehaviour {

	public Gunman(IWeapon weapon, IRefillBehaviour refillBehavior, IRepairBehaviour repairBehavior) {
		super(weapon, refillBehavior, repairBehavior);
		System.out.println("I am gunman");
	}
}