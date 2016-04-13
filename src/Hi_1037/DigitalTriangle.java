package Hi_1037;

import java.util.Scanner;

/**
 * Created by Jason on 2016/4/13.
 */
public class DigitalTriangle {

    public static int getMaxValue(int[][] values,int size) {
        int maxValue = 0;
        int[][] best = new int[size][size];
        best[0][0] = values[0][0];
        for (int i=1;i<size;i++) {
            for (int j=0;j<=i;j++) {
                if (j==0) {
                    best[i][j] = best[i-1][j] + values[i][j];
                } else if (j==i) {
                    best[i][j] = best[i-1][j-1] + values[i][j];
                } else {
                    best[i][j] = Math.max(best[i-1][j-1],best[i-1][j]) + values[i][j];
                }
            }
        }
        for (int i=0;i<size;i++) {
            if (best[size-1][i]>maxValue) {
                maxValue = best[size-1][i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        for (int i=0;i<size;i++) {
            for (int j=0;j<=i;j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(getMaxValue(matrix,size));
    }

}
