class Solution {
  public int[] getOrder(int[][] tasks) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));

    // sortedTasks[i] = {enquque time, processing time, taskIndex}
    int sortedTasks[][] = new int[tasks.length][3];
    for (int i = 0; i < tasks.length; i++) {
      sortedTasks[i][0] = tasks[i][0];
      sortedTasks[i][1] = tasks[i][1];
      sortedTasks[i][2] = i;
    }
    Arrays.sort(sortedTasks, (a, b) -> (a[0] - b[0]));

    int[] res = new int[tasks.length];
    int curTime = 0;
    int taskIndex = 0;
    int ansIndex = 0;

    while (taskIndex < tasks.length || !pq.isEmpty()) {
      if (pq.isEmpty() && curTime < sortedTasks[taskIndex][0]) {
        curTime = sortedTasks[taskIndex][0];
      }

      while (taskIndex < tasks.length && curTime >= sortedTasks[taskIndex][0]) {
        pq.offer(sortedTasks[taskIndex]);
        taskIndex++;
      }

      int[] curTask = pq.poll();
      int processTime = curTask[1];
      int index = curTask[2];

      curTime += processTime;
      res[ansIndex++] = index;
    }
    return res;
  }
}

// int[][] sortedTasks = Arrays.stream(tasks)
// .map(task -> new int[]{task[0], task[1], Arrays.asList(tasks).indexOf(task)})
// .toArray(int[][]::new);
