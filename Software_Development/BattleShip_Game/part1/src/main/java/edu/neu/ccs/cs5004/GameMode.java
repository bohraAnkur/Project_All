package edu.neu.ccs.cs5004;

public abstract class GameMode implements Mode {

  Map guessMap;
  FleetMap playerMap;

  public GameMode (Map guessMap, FleetMap playerMap) {
    this.guessMap = guessMap;
    this.playerMap = playerMap;
  }
}
