import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the helper class to the <strong>IntegrationMain</strong> class, which selectively
 * executes methods of this class based on user input in the {@link #promptUser() promptUser}
 * method. This class is a supplemental class to the <strong>IntegrationMain</strong> class.
 * 
 * @author Tyler Dalbora
 * @version 1.0
 * @see Solution
 * @see Kangaroo
 * @see IntegrationMain
 */
public class IntegrationHelperClass {
  /**
   * The {@link Scanner} with which this program takes integer and double input from the user.
   */
  private Scanner scan;
  
  /**
   * The {@link BufferedReader} with which this program takes string input from the user.
   */
  private BufferedReader brIn;
  // list of options to be presented to the user when "promptUser() is called
  
  /**
   * The string array that holds the options the user can choose from.
   */
  private String[] list = { "A: Meal Tip Calculator;", "B: Hashtag Step Program;",
      "C: Kangaroo Program", "D: Tree Example", "E: Math Example", "F: Factorial Example",
      "G: Array Example", "H: Palindrome", "I: Multi-Dimensional Array Search",
      "J: Polymorphism Example" };
  
  /**
   * Constructor for the helper class. Initializes the buffered reader, and the scanner.
   */
  public IntegrationHelperClass() {
    // System.out.println("Initializing Helper Class");
    scan = new Scanner(System.in);
    brIn = new BufferedReader(new InputStreamReader(System.in));
  }
  
  /**
   * This method prompts the user which of the modules they would like to execute. they are
   * presented with a list of items to choose from. If the user does not make an appropriate choice,
   * they are presented with an error and prompted to make a proper choice, or exit.
   * 
   * @return The character the user types in, converted to upper-case so as to match exactly the
   *         characters in the 'case' statements in {@link IntegrationMain}.
   */
  public String promptUser() { // this is a header
    String ans = ""; // variable to store the char the user inputs
    System.out.println("Please choose a module: \nex: A or B");
    for (int i = 0;i < list.length;i++) {
      System.out.println(list[i]);
    }
    
    try {
      ans = scan.next();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return ans.toUpperCase();
  }
  
  /**
   * <strong>Meal Cost Calculator:</strong> This method takes a hypothetical meal cost, the tax, and
   * the tip, and calculates the meal's total cost. This module demonstrates a proficiency in double
   * primitive manipulation using multiplication and addition.
   */
  public void executeMealCostProgram() {
    System.out.println("Meal Tip Calculator");
    System.out.println("Please enter mealCost, tipPercent, taxPercent. eg: \"10.00, .20, .06\""
        + "\nWithout the '$' or '%' signs.");
    
    boolean token = true;
    double mealCost = 0;
    double tipPercent = 0;
    double taxPercent = 0;
    while (token) {
      try {
        
        System.out.println("Please enter meal cost");
        mealCost = safeReadDouble();
        System.out.println("Please enter tip percent without symbols");
        tipPercent = safeReadDouble();
        System.out.println("Please enter tax percent without symbols");
        taxPercent = safeReadDouble();
        
        if (mealCost < 0 || tipPercent < 0 || taxPercent < 0) {
          throw new NumberFormatException();
        }
        
        token = false;
      } catch (NumberFormatException n) {
        System.err.println("Please enter only positive decimal numbers. eg: 1 or 1.0");
      } catch (ArrayIndexOutOfBoundsException a) {
        System.err.println("Please enter exactly 3 numbers seperated by commas.");
      }
    }
    // percentage
    // Total meal cost: (meal price) + (meal price * tax) + (meal price * tip
    // percent)
    double tip = mealCost * tipPercent;
    double tax = mealCost * taxPercent;
    double cost = (mealCost) + (tip) + (tax);
    System.out.printf("The total meal cost is $%.2f\nwith a tip of $%.2f, and a tax of $%.2f\n",
        cost, tip, tax);
  }
  
  /**
   * <strong>Hashtag Step Creator</strong>: This method takes an integer and outputs a hashtag (#)
   * in increasing step form until the desired number is reached at the base of the steps. This
   * module demonstrates a proficiency with string manipulation, as well as use of supplemental
   * methods.
   * 
   * @see #printHashTags(int, int)
   */
  public void executeStepProgram() {
    System.out.println(
        "Step Program: This program prints out a number of " + "hashtags (#) in a step pattern!");
    System.out.println("Enter number of hashtags you want the base to be:");
    boolean token = true;
    int base = 0;
    while (token) {
      try {
        base = this.safeReadInt();
        if (base < 0) {
          throw new NumberFormatException();
        }
        token = false;
      } catch (NumberFormatException e) {
        System.err.println("Please enter a positive integer. eg: 1 or 2");
      }
    }
    
    for (int i = 1;i <= base;i++) {
      this.printHashTags((base - i), i);
    }
    
  }
  
  /**
   * This supplemental method assists the {@link #executeStepProgram() Step Program} in printing out
   * the desired hashtag step form. This method prints out hashtags in a special format one line per
   * call.
   * 
   * @param spaces
   *          - the number of spaces desired for this line of hashtags in the overall step form.
   * @param hashtags
   *          - the number of hashtags desired for this line of the hashtags in the step form.
   * @see #executeStepProgram
   */
  // helper method to print out hashtags
  private void printHashTags(int spaces, int hashtags) {
    for (int i = 0;i < spaces;i++) {
      System.out.print(" ");
    }
    
    for (int i = 0;i < hashtags;i++) {
      System.out.print("#");
    }
    System.out.print("\n");
  }
  
  /**
   * <strong>Kangaroo Race Simulator</strong>: This method simulates a race between two kangaroos.
   * The goal of this module is to see if the two kangaroos ever land on the same spot during the
   * race. This module implements a supplimental class, {@link Kangaroo}. This supplemental class is
   * instantiated twice, and the two kangaroos {@link Kangaroo#hop() hop} until the race is
   * finished, or they land at the same spot. This module demonstrates a proficiency in the use of
   * supplemental classes, integer math, and string manipulation
   * 
   * @see Kangaroo
   */
  public void executeKangarooExercise() {
    System.out.println("Kangaroo Program: ");
    System.out.println(
        "This program simulates race between 2 kangaroos! Do they ever land on the same spot?");
    System.out.println("Lets create the first kangaroo! what would you like to name him?");
    
    Kangaroo k1 = new Kangaroo();
    Kangaroo k2 = new Kangaroo();
    
    boolean token = true;
    while (token) {
      try {
        String name = brIn.readLine();
        System.out.println("Where will " + name + " start? Enter a positive integer:");
        int x = safeReadInt();
        System.out.println("How far will " + name + " be able to jump? Enter a positive integer");
        int v = safeReadInt();
        k1.setHopLength(v);
        k1.setName(name);
        k1.setStartingPoint(x);
        
        token = false;
      } catch (NumberFormatException e) {
        System.err.println("Please enter a positive integer. ");
      } catch (IOException e) {
        System.err.println("Please enter a name");
      }
    }
    
    token = true;
    while (token) {
      try {
        System.out.println("Lets create a second kangaroo!");
        System.out.println("What will its name be?");
        String name = brIn.readLine();
        System.out.println("Where will " + name + " start? Enter a positive integer:");
        int x = safeReadInt();
        System.out.println("How far will " + name + " be able to jump? Enter a positive integer");
        int v = safeReadInt();
        k2.setHopLength(v);
        k2.setName(name);
        k2.setStartingPoint(x);
        token = false;
      } catch (NumberFormatException e) {
        System.err.println("Please enter a positive integer. ");
      } catch (IOException e) {
        System.err.println("Please enter a name");
      }
    }
    
    // have the kangaroos race each other
    
    for (int i = 0;i < 10000;i++) {
      if (k1.getPosition() == k2.getPosition()) {
        System.out.printf("both %s and %s landed on space %d!\n", k1.getName(), k2.getName(),
            k1.getPosition());
        return;
        
      } else if (i < 10000 - 1) {
        k1.hop();
        k2.hop();
      } else {
        System.out.printf("%s and %s never land on the same space.\n", k1.getName(), k2.getName());
      }
    }
    
  }
  
  /**
   * <strong>Tree Growth Observation</strong>: This method simulates the growth of a specified
   * number of trees over a specified number of 'cycles' for each tree. The output of this module is
   * a chart with the specified tree, and the height it grew in meters after the specified number of
   * cycles. This module demonstrates a proficiency in integer math, array manipulation, and string
   * manipulation.
   */
  public void executeTreeExample() {
    System.out.println("Tree Growth Observation: watch trees grow...");
    System.out.println("You will enter the number of trees to watch,"
        + " and then you will enter the length for which to watch each tree");
    System.out.println("START!");
    
    boolean token = true;
    int numberOfTestCases = 0;
    int tmp = 0;
    ArrayList<Integer> listOfTrees = new ArrayList<Integer>();
    
    while (token) {
      try {
        System.out.println("Please enter the number of trees to observe:");
        numberOfTestCases = safeReadInt();
        
        if (numberOfTestCases < 0) {
          throw new NumberFormatException();
        }
        token = false;
      } catch (NumberFormatException e) {
        System.err.println("Please enter a positive integer.");
      }
    }
    for (int i = 0;i < numberOfTestCases;i++) {
      int num = i + 1;
      token = true;
      while (token) {
        try {
          
          System.out.println("please enter the number of cycles to observe " + "tree " + num);
          tmp = safeReadInt();
          
          if (tmp < 0) {
            throw new NumberFormatException();
          }
          
          listOfTrees.add(tmp);
          
          token = false;
        } catch (NumberFormatException e) {
          System.err.println("Please enter only positive integers. eg: 1 or 2");
        }
      }
    }
    
    // cycle through each plant
    for (int i = 0;i < listOfTrees.size();i++) {
      // grow the plant
      int cycles = listOfTrees.get(i);
      int currentCycle = 0;
      int treeHeight = 1; // initial height of the tree (meter)
      while (currentCycle < cycles) {
        
        if (currentCycle % 2 == 0) {
          // spring
          // System.out.println("Spring: ");
          treeHeight *= 2;
        } else {
          // summer
          // System.out.println("Summer: ");
          treeHeight++;
        }
        currentCycle++;
      }
      System.out.printf("Tree %d is %d meters tall after %d Cycles\n", i + 1, treeHeight, cycles);
    }
  }
  
  /**
   * <strong>Math Example</strong>: This method provides an example of arithmetic interaction
   * between the int and double primitive types. The user is prompted for a integer and a floating
   * point decimal and this method attempts to demonstrate integer - integer addition, and integer -
   * double addition. This module also demonstrates array operations with doubles by converting the
   * integers entered by the user in to doubles, and storing all three double in an array. The
   * program then iterates over the array and returns the smallest value found in the array. This
   * module demonstrates a proficiency in array creation and manipulation, and data type casting.
   * 
   * @see #executeArrayExample
   */
  public void executeMathExampleProgram() {
    System.out
        .println("Math Example: experiment with integer/double addition\nand array operations");
    
    System.out.println("Please enter an integer");
    int one = safeReadInt();
    
    System.out.println("Please enter another integer");
    int two = safeReadInt();
    
    System.out.println("Please enter a double");
    double three = safeReadDouble();
    
    System.out.println(one + ", " + two + ", " + three);
    System.out.println("Integer addition: " + one + " + " + two);
    int addInt = one + two;
    System.out.println("equals: " + addInt + "\n");
    System.out.println("Integer + Double: " + one + " + " + three);
    double addDouble = one + three;
    System.out.println("Java forces you to store it as a double: " + addDouble + "\n");
    
    // array operations
    System.out.println("Array Operations:");
    // added cast to integers
    double[] arrayOfDoubles = { (double) one, (double) two, three };
    System.out.println("Finding the smallest number in the numbers you entered!\n");
    
    // for every element, compare it to the others
    double index = arrayOfDoubles[0];
    for (int j = 0;j < arrayOfDoubles.length;j++) {
      if (arrayOfDoubles[j] < index) {
        index = arrayOfDoubles[j];
      }
    }
    System.out.println("The lowest number of the numbers you entered was: " + index);
  }
  
  /**
   * <strong>Array Example</strong>: This method is an example of array creation and manipulation.
   * This method prompts the user to enter intergers until the user wishes to stop. It then sums the
   * integers in the array and displays that sum to the user. This method then requests the user
   * search for an integer that may or may not be found in the array. It then iterates over the
   * array until it finds the desired number and alerts the user that it found the number, and
   * outputs its index location, or it reaches the end of the array, at which point it alerts the
   * user that the number is not in the array. This module demonstrates a proficiency in ArrayList
   * creation and manipulation, as well as array iteration.
   * 
   * @see #executeMathExampleProgram
   */
  public void executeArrayExample() {
    System.out.println("Integer Array Example: array manipulation");
    // System.out.println("Please enter integers to be added to the
    // array:\n\n");
    
    boolean token = true;
    ArrayList<Integer> intArray = new ArrayList<Integer>();
    
    while (token) {
      
      if (intArray.isEmpty()) {
        System.out.println("Please enter the first integer to add to the array:");
        intArray.add(safeReadInt());
      } else {
        System.out
            .println("Would you like to add more integers? Y for yes, or any other key for no:");
        token = scan.next().equalsIgnoreCase("y") ? true : false;
        if (token) {
          System.out.println("Please enter an integer: ");
          intArray.add(safeReadInt());
        } else {
          System.out.println("Array Complete!");
        }
      }
    }
    
    int sum = 0;
    for (int i = 0;i < intArray.size();i++) {
      sum += intArray.get(i);
    }
    System.out
        .println("The sum of the elements in the array " + intArray.toString() + " is: " + sum);
    
    System.out.println("Time to search for a number in the array you created!\n");
    
    System.out.println("please enter a number to search for in your array:");
    int searchTerm = safeReadInt();
    
    for (int i = 0;i < intArray.size();i++) {
      if (intArray.get(i) == searchTerm) {
        System.out.println("The number " + searchTerm + " was found in the array at index: " + i);
        return;
      }
    }
    System.out.println("The number was not in the array.");
    
  }
  
  /**
   * <strong>Factorial Example</strong>: This method recursively calculates the factorial of an
   * integer input by the user. This method determines whether the number is negative, and if it is,
   * prompts the user to enter a positive integer. if, in the course of calculating the factorial,
   * the stack overflows, the program prompts the user that the machine does not have the capacity
   * to calculate the given factorial, and to please enter a smaller integer value. the stack is
   * then cleared, and the factorial of the new, smaller number is calculated. This method makes use
   * of a supplemental method that it calls recursively. The int primitive data type is used in the
   * factorial calculation, so the program determines whether the 32bit signed int limit of 2^31 is
   * reached, and prompts the user accordingly. This module demonstrates a proficiency with
   * recursion, as well as error handling and manual garbage collection.
   * 
   * @see #factorial
   */
  public void executeFactorialExample() {
    System.out.println("Factorial Example: calculate the factorial of a number!");
    System.out.println("Enter the integer you would like to calculate the factorial of");
    boolean token = true;
    while (token) {
      try {
        long num = safeReadInt();
        if (num <= 0) {
          throw new NumberFormatException();
        }
        long f = factorial(num);
        
        // check to see if a stack overflow has occurred, or if the 32bit
        // unsigned integer limit has been reached
        // if the limit has been reached, the value will come back negative.
        if (f != 0 && f > 0) {
          System.out.println("Factorial calculated: " + num + "!" + " = " + f);
        } else {
          throw new ArrayIndexOutOfBoundsException();
        }
        
        token = false;
      } catch (NumberFormatException e) {
        System.err.println("Please enter a positive integer");
      } catch (ArrayIndexOutOfBoundsException a) {
        System.err.println("Please enter a smaller integer...this isn't a supercomputer....");
        System.gc();
      } catch (StackOverflowError e) {
        System.err.println("Please enter a smaller integer...this isn't a supercomputer....");
        System.gc();
      }
    }
  }
  
  /**
   * This supplemental method assists the {@link #executeFactorialExample() Factorial Example} in
   * calculating the factorial of a given integer. This method calculates the factorial of an
   * integer recursively.
   * 
   * @param num
   *          - the number for which to calculate the factorial.
   * @return - the factorial of the specified number.
   * @throws StackOverflowError
   *           This method throws an error if the stack overflows.
   */
  private long factorial(long num) throws StackOverflowError {
    
    if (num != 2) {
      return num * factorial(num - 1);
    } else {
      return 2;
    }
    
  }
  
  /**
   * <strong>Multi-Dimensional Array Example</strong>: This method is an example of 2D array
   * creation and manipulation. This method creates a 20 x 20 array of random values between 0 and
   * 100, and prompts the user to search for a value suspected to be contained in the array. It then
   * iterates over the entire array and If the value is found, outputs the value and the value's
   * location to the screen. If the value is not found, it outputs that the value was not contained
   * in the array. This module demonstrates a proficiency in 2D array creation and manipulation.
   */
  public void executeMultidimensionalArray() {
    
    int[][] arr = new int[20][20];
    for (int i = 0;i < arr.length;i++) {
      for (int j = 0;j < arr[0].length;j++) {
        arr[i][j] = (int) Math.ceil(Math.random() * 100);
      }
    }
    System.out.println("Integer Array Example: search for an integer in a 2D array!");
    System.out.println("Please enter a positive integer to search for.");
    boolean token = true;
    int search = 0;
    while (token) {
      try {
        search = safeReadInt();
        
        if (search < 0) {
          throw new NumberFormatException();
        }
        token = false;
      } catch (NumberFormatException e) {
        System.err.println("Search integer must be positive...");
      }
    }
    int x = 0;
    int y = 0;
    boolean found = false;
    for (int i = 0;i < arr.length;i++) {
      for (int j = 0;j < arr[0].length;j++) {
        System.out.printf(" %03d ", arr[i][j]);
        if (arr[i][j] == search) {
          found = true;
          x = i + 1;
          y = j + 1;
        }
      }
      System.out.println();
    }
    if (found) {
      System.out.println("The number " + search + " was found in the array at " + x + ", " + y);
    } else {
      System.out.println("The number " + search + " was not found in the array.");
    }
    
  }
  
  /**
   * <strong>Palindrome Example</strong>: This method determines whether a given word is a
   * palindrome (a word that is spelled the same both forwards and backwards) or not. The user
   * supplies a word, and this method outputs whether the word is a palindrome. This module
   * implements a supplemental class called {@link Solution}. Solution is responsible for the
   * creation and manipulation of both the Stack and the Queue. This module demonstrates a
   * proficiency in the use of supplemental Classes, and Stacks and Queues, and the comparison of
   * the two.
   * 
   * @see Solution
   */
  public void executePalindrome() {
    System.out.println("Palindrome Example: is your word spelled the same forwards");
    System.out.println("as it is backwards?");
    System.out.println("Please enter a word");
    // Convert input String to an array of characters:
    String input = "";
    boolean token = true;
    while (token) {
      try {
        input = brIn.readLine();
        
        if (input.length() < 3) {
          throw new IOException();
        }
        // this should throw an error, which means that input IS a string.
        Double.parseDouble(input);
        
        // this should only ever be executed if the user enters a string of
        // numbers.
        System.err.println("Please enter a word with 3 or more letters.");
      } catch (IOException e) {
        System.err.println("Please enter a word with 3 or more letters.");
      } catch (NumberFormatException e) {
        token = false; // input is a string, move on.
      }
    }
    char[] s;
    if (input != null) {
      s = input.toCharArray();
    } else {
      s = new char[1]; // this line will never execute due to the validation
    } // above.
    
    // Create a Solution object:
    Solution p = new Solution();
    
    // Enqueue/Push all chars to their respective data structures:
    for (char c : s) {
      p.pushCharacter(c);
      p.enqueueCharacter(c);
    }
    
    // Pop/Dequeue the chars at the head of both data structures and compare
    // them:
    boolean isPalindrome = true;
    for (int i = 0;i < s.length / 2;i++) {
      if (p.popCharacter() != p.dequeueCharacter()) {
        isPalindrome = false;
        break;
      }
    }
    
    // Finally, print whether string s is palindrome or not.
    System.out.println(
        "The word, " + input + ", is " + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
  }
  
  /**
   * This method creates an animal object that makes noise. This module exemplifies the use of
   * polymorphism and Inheritance.
   * 
   * @see Kangaroo
   * @see #executeKangarooExercise
   */
  public void executePolymorphismExample() {
    // This method recycles the Kangaroo class for the purpose of making animal sounds!
    System.out.println(
        "You have a new pet kangaroo!! Do you want to name him? Of course you do! Silly question!");
    System.out.println("What is your new pet kangaroo's name?");
    boolean token = true;
    String name = "";
    while (token) {
      try {
        name = brIn.readLine();
        
        Double.parseDouble(name); // this code should throw an error...
        // this code should never run...
        System.err.println("Please dont give him a name with numbers in it, that's mean...");
        
      } catch (IOException e) {
        System.err.println("Whoops, something went wrong!");
        
      } catch (NumberFormatException e) {
        token = false; // this code will execute if the user does not enter numbers for the name.
      }
    }
    
    Kangaroo james = new Kangaroo("AAGGHHHHH!!!!", name);
    System.out.println("Your new baby kangaroo's name is " + name);
    System.out.println("He says: ");
    System.out.println(james.makeNoise()); // Kangaroo doesn't implement this method, it inherits it
                                           // from the super class, Animal.
    
  }
  
  /**
   * This method is designed to safely read an integer value from the scanner. This method handles
   * all of the validation involved with reading a specific data type from the user.
   * 
   * @return - a validated integer value to the calling method.
   * @see #safeReadDouble
   */
  private int safeReadInt() {
    while (true) {
      try {
        int ans = scan.nextInt();
        return ans;
      } catch (Exception n) {
        System.err.println("Please Enter An Integer");
        scan.nextLine(); // clear the line
      }
      
    }
  }
  
  /**
   * This method is designed to safely read a double value from the scanner. This method handles all
   * of the validation involved with reading a specific data type from the user.
   * 
   * @return - a validated double value to the calling method.
   * @see #safeReadInt
   */
  private double safeReadDouble() {
    while (true) {
      try {
        double ans = scan.nextDouble();
        return ans;
      } catch (Exception n) {
        System.err.println("Please Enter A Decimal Number. eg: 1 or 1.0");
        scan.nextLine(); // clear the line
      }
      
    }
  }
  
  /**
   * This method prompts the user whether they would like to continue running the program, or exit.
   * 
   * @return - a boolean value. True to continue, and false to exit.
   */
  public boolean promptContinue() {
    String ans = scan.next();
    if (ans.equalsIgnoreCase("y")) {
      return true;
    } else {
      System.out.println("Goodbye!");
      scan.close();
      return false;
    }
  }
  
}
