package edu.neu.ccs.cs5004;


public class BattleShip extends AbstractShip implements BattleShipInterface {

  public static Integer BATTLESHIP_SIZE = 4;


  /**
   * a constructor for the destroyer class
   */
  public BattleShip() {
    super(BATTLESHIP_SIZE);
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
