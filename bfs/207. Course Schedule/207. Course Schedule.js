/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function (numCourses, prerequisites) {
  // graph [[0号课指向a,b],[1号课指向c,d],..]
  const graph = [];
  for (let i = 0; i < numCourses; i++) {
    graph.push([]);
  }
  // inDegree [0号课有几门先修,1号课有几门先修,..]
  const inDegree = Array(numCourses).fill(0);
  for (let arr of prerequisites) {
    graph[arr[1]].push(arr[0]);
    inDegree[arr[0]]++;
  }

  // 没有先修要求的课放进q，准备上课
  const q = [];
  for (let i = 0; i < numCourses; i++) {
    if (inDegree[i] === 0) {
      q.push(i);
    }
  }

  // 上current课，找neighbors，nei的先修要求-1，如果nei的inDegree减到0了，放进q，准备上课
  let coursesTaken = 0;
  while (q.length) {
    // O(numCourses+prerequisites)
    const curCourse = q.shift();
    coursesTaken++;
    const neighbors = graph[curCourse];
    for (let nei of neighbors) {
      inDegree[nei]--;
      if (inDegree[nei] === 0) {
        q.push(nei);
      }
    }
  }

  // 可以上的课是否=总课数
  console.log(coursesTaken);
  return coursesTaken === numCourses;
};
