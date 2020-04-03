package edu.neu.ccs.cs5004.problem1and2;

import edu.neu.ccs.cs5004.problem1and2.iterator.IbstInOrderIterator;
import edu.neu.ccs.cs5004.problem1and2.iterator.IbstPostOrderIterator;
import edu.neu.ccs.cs5004.problem1and2.iterator.IbstPreOrderIterator;

import java.util.Iterator;
import java.util.Objects;

/**
 * ibst node.
 */
public class IbstNode implements Ibst {
  private Integer value;
  private Ibst left;
  private Ibst right;

  /**
   * constructor for ibst noce.
   * @param value of node
   * @param left tree
   * @param right tree
   */
  public IbstNode(Integer value, Ibst left, Ibst right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  @Override
  public Boolean isEmpty() {
    return false;
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
  public Integer getValue() {
    return value;
  }

  @Override
  public Ibst getLeft() {
    return left;
  }

  @Override
  public Ibst getRight() {
    return right;
  }

  @Override
  public Ibst add(Integer val) {
    if (this.contains(val)) {
      return this;
    }
    if (val > value) {
      return new IbstNode(value, left, right.add(val));
    }
    return new IbstNode(value, left.add(val), right);
  }

  @Override
  public Ibst add(Ibst ibst) {
    if (ibst.getValue() == null) {
      return this;
    }
    if (ibst.getValue() > value) {
      return new IbstNode(value, left, right.add(ibst));
    }
    return new IbstNode(value, left.add(ibst), right);
  }

  @Override
  public Ibst deleteNode(Integer val) {
    if (this.contains(val)) {
      if (val.equals(value)) {
        return right.add(left);
      }
      return new IbstNode(value, left.deleteNode(val), right.deleteNode(val));
    }
    return this;
  }

  @Override
  public Ibt mirror() {
    return new IbtNode(value, right.mirror(), left.mirror());
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
  public Integer postOrderNext() {
    if (!left.isEmpty()) {
      return left.postOrderNext();
    } else if (!right.isEmpty()) {
      return right.postOrderNext();
    }
    return value;
  }

  @Override
  public Integer inOrderNext() {
    if (!left.isEmpty()) {
      return left.inOrderNext();
    }
    return value;
  }

  @Override
  public String toString() {
    return "IbstNode{"
        + "value=" + value
        + ", left=" + left
        + ", right=" + right
        + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    IbstNode ibstNode = (IbstNode) obj;
    return Objects.equals(getValue(), ibstNode.getValue())
        && Objects.equals(getLeft(), ibstNode.getLeft())
        && Objects.equals(getRight(), ibstNode.getRight());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getValue(), getLeft(), getRight());
  }
}
