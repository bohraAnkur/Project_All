package edu.neu.ccs.cs5004.problem4;

import java.util.Objects;

/**
 * Represents the common properties of the actor Entity.
 */
public class Actor {

  Name actorName;

  /**
   * Constructor For the Actor Entity Of the Data Base.
   *
   * @param actorName actorName of the actor.
   */

  public Actor(Name actorName) {
    this.actorName = actorName;
  }

  /**
   * Getter for the actorName of the actor.
   *
   * @return the List of the actor
   */

  public Name getActorName() {
    return this.actorName;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Actor actor = (Actor) object;
    return Objects.equals(actorName, actor.actorName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(actorName);
  }

  @Override
  public String toString() {
    return "Actor{"
            +
            "actorName=" + actorName
            +
            '}';
  }
}
