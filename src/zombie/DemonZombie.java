/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombie;

import intf.*;


/**
 *
 * @author Waffle
 */
public class DemonZombie extends Character implements IZombie
{
   public DemonZombie(){
      super(120);
   }
   
   public void attack(ISurvivor survivor){
      survivor.decreaseHealth(30);
   }
   public String getIZombie(){
      return "DemonZombie!";
   }
   
}
