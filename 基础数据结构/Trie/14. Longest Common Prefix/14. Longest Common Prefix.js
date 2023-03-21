/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  let trie = new Trie();
  for (const word of strs) {
    if (word.length === 0) return "";
    trie.insert(word);
  }
  return trie.getPrefix();
};

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
    let cur = this.root;
    for (const char of word) {
      if (!cur.children.has(char)) {
        cur.children.set(char, new TrieNode());
      }
      cur = cur.children.get(char);
    }
    cur.isEndWord = true;
  }

  getPrefix() {
    let prefix = "";
    let stack = [this.root];
    while (stack.length) {
      const curNode = stack.pop();
      // When the current node has multiple children,
      // it means that at that point,
      // the words stored in the Trie diverge from each other,
      // and so the prefix up to that point is the longest common prefix.
      if (curNode.children.size > 1 || curNode.isEndWord) {
        return prefix;
      }
      curNode.children.forEach((childNode, childKey) => {
        prefix += childKey;
        stack.push(childNode);
      });
    }
    return prefix;
  }
}
