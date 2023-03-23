import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  private Set<String> res = new HashSet<>();
  private int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public List<String> findWords(char[][] board, String[] words) {
    int rows = board.length;
    int cols = board[0].length;
    Trie trie = new Trie();
    boolean[][] visited = new boolean[rows][cols];
    for (String word : words)
      trie.insert(word);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        dfs(board, visited, "", i, j, trie);
      }
    }
    return new ArrayList<String>(res);
  }

  public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y])
      return;
    str += board[x][y];
    if (!trie.startsWith(str))
      return;
    if (trie.search(str))
      res.add(str);
    visited[x][y] = true;
    for (int[] dir : dirs) {
      dfs(board, visited, str, x + dir[0], y + dir[1], trie);
    }
    visited[x][y] = false;
  }
}

// class Trie{
// TrieNode root;

// public Trie(){
// root = new TrieNode();
// }

// public void insert(String word){
// TrieNode node = root;
// for(char c : word.toCharArray()){
// node.children.computeIfAbsent(c, k -> new TrieNode());
// node = node.children.get(c);
// }
// node.isWord = true;
// }

// public boolean search(String word){
// TrieNode node = root;
// for(char c : word.toCharArray()){
// node = node.children.get(c);
// if(node == null) return false;
// }
// return node.isWord;
// }

// public boolean startsWith(String prefix){
// TrieNode node = root;
// for(char c : prefix.toCharArray()){
// node = node.children.get(c);
// if(node == null) return false;
// }
// return true;
// }
// }

// class TrieNode{
// Map<Character, TrieNode> children;
// boolean isWord;

// public TrieNode() {
// children = new HashMap<>();
// }
// }

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
