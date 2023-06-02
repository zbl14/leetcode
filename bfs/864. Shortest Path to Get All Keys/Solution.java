// TLE
class Solution {
  private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public int shortestPathAllKeys(String[] grid) {
    int rows = grid.length;
    int cols = grid[0].length();

    Set<String> visited = new HashSet<>();
    Queue<Node> q = new LinkedList<>();
    int steps = 0;
    int keyCount = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i].charAt(j) == '@') {
          q.offer(new Node(i, j, ""));
        } else if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'z') {
          keyCount++;
        }
      }
    }

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node cur = q.poll();
        int x = cur.row;
        int y = cur.col;
        String key = cur.key;
        if (!visited.contains(cur.encode(x, y, key))) {
          visited.add(cur.encode(x, y, key));
        }
        if (key.length() == keyCount) {
          return steps;
        }

        for (int[] d : dirs) {
          int newX = x + d[0];
          int newY = y + d[1];

          Node nextNode = new Node(newX, newY, key);

          if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX].charAt(newY) != '#'
              && !visited.contains(nextNode.encode(newX, newY, key))) {
            char ch = grid[newX].charAt(newY);

            if (key.indexOf(ch) == -1 && ch >= 'a' && ch <= 'z') {
              q.offer(new Node(newX, newY, key + ch));
            } else if (ch >= 'A' && ch <= 'Z' && key.indexOf(Character.toLowerCase(ch)) == -1) {
              continue;
            } else {
              q.offer(new Node(newX, newY, key));
            }
          }
        }
      }
      steps++;
    }
    return -1;
  }
}

class Node {
  int row;
  int col;
  String key;

  public Node(int row, int col, String key) {
    this.row = row;
    this.col = col;
    this.key = key;
  }

  public String encode(int row, int col, String key) {
    return row + "#" + col + "#" + key;
  }
}
