/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
  //将wordList里所有word放进dict，若dict没有endWord直接返回0
  const dict = new Set(wordList);
  if (!dict.has(endWord)) return 0;

  // 双向BFS
  var start = new Set();
  var end = new Set();
  var visited = new Set(); //works as memo
  start.add(beginWord);
  end.add(endWord);
  var distance = 1;
  while (start.size && end.size) {
    //start always has smaller set
    if (start.size > end.size) {
      let tmp = start;
      start = end;
      end = tmp;
    }

    var tmp = new Set();
    for (let word of start) {
      for (let i = 0; i < word.length; i++) {
        const a = "a".charCodeAt();
        const left = word.substring(0, i);
        const right = word.substring(i + 1);
        for (let j = 0; j < 26; j++) {
          const x = String.fromCharCode(j + a);
          const newWord = left + x + right;
          if (end.has(newWord)) {
            return distance + 1;
          }
          if (!visited.has(newWord) && dict.has(newWord)) {
            tmp.add(newWord);
            visited.add(newWord);
          }
        }
      }
    }
    start = tmp;
    distance++;
  }
  return 0;
};
