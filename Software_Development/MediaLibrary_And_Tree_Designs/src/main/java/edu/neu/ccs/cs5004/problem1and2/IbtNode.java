package edu.neu.ccs.cs5004.problem1and2;

import java.util.Objects;

/**
 * ibt node.
 */
public class IbtNode implements Ibt {

  private Integer value;
  private Ibt left;
  private Ibt right;

  /**
   * constructor for ibt node.
   * @param value of node
   * @param left tree
   * @param right tree
   */
  public IbtNode(Integer value, Ibt left, Ibt right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public Integer getValue() {
    return value;
  }

  public Ibt getLeft() {
    return left;
  }

  public Ibt getRight() {
    return right;
  }

  @Override
  public boolean contains(Integer val) {
    if (value.equals(val)) {
      return true;
    }
    return left.contains(val) || right.contains(val);
  }

  @Override
  public boolean isBst() {
    Integer leftMax = this.left.maxNumber(value);
    Integer rightMax = this.right.maxNumber(value);
    if (value < leftMax
        || value > rightMax) {
      return false;
    }

    return left.isBst() && right.isBst();
  }

  @Override
  public Integer maxNumber(Integer acc) {
    acc = value > acc ? value : acc;
    acc = left.maxNumber(acc) > right.maxNumber(acc) ? left.maxNumber(acc) : right.maxNumber(acc);
    return acc;
  }

  @Override
  public Ibt add(Integer value) {
    if (this.contains(value)) {
      return this;
    }
    return new IbtNode(value, this, new IbtEmpty());
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    IbtNode that = (IbtNode) obj;
    return Objects.equals(getValue(), that.getValue())
        && Objects.equals(getLeft(), that.getLeft())
        && Objects.equals(getRight(), that.getRight());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getValue(), getLeft(), getRight());
  }

  @Override
  public String toString() {
    return "IbtNode{"
        + "value=" + value
        + ", left=" + left
        + ", right=" + right
        + '}';
  }
}
