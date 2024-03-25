package de.openvalue.openrevrite.workshop;

import java.io.*;
import java.util.Map;
import java.util.stream.Stream;

public class FileUtils {
  private FileUtils() {
  }

  public static boolean copyFile(File original, File directory, String newFileName) {
    if (!directory.isDirectory()) {
      throw new IllegalArgumentException("second parameter is not a directory");
    }

    boolean result = true;

    File copy = new File(directory, newFileName);
    try (InputStream in = new BufferedInputStream(new FileInputStream(original)); OutputStream out = new BufferedOutputStream(new FileOutputStream(copy))) {
      byte[] buffer = new byte[1024];
      int lengthRead;
      while ((lengthRead = in.read(buffer)) > 0) {
        out.write(buffer, 0, lengthRead);
        out.flush();
      }
    } catch (IOException e) {
      result = false;
    }
    return result;
  }
}
