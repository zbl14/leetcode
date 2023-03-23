class WordDictionary {
  TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
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
    return helper(node, 0, word);
  }

  private boolean helper(TrieNode node, int idx, String word) {
    if (idx == word.length())
      return node.isWord;
    char c = word.charAt(idx);
    if (c == '.') {
      for (TrieNode child : node.children) {
        if (child != null && helper(child, idx + 1, word))
          return true;
      }
      return false;
    } else if (node.children[c - 'a'] != null) {
      return helper(node.children[c - 'a'], idx + 1, word);
    }
    return false;
  }
}

class TrieNode {
  TrieNode[] children;
  boolean isWord;

  public TrieNode() {
    children = new TrieNode[26];
  }
}