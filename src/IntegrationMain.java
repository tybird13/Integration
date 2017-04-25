
// A variable is a location in memory
// A Class is code!!
// Author: Tyler Dalbora
// last edited: 4/6/2017
// Purpose: JAVA Integration Project
//          A culmination of the entire course in a single project.
//          Exercises are inspired by www.HackerRank.com.
//          A Class is code!
//          HackerRank exercises are used in this code
//          All rights reserved

//boolean   -   true or false
//byte      -   8 bits; -128 to 127
//short     -   16 bits; -32768 to 32767
//int       -   32 bits; -2,147,483,648 to 2,147,483,647
//long      -   64 bits; -2^63 to 2^63-1
//float     -   32 bits; 32 bit IEEE 754 floating point
//double    -   64 bits; 64 bit IEEE 754 floating point
//char      -   16 bits; ['\u0000', '\uffff'] or [0, 65535]
//String    -   Class  ; Code to handle a string of chars

/*
 *      Relational Operators - tests or defines some kind of relation between two entities 
 *      
 *      ==      equal to
 *      !=      not equal to
 *      >       greater than
 *      >=      greater than or equal to
 *      <       less than
 *      <=      less than or equal to
 */

/*      Conditional Operators
 *      && Conditional-AND
 *      || Conditional-OR
 */

/**
 * This program is one of the capstone projects of the COP2006 Intro To Programming course at
 * Florida Gulf Coast University. This program was added to over the course of the semester.
 * 
 * @author Tyler Dalbora
 * @version 1.0
 * @see IntegrationHelperClass
 */
public class IntegrationMain {
  
  /**
   * This is the main method of this program.
   * 
   * @param args
   *          Command line arguments
   */
  public static void main(String[] args) {
    
    // Scanner is initialized in the HelperClass constructor
    // The helper class handles everything from prompting the user, to executing
    // major program functionality
    IntegrationHelperClass hc = new IntegrationHelperClass();
    
    String selection;
    
    /*
     * 'token' will be used throughout the program as a way to catch recurring input errors
     */
    
    boolean token = true;
    while (token) {
      // this is a call to the method that prompts the user
      selection = hc.promptUser();
      
      // Menu system for the user to choose a code module
      switch (selection) {
        
        case "A":
          hc.executeMealCostProgram();
          break;
        
        case "B":
          hc.executeStepProgram();
          break;
        
        case "C":
          hc.executeKangarooExercise();
          break;
        
        case "D":
          hc.executeTreeExample();
          break;
        
        case "E":
          hc.executeMathExampleProgram();
          break;
        
        case "F":
          hc.executeFactorialExample();
          break;
        
        case "G":
          hc.executeArrayExample();
          break;
        
        case "H":
          hc.executePalindrome();
          break;
        
        case "I":
          hc.executeMultidimensionalArray();
          break;
        
        case "J":
          hc.executePolymorphismExample();
          break;
          
        default:
          System.out.println("Invalid Entry! Please enter a letter between A and G.");
          break;
      }
      
      System.out.println("Enter 'Y' to continue, or any other key to exit.");
      token = hc.promptContinue();
    }
  }
}
