package edu.neu.ccs.cs5004.problem1and2.iterator;

import edu.neu.ccs.cs5004.problem1and2.Ibst;

import java.util.Iterator;
import java.util.Objects;

/**
 * abstract iterator.
 */
public abstract class AbstractIterator implements Iterator{
  protected Ibst ibst;

  public AbstractIterator(Ibst ibst) {
    this.ibst = ibst;
  }

  @Override
  public boolean hasNext() {
    return !ibst.isEmpty();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Don't even think about it!");
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractIterator that = (AbstractIterator) obj;
    return Objects.equals(ibst, that.ibst);
  }

  @Override
  public int hashCode() {

    return Objects.hash(ibst);
  }
}
