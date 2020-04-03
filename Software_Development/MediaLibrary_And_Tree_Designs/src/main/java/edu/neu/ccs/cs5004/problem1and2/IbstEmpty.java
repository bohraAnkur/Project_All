package edu.neu.ccs.cs5004.problem1and2;

import edu.neu.ccs.cs5004.problem1and2.iterator.IbstInOrderIterator;
import edu.neu.ccs.cs5004.problem1and2.iterator.IbstPostOrderIterator;
import edu.neu.ccs.cs5004.problem1and2.iterator.IbstPreOrderIterator;

import java.util.Iterator;

/**
 * ibst empty.
 */
public class IbstEmpty implements Ibst {
  /**
   * constructor for ibst empty.
   */
  public IbstEmpty() {
  }

  @Override
  public Ibst deleteNode(Integer value) {
    return this;
  }

  @Override
  public Ibst add(Ibst ibst) {
    return ibst;
  }

  @Override
  public Ibst add(Integer value) {
    return new IbstNode(value, new IbstEmpty(), new IbstEmpty());
  }

  @Override
  public Ibt mirror() {
    return this;
  }

  @Override
  public Iterator preOrderIterator() {
    return new IbstPreOrderIterator(this);
  }

  @Override
  public Iterator postOrderIterator() {
    return new IbstPostOrderIterator(this);
  }

  @Override
  public Iterator inOrderIterator() {
    return new IbstInOrderIterator(this);
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public boolean contains(Integer value) {
    return false;
  }

  @Override
  public boolean isBst() {
    return true;
  }

  @Override
  public Integer maxNumber(Integer acc) {
    return acc;
  }

  @Override
  public Integer getValue() {
    return null;
  }

  @Override
  public <X extends Ibt> X getLeft() {
    return null;
  }

  @Override
  public <X extends Ibt> X getRight() {
    return null;
  }

  @Override
  public Integer postOrderNext() {
    return null;
  }

  @Override
  public Integer inOrderNext() {
    return null;
  }

  @Override
  public String toString() {
    return "IbstEmpty{}";
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }
}
