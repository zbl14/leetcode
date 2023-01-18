// push(x): O(n) time complexity and O(n) space complexity, where n is the number of elements in the stack.
// pop(): O(1) time complexity and O(n) space complexity, where n is the number of elements in the stack.
// top(): O(1) time complexity and O(n) space complexity, where n is the number of elements in the stack.
// empty(): O(1) time complexity and O(1) space complexity.

var MyStack = function () {
  this.q1 = [];
  this.q2 = [];
};

MyStack.prototype.push = function (x) {
  if (!this.q1.length) this.q1.push(x);
  while (this.q2.length) this.q1.push(this.q2.shift());
  while (this.q1.length) this.q2.push(this.q1.shift());
};

MyStack.prototype.pop = function () {
  return this.q2.shift();
};

MyStack.prototype.top = function () {
  return this.q2[0];
};

MyStack.prototype.empty = function () {
  return !this.q1.length && !this.q2.length;
};

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
