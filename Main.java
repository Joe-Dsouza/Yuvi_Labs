import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter array size (for N x N array): ");
        int n = s.nextInt();
        int[][] grid = generateGrid(n);

        System.out.println();
        System.out.println("Generated 2D array:");
        printGrid(grid, -1); 

        System.out.print("Enter a number to highlight (even number 2-20): ");
        int highlight = s.nextInt();

        System.out.println();
        System.out.println("Array with " + highlight + " highlighted:");
        int count = printGrid(grid, highlight);   

        System.out.println();
        System.out.println("Number " + highlight + " appeared " + count + " times");

    }

    private static int[][] generateGrid(int n) {
        int[][] grid = new int[n][n];
        Random random = new Random();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                grid[row][col] = (random.nextInt(10) + 1) * 2;
            }
        }
        return grid;
    }
    private static int printGrid(int[][] grid, int highlightValue) {
        int n = grid.length;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = grid[row][col];
                String cell;

                if (highlightValue != -1 && value == highlightValue) {
                    cell = "[" + value + "]";
                    count++;
                } else {
                    cell = String.valueOf(value);
                }

                System.out.printf("%6s", cell);
            }
            System.out.println();
        }
        return count;
    }
}    
