package edu.neu.ccs.cs5004.problem2;

import edu.neu.ccs.cs5004.problem1.LinkedList;

import java.util.Comparator;

/**
 * generic priority queue.
 * @param <X> type of element
 */
public class APriorityQueue<X extends Comparable<X>> implements PriorityQueue<X> {
  protected LinkedList<X> queue;
  protected Comparator<X> comparator;

  public APriorityQueue() {
    this.queue = new LinkedList<>();
  }

  public APriorityQueue(Comparator<X> comparator) {
    this.queue = new LinkedList<>();
    this.comparator = comparator;
  }

  public LinkedList<X> getQueue() {
    return queue;
  }

  /**
   * insert the element in the queue. Use the Comparable method  compareTo( ) to
   * implement the ordering.
   *
   * @param element to be inserted
   */
  @Override
  public void insert(X element) {
    if (queue.isEmpty()) {
      queue.add(element);
      return;
    }

    if (comparator == null) {
      for (int i = 0; i < queue.size(); i++) {
        if (element.compareTo(queue.get(i)) > 0) {
          queue.add(i, element);
          return;
        }
      }
    } else {
      for (int i = 0; i < queue.size(); i++) {
        if (comparator.compare(element, queue.get(i)) > 0) {
          queue.add(i, element);
          return;
        }
      }
    }

    queue.add(element);
  }

  /**
   * removes the object from the front. Throw an appropriate exception if the
   * Priority Queue is empty.
   */
  @Override
  public void remove() {
    if (queue.isEmpty()) {
      throw new IllegalOperationException("Queue is Empty.");
    }

    queue.remove(0);
  }

  /**
   * removes the element located at the specified index from the queue.
   *
   * @param index of the element to be removed.
   */
  @Override
  public void remove(int index) {
    queue.remove(index);
  }


  /**
   * returns the object at the front without changing the Priority Queue. Throw
   * an appropriate exception if the Priority Queue is empty.
   *
   * @return the object at front
   */
  @Override
  public X front() {
    if (queue.isEmpty()) {
      throw new IllegalOperationException("Queue is Empty.");
    }

    return queue.get(0);
  }

  /**
   * returns true if the queue is empty and false otherwise.
   *
   * @return boolean
   */
  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  /**
   * returns the size of the queue.
   *
   * @return size of the queue.
   */
  @Override
  public int size() {
    return queue.size();
  }

  /**
   * gets an element located at the specified index (the queue remains unaltered).
   *
   * @param index of the element
   * @return element at given index
   */
  @Override
  public X get(int index) {
    return queue.get(index);
  }
}


