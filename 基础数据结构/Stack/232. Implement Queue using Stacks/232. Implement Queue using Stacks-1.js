// TC = amortized O(1)
var MyQueue = function () {
  this.queue = [];
  this.stack = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
  this.stack.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function () {
  this.peek();
  return this.queue.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function () {
  if (!this.queue.length) {
    while (this.stack.length) {
      this.queue.push(this.stack.pop());
    }
  }
  return this.queue[this.queue.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
  return !this.queue.length && !this.stack.length;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
