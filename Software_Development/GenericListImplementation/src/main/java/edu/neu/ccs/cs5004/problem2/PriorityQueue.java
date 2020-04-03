package edu.neu.ccs.cs5004.problem2;

import edu.neu.ccs.cs5004.problem1.LinkedList;

/**
 * priority queue of element of type x.
 *
 * @param <X> element type
 */
public interface PriorityQueue<X> {
  /**
   * insert the element in the queue. Use the Comparable method  compareTo( ) to
   * implement the ordering.
   * time complexity: O(n^2).
   *
   * @param element to be inserted
   */
  void insert(X element);

  /**
   * removes the object from the front. Throw an appropriate exception if the
   * Priority Queue is empty.
   * time complexity: O(1).
   */
  void remove();

  /**
   * removes the element located at the specified index from the queue.
   * time complexity: O(n).
   *
   * @param index of the element to be removed.
   */
  void remove(int index);

  /**
   * returns the object at the front without changing the Priority Queue. Throw
   * an appropriate exception if the Priority Queue is empty.
   * time complexity: O(1).
   *
   * @return the object at front
   */
  X front();

  /**
   * returns true if the queue is empty and false otherwise.
   * time complexity: O(1).
   *
   * @return boolean
   */
  boolean isEmpty();

  /**
   * returns the size of the queue.
   * time complexity: O(n).
   *
   * @return size of the queue.
   */
  int size();

  /**
   * gets an element located at the specified index (the queue remains unaltered).
   * time complexity: O(n).
   *
   * @param index of the element
   * @return element at given index
   */
  X get(int index);


  /**
   * get the queue inside priority queue.
   * time complexity: O(1).
   *
   * @return queue
   */
  LinkedList<X> getQueue();
}
