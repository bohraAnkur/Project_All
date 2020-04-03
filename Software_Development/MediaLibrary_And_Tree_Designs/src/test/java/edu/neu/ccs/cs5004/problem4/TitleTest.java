package edu.neu.ccs.cs5004.problem4;

import edu.neu.ccs.cs5004.problem4.Title;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TitleTest {

  private String shortNameOne = "ABC";
  private String shortNameTwo = "EFG";
  private Title titleOne;
  private Title sameRefTitle;
  private Title sameStateTitle;
  private Title yetAnotherTitle;
  private Title differentTitle;
  private Title nullTitle;


  @Before
  public void setUp() throws Exception {
    this.titleOne = new Title(this.shortNameOne);
    this.sameRefTitle = titleOne;
    this.sameStateTitle = new Title(this.shortNameOne);
    this.yetAnotherTitle = new Title(this.shortNameOne);
    this.differentTitle = new Title(this.shortNameTwo);
    this.nullTitle = null;
  }


  @Test
  public void getTitleName() {
    Assert.assertEquals(this.shortNameOne, this.titleOne.getTitleName());
    Assert.assertEquals(this.shortNameTwo, this.differentTitle.getTitleName());
  }

  @Test
  public void equals() {
    Assert.assertEquals(this.titleOne, this.titleOne);
    Assert.assertEquals(this.titleOne, this.sameRefTitle);
    Assert.assertEquals(this.sameRefTitle, this.titleOne);
    Assert.assertEquals(this.titleOne.equals(this.sameStateTitle)
            && this.sameStateTitle.equals(this.yetAnotherTitle), this.titleOne.equals(this.yetAnotherTitle));

    Assert.assertFalse(this.titleOne.equals("A"));
    Assert.assertFalse(this.titleOne.equals(null));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.titleOne.hashCode(), this.sameRefTitle.hashCode());
    Assert.assertEquals(this.titleOne.hashCode(), this.sameStateTitle.hashCode());
  }

  @Test
  public void toStringTest() {

    Assert.assertEquals("Title{titleName='ABC'}", this.titleOne.toString());
  }


}