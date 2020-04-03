package edu.neu.ccs.cs5004.problem1;

import java.util.Objects;

/**
 * Concrete class for the list node.
 *
 * @param <X> the object type
 */
public class ListNode<X> implements ListNodeInterface<X> {
  private X element;
  private ListNode next;

  /**
   * Constructor for the list node.
   *
   * @param element the current node element
   * @param next    the next linked node
   */
  public ListNode(X element, ListNode next) {
    this.element = element;
    this.next = next;
  }

  @Override
  public X getElement() {
    return this.element;
  }

  @Override
  public ListNode getNext() {
    return this.next;
  }

  @Override
  public void setElement(X newElement) {
    this.element = newElement;
  }

  @Override
  public void setNext(ListNode nextNode) {
    this.next = nextNode;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ListNode<?> that = (ListNode<?>) obj;
    return (this.getElement().equals(that.getElement()));
  }

  @Override
  public int hashCode() {

    return Objects.hash(getElement(), getNext());
  }
}
