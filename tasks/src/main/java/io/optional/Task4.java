package io.optional;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
      List<String> listOfWords = new ArrayList<>();
      while (sc.hasNext()) {
        String wordNext = sc.next();
        if (wordNext.length() > 2) {
          listOfWords.add(wordNext.toUpperCase() + " ");
        } else {
          listOfWords.add(wordNext + " ");
        }
      }
      for (String word : listOfWords) {
        fileWriter.write(word);
      }
    }
    fileWriter.close();

  }
}
