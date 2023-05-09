/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
// TC = O(nlogn), as the sorting takes O(nlogn) time and the rest of the operations take O(n) time.
// SC = O(n), as it requires O(n) memory to store the frequency of each word.
var topKFrequent = function (words, k) {
  const wordsToFreq = new Map();
  const sortedWords = words.sort((a, b) => a.localeCompare(b));
  sortedWords.forEach((word) =>
    wordsToFreq.set(word, wordsToFreq.get(word) + 1 || 1)
  );
  const sorted = [...wordsToFreq.entries()].sort((a, b) => b[1] - a[1]);
  const res = sorted.filter((word, index) => index < k).map(([word]) => word);
  return res;
};
