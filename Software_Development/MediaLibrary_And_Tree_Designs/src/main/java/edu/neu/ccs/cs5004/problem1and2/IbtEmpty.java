package edu.neu.ccs.cs5004.problem1and2;

/**
 * empty ibt.
 */
public class IbtEmpty implements Ibt {
  /**
   * constructor for empty ibt.
   */
  public IbtEmpty() {
  }

  @Override
  public Integer getValue() {
    return null;
  }

  @Override
  public Ibt getLeft() {
    return null;
  }

  @Override
  public Ibt getRight() {
    return null;
  }

  @Override
  public Ibt add(Integer value) {
    return new IbtNode(value, new IbtEmpty(), new IbtEmpty());
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public boolean contains(Integer val) {
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
  public String toString() {
    return "IbtEmpty{}";
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
