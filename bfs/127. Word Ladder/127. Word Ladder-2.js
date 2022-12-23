/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
  //将wordList里所有word放进dict，若dict没有endWord直接返回0
  const dict = new Set();
  for (let i = 0; i < wordList.length; i++) {
    dict.add(wordList[i]);
  }
  if (!dict.has(endWord)) return 0;

  let q = [];
  let distance = 2;
  //将第二个词加入到queue
  findNeighbors(q, beginWord);
  while (q.length) {
    let currLevel = q.length;
    for (let i = 0; i < currLevel; i++) {
      let word = q.shift();
      if (word === endWord) return distance;
      dict.delete(word);
      findNeighbors(q, word);
    }
    distance++;
  }
  return 0;

  function findNeighbors(q, word) {
    for (let i = 0; i < word.length; i++) {
      const a = "a".charCodeAt(0);
      const left = word.substring(0, i);
      const right = word.substring(i + 1);
      for (let j = 0; j < 26; j++) {
        const x = String.fromCharCode(j + a);
        const newWord = left + x + right;
        if (dict.has(newWord)) {
          q.push(newWord);
          dict.delete(newWord);
        }
      }
    }
  }
};
