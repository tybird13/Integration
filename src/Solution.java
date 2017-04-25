import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This supplemental class is intended to assist {@link IntegrationHelperClass} with the
 * manipulation of Stacks and Queues, specifically for the
 * {@link IntegrationHelperClass#executePalindrome() Palindrome} Example.
 * 
 * @author Tyler Dalbora
 * @version 1.0
 */
public class Solution {
  Queue<Character> myQueue;
  Stack<Character> myStack;
  
  /**
   * The constructor for the Solution class. This method instantiates the Stack, and the Queue.
   */
  public Solution() {
    myQueue = new LinkedList<Character>();
    myStack = new Stack<Character>();
  }
  
  /**
   * This method pushes a character onto the Stack.
   * 
   * @param c
   *          - the character to be pushed to the Stack
   * @see Stack#push()
   */
  public void pushCharacter(char c) {
    myStack.push(c);
  }
  
  /**
   * This method offers a character into the Queue.
   * 
   * @param c
   *          - the character to be offered to the queue.
   * @see Queue#offer()
   */
  public void enqueueCharacter(char c) {
    myQueue.offer(c);
  }
  
  /**
   * This method pops a character from the Stack.
   * 
   * @return - a character from the stack.
   * @see Stack#pop()
   */
  public char popCharacter() {
    return myStack.pop();
  }
  
  /**
   * This method polls a character from the Queue.
   * 
   * @return - a character from the Queue
   * @see Queue#poll()
   */
  public char dequeueCharacter() {
    return myQueue.poll();
  }
}
