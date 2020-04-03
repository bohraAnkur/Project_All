package edu.neu.ccs.cs5004.problem4;

import edu.neu.ccs.cs5004.problem4.ReleaseYear;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReleaseYearTest {

  private Integer newYear = 1994;

  private Integer newYearTwo = 2017;

  private ReleaseYear releaseYear;

  private ReleaseYear sameRefReleaseYear;

  private ReleaseYear sameStateReleaseYear;

  private ReleaseYear diffReleaseYear;

  private ReleaseYear yetAnotherReleaseYear;

  private ReleaseYear nullReleaseYear;

  @Before
  public void setUp() throws Exception {
    this.releaseYear = new ReleaseYear(newYear);

    this.sameRefReleaseYear = this.releaseYear;

    this.sameStateReleaseYear = new ReleaseYear(newYear);

    this.diffReleaseYear = new ReleaseYear(newYearTwo);

    this.yetAnotherReleaseYear = new ReleaseYear(newYearTwo);

    this.nullReleaseYear = null;
  }

  @Test
  public void getYearReleased() {
    Assert.assertEquals(this.releaseYear.getYearReleased(), this.releaseYear.getYearReleased());

    Assert.assertEquals(this.releaseYear.getYearReleased(), this.sameStateReleaseYear.
            getYearReleased());
  }

  @Test
  public void equals() {
    Assert.assertEquals(this.releaseYear, this.releaseYear);

    Assert.assertEquals(this.releaseYear, this.sameRefReleaseYear);

    Assert.assertEquals(this.releaseYear, this.sameStateReleaseYear);

    Assert.assertEquals(this.sameStateReleaseYear, this.releaseYear);

    Assert.assertEquals(this.releaseYear.equals(this.sameStateReleaseYear)
                    &&
                    this.sameStateReleaseYear.equals(this.yetAnotherReleaseYear),
            this.releaseYear.equals(this.yetAnotherReleaseYear));

    Assert.assertFalse(this.releaseYear.equals(this.nullReleaseYear));

    Assert.assertFalse(this.releaseYear.equals(this.diffReleaseYear));

    Assert.assertFalse(this.releaseYear.equals("A"));

    Assert.assertFalse(this.releaseYear.equals(null));
  }

  @Test
  public void hashCodeTest() {

    Assert.assertEquals(this.releaseYear.hashCode(), this.sameRefReleaseYear.hashCode());

    Assert.assertEquals(this.releaseYear.hashCode(), this.sameStateReleaseYear.hashCode());
  }

  @Test
  public void toStringTest() {

    Assert.assertEquals("ReleaseYear{yearReleased=1994}", this.releaseYear.toString());

  }
}