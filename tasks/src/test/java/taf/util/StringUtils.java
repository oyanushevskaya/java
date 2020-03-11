package taf.util;

import java.util.Random;

public class StringUtils {
  public final static String VALID_LOGIN = "training.test.login";
  public final static String VALID_PASSWORD = "training.test.password";

  public final static String DOCUMENT_BODY_TEXT = "Hello world!!!";
  public final static String DOCUMENT_NAME = "Hello world";

  public final static String NEWEST_LINK = "https://disk.yandex.com/client/recent";
  public final static String FILES_LINK = "https://disk.yandex.com/client/disk";
  public final static String PHOTO_LINK = "https://disk.yandex.com/client/photo";
  public final static String PUBLISHED_LINK = "https://disk.yandex.com/client/shared";
  public final static String HISTORY_LINK = "https://disk.yandex.com/client/journal";
  public final static String ARCHIVE_LINK = "https://disk.yandex.com/client/attach";
  public final static String TRASH_LINK = "https://disk.yandex.com/client/trash";

  public String generateFolderName() {
    int randomNumberBound = 100;
    Random random = new Random();
    return "folder_" + random.nextInt(randomNumberBound);
  }

}
