class MinStack {
  constructor() {
    this.stack = [];
  }

  push(x) {
    if (!this.stack.length) {
      this.stack.push([x, x]);
      return;
    }
    let min = this.stack[this.stack.length - 1][1];
    this.stack.push([x, Math.min(x, min)]);
  }

  pop() {
    this.stack.pop();
  }

  top() {
    return this.stack[this.stack.length - 1][0];
  }

  getMin() {
    return this.stack[this.stack.length - 1][1];
  }
}
