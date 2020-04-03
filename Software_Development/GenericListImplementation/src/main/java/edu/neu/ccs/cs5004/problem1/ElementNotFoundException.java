package edu.neu.ccs.cs5004.problem1;

/**
 * Exception thrown when the given element is not contained in the list.
 */
public class ElementNotFoundException extends RuntimeException {

  /**
   * The message shown when the exception is thrown.
   */
  private static final String ELEMENT_NOT_FOUND_MSG
      = "The given element is not contained in this list";

  /**
   * Constructor for the exception.
   */
  public ElementNotFoundException() {
    super(ELEMENT_NOT_FOUND_MSG);
  }
}
