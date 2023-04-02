/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {number[]}
 */
var findOrder = function (numCourses, prerequisites) {
  const graph = [];
  for (let i = 0; i < numCourses; i++) {
    graph.push([]);
  }

  const inDegree = Array(numCourses).fill(0);
  for (let arr of prerequisites) {
    graph[arr[1]].push(arr[0]);
    inDegree[arr[0]]++;
  }

  const q = [];
  for (let i = 0; i < numCourses; i++) {
    if (inDegree[i] === 0) {
      q.push(i);
    }
  }

  const result = [];
  while (q.length) {
    const curCourse = q.shift();
    result.push(curCourse);
    const neighbors = graph[curCourse];
    for (let nei of neighbors) {
      inDegree[nei]--;
      if (inDegree[nei] === 0) {
        q.push(nei);
      }
    }
  }
  return result.length === numCourses ? result : [];
};
