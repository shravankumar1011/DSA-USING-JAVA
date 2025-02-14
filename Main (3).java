/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> names = new ArrayList<>();
        for (int i = 0; i < 10; i++) { 
            names.add(i + 1);
        }
        System.out.println(names);
    }
}