/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}};
        int arr1[][] = {{1, 2, 3}, {4, 5, 6}};
        
        
        int rows = arr.length;
        int cols = arr[0].length;

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                System.out.println(arr[i][j] + arr1[i][j]);
            }
        }
    }
}