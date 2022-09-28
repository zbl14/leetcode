/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function (nums, k) {
  let keyFreq = {}; // {key : frequency}
  let output = [];
  for (const num of nums) {
    if (!keyFreq[num]) {
      keyFreq[num] = 1;
    } else {
      keyFreq[num]++;
    }
  }
  let freqKey = {}; // {freq : keys[]}
  for (const key in keyFreq) {
    let freq = keyFreq[key];
    if (!freqKey[freq]) {
      freqKey[freq] = [];
    }
    freqKey[freq].push(parseInt(key));
  }
  for (
    let i = Object.keys(freqKey).length - 1;
    i >= 0 && output.length < k;
    i--
  ) {
    for (let j = 0; j < Object.values(freqKey)[i].length; j++) {
      output.push(Object.values(freqKey)[i][j]);
      if (output.length === k) {
        break;
      }
    }
  }
  return output;
};
