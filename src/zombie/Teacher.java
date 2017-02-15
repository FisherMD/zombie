package zombie;

import intf.ISurvivor;
import intf.IZombie;

public class Teacher extends Character implements ISurvivor{ 
	
	public Teacher() {
		super(50);
	}
	
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(5);
	}

}
