package Hi_1043;

import java.util.Scanner;

/**
 * Created by Jason on 2016/4/13.
 */
public class CompletePack {

    public static int getMaxValue(int[] costs,int[] values,int m) {
        int n = costs.length;
        int[] f = new int[m+1];
        for (int i=0;i<n;i++) {
            for (int j=costs[i];j<=m;j++) {
                f[j] = Math.max(f[j],f[j-costs[i]]+values[i]);
            }
        }
        return f[m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] costs = new int[n];
        int[] values = new int[n];
        for (int i=0;i<n;i++) {
            costs[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        System.out.println(getMaxValue(costs,values,m));
    }

}
