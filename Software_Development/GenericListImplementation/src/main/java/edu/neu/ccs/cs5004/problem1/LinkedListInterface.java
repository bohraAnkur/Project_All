package edu.neu.ccs.cs5004.problem1;

/**
 * Represents a linked list.
 */
public interface LinkedListInterface<X> {

  /**
   * Adds an element to the front of the linked list.
   *
   * @param element the element to be added
   */
  void add(X element);

  /**
   * Adds an element at a specified index to a linked list.
   *
   * @param index   the index where the element will be added
   * @param element the element to be added
   */
  void add(int index, X element);

  /**
   * Gets the element at a specified index.
   *
   * @param index the index where the element resides
   * @return the element at the index
   */
  X get(int index);

  /**
   * Retrieves the index of a specified element.
   *
   * @param element the element that is being inquired about
   * @return the element's index
   */
  int indexOf(X element);

  /**
   * Asks if the linked list is empty.
   *
   * @return true if the list is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Removes the node at the specified index.
   *
   * @param index the index of the node
   */
  void remove(int index);

  /**
   * Gets the size of the list.
   *
   * @return the size of the list
   */
  int size();

  /**
   * Checks if a specified element is in the linked list.
   *
   * @param element the element that is being searched for
   * @return true if the element is in the list, false otherwise
   */
  boolean contains(X element);
}
