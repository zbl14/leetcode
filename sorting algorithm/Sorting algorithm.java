//merge sort, TC = O(nlogn)
public static int[] mergeSort(int[] arr) {
    if (arr.length == 1) {
        return arr;
    }
    int mid = arr.length >> 1;
    int[] leftRes = Arrays.copyOfRange(arr, 0, mid);
    int[] rightRes = Arrays.copyOfRange(arr, mid, arr.length);
    return merge(mergeSort(leftRes), mergeSort(rightRes));
}

public static int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i = 0, j = 0, k = 0;
    while (i < left.length && j < right.length) {
        if (left[i] < right[j]) {
            result[k++] = left[i++];
        } else {
            result[k++] = right[j++];
        }
    }
    while (i < left.length) {
        result[k++] = left[i++];
    }
    while (j < right.length) {
        result[k++] = right[j++];
    }
    return result;
}
