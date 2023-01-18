// push(x): O(1) time complexity and O(n) space complexity, where n is the number of elements in the stack.
// pop(): O(n) time complexity and O(n) space complexity, where n is the number of elements in the stack.
// top(): O(n) time complexity and O(n) space complexity, where n is the number of elements in the stack.
// empty(): O(1) time complexity and O(1) space complexity.

var MyStack = function () {
  this.inQueue = [];
  this.outQueue = [];
};

MyStack.prototype.push = function (x) {
  this.inQueue.push(x);
};

MyStack.prototype.pop = function () {
  while (this.inQueue.length > 1) {
    this.outQueue.push(this.inQueue.shift());
  }
  const top = this.inQueue.shift();
  [this.inQueue, this.outQueue] = [this.outQueue, this.inQueue];
  return top;
};

MyStack.prototype.top = function () {
  while (this.inQueue.length > 1) {
    this.outQueue.push(this.inQueue.shift());
  }
  const top = this.inQueue[0];
  this.outQueue.push(this.inQueue.shift());
  [this.inQueue, this.outQueue] = [this.outQueue, this.inQueue];
  return top;
};

MyStack.prototype.empty = function () {
  return this.inQueue.length === 0;
};

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
