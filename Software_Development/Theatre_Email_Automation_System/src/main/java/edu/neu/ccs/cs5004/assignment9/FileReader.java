package edu.neu.ccs.cs5004.assignment9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * read files.
 */
public class FileReader {

  /**
   * read a file, return a string array as output.
   * @param fileName of the file
   * @return string array
   */
  public static ArrayList<String> read(String fileName) {
    String line;
    ArrayList<String> result = new ArrayList<>();

    try (BufferedReader bufferReader = new BufferedReader(
        new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {

      while ((line = bufferReader.readLine()) != null) {
        result.add(line);
      }

    } catch (IOException ioe) {
      System.out.println("File reading error.");
      ioe.printStackTrace();
      System.exit(1);
    }

    return result;
  }
}
