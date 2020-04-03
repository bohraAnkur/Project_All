package edu.neu.ccs.cs5004.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem2.IllegalOperationException;
import edu.neu.ccs.cs5004.problem2.PriorityQueue;

import static org.junit.Assert.*;

public class EmergencyQueueTest {

  private EmergencyQueue emergencyQueue;
  private EmergencyQueue emptyQueue;
  private Patient junA;
  private Patient junB;
  private Patient junC;
  private Patient junD;
  private Patient junE;
  private Patient junF;


  @Before
  public void setUp() throws Exception {
    emergencyQueue = new AEmergencyQueue();
    emptyQueue = new AEmergencyQueue();



    junA = new Patient(new Urgency(1), new Name("juna", "he"));
    junB = new Patient(new Urgency(3), new Name("junb", "he"));
    junC = new Patient(new Urgency(6), new Name("junc", "he"));
    junD = new Patient(new Urgency(9), new Name("jund", "he"));
    junE = new Patient(new Urgency(2), new Name("june", "he"));
    junF = new Patient(new Urgency(4), new Name("junf", "he"));

    emergencyQueue.add(junA);
    emergencyQueue.add(junB);
    emergencyQueue.add(junC);
    emergencyQueue.add(junD);
    emergencyQueue.add(junE);
    emergencyQueue.add(junF);
  }

  @Test (expected = IllegalOperationException.class)
  public void testNextPatient() {
    Assert.assertTrue(emergencyQueue.nextPatient().equals(junA));
    // exception will be thrown
    emptyQueue.nextPatient();
  }

  @Test (expected = IllegalOperationException.class)
  public void removeNext() {
    emergencyQueue.removeNext();
    Assert.assertTrue(emergencyQueue.nextPatient().equals(junB));
    //Assert.assertTrue(emergencyQueue.nextPatient().equals(junD));

    // exception will be thrown
    emptyQueue.removeNext();

  }

  @Test
  public void nextMostUrgent() {
    Assert.assertTrue(emergencyQueue.nextMostUrgent().equals(junD));
    Assert.assertFalse(emergencyQueue.nextMostUrgent().equals(junB));
  }

  @Test (expected = IllegalOperationException.class)
  public void removeMostUrgent() {
    emergencyQueue.removeMostUrgent();
    Assert.assertFalse(emergencyQueue.nextMostUrgent().equals(junD));
    Assert.assertTrue(emergencyQueue.nextMostUrgent().equals(junC));
    emptyQueue.removeMostUrgent();
  }

  @Test
  public void add() {
    emptyQueue.add(junA);
    Assert.assertTrue(emptyQueue.nextPatient().equals(junA));

  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(emptyQueue.isEmpty());
    Assert.assertFalse(emergencyQueue.isEmpty());
  }

  @Test
  public void size() {
    Assert.assertEquals(emptyQueue.size(), 0);
    Assert.assertEquals(emergencyQueue.size(), 6);
  }

  @Test
  public void test() {
    long t1 = System.nanoTime();
    emergencyQueue.removeNext();
    emergencyQueue.removeNext();
    emergencyQueue.removeNext();
    emergencyQueue.removeNext();
    emergencyQueue.removeNext();
    emergencyQueue.removeNext();
    long t2 = System.nanoTime() - t1;
    System.out.println("removeNext() runtime:" + t2/6);
  }

  @Test
  public void test2() {
    long t1 = System.nanoTime();
    emergencyQueue.removeMostUrgent();
    emergencyQueue.removeMostUrgent();
    emergencyQueue.removeMostUrgent();
    emergencyQueue.removeMostUrgent();
    emergencyQueue.removeMostUrgent();
    emergencyQueue.removeMostUrgent();
    long t2 = System.nanoTime() - t1;
    System.out.println("removeMostUrgent() runtime:" + t2/6);
  }
}