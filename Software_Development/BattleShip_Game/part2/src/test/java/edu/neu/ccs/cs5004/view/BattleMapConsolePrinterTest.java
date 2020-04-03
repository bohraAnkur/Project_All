package edu.neu.ccs.cs5004.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.TestCaseUtils;
import edu.neu.ccs.cs5004.model.cells.GapCell;
import edu.neu.ccs.cs5004.model.cells.SpecificShipCell;
import edu.neu.ccs.cs5004.model.ships.Destroyer;
import edu.neu.ccs.cs5004.model.ships.Submarine;

import static org.junit.Assert.*;

public class BattleMapConsolePrinterTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void cellTypeToString() {
    BattleMapConsolePrinter printer = new BattleMapConsolePrinter();
    SpecificShipCell shipCell = new SpecificShipCell(new Destroyer());
    GapCell missCell = new GapCell();
    Assert.assertEquals("[ ]", printer.cellTypeToString(shipCell));
    Assert.assertEquals("[ ]", printer.cellTypeToString(missCell));
    missCell.attackThisCell();
    Assert.assertEquals("[O]", printer.cellTypeToString(missCell));
  }

  @Test
  public void equalsTest() {
    BattleMapConsolePrinter printer = new BattleMapConsolePrinter();
    BattleMapConsolePrinter printerCopy = new BattleMapConsolePrinter();
    BattleMapConsolePrinter printerCopy2 = new BattleMapConsolePrinter();
    BattleMapConsolePrinter printerSameRef = printer;
    BattleMapConsolePrinter differentPrinter = new BattleMapConsolePrinter();
    TestCaseUtils.assertPassesAlwaysEqualsTest(printer, printerCopy, printerCopy2, printerSameRef,
        differentPrinter);
  }

  @Test
  public void hashCodeTest() {
    BattleMapConsolePrinter printer = new BattleMapConsolePrinter();
    BattleMapConsolePrinter printerCopy = new BattleMapConsolePrinter();
    BattleMapConsolePrinter printerSameRef = printer;
    TestCaseUtils.assertPassesHashCodeTest(printer, printerCopy, printerSameRef);
  }
}