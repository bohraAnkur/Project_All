package edu.neu.ccs.cs5004.assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/**
 * random order iterator.
 */
public class RandomOrderIterator implements Iterator<Id> {
  protected Stack<Id> stack;

  /**
   * construct random order iterator.
   * @param list to be iterated
   */
  public RandomOrderIterator(ArrayList<Id> list) {
    this.stack = new Stack<>();
    Collections.shuffle(list);
    stack.addAll(list);
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public Id next() {
    return stack.pop();
  }

  @Override
  public void remove() {
    throw new InvalidInputException("function not supported");
  }
}
