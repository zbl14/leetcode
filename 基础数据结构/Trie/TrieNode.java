package 基础数据结构.Trie;

class TrieNode {
  TrieNode[] children;
  boolean isWord;

  public TrieNode() {
    children = new TrieNode[26];
  }
}
