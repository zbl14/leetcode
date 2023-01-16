// template of Trie
class TrieNode {
  constructor() {
    this.children = new Map();
    this.isEndWord = false;
  }
}

class Trie {
  constructor() {
    this.root = new TrieNode();
  }

  insert(word) {
    let curr = this.root;
    for (const char of word) {
      if (!curr.children.has(char)) {
        curr.children.set(char, new TrieNode());
      }
      curr = curr.children.get(char);
    }
    curr.isEndWord = true;
  }

  search(word) {
    let curr = this.root;
    for (const char of word) {
      if (!curr.children.has(char)) {
        return false;
      }
      curr = curr.children.get(char);
    }
    return curr.isEndWord;
  }

  startsWith(prefix) {
    let curr = this.root;
    for (const char of prefix) {
      if (!curr.children.has(char)) {
        return false;
      }
      curr = curr.children.get(char);
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
