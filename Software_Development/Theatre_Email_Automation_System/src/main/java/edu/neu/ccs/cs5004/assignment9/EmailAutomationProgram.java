package edu.neu.ccs.cs5004.assignment9;

/**
 * Theater Company Email and Letter Automation.
 */
public class EmailAutomationProgram {
  /**
   * email automation program.
   * @param args input args
   */
  public static void main(String[] args) {
    System.out.println("Program start.");
    EmailAutomationCore core = new EmailAutomationCore(args);
    System.out.println("Email automation core initialized.");
    core.process();
    System.out.println("Program ran successfully.");
  }
}
