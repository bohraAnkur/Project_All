package edu.neu.ccs.cs5004.problem1and2.iterator;

import edu.neu.ccs.cs5004.problem1and2.Ibst;

/**
 * post order iterator.
 */
public class IbstPostOrderIterator extends AbstractIterator {
  public IbstPostOrderIterator(Ibst ibst) {
    super(ibst);
  }

  @Override
  public Object next() {
    Integer result = ibst.postOrderNext();
    ibst = ibst.deleteNode(result);
    return result;
  }
}
