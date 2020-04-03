package edu.neu.ccs.cs5004.problem1and2.iterator;

import edu.neu.ccs.cs5004.problem1and2.IbstEmpty;
import edu.neu.ccs.cs5004.problem1and2.TestUtility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractIteratorTest extends TestUtility{

  private AbstractIterator i1;
  private AbstractIterator i2;
  private AbstractIterator i3;
  private AbstractIterator diff;

  @Before
  public void setUp() throws Exception {
    i1 = new IbstInOrderIterator(new IbstEmpty());
    i2 = i1;
    i3 = i1;
    diff = new IbstPostOrderIterator(new IbstEmpty());
  }

  @Test
  public void remove() {
    boolean thrown = false;

    try {
      i1.remove();
    } catch (UnsupportedOperationException e) {
      thrown = true;
    }

    Assert.assertTrue(thrown);
  }

  @Test
  public void equalsT() {
    isEqualsContractValid(i1,i2,i3,diff);
  }

}