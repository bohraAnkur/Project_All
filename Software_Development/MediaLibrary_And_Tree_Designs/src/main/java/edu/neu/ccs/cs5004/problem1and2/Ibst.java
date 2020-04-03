package edu.neu.ccs.cs5004.problem1and2;

import java.util.Iterator;

/**
 * Integer binary search tree.
 */
public interface Ibst extends Ibt {

  /**
   * creates empty ibst.
   * @return empty ibst
   */
  static Ibst createEmpty() {
    return new IbstEmpty();
  }

  /**
   * delete a node in ibst.
   * @param value to be deleted
   * @return ibst
   */
  Ibst deleteNode(Integer value);

  /**
   * add an ibst to ibst.
   * @param ibst to be added
   * @return ibst
   */
  Ibst add(Ibst ibst);

  /**
   * add a value to ibst.
   * @param val to be added
   * @return ibst
   */
  @Override
  Ibst add(Integer val);

  /**
   * creates mirror of ibst.
   * @return ibt
   */
  Ibt mirror();

  /**
   * get the preorder iterator.
   * @return preorder iterator
   */
  Iterator preOrderIterator();

  /**
   * get the postorder iterator.
   * @return postorder iterator
   */
  Iterator postOrderIterator();

  /**
   * get the inorder iterator.
   * @return inorder iterator
   */
  Iterator inOrderIterator();

  /**
   * finds the next post order integer.
   * @return integer
   */
  Integer postOrderNext();

  /**
   * finds the next in order integer.
   * @return integer
   */
  Integer inOrderNext();
}
