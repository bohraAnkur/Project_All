package edu.neu.ccs.cs5004.assignment9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * write to file.
 */
public class FileWriter {
  /**
   * write message to destDir.
   * @param message to be written
   * @param destDir target dir
   * @param fileName file name
   */
  public static void write(List<String> message, String destDir, String fileName) {
    // System.out.println(fileName);
    File file = new File(destDir + File.separator + fileName);
    /*If file gets created then the createNewFile()
     * method would return true or if the file is
     * already present it would return false
     */
    boolean fvar = false;
    try {
      fvar = file.createNewFile();

      if (!fvar) {
        System.out.println("new file existed in target dir. replaced.");
      }

      BufferedWriter bufferWriter = new BufferedWriter(
          new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

      message.stream().forEach(line -> {
        try {
          bufferWriter.write(line + "\n");
        } catch (IOException e) {
          e.printStackTrace();
          System.exit(1);
        }
      });

      bufferWriter.close();

    } catch (IOException ioe) {
      System.out.println("File writing error.");
      ioe.printStackTrace();
      System.exit(1);
    }

  }
}
