package 基础数据结构.Trie;

import java.util.HashMap;
import java.util.Map;

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

  public boolean search(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      node = node.children.get(c);
      if (node == null)
        return false;
    }
    return node.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
      node = node.children.get(c);
      if (node == null)
        return false;
    }
    return true;
  }
}

class TrieNode {
  Map<Character, TrieNode> children;
  boolean isWord;

  public TrieNode() {
    children = new HashMap<>();
  }
}