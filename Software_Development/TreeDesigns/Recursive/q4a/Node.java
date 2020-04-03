package q4a;

import java.util.Objects;

/**
 * Created by therapon on 8/18/16.
 */
public class Node<X> {

  private X val;

  private Node<X> left;
  private Node<X> right;
  private Node<X> parent;

  public Node(X val, Node<X> left, Node<X> right, Node<X> parent) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.parent = parent;
  }


  public boolean contains(X value) {
    return this.val.equals(value)
        || (this.right == null ? false : this.right.contains(value))
        || (this.left == null ? false : this.left.contains(value));
  }

  public boolean isEmpty() {
    return this.val == null
        && this.left == null
        && this.right == null
        && this.parent == null;
  }

  // requires: this.contains(value) == true
  public Integer getNumberOfEdgesToRoot(X value) {
    if (this.val.equals(value)) {
      return this.countParentEdges();
    } else if (!isEmptyRight() && this.right.contains(value)) {
      return this.right.getNumberOfEdgesToRoot(value);
    } else {
      return this.left.getNumberOfEdgesToRoot(value);
    }
  }

  private Integer countParentEdges() {
    return parent == null ? 0 : 1 + this.parent.countParentEdges();
  }

  private boolean isEmptyRight() {
    return this.right == null;
  }

  public void addNewNode(X value, Node<X> parent) {
    if (val == null) {
      this.val = value;
      this.parent = parent;
    } else if (isEmptyRight()) {
      this.right = new Node<>(value, null, null, this);
    } else if (isEmptyLeft()) {
      this.left = new Node<>(value, null, null, this);
    } else if (this.left.countNodes() < this.right.countNodes()) {
      this.left.addNewNode(val, this);
    } else {
      this.right.addNewNode(value, this);
    }
  }

  private Integer countNodes() {
    if (isEmptyLeft() && isEmptyRight()) {
      return 1;
    } else if (isEmptyLeft() && !isEmptyRight()) {
      return 1 + this.right.countNodes();
    } else if (!isEmptyLeft() && isEmptyRight()) {
      return 1 + this.left.countNodes();
    } else {
      return 1 + this.left.countNodes() + this.right.countNodes();
    }
  }

  public boolean isEmptyLeft() {
    return this.left == null;
  }

  // required: !this.isEmpty() && this.contains(value)
  public void removeValue(X value, Node<X> newParent) {
    if (this.val.equals(value)) {
      removeThisNode(newParent);
    } else if (!isEmptyLeft() && this.left.contains(value) ){
      this.left.removeValue(value, this);
    } else if (!isEmptyRight() && this.right.contains(value)) {
      this.right.removeValue(value, this);
    }
}

  private void removeThisNode(Node<X> newParent) {
    if (isLeaf()) {
      removeLeafNode(newParent);
    } else if (isEmptyLeft() && !isEmptyRight()) {
      this.right.setParent(newParent);
      updateParent(newParent, this.right);
    } else if (!isEmptyLeft() && isEmptyRight()) {
      this.left.setParent(newParent);
      updateParent(newParent, this.left);
    } else {
      this.left.setParent(newParent);
      updateParent(newParent, this.left);
      this.left.addToRightMost(this.right);
    }
  }

  private void removeLeafNode(Node<X> newParent) {
    updateParent(newParent, null);
    this.setVal(null);
    this.setParent(null);
  }

  private void updateParent(Node<X> newParent, Node<X> newChild) {
    if (newParent == null) {
      return;
    } else if (newParent.isEmptyLeft()) {
      newParent.setRight(newChild);
    } else if (newParent.isEmptyRight()) {
      newParent.setLeft(newChild);
    } else if (newParent.getLeft().getVal().equals(this.val)) {
      newParent.setLeft(newChild);
    } else {
      newParent.setRight(newChild);
    }
  }


  private void addToRightMost(Node<X> tree) {
    Node<X> current = this;

    while (current.right != null) {
      current = current.right;
    }

    tree.setParent(current);
    current.right = tree;
  }


  public X getVal() {
    return val;
  }

  public void setVal(X val) {
    this.val = val;
  }

  public Node<X> getLeft() {
    return left;
  }

  public void setLeft(Node<X> left) {
    this.left = left;
  }

  public Node<X> getRight() {
    return right;
  }

  public void setRight(Node<X> right) {
    this.right = right;
  }

  public Node<X> getParent() {
    return parent;
  }

  public void setParent(Node<X> parent) {
    this.parent = parent;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    Node<?> node = (Node<?>) other;
    return Objects.equals(val, node.val)
        && Objects.equals(left, node.left)
        && Objects.equals(right, node.right)
        && parentsEqual(this.parent, node.getParent());
  }

  private boolean parentsEqual(Node<X> parent, Node<?> otherParent) {
    if (parent == otherParent) return true;
    if (parent == null && otherParent != null) return false;
    if (parent != null && otherParent == null) return false;
    return parent.getVal().equals(otherParent.getVal());
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, left, right, parent);
  }

  @Override
  public String toString() {
    return "Node{"
        + "val=" + (val == null ? "null" : val.toString())
        + ", left=" + (left == null ? "null" : left.toString())
        + ", right=" + (right == null ? "null" : right.toString())
        + ", parent=" + (parent == null ? "null" : parent.getVal().toString())
        + '}';
  }

  public boolean isLeaf() {
    return isEmptyLeft() && isEmptyRight() && val != null;
  }
}
