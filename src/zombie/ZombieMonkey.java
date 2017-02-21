/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombie;

/**
 *
 * @author scottbutler
 */


import intf.IZombie;
import intf.ISurvivor;


public class ZombieMonkey extends Character implements IZombie{


	public ZombieMonkey() {
		super(60);
	}

	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(5);
	}
        
        public String getIZombie(){
            return "ZombieMonkey";
        }
	
}
