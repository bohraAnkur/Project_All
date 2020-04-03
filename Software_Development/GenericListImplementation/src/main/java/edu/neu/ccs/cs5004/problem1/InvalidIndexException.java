package edu.neu.ccs.cs5004.problem1;

/**
 * Exception thrown when the given index is outside the bounds of a list.
 */
public class InvalidIndexException extends RuntimeException  {

  /**
   * The message shown when the exception is thrown.
   */
  private static final String INDEX_EXCEPTION_MSG = "Index is outside of the bounds of the list.";

  /**
   * Constructor for the exception.
   */
  public InvalidIndexException() {
    super(INDEX_EXCEPTION_MSG);
  }
}
