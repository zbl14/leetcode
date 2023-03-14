class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = search(nums, target, true);
        res[1] = search(nums, target, false);
        return res;
    }

    public int search(int[] nums, int target, boolean findFirst){
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                ans = mid;
                if(findFirst) r = mid - 1;
                else l = mid + 1;
            } else {
                if(nums[mid] < target) l = mid + 1;
                else r = mid - 1;
            }
        }
        return ans;
    }
}