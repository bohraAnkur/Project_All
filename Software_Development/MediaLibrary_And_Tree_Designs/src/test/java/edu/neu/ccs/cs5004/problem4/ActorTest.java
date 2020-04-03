package edu.neu.ccs.cs5004.problem4;

import edu.neu.ccs.cs5004.problem4.Actor;
import edu.neu.ccs.cs5004.problem4.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActorTest {
  private Name nameOne;
  private Name nameTwo;

  private Actor actorOne;
  private Actor sameRefActor;
  private Actor sameStateActor;
  private Actor yetAnotherActor;
  private Actor differentActor;
  private Actor nullActor;

  @Before
  public void setUp() throws Exception {

    this.nameOne = new Name("A", "B");
    this.nameTwo = new Name("C", "D");
    this.actorOne = new Actor(nameOne);
    this.sameRefActor = this.actorOne;
    this.sameStateActor = new Actor(nameOne);
    this.yetAnotherActor = new Actor(nameOne);
    this.differentActor = new Actor(nameTwo);
    this.nullActor = null;
  }

  @Test
  public void getActorName() {
    Assert.assertEquals(this.nameOne, this.actorOne.getActorName());
    Assert.assertEquals(this.nameTwo, this.differentActor.getActorName());
  }

  @Test
  public void equals() {
    Assert.assertEquals(this.actorOne, this.actorOne);
    Assert.assertEquals(this.actorOne, this.sameRefActor);
    Assert.assertEquals(this.actorOne, this.sameStateActor);
    Assert.assertEquals(this.sameStateActor, this.actorOne);
    Assert.assertEquals(this.actorOne.equals(this.sameStateActor)
                    &&
                    this.sameStateActor.equals(this.yetAnotherActor),
            this.actorOne.equals(this.yetAnotherActor));
    Assert.assertFalse(this.actorOne.equals(this.nullActor));
    Assert.assertFalse(this.actorOne.equals("A"));
    Assert.assertFalse(this.actorOne.equals(null));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.actorOne.hashCode(),this.sameRefActor.hashCode());
    Assert.assertEquals(this.actorOne.hashCode(),this.sameStateActor.hashCode());
  }

  @Test
  public void toStringTest() {

    Assert.assertEquals("Actor{actorName=Name{first='A', last='B'}}",
            this.actorOne.toString());

    }
}