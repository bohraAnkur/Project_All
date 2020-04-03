package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.map.BattleMap;
import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.model.map.PlayerMap;
import edu.neu.ccs.cs5004.view.AbstractConsolePrinter;

import static org.junit.Assert.*;

public class AbstractConsolePrinterTest {

  private class TestAbstractConsolePrinterTest extends AbstractConsolePrinter {
    private int cellTypeToStringCallCount = 0;
    @Override
    protected String cellTypeToString(Cell cell) {
      cellTypeToStringCallCount++;
      return "";
    }

    public int getCellTypeToStringCallCount() {
      int n = cellTypeToStringCallCount;
      cellTypeToStringCallCount = 0;
      return n;
    }
  }

  @Before
  public void setUp() {
  }

//  @Test
//  public void toConsoleTest() {
//    // This will test the amount of times cellTypeToString() is called by toConsole().
//    // It should be called ROW_SIZE*COLUMN_SIZE amount of times.
//    TestAbstractConsolePrinterTest abstractConsolePrinter = new TestAbstractConsolePrinterTest();
//    abstractConsolePrinter.toConsole(new BattleMap());
//    final int expectedCount = Row.ROW_SIZE.ordinal() * Column.COLUMN_SIZE.ordinal();
//
//    Assert.assertEquals(abstractConsolePrinter.getCellTypeToStringCallCount(), expectedCount);
//
//    abstractConsolePrinter.toConsole(new PlayerMap());
//    Assert.assertEquals(abstractConsolePrinter.getCellTypeToStringCallCount(), expectedCount);
//  }

  @Test
  public void equalsTest() {
    // The assumption here is that all console printers are the same. They are merely the bridge
    // between a map and a concrete console printer.
    TestAbstractConsolePrinterTest abstractConsolePrinter = new TestAbstractConsolePrinterTest();
    TestAbstractConsolePrinterTest sameConsolePrinter = new TestAbstractConsolePrinterTest();
    TestCaseUtils.assertPassesAlwaysEqualsTest(abstractConsolePrinter, sameConsolePrinter,
        abstractConsolePrinter, abstractConsolePrinter, abstractConsolePrinter);
  }

  @Test
  public void hashCodeTest() {
    TestAbstractConsolePrinterTest abstractConsolePrinter = new TestAbstractConsolePrinterTest();
    TestAbstractConsolePrinterTest sameConsolePrinter = new TestAbstractConsolePrinterTest();
    assertEquals(abstractConsolePrinter.hashCode(), sameConsolePrinter.hashCode());
    assertEquals(42, abstractConsolePrinter.hashCode());
  }
}