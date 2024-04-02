package de.openvalue.workshop.openrevrite;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  @Test
  public void testCopyFile() throws IOException {
    File directory = folder.newFolder();
    File original = folder.newFile();
    String fileName = "test.txt";

    FileUtils.copyFile(original, directory, fileName);

    Assert.assertTrue(new File(directory, fileName).exists());
  }

}