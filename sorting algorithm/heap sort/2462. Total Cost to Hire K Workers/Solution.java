import java.util.PriorityQueue;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] costs = { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
    int k = 3;
    int candidates = 4;

    long res = solution.totalCost(costs, k, candidates);

    System.out.println(res);
  }

  public long totalCost(int[] costs, int k, int candidates) {
    long res = 0;
    if (costs.length == k) {
      for (int cost : costs) {
        res += cost;
      }
      return res;
    }

    PriorityQueue<Integer> head = new PriorityQueue<>();
    PriorityQueue<Integer> tail = new PriorityQueue<>();

    for (int i = 0; i < candidates; i++) {
      head.offer(costs[i]);
    }
    for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
      tail.offer(costs[i]);
    }

    int nextHead = candidates;
    int nextTail = costs.length - candidates - 1;

    for (int i = 0; i < k; i++) {
      if (tail.isEmpty() || !head.isEmpty() && head.peek() <= tail.peek()) {
        res += head.poll();
        if (nextHead <= nextTail) {
          head.offer(costs[nextHead]);
          nextHead++;
        }
      } else {
        res += tail.poll();
        if (nextHead <= nextTail) {
          tail.offer(costs[nextTail]);
          nextTail--;
        }
      }
    }
    return res;
  }
}
