package edu.neu.ccs.cs5004.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.TestCaseUtils;
import edu.neu.ccs.cs5004.model.cells.GapCell;
import edu.neu.ccs.cs5004.model.cells.SpecificShipCell;
import edu.neu.ccs.cs5004.model.ships.Cruiser;

public class PlayerMapConsolePrinterTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void cellTypeToString() {
    PlayerMapConsolePrinter printer = new PlayerMapConsolePrinter();
    Assert.assertEquals("[ ]", printer.cellTypeToString(new GapCell()));
    Assert.assertNotEquals("[ ]", printer.cellTypeToString(new SpecificShipCell(
        new Cruiser())));
  }

  @Test
  public void equalsTest() {
    PlayerMapConsolePrinter printer = new PlayerMapConsolePrinter();
    PlayerMapConsolePrinter printerCopy = new PlayerMapConsolePrinter();
    PlayerMapConsolePrinter printerCopy2 = new PlayerMapConsolePrinter();
    PlayerMapConsolePrinter sameReference = printer;
    PlayerMapConsolePrinter differentPrinter = new PlayerMapConsolePrinter();
    TestCaseUtils.assertPassesAlwaysEqualsTest(printer, printerCopy, printerCopy2,
        sameReference, differentPrinter);
  }

  @Test
  public void hashCodeTest() {
    PlayerMapConsolePrinter printer = new PlayerMapConsolePrinter();
    PlayerMapConsolePrinter printerCopy = new PlayerMapConsolePrinter();
    PlayerMapConsolePrinter sameReference = printer;
    TestCaseUtils.assertPassesHashCodeTest(printer, printerCopy, sameReference);
  }
}