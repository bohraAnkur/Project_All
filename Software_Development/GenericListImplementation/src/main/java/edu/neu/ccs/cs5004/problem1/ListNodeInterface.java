package edu.neu.ccs.cs5004.problem1;

/**
 * Represents a node in a linked list.
 *
 * @param <X> the object type
 */
public interface ListNodeInterface<X> {

  /**
   * Getter for the element .
   *
   * @return the element
   */
  X getElement();

  /**
   * Getter for the next node.
   *
   * @return the next node
   */
  ListNode getNext();

  /**
   * Setter for the element.
   *
   * @param newElement the element
   */
  void setElement(X newElement);

  /**
   * Setter for the next node.
   *
   * @param nextNode the node
   */
  void setNext(ListNode nextNode);
}
