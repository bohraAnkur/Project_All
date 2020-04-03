package q4;

/**
 * Created by therapon on 8/14/16.
 */
public class Node<E> {

  private E val;
  private Node<E> parent;
  private Node<E> left;
  private Node<E> right;

  public Node(E val) {
    this.val = val;
    this.parent = null;
    this.left = null;
    this.right = null;
  }

  public Node(E val, Node<E> parent, Node<E> left, Node<E> right) {
    this.val = val;
    this.parent = parent;
    this.left = left;
    this.right = right;
  }


  public boolean isEmpty() {
    return parent == null && val == null && right == null && left == null;
  }

  public Integer edgesToRoot(E value) {
    if (!this.contains(value)) {
      throw new PBTInvalidRequestException("Tree does not contain: " + value);
    } else {
      return this.countEdgesToRoot(value);
    }
  }

  protected Integer countEdgesToRoot(E value) {
    if (this.val.equals(value)) {
      return countEdgesFromHereToRoot();
    } else {
      if (this.left != null && this.left.contains(value)) {
        return this.left.countEdgesToRoot(value);
      } else { // already know is in the tree, if not left then right
        return this.right.countEdgesToRoot(value);
      }
    }
  }


  protected Integer countEdgesFromHereToRoot() {
    Integer result = 0;
    Node<E> current = this;
    while (current != null) {
      result++;
      current = current.getParent();
    }
    return result;
  }


  public Integer totalNodesUnder() {
    Integer result = 1;
    if (this.left != null) {
      result += this.left.totalNodesUnder();
    }

    if (this.right != null) {
      result += this.right.totalNodesUnder();
    }
    return result;
  }


  public void add(E value) {
    if (this.left == null && this.right == null) {
      // pick left
      this.left = new Node<E>(value, this, null, null);
    } else if (this.left != null && this.right == null) {
      this.right = new Node<E>(value, this, null, null);
    } else if (this.left == null && this.right != null) {
      this.left = new Node<E>(value, this, null, null);
    } else {
      Integer leftTreeCount = this.left.totalNodesUnder();
      Integer rightTreeCount = this.right.totalNodesUnder();
      if (leftTreeCount <= rightTreeCount) {
        this.left.add(value);
      } else {
        this.right.add(value);
      }
    }
  }

  public void remove(E value) {
    if (this.val.equals(value)) {
      remove();
    } else if (this.left != null && this.left.contains(value)) {
      this.left.remove(value);
    } else { // tree contains and not in left, thus right
      this.right.remove(value);
    }
  }


  protected void remove() {
    if (this.left == null && this.right == null) { // leaf
        updateParent(null);
    } else {
      if (this.left == null) {
        updateParent(this.right);
        this.right.setParent(this.parent);
      } else if (this.right == null) {
        updateParent(this.left);
        this.left.setParent(this.parent);
      } else {
        updateParent(this.left);
        this.left.setParent(this.parent);
        this.left.addToRightMost(this.right);
      }
    }
  }


  private void updateParent(Node<E> right) {
    if (this.parent.left != null && this.parent.getLeft().getVal().equals(this.val)) {
      this.parent.setLeft(right);
    } else {
      this.parent.setRight(right);
    }
  }

  protected void addToRightMost(Node<E> subtree) {
    if (this.right == null) {
      this.right = subtree;
      subtree.setParent(this);
    } else {
      this.right.addToRightMost(subtree);
    }
  }


  public boolean contains(E value) {
    if (this.val.equals(value)) {
      return true;
    } else {
      return this.getLeft().contains(value) ||
          this.getRight().contains(value);
    }
  }


  public Node<E> getLeft() {
    return left;
  }

  public void setLeft(Node<E> left) {
    this.left = left;
  }

  public Node<E> getRight() {
    return right;
  }

  public void setRight(Node<E> right) {
    this.right = right;
  }

  public E getVal() {
    return val;
  }

  public void setVal(E val) {
    this.val = val;
  }

  public Node<E> getParent() {
    return parent;
  }

  public void setParent(Node<E> parent) {
    this.parent = parent;
  }

}