import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> paths = new ArrayList<List<Integer>>();
    Queue<List<Integer>> q = new LinkedList<List<Integer>>();

    // for(int i=0;i<graph[0].length;i++){
    // List<Integer> path = new ArrayList<Integer>();
    // path.add(0);
    // path.add(graph[0][i]);
    // q.offer(path);
    // }

    // graph = [[1,2],[3],[3],[]]
    // q = [[0,1],[0,2]]

    q.offer(Arrays.asList(0));
    // q = [[0]]

    while (!q.isEmpty()) {
      List<Integer> list = q.poll();
      int node = list.get(list.size() - 1);
      if (node == graph.length - 1) {
        paths.add(list);
      }

      for (int i = 0; i < graph[node].length; i++) {
        List<Integer> newPath = new ArrayList<Integer>(list);
        newPath.add(graph[node][i]);
        q.offer(newPath);
      }
    }
    return paths;
  }
}

// dfs recursive
class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> paths = new ArrayList<List<Integer>>();
    backtrack(graph, paths, new ArrayList<>(Arrays.asList(0)), 0);
    return paths;
  }

  private void backtrack(int[][] graph, List<List<Integer>> paths, List<Integer> path, int node) {
    if (node == graph.length - 1) {
      paths.add(new ArrayList<>(path));
      return;
    }

    for (int nextNode : graph[node]) {
      path.add(nextNode);
      backtrack(graph, paths, path, nextNode);
      path.remove(path.size() - 1);
    }
  }
}
