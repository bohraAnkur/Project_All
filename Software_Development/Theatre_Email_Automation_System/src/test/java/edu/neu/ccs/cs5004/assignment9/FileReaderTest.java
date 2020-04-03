package edu.neu.ccs.cs5004.assignment9;

//import org.junit.Assert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.core.Is.is;


public class FileReaderTest {

  FileReader reader;
  @Before
  public void setUp() throws Exception {
    reader = new FileReader();
  }


  @Test
  public void testRead() throws java.io.FileNotFoundException {

  }
}