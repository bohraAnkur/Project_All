package edu.neu.ccs.cs5004.problem1;

public class LinkedList<X> extends AbstractLinkedList<X> {

  public LinkedList() {
    super();
  }

  /**
   * Time Complexity.
   * best case O(1)
   * worst case (O(n))
   */
  @Override
  public void add(X element) {
    if (this.front == null) {
      this.front = new ListNode(element, null);
    } else {
      ListNode<X> current = front;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(new ListNode(element, null));
    }
  }

  /**
   * Time Complexity.
   * best case O(1)
   * worst case (O(n))
   */
  @Override
  public void add(int index, X element) {
    int currentIndex = 0;
    ListNode<X> currentNode = this.front;
    ListNode<X> tempNode;
    if (index == 0) {
      tempNode = this.front;
      this.front = new ListNode<>(element, tempNode);
    } else {
      while (currentIndex != index - 1) {
        currentIndex++;
        currentNode = currentNode.getNext();
      }
      tempNode = currentNode.getNext();
      currentNode.setNext(new ListNode<X>(element, tempNode));
    }
  }

  /**
   * Time Complexity.
   * best case O(1)
   * worst case (O(n))
   */
  @Override
  public X get(int index) {
    if (isValidIndex(index)) {
      ListNode<X> current = front;
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
      return current.getElement();
    } else {
      throw new InvalidIndexException();
    }
  }

  /**
   * Time Complexity.
   * best case O(1)
   * worst case (O(n))
   */
  @Override
  public int indexOf(X element) {
    int index = 0;
    ListNode<X> current = front;
    while (current != null) {
      if (current.getElement().equals(element)) {
        return index;
      }
      index++;
      current = current.getNext();
    }
    throw new ElementNotFoundException();
  }

  /**
   * Time Complexity.
   * O(1)
   */
  @Override
  public boolean isEmpty() {
    return (this.front == null);
  }

  /**
   * Time Complexity.
   * best case O(1)
   * worst case (O(n))
   */
  @Override
  public void remove(int index) {
    int currentIndex = 0;
    ListNode<X> currentNode = this.front;

    if (0 > index || index > this.size() - 1) {
      throw new InvalidIndexException();
    } else if (index == 0) {
      removeFirst();
    } else {
      while (currentIndex != index - 1) {
        currentIndex++;
        currentNode = currentNode.getNext();
      }
      if (index == this.size() - 1) {
        currentNode.setNext(null);
      } else {
        currentNode.setNext(currentNode.getNext().getNext());
      }
    }
  }

  /**
   * Time Complexity.
   * best case O(1)
   * worst case (O(n))
   */
  @Override
  public int size() {
    int size = 0;
    ListNode<X> current = front;

    while (current != null) {
      size++;
      current = current.getNext();
    }
    return size;
  }

  /**
   * Time Complexity.
   * best case O(1)
   * worst case (O(n))
   */
  @Override
  public boolean contains(X element) {
    if (this.isEmpty()) {
      return false;
    }
    if (this.front.getElement().equals(element)) {
      return true;
    }
    ListNode<X> current = front;
    while (current.getNext() != null) {
      current = current.getNext();

      if (current.getElement().equals(element)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return printList();
  }

}
