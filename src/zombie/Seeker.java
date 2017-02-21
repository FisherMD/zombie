package zombie;  
 
import intf.IZombie; 
package zombie;

import intf.IZombie;
import intf.ISurvivor;

/**
 * The Seeker is fast aggressive zombie that runs down survivors
 * They have low health but can do lot of damage.  
 * 
 * @author Jaiden
 */
public class Seeker extends Character implements IZombie{

	/**
	 * A Seeker starts with 40 points of health
	 */
	public Seeker() {
		super(40);
	}

	/**
	 * An attack from the tank decrease a survivor's health by 15 points.
	 * @param survivor 
	 */
	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(15);
	}
        
        public String getIZombie(){
            return "Seeker";
        }
	
	
}
