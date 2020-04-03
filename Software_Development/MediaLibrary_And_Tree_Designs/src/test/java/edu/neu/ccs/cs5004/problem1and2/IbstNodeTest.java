package edu.neu.ccs.cs5004.problem1and2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import edu.neu.ccs.cs5004.problem1and2.iterator.IbstInOrderIterator;
import edu.neu.ccs.cs5004.problem1and2.iterator.IbstPostOrderIterator;
import edu.neu.ccs.cs5004.problem1and2.iterator.IbstPreOrderIterator;

import static org.junit.Assert.*;

public class IbstNodeTest extends TestUtility{
  private Ibst bt1;
  private Ibst bt2;
  private Ibst bt3;
  private Ibst diff;
  private Ibst nEm;
  private Ibst n1;

  @Before
  public void setUp() throws Exception {
    nEm = new IbstEmpty();
    n1 = new IbstNode(4,
        new IbstNode(2,
            new IbstNode(1, nEm, nEm),
            new IbstNode(3, nEm, nEm)),
        new IbstNode(8,
            new IbstNode(6, nEm, nEm),
            new IbstNode(10, nEm,nEm)));
    bt1 = Ibst.createEmpty();
    bt1 = bt1.add(4).add(2).add(1).add(8).add(3).add(10).add(6);
    bt2 = bt1;
    bt3 = bt1;
    diff = bt1.add(13);
  }

  @Test
  public void isEmpty() {
    Assert.assertFalse(bt1.isEmpty());
    Assert.assertTrue(nEm.isEmpty());
  }

  @Test
  public void contains() {
    Assert.assertTrue(bt1.contains(4));
    Assert.assertFalse(bt1.contains(7));
  }

  @Test
  public void isBst() {
    Assert.assertTrue(bt1.isBst());
    Assert.assertTrue(diff.isBst());
  }

  @Test
  public void getValue() {
    Assert.assertTrue(bt1.getValue().equals(4));
  }

  @Test
  public void getLeft() {
    nEm.getLeft();
    Assert.assertTrue(bt1.getLeft().getValue().equals(2));

  }

  @Test
  public void getRight() {
    nEm.getRight();
    Assert.assertTrue(bt1.getRight().getValue().equals(8));
  }

  @Test
  public void add() {
    Assert.assertTrue(bt1.add(13).equals(diff));
  }

  @Test
  public void add1() {
    Assert.assertTrue(bt1.add(new IbstNode(13, nEm, nEm)).equals(diff));
  }

  @Test
  public void deleteNode() {
    Ibst node = new IbstNode(8,
        new IbstNode(6,
            new IbstNode(2,
                new IbstNode(1, nEm, nEm),
                new IbstNode(3, nEm, nEm)),
            nEm),
        new IbstNode(10, nEm, nEm));
    Assert.assertTrue(bt1.deleteNode(4).equals(node));
  }

  @Test
  public void mirror() {
    Ibt node = new IbtNode(4,
        new IbtNode(8,
            new IbtNode(10, nEm, nEm),
            new IbtNode(6, nEm, nEm)),
        new IbtNode(2,
            new IbtNode(3, nEm, nEm),
            new IbtNode(1, nEm,nEm)));
    Assert.assertTrue(node.equals(bt1.mirror()));
  }

  @Test
  public void Iterator() {
    Assert.assertTrue(nEm.preOrderIterator().equals(new IbstPreOrderIterator(nEm)));
    Assert.assertTrue(nEm.postOrderIterator().equals(new IbstPostOrderIterator(nEm)));
    Assert.assertTrue(nEm.inOrderIterator().equals(new IbstInOrderIterator(nEm)));
    Assert.assertTrue(bt1.preOrderIterator().equals(new IbstPreOrderIterator(bt1)));
    Assert.assertTrue(bt1.postOrderIterator().equals(new IbstPostOrderIterator(bt1)));
    Assert.assertTrue(bt1.inOrderIterator().equals(new IbstInOrderIterator(bt1)));
    Iterator preI = bt1.preOrderIterator();
    System.out.print("Pre-Order: ");
    while (preI.hasNext()) {
      System.out.print(preI.next());
      System.out.print(" ");
    }
    Iterator postI = bt1.postOrderIterator();
    System.out.print("\nPost-Order: ");
    while (postI.hasNext()) {
      System.out.print(postI.next() + " ");
    }
    Iterator inI = bt1.inOrderIterator();
    System.out.print("\nIn-Order: ");
    while (inI.hasNext()) {
      System.out.print(inI.next() + " ");
    }
  }

  @Test
  public void postOrderNext() {
    nEm.postOrderNext();
    Assert.assertTrue(bt1.deleteNode(1).postOrderNext().equals(3));
  }

  @Test
  public void inOrderNext() {
    nEm.inOrderNext();
    Assert.assertTrue(bt1.deleteNode(1).inOrderNext().equals(2));
  }

  @Test
  public void toStringT() {
    String str = "IbstNode{value=4, left=IbstNode{value=2, left=IbstNode{value=1, left=IbstEmpty{}, " +
        "right=IbstEmpty{}}, right=IbstNode{value=3, left=IbstEmpty{}, right=IbstEmpty{}}}, " +
        "right=IbstNode{value=8, left=IbstNode{value=6, left=IbstEmpty{}, right=IbstEmpty{}}, " +
        "right=IbstNode{value=10, left=IbstEmpty{}, right=IbstEmpty{}}}}";
    Assert.assertEquals(bt1.toString(), str);
  }

  @Test
  public void equalsT() {
    isEqualsContractValid(bt1, bt2, bt3, diff);
  }
}