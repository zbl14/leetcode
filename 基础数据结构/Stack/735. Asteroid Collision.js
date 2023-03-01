/**
 * @param {number[]} asteroids
 * @return {number[]}
 */
var asteroidCollision = function (asteroids) {
  const stack = [];
  for (let i = 0; i < asteroids.length; i++) {
    if (stack.length == 0 || stack[stack.length - 1] < 0)
      stack.push(asteroids[i]);
    else {
      if (
        (asteroids[i] < 0 && stack[stack.length - 1] < 0) ||
        (asteroids[i] > 0 && stack[stack.length - 1] > 0)
      )
        stack.push(asteroids[i]);
      else {
        if (asteroids[i] < 0 && stack[stack.length - 1] > 0) {
          if (asteroids[i] + stack[stack.length - 1] < 0) {
            stack.pop();
            i--;
          } else if (asteroids[i] + stack[stack.length - 1] === 0) {
            stack.pop();
          }
        } else {
          stack.push(asteroids[i]);
        }
      }
    }
  }
  return stack;
};
