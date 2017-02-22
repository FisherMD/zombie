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
public class OneLegZombie extends Character implements IZombie
{
    public OneLegZombie(){
      super(20);
   }
   
   public void attack(ISurvivor survivor){
      survivor.decreaseHealth(10);
   }
   public String getIZombie(){
      return "OneLegZombie";
   }
}
