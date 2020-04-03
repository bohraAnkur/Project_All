package edu.neu.ccs.cs5004;

public class GameManual extends GameMode {

  private Map guessMap;
  private FleetMap playeMap;


  public GameManual(Map guessMap, FleetMap playerMap){
    super(guessMap,playerMap);
  }
  @Override
  public void viewAllMaps() {

  }
}
