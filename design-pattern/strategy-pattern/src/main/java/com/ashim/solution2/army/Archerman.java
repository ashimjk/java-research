package com.ashim.solution2.army;

import com.ashim.solution2.behaviour.IRefillBehaviour;
import com.ashim.solution2.behaviour.IRepairBehaviour;
import com.ashim.solution2.weapon.IWeapon;

public class Archerman extends Soldier implements IRefillBehaviour, IRepairBehaviour {

	public Archerman(IWeapon weapon, IRefillBehaviour refillBehavior, IRepairBehaviour repairBehavior) {
		super(weapon, refillBehavior, repairBehavior);
		System.out.println("I am archerman");
	}
}
