package edu.neu.ccs.cs5004.problem1and2.iterator;

import edu.neu.ccs.cs5004.problem1and2.Ibst;

/**
 * pre order iterator.
 */
public class IbstPreOrderIterator extends AbstractIterator {
  public IbstPreOrderIterator(Ibst ibst) {
    super(ibst);
  }

  @Override
  public Object next() {
    Integer result = ibst.getValue();
    ibst = ibst.<Ibst>getLeft().add(ibst.<Ibst>getRight());
    return result;
  }
}
