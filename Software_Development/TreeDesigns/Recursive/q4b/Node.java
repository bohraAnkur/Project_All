package q4b;

import java.util.Objects;

public class Node<N> {

  private Node<N> right;
  private Node<N> left;
  private N val;
  private Node<N> parent;

  public Node(N val, Node<N> left, Node<N> right, Node<N> parent) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.parent = parent;

  }


  public boolean isEmpty() {
    return this.val == null
        && this.left == null
        && this.right == null
        && this.parent == null;
  }

  public boolean contains(N value) {
    return (this.val == null ? false : this.val.equals(value))
        || (this.left == null ? false : this.left.contains(value))
        || (this.right == null ? false : this.right.contains(value));
  }

  // requires: this.contains(value) == true
  public Integer getNumberOfEdgesToRoot(N value) {
    if (this.val.equals(value)) {
      return this.countParentEdges();
    } else if (!isEmptyRight() && this.right.contains(value)) {
      return this.right.getNumberOfEdgesToRoot(value);
    } else {
      return this.left.getNumberOfEdgesToRoot(value);
    }
  }


  public boolean isEmptyLeft() {
    return this.left == null;
  }


  public boolean isEmptyRight() {
    return this.right == null;
  }

  private Integer countParentEdges() {
    return parent == null ? 0 : 1 + this.parent.countParentEdges();
  }


  public void addNewNode(N value, Node<N> parent) {
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

  // required: !this.isEmpty() && this.contains(value)
  public void removeValue(N value, Node<N> newParent) {
    if (this.val.equals(value)) {
      removeThisNode(newParent);
    } else if (!isEmptyLeft() && this.left.contains(value)) {
      this.left.removeValue(value, this);
    } else if (!isEmptyRight() && this.right.contains(value)) {
      this.right.removeValue(value, this);
    }
  }

  public boolean isLeaf() {
    return isEmptyLeft() && isEmptyRight() && val != null;
  }

  private void removeThisNode(Node<N> newParent) {
    if (isLeaf()) {
      removeLeafNode(newParent);
    } else if (isEmptyLeft() && !isEmptyRight()) {
      this.right.setParent(newParent);
      updateParent(newParent, this.right);
      nullify();
    } else if (!isEmptyLeft() && isEmptyRight()) {
      this.left.setParent(newParent);
      updateParent(newParent, this.left);
      nullify();
    } else {
      this.left.setParent(newParent);
      updateParent(newParent, this.left);
      this.left.addToRightMost(this.right);
      nullify();
    }
  }

  private void nullify() {
    this.val = null;
    this.left = null;
    this.right = null;
    this.parent = null;
  }

  private void removeLeafNode(Node<N> newParent) {
    updateParent(newParent, null);
    this.setVal(null);
    this.setParent(null);
  }

  private void updateParent(Node<N> newParent, Node<N> newChild) {
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


  public void addToRightMost(Node<N> tree) {
    Node<N> current = this;

    while (current.right != null) {
      current = current.right;
    }

    tree.setParent(current);
    current.right = tree;
  }


  /**
   * Getter for property 'right'.
   *
   * @return Value for property 'right'.
   */
  public Node<N> getRight() {
    return right;
  }

  /**
   * Setter for property 'right'.
   *
   * @param right Value to set for property 'right'.
   */
  public void setRight(Node<N> right) {
    this.right = right;
  }

  /**
   * Getter for property 'left'.
   *
   * @return Value for property 'left'.
   */
  public Node<N> getLeft() {
    return left;
  }

  /**
   * Setter for property 'left'.
   *
   * @param left Value to set for property 'left'.
   */
  public void setLeft(Node<N> left) {
    this.left = left;
  }

  /**
   * Getter for property 'val'.
   *
   * @return Value for property 'val'.
   */
  public N getVal() {
    return val;
  }

  /**
   * Setter for property 'val'.
   *
   * @param val Value to set for property 'val'.
   */
  public void setVal(N val) {
    this.val = val;
  }

  /**
   * Getter for property 'parent'.
   *
   * @return Value for property 'parent'.
   */
  public Node<N> getParent() {
    return parent;
  }

  /**
   * Setter for property 'parent'.
   *
   * @param parent Value to set for property 'parent'.
   */
  public void setParent(Node<N> parent) {
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

  private boolean parentsEqual(Node<N> parent, Node<?> otherParent) {
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


}
