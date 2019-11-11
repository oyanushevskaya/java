package collectionsOptionalTask;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
public class OptionalTask1 {
    public static void main(String[] args) throws IOException {
        final String PACKAGE = "src/main/java/";
        final String EXT = ".txt";
        FileReader fileReader = new FileReader(PACKAGE + "in" + EXT);
        FileWriter fileWriter = new FileWriter(PACKAGE + "out" + EXT);
        Scanner sc = new Scanner(fileReader);
        List<String> list = new ArrayList<String>();
        while (sc.hasNext()) {
            String lineNext = sc.nextLine();
            list.add(lineNext);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            fileWriter.write(list.get(i) + "\n");
        }
        fileReader.close();
        fileWriter.close();
    }
}
