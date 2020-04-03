package edu.neu.ccs.cs5004.problem3;

import edu.neu.ccs.cs5004.problem1.ListNode;
import edu.neu.ccs.cs5004.problem2.APriorityQueue;
import edu.neu.ccs.cs5004.problem2.IllegalOperationException;
import edu.neu.ccs.cs5004.problem2.PriorityQueue;

/**
 * a emergency queue.
 */
public class AEmergencyQueue extends AbstractEmergencyQueue implements EmergencyQueue{
  public AEmergencyQueue() {
    this.queue = new APriorityQueue<>();
  }

  /**
   * returns the next patient (based on the arrival order), without changing the priorityQueue.
   * If the priorityQueue is empty, an exception should be thrown.
   *
   * @return the next patient
   */
  @Override
  public Patient nextPatient() {
    if (queue.isEmpty()) {
      throw new IllegalOperationException("Queue is empty!");
    }

    PriorityQueue<Patient> priorityQueue = this.queue;
    Patient acc = priorityQueue.front();

    return nextPatientRecur(acc, priorityQueue.getQueue().getFront());
  }

  /**
   * helper function for nextPatient().
   *
   * @param acc current most front patient
   * @param node rest of the queue
   * @return next patient (based on the arrival order)
   */
  private static Patient nextPatientRecur(Patient acc, ListNode<Patient> node) {
    if (node == null) {
      return acc;
    }
    if (new SortByArrivingOrder().compare(acc, node.getElement()) < 0) {
      acc = node.getElement();
      return nextPatientRecur(acc, node.getNext());
    } else {
      return nextPatientRecur(acc, node.getNext());
    }
  }

  /**
   * removes the next patient (based on the arrival order). If the priorityQueue is empty,
   * an exception should be thrown.
   */
  @Override
  public void removeNext() {
    if (queue.isEmpty()) {
      throw new IllegalOperationException("Queue is empty!");
    }

    queue.remove(queue.getQueue().indexOf(this.nextPatient()));
  }
}
