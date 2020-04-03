package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.model.map.MapInterface;

/**
 * represents a printer.
 */
public interface ConsolePrinterInterface {

  /**
   * converts a map into a string.
   *
   * @param map a map that will be printed
   */
  String mapToString(MapInterface map);


}

