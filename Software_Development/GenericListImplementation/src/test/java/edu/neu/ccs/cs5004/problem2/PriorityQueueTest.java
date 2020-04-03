package edu.neu.ccs.cs5004.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    private PriorityQueue<Integer> testPQ;
    private PriorityQueue<Integer> integerPQ;

    @Before
    public void setUp() throws Exception {
        testPQ = new APriorityQueue<>();

        for (int i = 0; i < 5; i++) {
            testPQ.insert(i);
        }

        integerPQ = new APriorityQueue<>();
    }

    @Test
    public void insert() {
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(testPQ.getQueue().contains(i));
        }
    }

    @Test (expected = IllegalOperationException.class)
    public void remove() {
        for (int i = 0; i < 5; i++) {
            testPQ.remove();
        }
        Assert.assertTrue(testPQ.isEmpty());
        testPQ.remove();
    }

    @Test (expected = IllegalOperationException.class)
    public void front() {
        for (int i = 4; i < -1; i--) {
            testPQ.remove();
            Assert.assertTrue(testPQ.front().equals(i));
        }
        integerPQ.front();

    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(integerPQ.isEmpty());
        Assert.assertFalse(testPQ.isEmpty());
    }

    @Test
    public void size() {
        Assert.assertEquals(testPQ.size(), 5);
        Assert.assertEquals(integerPQ.size(), 0);
    }

    @Test
    public void get() {
        Assert.assertEquals(testPQ.get(0), new Integer (4));
        Assert.assertEquals(testPQ.get(3), new Integer(1));
    }

    @Test
    public void remove1() {
        testPQ.remove(2);
        Assert.assertFalse(testPQ.getQueue().contains(2));
    }

}