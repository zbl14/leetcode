class TrieNode {
  constructor() {
    this.children = {};
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
      if (!curr.children[char]) {
        curr.children[char] = new TrieNode();
      }
      curr = curr.children[char];
    }
    curr.isEndWord = true;
  }

  search(word) {
    let curr = this.root;
    for (const char of word) {
      if (!curr.children[char]) {
        return false;
      }
      curr = curr.children[char];
    }
    return curr.isEndWord;
  }

  startsWith(prefix) {
    let curr = this.root;
    for (const char of prefix) {
      if (!curr.children[char]) {
        return false;
      }
      curr = curr.children[char];
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
