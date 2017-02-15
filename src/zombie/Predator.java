package zombie;


import intf.IZombie;
import intf.ISurvivor;


public class Predator extends Character implements IZombie{


	public Predator() {
		super(80);
	}

	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(10);
	}
	
}