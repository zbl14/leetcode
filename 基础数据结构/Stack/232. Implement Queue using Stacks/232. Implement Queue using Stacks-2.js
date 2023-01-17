// TC = O(n)
var MyQueue = function () {
  this.queue = [];
  this.stack = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
  if (!this.queue.length) this.queue.push(x);
  else {
    while (this.queue.length) this.stack.push(this.queue.pop());
    this.queue.push(x);
    while (this.stack.length) this.queue.push(this.stack.pop());
  }
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function () {
  return this.queue.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function () {
  return this.queue[this.queue.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
  return !this.queue.length;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
