package edu.neu.ccs.cs5004.assignment9;

/**
 * invalid input exception.
 */
public class InvalidInputException extends RuntimeException {
  /**
   * construct invalid input exception.
   * @param message to be displayed
   */
  public InvalidInputException(String message) {
    super(message);
  }
}
