/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} source
 * @param {number} destination
 * @return {boolean}
 */
var validPath = function (n, edges, source, destination) {
  const graph = new Map();
  for (let i = 0; i < edges.length; i++) {
    const [a, b] = edges[i];
    if (!graph.has(a)) graph.set(a, []);
    if (!graph.has(b)) graph.set(b, []);
    graph.get(a).push(b);
    graph.get(b).push(a);
  }
  const seen = Array(n).fill(false);
  seen[source] = true;
  const q = [];
  q.push(source);
  while (q.length > 0) {
    const cur = q.shift();
    if (cur === destination) return true;
    for (const next of graph.get(cur)) {
      if (!seen[next]) {
        seen[next] = true;
        q.push(next);
      }
    }
  }
  return false;
};
