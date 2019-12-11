package collections;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.
public class OptionalTask6 {
    public static void main(String[] args) throws IOException {
        final String PACKAGE = "src/main/java/";
        final String EXT = ".txt";
        try (FileReader fileReader = new FileReader(PACKAGE + "in" + EXT)) {
            Scanner sc = new Scanner(fileReader);
            List<String> list = new ArrayList<String>();
            while (sc.hasNext()) {
                String lineNext = sc.nextLine();
                list.add(lineNext);
            }
            list.sort(Comparator.comparing(String::length).reversed());
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i));
            }
        }
    }
}
