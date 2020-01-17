package io.optional;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
public class Task2 {
  public static void main(String[] args) throws IOException {
    final String PACKAGE = "data/";
    final String EXT = ".txt";

    FileWriter fileWriter;
    try (FileReader fileReader = new FileReader(PACKAGE + "programText" + EXT)) {
      fileWriter = new FileWriter(PACKAGE + "modifiedProgram" + EXT);
      Scanner sc = new Scanner(fileReader);
      List<String> listOfLines = new ArrayList<>();
      while (sc.hasNext()) {
        String lineNext = sc.nextLine();
        listOfLines.add(lineNext + "\n");
      }
      for (String word : listOfLines) {
        fileWriter.write(word.replace("public", "private"));
      }
    }
    fileWriter.close();
  }
}
