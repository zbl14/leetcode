/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
// backtracking
class Trienode {
  constructor() {
    this.children = {};
    this.isEndWord = false;
  }
}

class Trie {
  constructor() {
    this.root = new Trienode();
  }

  insert(word) {
    let curr = this.root;
    for (const char of word) {
      if (!curr.children[char]) {
        curr.children[char] = new Trienode();
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

  startsWith(word) {
    let curr = this.root;
    for (const char of word) {
      if (!curr.children[char]) {
        return false;
      }
      curr = curr.children[char];
    }
    return true;
  }
}

var findWords = function (board, words) {
  const res = new Set();
  const row = board.length;
  const col = board[0].length;
  let trie = new Trie();
  for (const word of words) {
    trie.insert(word);
  }
  let visited = Array(row)
    .fill()
    .map(() => Array(col).fill(false));
  for (let i = 0; i < row; i++) {
    for (let j = 0; j < col; j++) {
      dfs(board, visited, "", i, j, trie, res);
    }
  }
  return [...res];
};

const dfs = (board, visited, str, x, y, trie, res) => {
  const direction = [-1, 0, 1, 0, -1];
  if (
    x < 0 ||
    x >= board.length ||
    y < 0 ||
    y >= board[0].length ||
    visited[x][y]
  )
    return;
  str += board[x][y];
  if (!trie.startsWith(str)) return;
  if (trie.search(str)) res.add(str);
  visited[x][y] = true;
  for (let k = 0; k < 4; k++) {
    const newX = x + direction[k];
    const newY = y + direction[k + 1];
    dfs(board, visited, str, newX, newY, trie, res);
  }
  visited[x][y] = false;
};
