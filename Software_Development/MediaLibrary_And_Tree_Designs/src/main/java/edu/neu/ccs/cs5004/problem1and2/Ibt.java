package edu.neu.ccs.cs5004.problem1and2;

/**
 * Integer binary tree.
 */
public interface Ibt {

  /**
   * creates empty IBT.
   * @return empty ibt
   */
  static Ibt createEmpty() {
    return new IbtEmpty();
  }

  /**
   * add value to ibt.
   * @param value to be added
   * @param <X> return type of ibt
   * @return x
   */
  <X extends Ibt> X add(Integer value);

  /**
   * check if ibt is empty.
   * @return boolean
   */
  Boolean isEmpty();

  /**
   * check if ibt contain value.
   * @param value to be checked
   * @return boolean
   */
  boolean contains(Integer value);

  /**
   * check if ibt is bst.
   * @return boolean
   */
  boolean isBst();

  /**
   * get the value of node.
   * @return value
   */
  Integer getValue();

  /**
   * get the left tree.
   * @param <X> type of tree
   * @return left tree
   */
  <X extends Ibt> X getLeft();

  /**
   * get the right tree.
   * @param <X> type of tree
   * @return right tree
   */
  <X extends Ibt> X getRight();

  /**
   * get the max number of the ibt.
   * @param acc current max number
   * @return max number inside ibt
   */
  Integer maxNumber(Integer acc);
}
