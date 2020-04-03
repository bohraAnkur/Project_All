package edu.neu.ccs.cs5004;

public interface DestroyerInterface {
  /**
   * Represents the constructor for creating Destroyer Ship.
   *
   * @return A destroyer ship
   */
  static Ship createDestroyerShip() {
    return new Destroyer();
  }
}
