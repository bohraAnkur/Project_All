package edu.neu.ccs.cs5004;

import java.beans.FeatureDescriptor;

public abstract class DebugMode implements Mode {

  protected Map guessMap;
  protected FleetMap playerMap;

  protected Map enemyGuessMap;
  protected FleetMap enemyMap;



  public DebugMode(Map guessMap, FleetMap playerMap, Map enemyGuessMap, FleetMap enemyMap){
    this.guessMap = guessMap;
    this.playerMap = playerMap;
    this.enemyGuessMap = enemyGuessMap;
    this.enemyMap = enemyMap;
  }

}
