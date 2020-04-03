package edu.neu.ccs.cs5004.problem3;

/**
 * urgent care queue.
 */
public interface UrgentCareQueue extends EmergencyQueue{
  /**
   * returns the next patient (based on the arrival order), without changing the queue. If the
   * queue is empty, an exception should be thrown.
   * observer.
   * time complexity: O(1).
   *
   * @return the next patient
   */
  Patient nextPatient();
}
