package taf.product.yandex.disk.service;

import java.util.Random;
import taf.product.yandex.disk.model.Folder;

public class FolderFactory {
  private static final int RANDOM_NUMBER_BOUND = 100;

  public static Folder generateFolderName() {
    Random random = new Random();
    Folder newFolder = new Folder();
    newFolder.setName("folder_" + random.nextInt(RANDOM_NUMBER_BOUND));
    return new Folder(newFolder.getName());
  }
}
