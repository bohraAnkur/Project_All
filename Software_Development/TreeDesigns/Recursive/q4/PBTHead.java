package q4;

public class PBTHead<N> implements PBT<N> {

  private Node<N> root;

  public PBTHead(N value) {
    this.root = new Node<N>(value);
  }

  @Override
  public Integer edgesToRoot(N value) {
    if (root.contains(value)) {
      return root.edgesToRoot(value);
    } else {
      throw new PBTInvalidRequestException("Value passed must be in PBT");
    }
  }

  @Override
  public void add(N value) {
    if (root.contains(value)) {
      return;
    }

    if (root == null) {
      root = new Node<N>(value, null, null, null);
    } else if (root.isEmpty()) {
      root.setVal(value);
    } else {
      root.add(value);
    }
  }

  @Override
  public void remove(N value) {
    if (!root.contains(value)) {
      return;
    }

    if (root == null || root.isEmpty()) {
      return;
    } else if (root.getVal().equals(value)) { // removing value at root
      Node<N> left = root.getRight();
      Node<N> right = root.getLeft();
      left.setParent(null);
      left.addToRightMost(right);
    } else {
      root.remove(value);
    }
  }

  public Node<N> getRoot() {
    return root;
  }

  public void setRoot(Node<N> root) {
    this.root = root;
  }

}

