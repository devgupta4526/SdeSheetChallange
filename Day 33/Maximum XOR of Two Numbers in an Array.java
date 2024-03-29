import java.util.*;
import java.io.*;

public class Solution {
    public static int maximumXor(int[] A) {
        Trie trie = new Trie();
        for (int num : A) {
            insert(num, trie.root);
        }
        int max = 0;
        for (int num : A) {
            int tmp = getMax(num, trie.root);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    public static void insert(int num, TrieNode node) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                TrieNode child = new TrieNode();
                node.children[bit] = child;
            }
            node = node.children[bit];
        }
    }

    public static int getMax(int num, TrieNode node) {
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[1 - bit] != null) {
                max |= (1 << i);
                node = node.children[1 - bit];
            } else {
                node = node.children[bit];
            }
        }
        return max;
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }
    }
}

class TrieNode {
    TrieNode[] children;

    TrieNode() {
        this.children = new TrieNode[2];
    }
}
