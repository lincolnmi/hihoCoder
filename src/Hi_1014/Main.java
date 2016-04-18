package Hi_1014;

import java.util.Scanner;

/**
 * Created by Jason on 2016/4/17.
 */
public class Main {
    private TrieNode root;

    public Main() {
        root = new TrieNode();
    }

    public void insert(String str) {
        if (str=="") {
            return;
        } else {
            int size = str.length();
            TrieNode current = root;
            for (int i=0;i<size;i++) {
                char ch = str.charAt(i);
                if (current.childList[ch-'a']==null) {
                    current.childList[ch-'a'] = new TrieNode();
                }
                current = current.childList[ch-'a'];
                current.count++;
            }
        }
    }

    public int query(String str) {
        if (str=="") {
            return 0;
        } else {
            int size = str.length();
            TrieNode current = root;
            for (int i=0;i<size;i++) {
                if (current==null) {
                    return 0;
                }
                char ch = str.charAt(i);
                current = current.childList[ch - 'a'];
            }
            if (current==null) {
                return 0;
            }
            return current.count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main main = new Main();
        while (n-->0) {
            main.insert(sc.next());
        }
        int m = sc.nextInt();
        while (m-->0) {
            int count = main.query(sc.next());
            System.out.println(count);
        }
    }

    class TrieNode {
        TrieNode[] childList;
        int count;

        public TrieNode() {
            count = 0;
            childList = new TrieNode[26];
            for (int i=0;i<26;i++) {
                childList[i] = null;
            }
        }

    }

}
