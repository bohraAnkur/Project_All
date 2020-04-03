package edu.neu.ccs.cs5004;

public interface SubmarineInterface {
  /**
   * Constructor for the Submarine.
   *
   * @return a new Submarine
   */
  static Ship createSubmarine() {

    return new Submarine();
  }
}

