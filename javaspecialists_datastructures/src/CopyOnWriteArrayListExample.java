import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {
        List<String> names = new CopyOnWriteArrayList<>(Arrays.asList("John", "Anton", "Heinz"));
        names.forEach(name -> {
            System.out.printf("Checking %s%n", name);
            if (name.contains("o")) {
                names.remove(name);
            }
        });

        System.out.println("names = " + names);
        for (Iterator<String> iterator = names.iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            
        }
    }
}
