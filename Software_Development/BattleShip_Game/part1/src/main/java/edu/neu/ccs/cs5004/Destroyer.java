package edu.neu.ccs.cs5004;

public class Destroyer extends AbstractShip implements DestroyerInterface {
  public static Integer DESTROYER_SIZE = 1;

  /**
   * a constructor for the destroyer class
   */
  public Destroyer() {
    super(DESTROYER_SIZE);
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
