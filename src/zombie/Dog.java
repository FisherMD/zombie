/*
 * Michael Fisher
 * UW-Whitewater
 */
package zombie;

import intf.IZombie;
import intf.ISurvivor;

/*  
    From what I see in movies, dogs have approximately
    the health of a child and the attack of a soldier.
*/


public class Dog extends Character implements ISurvivor{
    
    public Dog() {
            super(20);
    }

    @Override
    public void attack(IZombie zombie) {
            zombie.decreaseHealth(10);
    }
    
    @Override
    public String getISurvivor(){
        return "Dog";
    }
	
}