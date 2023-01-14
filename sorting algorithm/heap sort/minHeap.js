const minHeapify = (arr, n, i) => {
  let smallest = i;
  let l = 2 * i + 1; //left child index
  let r = 2 * i + 2; //right child index

  //If left child is smaller than root
  if (l < n && arr[l] < arr[smallest]) {
    smallest = l;
  }

  // If right child is smaller than smallest so far
  if (r < n && arr[r] < arr[smallest]) {
    smallest = r;
  }

  // If smallest is not root
  if (smallest != i) {
    let temp = arr[i];
    arr[i] = arr[smallest];
    arr[smallest] = temp;

    // Recursively heapify the affected sub-tree
    minHeapify(arr, n, smallest);
  }
};

// main function to do heap sort
const heapSort = (arr) => {
  // Build heap (rearrange array)
  const n = arr.length;
  for (let i = Math.floor(n / 2 - 1); i >= 0; i--) {
    minHeapify(arr, n, i);
  }

  // One by one extract an element from heap
  for (let i = n - 1; i >= 0; i--) {
    // Move current root to end
    let temp = arr[0];
    arr[0] = arr[i];
    arr[i] = temp;

    // call min heapify on the reduced heap
    minHeapify(arr, i, 0);
  }
};
