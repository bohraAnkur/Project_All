package edu.neu.ccs.cs5004.assignment8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RandomOrderIteratorTest {
  private RandomOrderIterator roi;

  @Before
  public void setUp() throws Exception {
    ArrayList<Id> al = new ArrayList<>();
    al.add(new Id(1));
    al.add(new Id(4));
    roi = new RandomOrderIterator(al);
  }

  @Test
  public void hasNext() {
    Assert.assertTrue(roi.hasNext());
    roi.next();
    roi.next();
    Assert.assertFalse(roi.hasNext());
  }

  @Test
  public void next() {
    Assert.assertTrue(roi.next().equals(new Id(4)));
  }

  @Test
  public void remove() {
    boolean thrown = false;
    try {
      roi.remove();
    } catch (InvalidInputException e) {
      thrown = true;
    }

    Assert.assertTrue(thrown);
  }
}