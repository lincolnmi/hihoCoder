package Hi_1002;

import java.util.Scanner;

/**
 * Created by Jason on 2016/4/4.
 */
public class SubPalindromeStr {

    private static String addSpecialCharacter(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int size = str.length();
        for (int i=0;i<size;i++) {
            sb.append(str.charAt(i));
            if (i<size-1) {
                sb.append('#');
            }
        }
        return sb.toString();
    }

    public static int getPalindromeLength(String str) {
        String ss = addSpecialCharacter(str);
        int length = ss.length();
        //init value
        int[] value = new int[length];
        value[0] = 0;
        int maxLength = 1;
        //init id and mx
        int id = 0,mx = 0;
        for (int i=1;i<length;i++) {
            int r = 0;
            if (i>mx) {
                // mx < i, update value[i]
                r = 0;
            } else {
                // mx > i, check (mx-i) and value[2*id-i]
                r = Math.min(mx-i,value[2*id-i]);
            }
            while (i-r-1>=0&&i+r+1<length) {
                if (ss.charAt(i-r-1)==ss.charAt(i+r+1)) {
                    r++;
                } else {
                    break;
                }
            }
            value[i] = r;
            //update the id to make mx maximum
            if (value[i]+i>mx) {
                id = i;
                mx = value[i]+i;
            }

            if (maxLength < value[i] + 1) {
                maxLength = value[i] + 1;
                if (ss.charAt(i-value[i])=='#') {
                    maxLength--;
                }
            }
        }
        /*for (int i=0;i<length;i++) {
            System.out.print(value[i]+" ");
        }
        System.out.println();
        */
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        while (size-->0) {
            String str = sc.next();
            System.out.println(getPalindromeLength(str));
        }
    }

}
