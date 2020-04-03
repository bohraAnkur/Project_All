package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListNodeTest {

  private ListNode<Integer> nodeOne;
  private ListNode<Integer> nodeTwo;
  private ListNode<Integer> nodeThree;
  private ListNode<Integer> sameNode;
  private ListNode<Integer> differentNode;
  private ListNode<Integer> nullNode;


  @Before
  public void setUp() throws Exception {
    nodeOne = new ListNode<>(2, null);
    nodeTwo = new ListNode<>(2, null);
    nodeThree = new ListNode<>(2, null);
    sameNode = nodeOne;
    differentNode = new ListNode<>(5, nodeOne);
    nullNode = null;
  }

  @Test
  public void setElement() {
    nodeOne.setElement(5);
    Assert.assertEquals(nodeOne.getElement(), new Integer(5));

  }

  @Test
  public void equals() {
    Assert.assertTrue(this.nodeOne.equals(this.nodeTwo));
    Assert.assertTrue(this.nodeTwo.equals(this.nodeOne));
    Assert.assertTrue(this.nodeOne.equals(this.sameNode));
    Assert.assertTrue(this.nodeOne.equals(this.nodeOne));
    Assert.assertEquals(this.nodeOne.equals(this.nodeTwo) &&
            this.nodeTwo.equals(this.nodeThree),
        this.nodeThree.equals(this.nodeOne));
    Assert.assertFalse(this.nodeOne.equals(this.differentNode));
    Assert.assertFalse(this.nodeOne.equals(this.nullNode));
  }
}