package zombie;


import intf.IZombie;
import intf.ISurvivor;


public class CommonInf extends Character implements IZombie{


	public CommonInf() {
		super(30);
	}

	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(5);
	}
	
}