package edu.neu.ccs.cs5004.problem4;

import edu.neu.ccs.cs5004.problem4.Alias;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AliasTest {
  private String shortNameOne;
  private String shortNameTwo;

  private Alias aliasOne;
  private Alias sameRefAlias;
  private Alias sameStateAlias;
  private Alias yetAnotherAlias;
  private Alias differentAlias;
  private Alias nullAlias;


  @Before
  public void setUp() throws Exception {
    this.shortNameOne = "A";
    this.shortNameTwo = "B";
    this.aliasOne = new Alias(shortNameOne);
    this.sameRefAlias = this.aliasOne;
    this.sameStateAlias = new Alias(shortNameOne);
    this.differentAlias = new Alias(shortNameTwo);
    this.nullAlias = null;

  }

  @Test
  public void getShortName() {
    Assert.assertEquals(this.shortNameOne, this.aliasOne.getShortName());
    Assert.assertEquals(this.shortNameTwo, this.differentAlias.getShortName());
  }

  @Test
  public void equals() {
    Assert.assertEquals(this.aliasOne, this.aliasOne);
    Assert.assertEquals(this.aliasOne, this.sameStateAlias);
    Assert.assertEquals(this.aliasOne, this.sameStateAlias);
    Assert.assertEquals(this.sameStateAlias, this.aliasOne);
    Assert.assertEquals(this.aliasOne.equals(this.sameStateAlias)
                    &&
                    this.sameStateAlias.equals(this.yetAnotherAlias),
            this.aliasOne.equals(this.yetAnotherAlias));
    Assert.assertFalse(this.aliasOne.equals("A"));
    Assert.assertFalse(this.aliasOne.equals(null));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.aliasOne.hashCode(), this.sameStateAlias.hashCode());

    Assert.assertEquals(this.aliasOne.hashCode(), this.sameRefAlias.hashCode());
  }

  @Test
  public void toStringTest() {

    Assert.assertEquals("Alias{shortName='A'}", this.aliasOne.toString());
  }
}