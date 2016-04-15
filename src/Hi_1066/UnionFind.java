package Hi_1066;

import java.util.*;

/**
 * Created by Jason on 2016/4/15.
 * Time exceed
 */
public class UnionFind {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String,Set<String>> relations = new HashMap<String, Set<String>>();
        while (n-->0) {
            int flag = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            if (flag==0) {
                Set<String> friends1 = relations.get(s1);
                if (friends1==null) {
                    friends1 = new HashSet<String>();
                    friends1.add(s1);
                    relations.put(s1,friends1);
                }
                Set<String> friends2 = relations.get(s2);
                if (friends2==null) {
                    friends2 = new HashSet<String>();
                    friends2.add(s2);
                    relations.put(s2,friends2);
                }
                //此处必须要new HashSet，否则friend1会被改变，传引用的拷贝
                addRelation(relations, new HashSet<String>(friends1), friends2);
                addRelation(relations, new HashSet<String>(friends2), friends1);
            } else {
                String result = getRelation(relations,s1,s2);
                System.out.println(result);
            }
        }
    }

    private static String getRelation(HashMap<String, Set<String>> relations, String s1, String s2) {
        Set<String> friends = relations.get(s1);
        if (friends==null) {
            return "no";
        } else if (friends.contains(s2)) {
            return "yes";
        } else {
            return "no";
        }
    }

    private static void addRelation(HashMap<String, Set<String>> relations, Set<String> s1, Set<String> s2) {
        for (String key:s1) {
            Set<String> friends = relations.get(key);
            if (friends==null) {
                friends = new HashSet<String>();
            }
            friends.addAll(new HashSet<String>(s2));
            relations.put(key,new HashSet<String>(friends));
        }
    }

}
