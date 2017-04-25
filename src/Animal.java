/**
 * This class describes an object with the properties of an animal.
 * 
 * @author Tyler Dalbora
 * @version 1.0
 */
public class Animal {
  
  /**
   * The name of the animal, which will be inherited from this superclass.
   */
  protected String name;
  
  /**
   * The sound the animal makes.
   * 
   * @see #makeNoise
   */
  protected String sound;
  
  /**
   * The constructor for this class.
   * 
   * @param sound
   *          - The sound the animal makes.
   * @param name
   *          - The name of the animal.
   */
  public Animal(String sound, String name) {
    this.sound = sound;
    this.name = name;
  }
  
  /**
   * This constructor takes the name of the animal as a parameter.
   * 
   * @param name
   *          - the name of the kangaroo.
   */
  public Animal(String name) {
    this.name = name;
  }
  
  /**
   * This is an empty constructor.
   */
  public Animal() {
    
  }
  
  /**
   * This method makes the sound the animal was defined as making
   * 
   * @return - The sound the animal makes (as a String).
   */
  public String makeNoise() {
    return sound;
  }
  
}
