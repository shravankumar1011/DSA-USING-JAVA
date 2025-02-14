import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>();
        
        for (int i = 1; i < 100; i++) {
            a1.add(i);
        }

        int num = 50;
        for (int i = 1; i < a1.size(); i++) {
            if (a1.get(i)==num) {
                System.out.println(i);
                System.out.println(a1);
                
            }
        }
    }
}
