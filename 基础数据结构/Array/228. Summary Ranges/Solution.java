// class Solution {
//     public List<String> summaryRanges(int[] nums) {
//         List<String> res = new ArrayList<>();
//         if(nums.length == 0) return res;
//         int l = 0;
//         for(int r = 0; r < nums.length - 1; r++){
//             if(nums[r] + 1 == nums[r + 1]){
//                 continue;
//             } else {
//                 if(l == r){
//                     res.add("" + nums[l]);
//                 } else {
//                     res.add("" + nums[l] + "->" + nums[r]);
//                 }
//                 l = r + 1;
//             }
//         }
//         if(l == nums.length - 1){
//             res.add("" + nums[l]);
//         } else {
//             res.add("" + nums[l] + "->" + nums[nums.length - 1]);
//         }
//         return res;
//     }
// }

class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> ranges = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int start = nums[i];
      while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
        i++;
      }

      if (start != nums[i]) {
        ranges.add(start + "->" + nums[i]);
      } else {
        ranges.add(String.valueOf(start));
      }
    }

    return ranges;
  }
}
