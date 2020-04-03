package edu.neu.ccs.cs5004;

public class DebugManual extends DebugMode {

  private Map guessMap;
  private FleetMap playerMap;

  private Map enemyGuessMap;
  private FleetMap enemyMap;

  public DebugManual(Map guessMap, FleetMap playerMap, Map enemyGuessMap, FleetMap enemyMap){
    super(guessMap,playerMap, enemyGuessMap, enemyMap);
  }
  @Override
  public void viewAllMaps() {

  }


}
