package io.optional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

// 1.Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
public class Task1 {
  public static void main(String[] args) throws IOException {
    final String PACKAGE = "data/";
    final String EXT = ".txt";
    File file = new File(PACKAGE + "numbers" + EXT);

    Random random = new Random();
    List<Integer> randomNumbers = new ArrayList<>();
    try (FileWriter fileWriter = new FileWriter(file)) {
      for (int i = 0; i < 20; i++) {
        randomNumbers.add(random.nextInt(10000));
        randomNumbers.sort(Comparator.comparing(Integer::intValue));
      }
      fileWriter.write(String.valueOf(randomNumbers));
    }
  }
}
