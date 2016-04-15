package Hi_1066;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jason on 2016/4/15.
 */
public class UnionFind2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String,String> relations = new HashMap<String, String>();
        while (n-->0) {
            int flag = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            if (flag==0) {
                String father1 = find(relations,s1);
                String father2 = find(relations,s2);
                if (!father1.equals(father2)) {
                    relations.put(father2,father1);
                }
            } else {
                String result = getRelation(relations,s1,s2);
                System.out.println(result);
            }
        }
        sc.close();
    }

    private static String getRelation(HashMap<String, String> relations, String s1, String s2) {
        String father1 = find(relations,s1);
        String father2 = find(relations,s2);
        if (father1.equals(father2)) {
            return "yes";
        } else {
            return "no";
        }
    }

    private static String find(HashMap<String, String> relations, String s1) {
        String father = s1;
        if (relations.get(father)==null) {
            relations.put(father,father);
        }
        while (!relations.get(father).equals(father)) {
            father = relations.get(father);
        }
        return father;
    }

}
