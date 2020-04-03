package edu.neu.ccs.cs5004.problem1;

import java.util.Objects;

/**
 * Abstract class for the linked list.
 *
 * @param <X> the object type
 */
public abstract class AbstractLinkedList<X> implements LinkedListInterface<X> {
  protected ListNode<X> front;

  public AbstractLinkedList() {
    front = null;
  }

  public ListNode<X> getFront() {
    return front;
  }

  /**
   * Checks that the given index is within the bounds of a list.
   *
   * @param index the given index
   * @return true if the index is within the list, false otherwise
   */
  protected boolean isValidIndex(int index) {
    if (0 <= index && index <= this.size() - 1) {
      return true;
    }
    return false;
  }

  protected void removeFirst() {
    if (this.front == null) {
      return;
    } else {
      if (this.size() == 1) {
        this.front = null;
      } else {
        this.front = front.getNext();
      }
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractLinkedList<?> that = (AbstractLinkedList<?>) obj;
    if (!((that.size()) == this.size())) {
      return false;
    } else {
      ListNode thisCurrent = this.front;
      ListNode thatCurrent = that.front;
      while (thisCurrent.getNext() != null) {
        if (!thisCurrent.equals(thatCurrent)) {
          return false;
        }
        thisCurrent = thisCurrent.getNext();
        thatCurrent = thatCurrent.getNext();
      }
      return true;
    }
  }

  @Override
  public int hashCode() {

    return Objects.hash(front);
  }

  protected String printList() {
    StringBuilder newString = new StringBuilder("");
    ListNode<X> current = front;
    while (current != null) {
      newString.append(current.getElement() + "\n");
      current = current.getNext();
    }
    return newString.toString();
  }
}
