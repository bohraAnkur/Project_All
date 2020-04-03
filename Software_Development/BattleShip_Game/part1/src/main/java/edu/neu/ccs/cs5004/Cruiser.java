package edu.neu.ccs.cs5004;

public class Cruiser extends AbstractShip implements CruiserInterface {

  public static Integer CRUISER_SIZE = 3;

  public static Integer ONE = 1;

  /**
   * a constructor for the destroyer class
   */
  public Cruiser() {
    super(CRUISER_SIZE);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
