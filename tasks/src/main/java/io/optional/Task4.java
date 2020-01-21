package io.optional;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// 4. Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.
public class Task4 {
  public static void main(String[] args) throws IOException {
    final String PACKAGE = "data/";
    final String EXT = ".txt";

    FileWriter fileWriter;
    try (FileReader fileReader = new FileReader(PACKAGE + "programText" + EXT)) {
      fileWriter = new FileWriter(PACKAGE + "modifiedText" + EXT);
      Scanner sc = new Scanner(fileReader);
      String text = "";
      while (sc.hasNext()) {
        String nextWord = sc.next();
        if (nextWord.length() > 2) {
          text = text.concat(nextWord.toUpperCase() + " ");
        } else {
          text = text.concat(nextWord + " ");
        }
      }
      fileWriter.write(text);
    }
    fileWriter.close();
  }
}
