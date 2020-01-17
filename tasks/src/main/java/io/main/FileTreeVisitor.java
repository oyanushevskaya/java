package io.main;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class FileTreeVisitor extends SimpleFileVisitor<Path> {
  private String fileVisitResult = "";

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
    fileVisitResult = fileVisitResult + "  |---" + dir.getFileName() + "\n";
    return CONTINUE;
  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
    fileVisitResult = fileVisitResult + "  |  " + file.getFileName() + "\n";
    return CONTINUE;
  }

  @Override
  public String toString() {
    return fileVisitResult;
  }
}
