package edu.neu.ccs.cs5004.assignment8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void toStringT() {
    Id id = new Id(44);
    String str = "Id{id=44}";
    Assert.assertEquals(id.toString(), str);
  }
}