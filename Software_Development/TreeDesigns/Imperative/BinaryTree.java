// Class BinaryTree implements BinaryTreeInterface  and prints a binary tree of
// objects of type E.
// null data is not allowed

import java.util.Objects;

public class BinaryTree<E>  implements PBT<E> {
    private Node root; // root of overall tree

    // post: constructs an empty tree
    public BinaryTree() {}

    // post: constructs a tree that contains a node
    // pre: value cannot be null
    //actually pretty useless, since you can just add to an empty tree, but this one is instead static factory in the interface
    public BinaryTree(E value) {
        root = new Node(value);
    }

    // post: value added to tree so as to preserve balanced tree
    //pre: value cannot be null
    // does nothing if the value is inside the tree already
    public void add(E value) {
        if (contains(value)) {
            return;
        }

        root = add(root, value, null);
    }
     //helper method
    // post: value added to tree so as to preserve binary search tree
    private Node add(Node root, E value, Node parent) {
        if (root == null) {
            root = new Node(value);
            root.parent = parent;
        } else if (numberOfNodes(root.right) > numberOfNodes(root.left)) {
            root.left = add(root.left, value,root);
        } else {
            root.right = add(root.right, value,root);
       }
        return root;
    }

    // post: value removed from the tree and the tree is adjusted
    // does nothing if the value is not inside the tree
    public void remove(E value) {
        if (!contains(value)) {
            return;
        }

        root = remove(root, value);
    }

    //helper method
    // post: value removed from the tree and the tree is adjusted
    private Node remove(Node root, E value) {
        if (root != null) {
            if (root.data.equals(value)) {
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.right == null) {
                    root.left.parent = root.parent;
                    return root.left;
                } else if (root.left == null) {
                    root.right.parent = root.parent;
                    return root.right;
                }

                root.data = root.right.data;
                root.right = remove(root.right, root.data);
            }
            else {
                root.right = remove(root.right, value);
                root.left  = remove(root.left, value);
            }
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(root, value);
    }

    //helper method
    // post: returns true if given tree contains value, returns false otherwise
   private boolean contains(Node root, E value) {
        if (root == null) {
            return false;
        } else {
            return root.data.equals(value) ||contains(root.right, value) || contains(root.left, value);
        }
    }

    // post: returns number of nodes in the tree
    public int numberOfNodes() {
        return numberOfNodes(root);
    }

    //helper method
    // post: returns number of nodes in the tree
    private int numberOfNodes(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + numberOfNodes(root.left) + numberOfNodes(root.right);

        }

    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        BinaryTree<E> second = (BinaryTree<E>) other;
        return compareTrees(root,second.root);
    }


    private boolean compareTrees(Node nodeFirst, Node nodeSecond)
    {
        if (nodeFirst == null || nodeSecond == null)
            return nodeFirst == nodeSecond;  // both must be null

        return nodeFirst.data.equals(nodeSecond.data)&& compareTrees(nodeFirst.left, nodeSecond.left) && compareTrees(nodeFirst.right, nodeSecond.right);
    }
    @Override
    public int hashCode() {
        int res = 0 ;
        if (root == null) return res;
        res = root.data.hashCode(); //assuming data cannot be null
        if(root.right!= null) { res += 31*root.right.hashCode(); }
        if(root.left!= null) { res += 31*31*root.left.hashCode(); }
        return res;
    }


  /*  private static class Node<E> {
        public E data;                   // data stored in this node
        public Node<E> left;   // left subtree
        public Node<E> right;  //  right subtree
        public Node<E> parent; // parent node

        // post: constructs a leaf node with given data
        public Node(E data) {
            this(data, null, null,null);
        }

        // post: constructs a node with the given data and links
        public Node(E data, Node<E> left, Node<E> right, Node<E> parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }*/
    public void printSideways() {
      printSideways(root, 0);
  }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(Node root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

    public void printSidewaysParent() {
        printSidewaysParent(root, 0);
    }

    // post: prints in reversed preorder the node parents with given
    //       root, indenting each line to the given level
    private void printSidewaysParent(Node root, int level) {
        if (root!= null){
            printSidewaysParent(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            if (root.parent!=null) {
                System.out.println(root.parent.data);
            }
            else {
                System.out.println();
            }
            printSidewaysParent(root.left, level + 1);
        }
    }

    private class Node {
        public E data;                   // data stored in this node
        public Node left;   // left subtree
        public Node right;  //  right subtree
        public Node parent; // parent node
        // post: constructs a leaf node with given data
        public Node(E data) {
            this(data, null, null, null);
        }

        // post: constructs a node with the given data and links
        public Node(E data, Node left,Node right,Node parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }


        public String toString() {
            return data.toString();
        }
    }



}
