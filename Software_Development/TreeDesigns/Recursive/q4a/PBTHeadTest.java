package q4a;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import q4.PBTInvalidRequestException;

public class PBTHeadTest {

  private PBTHead<Integer> empty;
  private PBTHead<Integer> single;
  private PBTHead<Integer> t1;
  private PBTHead<Integer> t2;

  @Before
  public void setUp() throws Exception {
    empty = new PBTHead<>(null);
    single = new PBTHead<>(2);
    t1 = new PBTHead<>(2);
    t2 = new PBTHead<>(20);
  }

  @Test(expected = PBTInvalidRequestException.class)
  public void edgesToRootNull() throws Exception {
    Assert.assertEquals(new Integer(0), empty.edgesToRoot(2));

  }

  @Test
  public void edgesToRoot() throws Exception {
    Assert.assertEquals(new Integer(0), single.edgesToRoot(2));

    PBT<Integer> t3 = PBT.create(100);
    System.out.println(t3);
    t3.add(10);
    t3.add(20);
    t3.add(30);

    System.out.println(t3);

    Assert.assertEquals(new Integer(2), t3.edgesToRoot(30));
  }

  @Test
  public void add() throws Exception {
    PBT<Integer> pbt1 = PBT.create(20);
    PBT<Integer> pbt2 = PBT.create(20);

    pbt1.add(100);
    pbt1.add(200);
    pbt1.add(300);
    pbt1.add(400);

    pbt2.add(100);
    pbt2.add(200);
    pbt2.add(300);
    pbt2.add(400);

    Assert.assertEquals(pbt1, pbt2);
    Assert.assertEquals(pbt1.toString(), pbt2.toString());
  }

  @Test
  public void remove() throws Exception {
    single.remove(2);
    t1.add(3);
    t1.add(4);
    t1.add(5);

    System.out.println("1 \t " + t1);
    t1.remove(2);
    System.out.println("2 \t " + t1);


  }

  @Test
  public void testEquals() throws Exception {
    Assert.assertEquals(empty, empty);
    Assert.assertEquals(single, PBT.create(2));
    Assert.assertNotEquals(t1,t2);
    PBT<Integer> pbt1 = PBT.create(20);
    PBT<Integer> pbt2 = PBT.create(20);

    pbt1.add(100);
    pbt1.add(200);
    pbt1.add(300);
    pbt1.add(400);

    pbt2.add(100);
    pbt2.add(200);
    pbt2.add(300);
    pbt2.add(400);

    Assert.assertEquals(pbt1, pbt2);
  }

}