import java.util.Map;
import java.util.HashMap;

class Solution {
  public String longestCommonPrefix(String[] strs) {
    Trie trie = new Trie();
    for (String word : strs) {
      if (word.length() == 0)
        return "";
      trie.insert(word);
    }
    return trie.getPrefix();
  }
}

class Trie {
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      node.children.computeIfAbsent(c, k -> new TrieNode());
      node = node.children.get(c);
    }
    node.isWord = true;
  }

  public String getPrefix() {
    StringBuilder prefix = new StringBuilder();
    TrieNode node = root;
    while (node.children.size() == 1 && !node.isWord) {
      TrieNode childNode = null;
      for (char key : node.children.keySet()) {
        prefix.append(key);
        childNode = node.children.get(key);
      }
      node = childNode;
    }
    return prefix.toString();
  }
}

class TrieNode {
  Map<Character, TrieNode> children;
  boolean isWord;

  public TrieNode() {
    children = new HashMap<>();
  }
}