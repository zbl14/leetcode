class Solution {
  public int coinChange(int[] coins, int amount) {
    if (amount == 0)
      return 0;

    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    queue.offer(0);
    visited.add(0);

    int coinCount = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      coinCount++;
      for (int i = 0; i < size; i++) {
        int total = queue.poll();
        for (int coin : coins) {
          int nextTotal = total + coin;
          if (nextTotal == amount)
            return coinCount;
          if (nextTotal < amount && !visited.contains(nextTotal)) {
            queue.offer(nextTotal);
            visited.add(nextTotal);
          }
        }
      }
    }
    return -1;
  }
}
