import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by masha on 4/25/2017.
 */
public class BinaryTreeTest {
    private PBT<Integer> empty;
    private PBT<Integer> single;
    private PBT<Integer> t1;
    private PBT<Integer> t2;

    @org.junit.Before
    public void setUp() throws Exception {
        empty = new BinaryTree<>();
        single = new BinaryTree<>(2);
        t1 = new BinaryTree<>(2);
        t2 = new BinaryTree<>(20);

    }



    @org.junit.Test
    public void numberOfNodes()  throws Exception  {
        Assert.assertEquals(1, single.numberOfNodes());

       PBT<Integer> t3 = PBT.create(100);
       System.out.println("Before: ");
        t3.printSideways();
        t3.add(10);
        t3.add(20);
        t3.add(30);
        System.out.println("After: ");
        t3.printSideways();
        Assert.assertEquals(4, t3.numberOfNodes());
        System.out.println("Number of nodes " +  t3.numberOfNodes());
    }

    @org.junit.Test
    public void add()  throws Exception {
        PBT<Integer>  pbt1 = PBT.create(20);
        PBT<Integer>  pbt2 = PBT.create(20);

        pbt1.add(100);
        pbt1.add(200);
        pbt1.add(300);
        pbt1.add(400);
        System.out.println("pbt1: ");
        pbt1.printSideways();

        pbt2.add(100);
        pbt2.add(200);
        pbt2.add(300);
        pbt2.add(400);
        System.out.println("pbt2: ");
        pbt2.printSideways();


        Assert.assertEquals(pbt1, pbt2);
    }

   @org.junit.Test
    public void remove() throws Exception {
        single.remove(2);
        t1.add(3);
        t1.add(4);
        t1.add(5);

        System.out.println("Before remove: ");
        System.out.println("    Tree: " );
        t1.printSideways();
        System.out.println("    Parents: " );
        t1.printSidewaysParent();
        t1.remove(2);
        System.out.println("After remove" );
        System.out.println("    Tree: " );
        t1.printSideways();
        System.out.println("    Parents: " );
        t1.printSidewaysParent();


    }

    @org.junit.Test
    public void testEquals() throws Exception {
        Assert.assertEquals(empty, empty);
        Assert.assertEquals(single, new BinaryTree<>(2));
        Assert.assertNotEquals(t1,t2);

        BinaryTree<Integer>  pbt1 = new BinaryTree<>(20);
        BinaryTree<Integer>  pbt2 = new BinaryTree<>(20);

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