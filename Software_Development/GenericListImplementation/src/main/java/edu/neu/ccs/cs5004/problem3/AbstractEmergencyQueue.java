package edu.neu.ccs.cs5004.problem3;

import edu.neu.ccs.cs5004.problem2.IllegalOperationException;
import edu.neu.ccs.cs5004.problem2.PriorityQueue;

/**
 * abstract class for emergency queue.
 */
public abstract class AbstractEmergencyQueue implements EmergencyQueue {
  private int maxOrderNumber;
  protected PriorityQueue<Patient> queue;

  public AbstractEmergencyQueue() {
    maxOrderNumber = 0;
  }

  @Override
  public Patient nextPatient() {
    return queue.front();
  }

  @Override
  public void removeNext() {
    queue.remove();
  }

  @Override
  public Patient nextMostUrgent() {
    return queue.front();
  }

  @Override
  public void removeMostUrgent() {
    if (queue.isEmpty()) {
      throw new IllegalOperationException("Queue is empty!");
    }
    queue.remove();
  }

  @Override
  public void add(Patient patient) {
    maxOrderNumber += 1;
    patient.setOrderNumber(maxOrderNumber);
    queue.insert(patient);
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public int size() {
    return queue.size();
  }
}
