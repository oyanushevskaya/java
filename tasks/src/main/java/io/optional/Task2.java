package io.optional;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
      String text = "";
      while (sc.hasNext()) {
        text = text.concat(sc.nextLine().replace("public", "private") + "\n");
      }
      fileWriter.write(text);
    }
    fileWriter.close();
  }
}
