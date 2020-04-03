package edu.neu.ccs.cs5004.problem4;

import edu.neu.ccs.cs5004.problem4.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private String first;
  private String last;

  private Name nameOne;
  private Name sameRefName;
  private Name sameStateName;
  private Name differentName;
  private Name yetAnotherName;
  private Name nullName;

  @Before
  public void setUp() throws Exception {
    this.first = "A";
    this.last = "B";

    this.nameOne = new Name(first, last);
    this.sameRefName = this.nameOne;
    this.sameStateName = new Name(first, last);
    this.differentName = new Name(last, first);
    this.yetAnotherName = new Name(first, last);
    this.nullName = null;
  }

  @Test
  public void getFirst() {
    Assert.assertEquals(first, this.nameOne.getFirst());
    Assert.assertEquals(last, this.differentName.getFirst());
  }

  @Test
  public void getLast() {
    Assert.assertEquals(last, this.nameOne.getLast());
    Assert.assertEquals(first, this.differentName.getLast());
  }

  @Test
  public void equals() {
    Assert.assertEquals(this.nameOne, this.nameOne);
    Assert.assertEquals(this.nameOne, this.sameRefName);
    Assert.assertEquals(this.nameOne, this.sameStateName);
    Assert.assertEquals(this.nameOne.equals(sameStateName)
            &&
            this.sameStateName.equals(yetAnotherName), this.nameOne.equals(this.sameStateName));
    Assert.assertFalse(this.nameOne.equals(this.nullName));
    Assert.assertFalse(this.nameOne.equals("B"));
    Assert.assertFalse(this.nameOne.equals(null));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.nameOne.hashCode(), this.sameRefName.hashCode());
    Assert.assertEquals(this.nameOne.hashCode(), this.sameStateName.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Name{first='A', last='B'}", this.nameOne.toString());
  }
}