/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = 10000;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(reader.get(mid) == Integer.MAX_VALUE) r = mid - 1;
            else {
                if(reader.get(mid) == target) return mid;
                else if(reader.get(mid) < target) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}