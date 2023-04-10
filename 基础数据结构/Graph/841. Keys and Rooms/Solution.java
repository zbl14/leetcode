import java.util.HashSet;
import java.util.List;
import java.util.Set;

// dfs recursive
class Solution {
  private Set<Integer> visited = new HashSet<>();

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    visited.add(0);
    dfs(rooms, 0);
    return visited.size() == rooms.size();
  }

  private void dfs(List<List<Integer>> rooms, int node) {
    for (int nextNode : rooms.get(node)) {
      if (!visited.contains(nextNode)) {
        visited.add(nextNode);
        dfs(rooms, nextNode);
      }
    }
  }
}

// bfs
// class Solution {
// public boolean canVisitAllRooms(List<List<Integer>> rooms) {
// Set<Integer> visited = new HashSet<>();
// Queue<Integer> q = new LinkedList<>();
// q.offer(0);
// visited.add(0);
// int cnt = 0;
// while(!q.isEmpty()){
// int node = q.poll();
// for(int nextNode : rooms.get(node)){
// if(!visited.contains(nextNode)){
// q.offer(nextNode);
// visited.add(nextNode);
// }
// }
// cnt++;
// }
// return cnt == rooms.size();
// }
// }

// dfs with stack
// class Solution {
// public boolean canVisitAllRooms(List<List<Integer>> rooms) {
// Set<Integer> visited = new HashSet<>();
// Stack<Integer> stack = new Stack<>();
// stack.push(0);
// visited.add(0);
// int cnt = 0;
// while(!stack.isEmpty()){
// int node = stack.pop();

// for(int nextNode : rooms.get(node)){
// if(!visited.contains(nextNode)){
// stack.push(nextNode);
// visited.add(nextNode);
// }
// }
// cnt++;
// }
// return cnt == rooms.size();
// }
// }
