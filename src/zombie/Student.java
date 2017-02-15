package zombie;

import intf.ISurvivor;
import intf.IZombie;

public class Student extends Character implements ISurvivor{ 
	
	public Student() {
		super(30);
	}
	
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(35);
	}

}
