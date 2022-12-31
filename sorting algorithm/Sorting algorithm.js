let x = [1, 3, 4, 2, 11, 4, 6, 7];

//bubble sort
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

//selection sort
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

//insertion sort, time complexity: O(n^2), space complexity: O(1)
let insertionSort = (arr) => {
  for (let i = 1; i < arr.length; i++) {
    for (let j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
      [arr[j], arr[j - 1]] = [arr[j - 1], arr[j]];
    }
  }
  return arr;
};

//shell sort
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

//merge sort
let mergeSort = (arr) => {
  if (arr.length == 1) {
    return arr;
  }
  let mid = arr.length >> 1;
  let left = arr.slice(0, mid);
  let right = arr.slice(mid);
  return merge(mergeSort(left), mergeSort(right));
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
  while (left.length) {
    result.push(left.shift());
  }
  while (right.length) {
    result.push(right.shift());
  }
  return result;
};

//quick sort(https://www.geeksforgeeks.org/quick-sort/)
//time comlexity: O(n^2), average O(nlogN)
//space complexity: O(n), average O(logN)
let swap = (arr, i, j) => {
  [arr[i], arr[j]] = [arr[j], arr[i]];
};

let partition = (arr, l, r) => {
  let pivot = arr[r];
  let i = l - 1;
  for (let j = l; j < r; j++) {
    if (arr[j] < pivot) {
      i++;
      swap(arr, i, j);
    }
  }
  swap(arr, i + 1, r);
  return i + 1;
};

let quickSort = (arr, l, r) => {
  if (l < r) {
    let partitionIndex = partition(arr, l, r);
    quickSort(arr, l, partitionIndex - 1);
    quickSort(arr, partitionIndex + 1, r);
  }
  return arr;
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

// dfsTemplate
function dfsTemplate(root) {
  let res;
  let start;
  let dfs = function (node, currentResult) {
    if (node == null) {
      return;
    }
    //update currentResult

    if (node.left == null && node.right == null) {
      //update res
    }
    dfs(node.left, currentResult);
    dfs(node.right, currentResult);
  };
  dfs(root, start);
  return res;
}

const canPaint = function () {
  const obj = {
    paint: function (color) {
      return `Paints ${color}!.`;
    },
  };
  return obj;
};

const painter1 = canPaint();

painter1.paint("green");
