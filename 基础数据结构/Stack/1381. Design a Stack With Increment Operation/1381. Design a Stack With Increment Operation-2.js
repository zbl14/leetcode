// Lazy increment
/**
 * @param {number} maxSize
 */
var CustomStack = function (maxSize) {
  this.stack = [];
  this.inc = new Array(maxSize).fill(0);
  this.maxSize = maxSize;
};

/**
 * @param {number} x
 * @return {void}
 */
CustomStack.prototype.push = function (x) {
  if (this.stack.length < this.maxSize) this.stack.push(x);
};

/**
 * @return {number}
 */
CustomStack.prototype.pop = function () {
  // if (this.stack.length) {
  //   const idx = this.stack.length - 1;
  //   const inc = this.inc[idx];
  //   if (idx - 1 >= 0) this.inc[idx - 1] += inc;
  //   this.inc[idx] = 0;
  //   return this.stack.pop() + inc;
  // } else {
  //   return -1;
  // }
  let idx = this.stack.length - 1;
  if (idx < 0) return -1;
  if (idx > 0) this.inc[idx - 1] += this.inc[idx];
  let res = this.stack.pop() + this.inc[idx];
  this.inc[idx] = 0;
  return res;
};

/**
 * @param {number} k
 * @param {number} val
 * @return {void}
 */
CustomStack.prototype.increment = function (k, val) {
  const idx = Math.min(k, this.stack.length) - 1;
  if (idx >= 0) this.inc[idx] += val;
};

/**
 * Your CustomStack object will be instantiated and called as such:
 * var obj = new CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,val)
 */

// example
let stk = new CustomStack(3);
stk.push(1);
console.log(stk); // CustomStack { stack: [ 1 ], inc: [ 0, 0, 0 ], maxSize: 3 }
stk.push(2);
console.log(stk); // CustomStack { stack: [ 1, 2 ], inc: [ 0, 0, 0 ], maxSize: 3 }
console.log(stk.pop()); // 2
console.log(stk); // CustomStack { stack: [ 1 ], inc: [ 0, 0, 0 ], maxSize: 3 }
stk.push(2);
console.log(stk); // CustomStack { stack: [ 1, 2 ], inc: [ 0, 0, 0 ], maxSize: 3 }
stk.push(3);
console.log(stk); // CustomStack { stack: [ 1, 2, 3 ], inc: [ 0, 0, 0 ], maxSize: 3 }
stk.push(4);
console.log(stk); // CustomStack { stack: [ 1, 2, 3 ], inc: [ 0, 0, 0 ], maxSize: 3 }
stk.increment(5, 100);
console.log(stk); // CustomStack { stack: [ 1, 2, 3 ], inc: [ 0, 0, 100 ], maxSize: 3 }
stk.increment(2, 100);
console.log(stk); //CustomStack { stack: [ 1, 2, 3 ], inc: [ 0, 100, 100 ], maxSize: 3 }
console.log(stk.pop()); // 103
console.log(stk); // CustomStack { stack: [ 1, 2 ], inc: [ 0, 200, 0 ], maxSize: 3 }
console.log(stk.pop()); // 202
console.log(stk); // CustomStack { stack: [ 1 ], inc: [ 200, 0, 0 ], maxSize: 3 }
console.log(stk.pop()); // 201
console.log(stk); // CustomStack { stack: [], inc: [ 0, 0, 0 ], maxSize: 3 }
console.log(stk.pop()); // -1
console.log(stk); // CustomStack { stack: [], inc: [ 0, 0, 0 ], maxSize: 3 }
