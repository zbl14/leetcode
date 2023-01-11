/**
 * @param {number[]} arr
 * @return {number[]}
 */
var pancakeSort = function (arr) {
  let result = [];
  const n = arr.length;
  let largest = n;
  for (let i = 0; i < n; i++) {
    const index = findLargest(arr, largest);
    flip(arr, index);
    flip(arr, largest - 1);
    result.push(index + 1);
    result.push(largest--);
  }
  return result;
};

const findLargest = (arr, target) => {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) return i;
  }
  return -1;
};

const flip = (arr, index) => {
  let i = 0,
    j = index;
  while (i < j) {
    let temp = arr[i];
    arr[i++] = arr[j];
    arr[j--] = temp;
  }
};
