//Christopher Garcia
//intro to Algo.
//April 23, 2025

import java.util.Scanner;

public class DirectorUndirect {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        boolean isUndirect = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {

                    isUndirect = false;
                    break;

                }
            }
            if (!isUndirect) break;
        }

        if (isUndirect) {
            System.out.println("undirect");
        } else {
            System.out.println("Direc.");
        }

        scan.close();
    }
}
