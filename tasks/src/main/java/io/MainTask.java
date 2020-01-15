package io;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileTreeVisitor extends SimpleFileVisitor<Path> {

  static String fileVisitResult = "";

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
}

public class MainTask {

  private static void getInfoAboutFile(Path path) throws IOException {
    File file = path.toFile();

    int countFiles = 0;
    int countFolders = -1; //not count the main folder
    int nameFiles;
    int lengthNameFiles = 0;
    List<String> listOfLines = new ArrayList<>();
    List<String> listFiles = new ArrayList<>();

    try (FileReader reader = new FileReader(file)) {
      Scanner sc = new Scanner(reader);
      while (sc.hasNext()) {
        String lineNext = sc.nextLine();
        listOfLines.add(lineNext.replace("|", " ").replace("-", " ").trim());
        listOfLines.removeIf(line -> (line.length() == 0)); //remove empty lines
      }

      if (!listOfLines.isEmpty()) {
        for (String lines : listOfLines) {
          if (lines.matches(".+(\\.[a-z0-9]{2,4})$")) {  //find all expansion
            countFiles++;
            listFiles.add(lines); //if the file name matches regex then add files to the list
          } else {
            countFolders++;
          }
        }

        for (String listFile : listFiles) {
          nameFiles = listFile.lastIndexOf('.');
          lengthNameFiles += nameFiles;
        }

        int averageFileInFolder = countFiles / countFolders;
        int averageLengthName = lengthNameFiles / listFiles.size();

        System.out.println(
            String.format("Count files : %d %nCount folders : %d", countFiles, countFolders));
        System.out.println(String
            .format("Average files in folder : %d %nAverage file name : %d ", averageFileInFolder,
                averageLengthName));
      } else {
        throw new IllegalArgumentException("File is empty!");
      }
    }
  }

  private static void getFileTree(Path path) throws IOException {
    Files.walkFileTree(path, new FileTreeVisitor());
    String fileVisitResult = FileTreeVisitor.fileVisitResult;
    try (FileWriter fileWriter = new FileWriter("data/files.txt")) {
      fileWriter.write(fileVisitResult);
    }
  }

  public static void main(String[] args) throws IOException {
    Path path = Paths.get(args[0]);
    System.out.println(path.toAbsolutePath());
    if (path.toFile().isDirectory()) {
      getFileTree(path);
    }
    if (path.toFile().isFile()) {
      getInfoAboutFile(path);
    }
    if (!path.toFile().isFile() && !path.toFile().isDirectory()) {
      throw new IllegalArgumentException("This file or directory not exist!");
    }
  }
}
