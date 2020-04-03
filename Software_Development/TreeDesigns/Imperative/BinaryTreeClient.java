// This program uses the SearchTree class to construct a binary
// search tree of strings and a binary search tree of integers
// and printing out each.

import java.util.*;

public class BinaryTreeClient {
    public static void main(String[] args) {
        Random rand = new Random();
        BinaryTree<Integer> nums = new BinaryTree<Integer>(1);
        List<Integer>list = new ArrayList<>();
        list =Arrays.asList(1,42,33,22,50,22,3,4,5);
        for (int i = 1; i < list.size(); i++) {
            //int curNum= rand.nextInt(100);
            nums.add(list.get(i));
           // list.add(curNum);

        }


        System.out.println("my List " + list);
        System.out.println("The tree: ");
        nums.printSideways();
        System.out.println("The Parents: ");
        nums.printSidewaysParent();
       int treeSize = nums.numberOfNodes();
  //      for (int i = treeSize; i >=9; i-- ){
          //  int curInd = rand.nextInt(2);
            System.out.println("Number to remove " + list.get(2));
            nums.remove(list.get(2));
        System.out.println("The tree: ");
            nums.printSideways();
        System.out.println("The Parents: ");
        nums.printSidewaysParent();
        System.out.println("Number to remove " + list.get(0));
        nums.remove(list.get(0));
        System.out.println("The tree: ");
        nums.printSideways();
        System.out.println("The Parents: ");
        nums.printSidewaysParent();

        //  }
    }
}
