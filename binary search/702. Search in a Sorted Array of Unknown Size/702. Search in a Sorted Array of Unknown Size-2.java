/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = target - reader.get(0);
        /*
         * Why right = target - reader.get(0) ?
         * Explanation: Given all the elements in the Array are unique. If first value
         * is n and we have all possible integers from n to target .
         * We will find the target at worst case at (target - n)
         * Example: If First Element is -1 and target = 5 if the array had all elements
         * between -1 and 5 i.e.,
         * [-1,0,1,2,3,4,5] Worst case 5 will be at (target - firstValue)
         */
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}

// 倍增法找右边界
// class Solution {
// public int search(ArrayReader reader, int target) {
// int l = 0;
// int r = 1;
// while(reader.get(r) < target) r <<=1;
// while(l <= r){
// int mid = l + (r - l) / 2;
// if(reader.get(mid) == target) return mid;
// else if(reader.get(mid) < target) l = mid + 1;
// else r = mid - 1;
// }
// return -1;
// }
// }
