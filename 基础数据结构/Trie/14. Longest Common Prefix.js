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
      if (curNode.children.size > 1 || curNode.isEndWord) {
        return prefix;
      }
      curNode.children.forEach((childNode, childKey) => {
        console.log(childNode, childKey);
        prefix += childKey;
        stack.push(childNode);
      });
    }
    return prefix;
  }
}
