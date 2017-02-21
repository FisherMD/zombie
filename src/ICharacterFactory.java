package intf;

public interface ICharacterFactory{
  
	 /**
	 * Make a character type
	 * 
	 * @param name of character type
  * @return that type of character
	 */
  public ICharacter make(String type);

}
