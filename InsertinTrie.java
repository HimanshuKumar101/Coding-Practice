import java.util.*;

/* insert in trie
 *  
 * time complixity O(L) L is Length of word
 * words[] = "the","a","there ","their","any","thee"
 * 't'-'a'
 * integer
 * 'a'-'a' = 0     
 * 'b' -'b' = 1    } index
 * 'c' - 'a' = 2  
 * 
 *        null
 *       /     \
 *  node         valid 
 *  exist        node
 *    /
 *  new node 
 *  insert
 * 
 * 
 *            [.](root)
 *           /  \
 *          t   a
 *         /      \
 *        h        n
 *       /          \ 
 *      e __ e       y
 *     / \
 *    r   i 
 *   /     \
 *  e      r
 * 
 * 
 */

public class InsertinTrie {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;

            }

        }

    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L) largest of the word.
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

    public static boolean search(String key) { // O(L)
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

    public static void main(String[] args) {

        String words[] = { "the", "a", "there", "their", "any", "thee" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("the"));
        System.out.println(search("tho"));

    }

}
