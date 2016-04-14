package Hi_1044;

import java.util.Scanner;

/**
 * Created by Jason on 2016/4/14.
 */
public class StateCompackOne {

    public static int getCount(int i) {
        int count = 0;
        while (i!=0) {
            if ((i&1)==1) {
                count++;
            }
            i>>=1;
        }
        return count;
    }

    public static int getMaxValue(int n,int m,int q,int[] array) {
        int maxValue = 0;
        int[][] values = new int[n+1][1<<m];
        for (int i=1;i<=n;i++) {
            for (int j=0;j<(1<<Math.min(i,m));j++) {
                if (getCount(j)>q) {
                    continue;
                }
                values[i][j] = Math.max(values[i-1][j>>1], values[i-1][(j>>1) + (1<<m-1)]);
                if ((j&1)==1) {  //index i is chosed
                    values[i][j] += array[i];
                }
            }
        }
        for (int i=0;i<(1<<Math.min(m,n));i++) {
            maxValue = Math.max(maxValue,values[n][i]);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[] array = new int[n+1];
        for (int i=1;i<=n;i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(getMaxValue(n,m,q,array));
    }

}
