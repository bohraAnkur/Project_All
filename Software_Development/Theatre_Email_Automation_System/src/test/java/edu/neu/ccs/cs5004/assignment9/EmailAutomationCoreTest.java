package edu.neu.ccs.cs5004.assignment9;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class EmailAutomationCoreTest {

  EmailAutomationCore core;
  String[] argsStandard;
  String[] argsWithEmail;
  String[] argsWithLetter;

  @Before
  public void setUp() throws Exception {

    argsStandard = new String[4];
    argsStandard[0] = "--output-dir";
    argsStandard[1] = "results";
    argsStandard[2] = "--csv-file";
    argsStandard[3] = "theater-company-members.csv";

    argsWithEmail = new String[7];
    argsWithEmail[0] = "--output-dir";
    argsWithEmail[1] = "results";
    argsWithEmail[2] = "--csv-file";
    argsWithEmail[3] = "theater-company-members.csv";
    argsWithEmail[4] = "--email";
    argsWithEmail[5] = "--email-template";
    argsWithEmail[6] = "default-email-template.txt";

    argsWithLetter = new String[10];
    argsWithLetter[0] = "--output-dir";
    argsWithLetter[1] = "results";
    argsWithLetter[2] = "--csv-file";
    argsWithLetter[3] = "theater-company-members.csv";
    argsWithLetter[4] = "--email";
    argsWithLetter[5] = "--email-template";
    argsWithLetter[6] = "default-email-template.txt";
    argsWithLetter[7] = "--letter";
    argsWithLetter[8] = "--letter-template";
    argsWithLetter[9] = "letter-template.txt";

  }

  @Test
  public void process() {
    core = new EmailAutomationCore(argsStandard);
    //core.process();
    core = new EmailAutomationCore(argsWithEmail);
    core.process();

    core = new EmailAutomationCore(argsWithLetter);
    //core.process();

  }
}