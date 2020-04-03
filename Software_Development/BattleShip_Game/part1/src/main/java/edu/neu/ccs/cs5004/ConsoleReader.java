package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements ConsoleReaderInterface{

  @Override
  public String promptDirectionInput() {
    String userInput = "";
    //do {
    userInput = prompt("input direction:");
    // need to determine what input is valid input
    // } while (!userInputisValid(userInput));
    //may change return statement to use a convert function
    return userInput;
  }


  @Override
  public String promptManualPlacementInput() {
    String userInput = "";
    // do {
    userInput = prompt("input row and column:");
    // need to determine what input is valid input
    // } while (!userInputisValid(userInput));
    //may change return statement to use a convert function
    return userInput;
  }

  protected String prompt(String message) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String result = "";

    System.out.println(message);

    try {
      result = reader.readLine();
//      reader.close();
    } catch (IOException exception) {
      try {
        reader.close();
        exception.printStackTrace();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return result;
  }

  public static Integer[] DebugFleetReader() {
    BufferedReader br = null;
    Integer[] data = new Integer[5];

    try {

      br = new BufferedReader(new InputStreamReader(System.in));

      while (true) {

        System.out.println("Enter the number of ships you want in your fleet ");
        Integer fleetSize = br.read();
        data[0] = fleetSize;

        System.out.println("Enter the number of BattleShips Required");
        Integer battleShipQuantity = br.read();
        data[1] = battleShipQuantity;

        System.out.println("Enter the number of Cruiser's Required");
        Integer cruiserQuantity = br.read();
        data[2] = cruiserQuantity;

        System.out.println("Enter the number of Submarine Required");
        Integer submarineQuantity = br.read();
        data[3] = submarineQuantity;

        System.out.println("Enter the number of Destroyers's Required");
        Integer destroyerQuantity = br.read();
        data[4] = destroyerQuantity;

        System.out.println("Your Fleet is configured press q to confirm");
        String coordinateInput = br.readLine();

        if (("q".equals(coordinateInput))) {
          System.out.println("Exit!");
          System.exit(0);
        }

        System.out.println("FleetSize : " + fleetSize);

        System.out.println("Battle Ship Quantity : " + battleShipQuantity);

        System.out.println("Cruiser Quantity : " + cruiserQuantity);

        System.out.println(" submarineQuantity " + submarineQuantity);

        System.out.println("Destroyer Quantity : " + destroyerQuantity);

        System.out.println("-----------\n");
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return data;
  }

  public static String modeSelector() {

    BufferedReader br = null;

    String input = "";

    try {
      br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("----MODES----");

      System.out.println("1) DEBUG MODE ");

      System.out.println("2) RANDOM MODE");

      System.out.println("Press D for DEBUG MODE");

      System.out.println("Press R for RANDOM MODE");

      input = br.readLine();

      if (input.equals("D")) {

        System.out.println("DEBUG MODE INITIATED");

      }

      if (input.equals("R")) {

        System.out.println("RANDOM MODE INITIATED");

      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return input;
  }
}
