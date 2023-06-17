class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    // build graph
    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      String dividend = equation.get(0);
      String divisor = equation.get(1);
      double quotient = values[i];

      graph.computeIfAbsent(dividend, k -> new HashMap<String, Double>()).put(divisor, quotient);
      graph.computeIfAbsent(divisor, k -> new HashMap<String, Double>()).put(dividend, 1 / quotient);
    }

    double[] res = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      String dividend = query.get(0);
      String divisor = query.get(1);

      if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
        res[i] = -1.0;
      } else if (dividend.equals(divisor)) {
        res[i] = 1.0;
      } else {
        Set<String> visited = new HashSet<>();
        res[i] = backtrack(graph, dividend, divisor, 1, visited);
      }
    }
    return res;
  }

  private double backtrack(Map<String, Map<String, Double>> graph, String cur, String target, double accProduct,
      Set<String> visited) {
    visited.add(cur);
    double ret = -1.0;

    Map<String, Double> neighbors = graph.get(cur);
    if (neighbors.containsKey(target)) {
      ret = accProduct * neighbors.get(target);
    } else {
      for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
        String next = pair.getKey();
        if (visited.contains(next))
          continue;
        ret = backtrack(graph, next, target, accProduct * pair.getValue(), visited);
        if (ret != -1.0) {
          break;
        }
      }
    }
    visited.remove(cur);
    return ret;
  }
}