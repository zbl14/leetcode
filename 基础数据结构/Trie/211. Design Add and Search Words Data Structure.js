class TrieNode {
  constructor() {
    this.children = {};
    this.isEndWord = false;
  }
}

class WordDictionary {
  constructor() {
    this.root = new TrieNode();
  }

  addWord(word) {
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
    const helper = (node, index) => {
      if (index === word.length) return node.isEndWord;

      const char = word[index];
      if (char === ".") {
        for (const key in node.children) {
          if (helper(node.children[key], index + 1)) return true;
        }
        return false;
      } else if (node.children[char])
        return helper(node.children[char], index + 1);
      return false;
    };
    return helper(this.root, 0);
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
