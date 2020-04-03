package edu.neu.ccs.cs5004.problem4;

import edu.neu.ccs.cs5004.problem4.Director;
import edu.neu.ccs.cs5004.problem4.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectorTest {
  private Name nameOne;
  private Name nameTwo;

  private Director directorOne;
  private Director sameRefDirector;
  private Director sameStateDirector;
  private Director yetAnotherDirector;
  private Director differentDirector;
  private Director nullActor;

  @Before
  public void setUp() throws Exception {
    this.nameOne = new Name("A", "B");
    this.nameTwo = new Name("C", "D");
    this.directorOne = new Director(nameOne);
    this.sameRefDirector = this.directorOne;
    this.sameStateDirector = new Director(nameOne);
    this.yetAnotherDirector = new Director(nameOne);
    this.differentDirector = new Director(nameTwo);
    this.nullActor = null;
  }

  @Test
  public void getName() {
    Assert.assertEquals(this.nameOne, this.directorOne.getName());
    Assert.assertEquals(this.nameTwo, this.differentDirector.getName());
  }

  @Test
  public void equals() {

    Assert.assertEquals(this.directorOne, this.directorOne);
    Assert.assertEquals(this.directorOne, this.sameRefDirector);
    Assert.assertEquals(this.directorOne, this.sameStateDirector);
    Assert.assertEquals(this.sameStateDirector, this.directorOne);
    Assert.assertEquals(this.directorOne.equals(this.sameStateDirector)
                    &&
                    this.sameStateDirector.equals(this.yetAnotherDirector),
            this.directorOne.equals(this.yetAnotherDirector));
    Assert.assertFalse(this.directorOne.equals(this.nullActor));
    Assert.assertFalse(this.directorOne.equals("A"));
    Assert.assertFalse(this.directorOne.equals(null));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.directorOne.hashCode(), this.sameRefDirector.hashCode());
    Assert.assertEquals(this.directorOne.hashCode(), this.sameStateDirector.hashCode());
  }

  @Test
  public void toStringTest() {

    Assert.assertEquals("Director{name=Name{first='A', last='B'}}",
            this.directorOne.toString());


  }
}