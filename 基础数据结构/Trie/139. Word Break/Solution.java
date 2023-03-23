import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    Trie trie = new Trie();
    Map<String, Boolean> dpMap = new HashMap<>();
    for (String word : wordDict) {
      trie.insert(word);
      dpMap.put(word, true);
    }
    return canWordBeBreaked(s, trie, dpMap);
  }

  private boolean canWordBeBreaked(String word, Trie trie, Map<String, Boolean> dpMap) {
    if (dpMap.containsKey(word))
      return dpMap.get(word);
    for (int i = 1; i < word.length(); i++) {
      if (!trie.startsWith(word.substring(0, i)))
        break;
      if (trie.search(word.substring(0, i)) && canWordBeBreaked(word.substring(i), trie, dpMap)) {
        dpMap.put(word, true);
        return true;
      }
    }
    dpMap.put(word, false);
    return false;
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
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.isWord = true;
  }

  public boolean search(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        return false;
      }
      node = node.children[c - 'a'];
    }
    return node.isWord;
  }

  public boolean startsWith(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null)
        return false;
      node = node.children[c - 'a'];
    }
    return true;
  }

}

class TrieNode {
  TrieNode[] children;
  boolean isWord;

  public TrieNode() {
    children = new TrieNode[26];
  }
}