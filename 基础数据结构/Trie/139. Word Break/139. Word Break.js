/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function (s, wordDict) {
  let trie = new Trie();
  let dpMap = new Map();
  for (const word of wordDict) {
    trie.insert(word);
    dpMap.set(word, true);
  }
  return canWordBeBreaked(s, trie, dpMap);
};

function canWordBeBreaked(word, trie, dpMap) {
  if (dpMap.has(word)) return dpMap.get(word);
  for (let i = 1; i < word.length; i++) {
    if (!trie.startsWith(word.substring(0, i))) break;
    if (
      trie.search(word.substring(0, i)) &&
      canWordBeBreaked(word.substring(i), trie, dpMap)
    ) {
      dpMap.set(word, true);
      return true;
    }
  }
  dpMap.set(word, false);
  return false;
}

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

  search(word) {
    let cur = this.root;
    for (const char of word) {
      if (!cur.children.has(char)) {
        return false;
      }
      cur = cur.children.get(char);
    }
    return cur.isEndWord;
  }

  startsWith(word) {
    let cur = this.root;
    for (const char of word) {
      if (!cur.children.has(char)) {
        return false;
      }
      cur = cur.children.get(char);
    }
    return true;
  }
}
