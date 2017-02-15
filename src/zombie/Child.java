package zombie;

import intf.ISurvivor;
import intf.IZombie;

public class Child extends Character implements ISurvivor{ 
	
	public Child() {
		super(20);
	}
	
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(2);
	}

}
