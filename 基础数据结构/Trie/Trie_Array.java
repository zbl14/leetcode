package 基础数据结构.Trie;

class Trie {
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null)
        node.children[c - 'a'] = new TrieNode();
      node = node.children[c - 'a'];
    }
    node.isWord = true;
  }

  public boolean search(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null)
        return false;
      node = node.children[c - 'a'];
    }
    return node.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
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
