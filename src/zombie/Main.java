package zombie;


import intf.ICharacter;
import intf.ICharacterFactory;
import intf.ISurvivor;
import intf.IZombie;

/**
 *
 * @author thaoc
 */
public class Main {
  
  private static final ICharacterFactory factory = CharacterFactory.instance;
  
  public static IZombie[] randomZombies() {
    int numZombies = (int) (Math.random() * 10);
    IZombie[] zombies = new IZombie[numZombies];
    for (int i = 0; i < zombies.length; i++) {
      int zombieType = (int) (Math.random() * 3);
      switch(zombieType){
        case 0: zombies[i] = (IZombie) factory.make("CommonInf"); break;
        case 1: zombies[i] = (IZombie) factory.make("Tank"); break;
        case 2: zombies[i] = (IZombie) factory.make("Predator"); break;
      }
    }
    return zombies;
  }

  public static ISurvivor[] randomSurvivors() {
    int numZombies = (int) (Math.random() * 20);
    ISurvivor[] survivors = new ISurvivor[numZombies];
    for (int i = 0; i < survivors.length; i++) {
      int type = (int) (Math.random() * 4);
      switch(type){
        case 0: survivors[i] = (ISurvivor) factory.make("Soldier"); break;
        case 1: survivors[i] = (ISurvivor) factory.make("Teacher"); break;
        case 2: survivors[i] = (ISurvivor) factory.make("Student"); break;
        case 3: survivors[i] = (ISurvivor) factory.make("Child"); break;
      }
    }
    return survivors;
  }

  public static boolean allDead(ICharacter[] characters){
    boolean allDead = true;
    for(int i=0; i<characters.length; i++){
      allDead &= !characters[i].isAlive();
    }
    return allDead;
  }

  /**
   * @param args the command line arguments
   */
  
  
  public static void main(String[] args) {

    IZombie[] zombies = randomZombies();
    ISurvivor[] survivors = randomSurvivors();

    System.out.println("We have " + survivors.length + " survivors trying to make it to safety.");
    System.out.println("But there are " + zombies.length + " zombies waiting for them.");
    
    do{
    
	    for(int i=0; i<survivors.length; i++){
	    	for(int j=0; j<zombies.length; j++){
	    		if(survivors[i].isAlive()){
	    			survivors[i].attack(zombies[j]);
	    		}
	    	}
    }
    
   
    
    for(int i=0; i<zombies.length; i++){
    	for(int j=0; j<survivors.length; j++){
    		if(zombies[i].isAlive()){
    			zombies[i].attack(survivors[j]);
    		}
    	}
    }
    
    }while((allDead(survivors)==false) & (allDead(zombies)==false));
   
    
    if (allDead(survivors)) {
      System.out.println("None of the survivors made it.");
    } else {
      int count = 0;
      for(int i=0; i<survivors.length; i++) {
        if (survivors[i].isAlive()) count++;
      }
      System.out.println("It seems " + count + " have made it to safety.");
    }
  }

}
