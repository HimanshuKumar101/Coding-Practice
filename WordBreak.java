import java.util.*;

/*
 * word break problem
 * 
 * given an input string and a dictionary of words, find out if the input string
 * can be broken into a space separated sequence of dictionary words.
 * 
 * words[] = {i,like,sam,samsung,mobile,ice}
 * key = "ilikesamsung"
 * 
 output : true


 approach
 1) create a trie form my string
  
 */

public class WordBreak {

    static class Node {
        Node children[] = new Node[26]; // 'a'-'z'
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static boolean wordBreakk(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            // substring(0,1)
            if (search(key.substring(0, i)) &&
                    wordBreakk(key.substring(i))) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreakk(key));

    }

}
