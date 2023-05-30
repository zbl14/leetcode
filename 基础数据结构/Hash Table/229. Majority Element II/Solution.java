// TC = O(n), SC = O(n)
class Solution {
  public List<Integer> majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int num : map.keySet()) {
      if (map.get(num) > nums.length / 3)
        res.add(num);
    }
    return res;
  }
}