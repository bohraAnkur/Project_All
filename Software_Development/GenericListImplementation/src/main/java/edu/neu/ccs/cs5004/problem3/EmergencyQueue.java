package edu.neu.ccs.cs5004.problem3;

/**
 * an emergency queue.
 */
public interface EmergencyQueue {
  /**
   * returns the next patient (based on the arrival order), without changing the queue. If the
   * queue is empty, an exception should be thrown.
   * observer.
   *
   * @return the next patient
   */
  Patient nextPatient();

  /**
   * removes the next patient (based on the arrival order). If the queue is empty, an exception
   * should be thrown.
   * mutator.
   * time complexity: O(n).
   * average run time when there are 6 patients in queue: 12346 nano sec.
   *
   */
  void removeNext();

  /**
   * returns the patient with the highest urgency in the queue, without changing the queue. If
   * the queue is empty, an exception should be thrown. The time complexity of this operation
   * should be O(1).
   * observer.
   *
   * @return the patient with the highest urgency
   */
  Patient nextMostUrgent();

  /**
   * removes the most urgent patient from the queue. Throw an appropriate exception if the queue
   * is empty.
   * mutator.
   * time complexity: O(1).
   * average run time when there are 6 patients in queue: 1710 nano sec.
   *
   */
  void removeMostUrgent();

  /**
   * adds a patient to the queue, based on his emergency.
   * mutator.
   *
   * @param patient to be added
   */
  void add(Patient patient);

  /**
   * returns true if the queue is empty and false otherwise.
   * observer.
   *
   * @return boolean
   */
  boolean isEmpty();

  /**
   * returns the number of patients in the queue.
   * observer.
   *
   * @return the size of queue
   */
  int size();
}
