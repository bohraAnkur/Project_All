package edu.neu.ccs.cs5004.problem1and2.iterator;

import edu.neu.ccs.cs5004.problem1and2.Ibst;

/**
 * in order iterator.
 */
public class IbstInOrderIterator extends AbstractIterator {
  public IbstInOrderIterator(Ibst ibst) {
    super(ibst);
  }

  @Override
  public Object next() {
    Integer result = ibst.inOrderNext();
    ibst = ibst.deleteNode(result);
    return result;
  }
}
