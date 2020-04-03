package edu.neu.ccs.cs5004.fakes;

import java.util.Random;

public class FakeRandom extends Random {
  private int[] fakeOutputSequence;
  private int callCount = 0;
  public int nextInt(int bounds) {
    if (this.callCount >= fakeOutputSequence.length) {
      return 0;
    }
    return fakeOutputSequence[this.callCount++];
  }
  public void setFakeRandomOutputSequence(int[] fakeOutputSequence) {
    this.fakeOutputSequence = fakeOutputSequence;
  }
  public boolean receivedUnexpectedCalls() {
    return this.callCount > fakeOutputSequence.length;
  }
}