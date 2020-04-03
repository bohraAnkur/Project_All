package edu.neu.ccs.cs5004.problem1and2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IbtNodeTest extends TestUtility{
  private Ibt n1;
  private Ibt n2;
  private Ibt n3;
  private Ibt diff;
  private Ibt nEm;

  @Before
  public void setUp() throws Exception {
    nEm = new IbtEmpty();
    n1 = new IbtNode(4,
        new IbtNode(2,
            new IbtNode(1, nEm, nEm),
            new IbtNode(3, nEm, nEm)),
        new IbtNode(8,
            new IbtNode(6, nEm, nEm),
            new IbtNode(10, nEm,nEm)));
    n2 = n1;
    n3 = n1;
    diff = n1.add(7);
  }

  @Test
  public void getValue() {
    nEm.getValue();
    Assert.assertTrue(n1.getValue().equals(new Integer(4)));
  }

  @Test
  public void getLeft() {
    nEm.getLeft();
    Ibt node = new IbtNode(2,
        new IbtNode(1, nEm, nEm),
        new IbtNode(3, nEm, nEm));
    Assert.assertTrue(n1.getLeft().equals(node));
  }

  @Test
  public void getRight() {
    nEm.getRight();
    Ibt node = new IbtNode(8,
        new IbtNode(6, nEm, nEm),
        new IbtNode(10, nEm,nEm));
    Assert.assertTrue(n1.getRight().equals(node));
  }

  @Test
  public void contains() {
    Assert.assertTrue(n1.contains(10));
    Assert.assertTrue(n1.contains(4));
    Assert.assertFalse(n1.contains(7));
  }

  @Test
  public void isBst() {
    Assert.assertTrue(n1.isBst());
    Assert.assertFalse(diff.isBst());
  }

  @Test
  public void add() {
    nEm.add(4);
    Assert.assertTrue(n1.add(4).equals(n1));
    Assert.assertTrue(n1.add(7).equals(diff));
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(Ibt.createEmpty().isEmpty());
    Assert.assertFalse(n1.isEmpty());
  }

  @Test
  public void equalsT() {
    isEqualsContractValid(n1, n2, n3, diff);
  }

  @Test
  public void toStringT() {
    String str = "IbtNode{value=4, " +
        "left=IbtNode{value=2, " +
        "left=IbtNode{value=1, " +
        "left=IbtEmpty{}, right=IbtEmpty{}}, " +
        "right=IbtNode{value=3, left=IbtEmpty{}, right=IbtEmpty{}}}, " +
        "right=IbtNode{value=8, left=IbtNode{value=6, left=IbtEmpty{}, " +
        "right=IbtEmpty{}}, right=IbtNode{value=10, left=IbtEmpty{}, right=IbtEmpty{}}}}";
    Assert.assertEquals(n1.toString(), str);
  }
}