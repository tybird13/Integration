/**
 * This class implements a kangaroo that starts at a starting point, and hops a number of times,
 * over the length specified in {@link #hopLength} . This class is meant to compare two kangaroos to
 * see if they ever land at the same end point, given that they start at two different places, and
 * they jump over two different distances. This class extends {@link Animal}, which has a name, and
 * makes a sound! This class exemplifies polymorphism and inheritance!
 *
 * @author Tyler Dalbora
 * @version 1.0
 * @see #Kangaroo(String, int, int)
 * @see Animal
 * @Edited 4/15/2017
 */
public class Kangaroo extends Animal {
  
  // The kangaroo will inherit the field of 'name' through inheritance
  /**
   * The distance over which the kangaroo travels in one hop.
   */
  private int hopLength;
  /**
   * The current location of the kangaroo. {@link #Kangaroo(String, int, int) Kangaroo} Constructor
   * instantiates this as the starting point.
   */
  private int currentLocation;
  
  /**
   * Constructs a kangaroo with a name, a non-negative starting point, and a non-negative hop
   * length.
   *
   * @param n
   *          The {@link #name} of the kangaroo (string)
   * @param h
   *          The {@link #hopLength} of the kengaroo. A non-negative integer
   * @param s
   *          The starting point of the kangaroo. A non-negative integer x value that gets assigned
   *          to {@link #currentLocation}.
   * @throws NumberFormatException
   *           if the starting point, or the hop length is negative
   * @see #currentLocation
   * @see #hopLength
   */
  public Kangaroo(String n, int h, int s) {
    super(n);
    if (h > 0 && s >= 0) {
      this.hopLength = h;
      this.currentLocation = s;
    } else {
      throw new NumberFormatException();
    }
    System.out.println(name + " says hello!");
  }
  
  /**
   * Constructor without assignment parameters. Fields {@link #name}, {@link #hopLength}, and
   * {@link #currentLocation} will have to be set manually.
   *
   * @see #Kangaroo(String, int, int)
   * @see #setHopLength(int)
   * @see #setStartingPoint(int)
   * @see #setName(String)
   */
  public Kangaroo() {
    super();
  }
  
  /**
   * This constructor accepts the name of the Kangaroo as a parameter, and passes it to the Parent
   * constructor (Animal).
   * 
   * @param name
   *          - the name of the Kangaroo.
   * @param noise
   *          - the noise the kangaroo makes.
   */
  public Kangaroo(String name, String noise) {
    super(name, noise);
  }
  
  /**
   * Sets the name of the Kangaroo.
   *
   * @param n
   *          - Name of the kangaroo
   * @see #Kangaroo(String, int, int)
   */
  public void setName(String n) {
    this.name = n;
  }
  
  /**
   * Sets the distance over which the kangaroo can hop.
   *
   * @param x
   *          - Positive integer distance over which the kangaroo can hop.
   * @throws NumberFormatException
   *           If x is negative
   */
  public void setHopLength(int x) throws NumberFormatException {
    if (x < 0) {
      throw new NumberFormatException();
    }
    
    hopLength = x;
  }
  
  /**
   * Sets the starting point of the kangaroo.
   *
   * @param s
   *          - Positive integer starting location of the kangaroo
   * @throws NumberFormatException
   *           If s is negative
   */
  public void setStartingPoint(int s) throws NumberFormatException {
    if (s < 0) {
      throw new NumberFormatException();
    }
    
    currentLocation = s;
  }
  
  /**
   * 'Hops' the kangaroo . Advances {@link #currentLocation} of the kangaroo in increments of
   * {@link #hopLength}
   */
  public void hop() {
    currentLocation = currentLocation + hopLength;
  }
  
  /**
   * Returns the current location of the kangaroo.
   *
   * @return {@link #currentLocation} - The current location of the kangaroo in the positive x
   *         direction
   */
  public int getPosition() {
    return currentLocation;
  }
  
  /**
   * Returns the name of the kangaroo that was assigned on creation.
   *
   * @see #Kangaroo(String, int, int)
   * @return name - The name of the kangaroo
   */
  public String getName() {
    return name;
  }
  
}
