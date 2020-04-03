package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractLinkedListTest {


  private AbstractLinkedList<Integer> testList;
  private AbstractLinkedList<Integer> testListTwo;
  private AbstractLinkedList<Integer> testListThree;
  private AbstractLinkedList<Integer> sameTestList;
  private AbstractLinkedList<Integer> emptyList;
  private AbstractLinkedList<Integer> nullList;
  private AbstractLinkedList<Integer> differentList;

  @Before
  public void setUp() throws Exception {
    testList = new LinkedList<>();
    for (int i = 0; i < 5; i++) {
      testList.add(i);
    }

    testListTwo = new LinkedList<>();
    for (int i = 0; i < 5; i++) {
      testListTwo.add(i);
    }

    testListThree = new LinkedList<>();
    for (int i = 0; i < 5; i++) {
      testListThree.add(i);
    }


    sameTestList = testList;

    emptyList = new LinkedList<>();

    nullList = null;

  }

  @Test
  public void testIsValidIndex() {

    Assert.assertTrue(testList.isValidIndex(2));
    Assert.assertFalse(testList.isValidIndex(8));
  }

  @Test
  public void testRemoveFirst() {

    testList.removeFirst();
    Assert.assertFalse(testList.contains(0));
    Assert.assertEquals(testList.size(), 4);
    emptyList.removeFirst();

  }

  @Test
  public void testEquals() {

    Assert.assertTrue(this.testList.equals(this.testListTwo));
    Assert.assertTrue(this.testListTwo.equals(this.testList));
    Assert.assertTrue(this.testList.equals(this.sameTestList));
    Assert.assertTrue(this.testList.equals(this.testList));
    Assert.assertEquals(this.testList.equals(this.testListTwo) &&
            this.testListTwo.equals(this.testListThree),
        this.testListThree.equals(this.testList));
    Assert.assertFalse(this.testList.equals(this.emptyList));
    Assert.assertFalse(this.testList.equals(this.nullList));
    Assert.assertFalse(this.testList.equals(this.differentList));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(this.testList.equals(this.testListTwo),
        this.testList.hashCode() == this.testListTwo.hashCode());
    Assert.assertEquals(this.testList.equals(this.sameTestList),
        this.testList.hashCode() == this.sameTestList.hashCode());
  }

  @Test
  public void testPrintList() {
    //System.out.println(testList.printList());
    String testListString = "0\n" + "1\n" + "2\n" + "3\n" + "4\n";
    Assert.assertEquals(testList.printList(), testListString);
  }
}