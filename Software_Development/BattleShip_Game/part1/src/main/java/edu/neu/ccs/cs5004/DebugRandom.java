package edu.neu.ccs.cs5004;

public class DebugRandom extends DebugMode {

  private Map guessMap;
  private FleetMap playerMap;

  private Map enemyGuessMap;
  private FleetMap enemyMap;

  public DebugRandom(Map guessMap, FleetMap playerMap, Map enemyGuessMap, FleetMap enemyMap){
    super(guessMap,playerMap, enemyGuessMap, enemyMap);
  }
  @Override
  public void viewAllMaps() {

  }

}
