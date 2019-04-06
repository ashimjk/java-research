package com.ashim.solution2;

import com.ashim.solution2.army.*;
import com.ashim.solution2.behaviour.*;
import com.ashim.solution2.weapon.Archer;
import com.ashim.solution2.weapon.Gun;

public class StrategyImplementation {

	public StrategyImplementation() {
		Soldier soldier1 = new Archerman(new Archer(), new WeaponBasedRefill(), new NoRepair());
		soldier1.attack();
		soldier1.refill();
		soldier1.repair();

		Gunman soldier2 = new Gunman(new Gun(), new TimeBasedRefill(), new NoRepair());
		soldier2.attack();
		soldier2.refill();
		soldier2.repair();

		//Superman can use any the weapon and is self repairable
		Soldier superman = new Superman(new Gun(), new TimeBasedRefill(), new SelfRepair());
		superman.attack();
		superman.changeWeapon(new Archer());
		superman.changeRefill(new WeaponBasedRefill());
		superman.attack();

		//Robot can use any the weapon and need human to repair
		Soldier robot = new Robot(new Archer(), new WeaponBasedRefill(), new ManualRepair());
		robot.attack();
		robot.changeWeapon(new Gun());
		robot.changeRefill(new TimeBasedRefill());
		robot.attack();
	}

}
