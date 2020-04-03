package edu.neu.ccs.cs5004.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {

  private Name nameOne;
  private Name nameTwo;
  private Name nameThree;
  private Name sameName;
  private Name differentName;
  private Name nullName;

  @Before
  public void setUp() throws Exception {
    nameOne = new Name("Sharice", "Gilbert");
    nameTwo = new Name("Sharice", "Gilbert");
    nameThree = new Name("Sharice", "Gilbert");
    sameName = nameOne;
    differentName = new Name("John", "Doe");
    nullName = null;



  }

  @Test
  public void testEquals() {
    Assert.assertTrue(this.nameOne.equals(this.nameTwo));
    Assert.assertTrue(this.nameTwo.equals(this.nameOne));
    Assert.assertTrue(this.nameOne.equals(this.sameName));
    Assert.assertTrue(this.nameOne.equals(this.nameOne));
    Assert.assertEquals(this.nameOne.equals(this.nameTwo) &&
            this.nameTwo.equals(this.nameThree),
        this.nameThree.equals(this.nameOne));
    Assert.assertFalse(this.nameOne.equals(this.differentName));
    Assert.assertFalse(this.nameOne.equals(this.nullName));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(this.nameOne.equals(this.nameTwo),
        this.nameOne.hashCode() == this.nameTwo.hashCode());
    Assert.assertEquals(this.nameOne.equals(this.sameName),
        this.nameOne.hashCode() == this.sameName.hashCode());
  }

  @Test
  public void testToString() {
    String equalsString = "Name{first='Sharice', last='Gilbert'}";
    Assert.assertEquals(nameOne.toString(), equalsString);
  }
}