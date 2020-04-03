package q4a;


import java.util.Objects;

import q4.PBTInvalidRequestException;

public class PBTHead<N> implements PBT<N> {

  private Node<N> root;

  public PBTHead(N val) {
    this.root = new Node<>(val, null, null, null);
  }

  @Override
  public Integer edgesToRoot(N value) {
    if (noTree() || root.isEmpty()) {
      throw new PBTInvalidRequestException("Empty PBT");
    } else if (root.contains(value)) {
      return root.getNumberOfEdgesToRoot(value);
    } else {
      throw new PBTInvalidRequestException("PBT must contain value");
    }
  }

  private boolean noTree() {
    return root == null;
  }

  @Override
  public void add(N value) {
    if (noTree()) {
      root = new Node<>(value, null, null, null);
    } else if (root.contains(value)) {
      return;
    } else {
      root.addNewNode(value, null);
    }
  }

  @Override
  public void remove(N value) {
    if (noTree() || root.isEmpty() ||  !root.contains(value)) {
      return;
    } else {
      root.removeValue(value, null);
    }
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    PBTHead<?> pbtHead = (PBTHead<?>) other;
    return Objects.equals(root, pbtHead.root);
  }

  @Override
  public int hashCode() {
    return Objects.hash(root);
  }

  @Override
  public String toString() {
    return "PBTHead{"
        + "root=" + (root == null ? "null" : root.toString())
        + '}';
  }
}
