package edu.neu.ccs.cs5004.fakes;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

import edu.neu.ccs.cs5004.view.ConsoleReader;

public class FakeConsoleReader extends ConsoleReader {
  private String lastPromptMessage;
  private ArrayList<String> fakeResponses;

  public FakeConsoleReader() {
    super();
    fakeResponses = new ArrayList<String>();
  }

  public String prompt(String message) {
    Assert.assertFalse(this.fakeResponses.isEmpty());
    this.lastPromptMessage = message;
    String resp = fakeResponses.get(0);
    this.fakeResponses.remove(0);
    return resp;
  }

  public String getLastPromptMessage() {
    return this.lastPromptMessage;
  }

  public void injectPromptResponseSequence(String[] fakeResp) {
    this.fakeResponses = new ArrayList<String>(Arrays.asList(fakeResp));
  }

  public boolean usedAllFakeResponses() {
    return this.fakeResponses.isEmpty();
  }
}