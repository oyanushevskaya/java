package io.main;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner {
  public static void main(String[] args) throws IOException {
    Path path = Paths.get(args[0]);
    System.out.println(path.toAbsolutePath());

    if (path.toFile().isDirectory()) {
      FileService.writeFilesTree(path);
    }
    if (path.toFile().isFile()) {
      FileService.printFileInfo(path);
    }
    if (!path.toFile().isFile() && !path.toFile().isDirectory()) {
      throw new IllegalArgumentException("This file or directory not exist!");
    }
  }
}
