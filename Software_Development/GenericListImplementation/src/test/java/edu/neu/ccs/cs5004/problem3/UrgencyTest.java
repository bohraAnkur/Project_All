package edu.neu.ccs.cs5004.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrgencyTest {

  private Urgency urgencyOne;
  private Urgency urgencyTwo;
  private Urgency urgencyThree;
  private Urgency sameUrgency;
  private Urgency differentUrgency;
  private Urgency nullUrgency;
  
  @Before
  public void setUp() throws Exception {
    urgencyOne = new Urgency(5);
    urgencyTwo = new Urgency(5);
    urgencyThree = new Urgency(5);
    sameUrgency = urgencyOne;
    differentUrgency = new Urgency(2);
    nullUrgency = null;
    
  }

  @Test
  public void compareTo() {
    Assert.assertEquals(urgencyOne.compareTo(urgencyTwo), 0);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(this.urgencyOne.equals(this.urgencyTwo));
    Assert.assertTrue(this.urgencyTwo.equals(this.urgencyOne));
    Assert.assertTrue(this.urgencyOne.equals(this.sameUrgency));
    Assert.assertTrue(this.urgencyOne.equals(this.urgencyOne));
    Assert.assertEquals(this.urgencyOne.equals(this.urgencyTwo) &&
            this.urgencyTwo.equals(this.urgencyThree),
        this.urgencyThree.equals(this.urgencyOne));
    Assert.assertFalse(this.urgencyOne.equals(this.differentUrgency));
    Assert.assertFalse(this.urgencyOne.equals(this.nullUrgency));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(this.urgencyOne.equals(this.urgencyTwo),
        this.urgencyOne.hashCode() == this.urgencyTwo.hashCode());
    Assert.assertEquals(this.urgencyOne.equals(this.sameUrgency),
        this.urgencyOne.hashCode() == this.sameUrgency.hashCode());
  }

  @Test
  public void testToString() {
    String equalsString = "Urgency{value=5}";
    Assert.assertEquals(urgencyOne.toString(), equalsString);
  }
}