import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> userPermissions = Arrays.asList("p1", "p2", "p3");
        List<String> permissions = Arrays.asList("p1", "p3", "p4");

        List<String> result = new ArrayList<>(userPermissions);

//        result.removeAll(permissions);
        result.removeAll(permissions);
        System.out.println("result = " + result);
    }

}
