
package zombie;


import intf.ICharacter;
import intf.ICharacterFactory;
/**
 *
 * @author thaoc
 */
public class CharacterFactory implements ICharacterFactory{
  
  public static final ICharacterFactory instance = new CharacterFactory();
  
  private CharacterFactory(){
   
  }

  /**
   * Make the character.  To support more characters,
   * simply implement a character and then add a case statement
   * to this method.
   * 
   * @param type The type of character to make.
   * @return 
   */
  
  @Override
  public ICharacter make(String type) {
    switch(type){
      case "CommonInf"  : return new CommonInf();
      case "Tank"     	: return new Tank();
      case "Predator"	: return new Predator();
      case "Child"		: return new Child();
      case "Teacher"	: return new Teacher();
      case "Soldier"	: return new Soldier();
      case "Student"	: return new Student();
    }
    return null;
  }
  
}
