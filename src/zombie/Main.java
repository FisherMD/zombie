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

    //initialize the number of characters
    int CommonInf, Tank, Predator = 0;
    
    /* Create array of random zombies */
    public static IZombie[] randomZombies() {
        int numZombies = (int) (Math.random() * 10);
        IZombie[] zombies = new IZombie[numZombies];
        for (int i = 0; i < zombies.length; i++) {
            int zombieType = (int) (Math.random() * 5);
            switch (zombieType) {
                case 0:
                    zombies[i] = (IZombie) factory.make("CommonInf");
                    
                    break;
                case 1:
                    zombies[i] = (IZombie) factory.make("Tank");
                    break;
                case 2:
                    zombies[i] = (IZombie) factory.make("Predator");
                    break;
                case 3:
                    zombies[i] = (IZombie) factory.make("ZombieMonkey");
                    break;
		case 4:
		    zombies[i] = (IZombie) factory.make("Seeker");
	            break;		    
	    }
        }
        return zombies;
    }

    /*  Created a array of random survivors */
    public static ISurvivor[] randomSurvivors() {
        int numZombies = (int) (Math.random() * 20);
        ISurvivor[] survivors = new ISurvivor[numZombies];
        for (int i = 0; i < survivors.length; i++) {
            int type = (int) (Math.random() * 5);
            switch (type) {
                case 0:
                    survivors[i] = (ISurvivor) factory.make("Soldier");
                    break;
                case 1:
                    survivors[i] = (ISurvivor) factory.make("Teacher");
                    break;
                case 2:
                    survivors[i] = (ISurvivor) factory.make("Student");
                    break;
                case 3:
                    survivors[i] = (ISurvivor) factory.make("Child");
                    break;
                case 4:
                    survivors[i] = (ISurvivor) factory.make("Dog");
                    break;
            }
        }
        return survivors;
    }

    /* Checks if all zombies and all survivors are dead  */
    public static boolean allDead(ICharacter[] characters) {
        boolean allDead = true;
        for (int i = 0; i < characters.length; i++) {
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

        // Store number of each type of zombie
        int[] numZTypes = new int[5];
	
        //Count number of each zombie, store in array
        for(int i=0;i<zombies.length;i++){
            if(zombies[i]instanceof CommonInf){
                    numZTypes[0]++;
            }else if(zombies[i]instanceof Predator){
                    numZTypes[1]++;
            }else if(zombies[i]instanceof Tank){
                    numZTypes[2]++;
            }else if(zombies[i]instanceof ZombieMonkey){
                    numZTypes[3]++;
            }else if(zombies[i]instanceof Seeker){
                    numZTypes[4]++;		
            }
	}
        
        System.out.println("We have " + survivors.length + " survivors trying to make it to safety.");
        System.out.println("But there are " + zombies.length + " zombies waiting for them.");
        System.out.print(numZTypes[0] + " Common Infected, " + numZTypes[1] + " Predator(s), " + numZTypes[2] + " Tank(s), "+ numZTypes[3] + " Zombie Monkey(ies)");
        System.out.println(", and " + numZTypes[4] + " Seeker(s).");
	    
        //Until either all zombies or all survivors are dead, have them attack each other
        do {

            //if alive, each survivor attacks every living zombie
            for (int i = 0; i < survivors.length; i++) {
                if (survivors[i].isAlive()){
                    for (int j = 0; j < zombies.length; j++) {
                        if(zombies[j].isAlive()){
                            
                            survivors[i].attack(zombies[j]);
                            if(!zombies[j].isAlive()){
                                System.out.println(survivors[i].getISurvivor() + " killed " + zombies[j].getIZombie() );
                            }
                        }
                    }
                }
            }

            //if alive, each zombie attacks every alive survivor
            for (int i = 0; i < zombies.length; i++) {
                if (zombies[i].isAlive()) {
                    for (int j = 0; j < survivors.length; j++) {
                        if(survivors[j].isAlive()){
                            
                            zombies[i].attack(survivors[j]);
                            if(!survivors[j].isAlive()){
                                System.out.println(zombies[i].getIZombie() + " " + " killed " + survivors[j].getISurvivor());
                            }
                        }
                    }
                }
            }

        } while ((allDead(survivors) == false) & (allDead(zombies) == false));

        if (allDead(survivors)) {
            System.out.println("None of the survivors made it.");
        } else {
            int count = 0;
            for (int i = 0; i < survivors.length; i++) {
                if (survivors[i].isAlive()) {
                    count++;
                }
            }
            System.out.println("It seems " + count + " have made it to safety.");
        }
    }
}
