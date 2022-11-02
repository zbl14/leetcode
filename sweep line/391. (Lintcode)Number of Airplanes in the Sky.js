const countOfAirplanes = (airplanes) => {
  const timeMapArr = [];

  for (let i = 0; i < airplanes.length; i++) {
    timeMapArr.push([airplanes[i].start, 1]);
    timeMapArr.push([airplanes[i].end, -1]);
  }

  timeMapArr.sort((a, b) => {
    if (a[0] != b[0]) {
      return a[0] - b[0];
    }
    return a[1] - b[1];
  });

  let count = 0;
  let ans = 0;
  for (let i = 0; i < timeMapArr.length; i++) {
    count += timeMapArr[i][1];
    ans = Math.max(ans, count);
  }

  return ans;
};
