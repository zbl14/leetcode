//栈是一种遵从后进先出(LIFO)原则的邮箱有序集合，新添加或待删除的元素都保存在栈的同一端，称之为栈顶，另一端叫栈底。

// stack based on array
class Stack {
  constructor() {
    this.items = [];
  }
  push(element) {
    this.items.push(element);
  }
  pop() {
    return this.items.pop();
  }
  peek() {
    return this.items[this.size() - 1];
  }
  isEmpty() {
    return this.items.length === 0;
  }
  clear() {
    return (this.items = []);
  }
  size() {
    return this.items.length;
  }
}

const nextGreaterElement = (nums) => {
  const res = [];
  const stack = [];
  for (let i = nums.length - 1; i >= 0; i--) {
    while (stack.length !== 0 && nums[i] >= stack[stack.length - 1])
      stack.pop();
    res[i] = stack.length === 0 ? -1 : stack[stack.length - 1];
    stack.push(nums[i]);
  }
  return res;
};

const nums = [2, 1, 2, 4, 4];
console.log(nextGreaterElement(nums));
