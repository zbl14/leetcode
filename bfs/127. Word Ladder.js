/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
 var ladderLength = function(beginWord, endWord, wordList) {
  let dict = {};
  for(let i = 0; i < wordList.length; i++) {
      dict[wordList[i]] = true;
  }
  if(!dict[endWord]) return 0;
      
  const findNeighbors = (q, word) => {
      for(let i = 0; i < word.length; i++) {
          const a = "a".charCodeAt(0);
          const left = word.substring(0, i);
          const right = word.substring(i+1);
          for(let j = 0; j < 26; j++) {
              const x = String.fromCharCode(j+a);
              const newWord = left + x + right;
              if(dict[newWord]) {
                  q.push(newWord);
                  delete dict[newWord];
              }
          }
      }
  }
  
  let q = [];
  let distance = 2;
  findNeighbors(q, beginWord);
  while(q.length) {
      let currLevel = q.length;
      while(currLevel--){
          let word = q.shift();
          if(word === endWord) return distance;
          delete dict[word];
          findNeighbors(q, word);
      }
      distance++;
  }
  return 0;
};