//常考：merge sort, quick sort(quick select), bucket sort, counting sort, heap sort
//少考：pancake sort
//不考：bubble sort, selection sort, insertion sort, shell sort, radix sort

let x = [1, 3, 4, 2, 11, 4, 6, 7];

//merge sort, TC = O(nlogn)
const mergeSort = (arr) => {
  if (arr.length == 1) {
    return arr;
  }
  const mid = arr.length >> 1;
  const leftRes = arr.slice(0, mid);
  const rightRes = arr.slice(mid);
  return merge(mergeSort(leftRes), mergeSort(rightRes));
};
const merge = (left, right) => {
  let result = [];
  while (left.length && right.length) {
    if (left[0] < right[0]) {
      result.push(left.shift());
    } else {
      result.push(right.shift());
    }
  }
  while (left.length) result.push(left.shift());
  while (right.length) result.push(right.shift());
  return result;
};

//quick sort(https://www.geeksforgeeks.org/quick-sort/)
//time comlexity: average O(nlogN), worst case O(n^2)
//space complexity: O(n), average O(logN)
const swap = (arr, i, j) => {
  [arr[i], arr[j]] = [arr[j], arr[i]];
};

const partition = (arr, l, r) => {
  let pivot = arr[r];
  let wall = l;
  for (let i = l; i < r; i++) {
    if (arr[i] < pivot) {
      swap(arr, wall, i);
      wall++;
    }
  }
  swap(arr, wall, r);
  return wall;
};

const quickSort = (arr, l, r) => {
  if (l < r) {
    let partitionIndex = partition(arr, l, r);
    quickSort(arr, l, partitionIndex - 1);
    quickSort(arr, partitionIndex + 1, r);
  }
  return arr;
};

const getRandomPivotIndex = (l, r) => {
  return l + Math.floor(Math.random() * (r - l + 1));
};

const shuffleArray = (array) => {
  for (let i = 0; i < array.length; i++) {
    const j = Math.floor(Math.random() * (i + 1));
    swap(array, i, j);
  }
};

//counting sort
let countingSort = (arr) => {
  let sortedIndex = 0;
  let bucket = {};
  let maxValue = arr[0];
  let minValue = arr[0];
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] > maxValue) {
      maxValue = arr[i];
    }
    if (arr[i] < minValue) {
      minValue = arr[i];
    }
    if (!bucket[arr[i]]) {
      bucket[arr[i]] = 1;
    } else {
      bucket[arr[i]]++;
    }
  }
  for (let j = minValue; j <= maxValue; j++) {
    while (bucket[j] > 0) {
      arr[sortedIndex++] = j;
      bucket[j]--;
    }
  }
  return arr;
};

//bubble sort, TC = O(n^2), SC = O(1)
//核心为相邻的两个数字交换位置，每次从头遍历一次
let bubbleSort = (arr) => {
  for (let i = 0; i < arr.length - 1; i++) {
    for (let j = 0; j < arr.length - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
      }
    }
  }
  return arr;
};

//selection sort, TC = O(n^2), SC = O(1)
//核心每次从未选的数字里，拿出最小的
let selectionSort = (arr) => {
  for (let i = 0; i < arr.length - 1; i++) {
    let minNumIndex = i;
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[minNumIndex]) {
        minNumIndex = j;
      }
      [arr[i], arr[minNumIndex]] = [arr[minNumIndex], arr[i]];
    }
  }
  return arr;
};

//insertion sort, TC = O(n^2), SC = O(1)
//核心为遍历每个元素，将其插入正确位置上，比左边的元素大，比右边的元素小（从小到大排）
let insertionSort = (arr) => {
  for (let i = 1; i < arr.length; i++) {
    for (let j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
      //往前扫，看是否有比当前数字大的，若有则把当前元素往前推
      [arr[j], arr[j - 1]] = [arr[j - 1], arr[j]];
    }
  }
  return arr;
};

//shell sort, TC = O(n^2)
function shellSort(arr) {
  var len = arr.length,
    temp,
    gap = 1;
  while (gap < len / 3) {
    //动态定义间隔序列
    gap = gap * 3 + 1;
  }
  for (gap; gap > 0; gap = Math.floor(gap / 3)) {
    for (var i = gap; i < len; i++) {
      temp = arr[i];
      for (var j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
        arr[j + gap] = arr[j];
      }
      arr[j + gap] = temp;
    }
  }
  return arr;
}
