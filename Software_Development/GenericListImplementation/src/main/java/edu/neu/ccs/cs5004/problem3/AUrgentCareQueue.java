package edu.neu.ccs.cs5004.problem3;

import edu.neu.ccs.cs5004.problem1.ListNode;
import edu.neu.ccs.cs5004.problem2.APriorityQueue;
import edu.neu.ccs.cs5004.problem2.IllegalOperationException;
import edu.neu.ccs.cs5004.problem2.PriorityQueue;

/**
 * urgent care queue.
 */
public class AUrgentCareQueue extends AbstractEmergencyQueue implements UrgentCareQueue{
  public AUrgentCareQueue() {
    queue = new APriorityQueue<>(new SortByArrivingOrder());
  }

  @Override
  public Patient nextMostUrgent() {
    if (queue.isEmpty()) {
      throw new IllegalOperationException("Queue is empty!");
    }

    PriorityQueue<Patient> priorityQueue = this.queue;
    Patient acc = priorityQueue.front();

    return nextMostUrgentRecur(acc, priorityQueue.getQueue().getFront());
  }

  /**
   * helper function for nextMostUrgent().
   *
   * @param acc current most urgent patient
   * @param node rest of the queue
   * @return next most urgent patient
   */
  private static Patient nextMostUrgentRecur(Patient acc, ListNode<Patient> node) {
    if (node == null) {
      return acc;
    }
    if (acc.compareTo(node.getElement()) < 0) {
      acc = node.getElement();
      return nextMostUrgentRecur(acc, node.getNext());
    } else {
      return nextMostUrgentRecur(acc, node.getNext());
    }
  }

  @Override
  public void removeMostUrgent() {
    if (queue.isEmpty()) {
      throw new IllegalOperationException("Queue is empty!");
    }

    queue.remove(queue.getQueue().indexOf(nextMostUrgent()));
  }
}
