package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListInterfaceTest {

  private LinkedListInterface<Integer> testList;
  private LinkedListInterface<Integer> newList;

  @Before
  public void setUp() throws Exception {

    testList = new LinkedList<Integer>();
    newList = new LinkedList<>();

  }

  @Test(expected = InvalidIndexException.class)
  public void testInterface()  {
    // testing that list is empty.
    Assert.assertTrue(newList.isEmpty());
    // testing that empty list does not contain an element.
    Assert.assertFalse(newList.contains(1));
    //testing that size of empty list is 0.
    Assert.assertEquals(newList.size(), 0);
    for (int i = 1; i <= 4; i++) {

      newList.add(i);
      //newList.printList();

      // testing that add adds new elements
      Assert.assertEquals(newList.size(), i);
      Assert.assertTrue(newList.contains(i));
      //testing that elements are added at the end of the list
      Assert.assertEquals(newList.get(i-1), new Integer(i));
      //System.out.println(newList.indexOf(i));
      Assert.assertEquals(newList.indexOf(i),i -1);
    }
    //testing that list does not contain elements that were not added.
    Assert.assertFalse(newList.contains(8));
    newList.get(8);


    testList.add(0, 0);
//    testList.printList();
    assertEquals(testList.get(0), new Integer(0));
    assertEquals(testList.get(1), new Integer(1));
  }

  @Test
  public void testAddAtIndex() {
    for (int i = 1; i <= 4; i++) {

      newList.add(i);
    }
    newList.add(0, 5);
    Assert.assertTrue(newList.contains(5));
    Assert.assertEquals(newList.indexOf(5), 0);

    newList.add(3, 8);
    Assert.assertTrue(newList.contains(8));
    Assert.assertEquals(newList.indexOf(8), 3);
    //newList.printList();
  }

  @Test (expected = InvalidIndexException.class)
  public void testRemove() {

    for (int i = 1; i <= 4; i++) {

      testList.add(i);
    }


    testList.remove(0);
    Assert.assertTrue(testList.size() == 3);
    Assert.assertFalse(testList.contains(1));

    testList.remove(1);
    Assert.assertTrue(testList.size() == 2);
    Assert.assertFalse(testList.contains(3));

    testList.remove(1);
    Assert.assertTrue(testList.size() == 1);

    testList.remove(8);


  }

}