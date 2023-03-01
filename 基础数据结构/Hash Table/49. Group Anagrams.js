/**
 * @param {string[]} strs
 * @return {string[][]}
 */
function groupAnagrams(words) {
  const obj = {};

  words.forEach((word) => {
    const sortedWord = word.split("").sort().join("");
    if (obj[sortedWord]) {
      obj[sortedWord].push(word);
    } else {
      obj[sortedWord] = [word];
    }
  });
  return Object.values(obj);
}
