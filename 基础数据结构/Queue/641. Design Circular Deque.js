/**
 * @param {number} k
 */
class MyCircularDeque {
  constructor(k) {
    this.q = new Array(k);
    this.front = 0;
    this.rear = -1;
    this.size = 0;
    this.capacity = k;
  }
  /**
   * @param {number} value
   * @return {boolean}
   */
  insertFront(value) {
    if (this.isFull()) return false;
    if (--this.front < 0) this.front += this.capacity;
    this.q[this.front] = value;
    this.size++;
    if (this.size === 1) this.rear = this.front;
    return true;
  }
  /**
   * @param {number} value
   * @return {boolean}
   */
  insertLast(value) {
    if (this.isFull()) return false;
    this.rear = (this.rear + 1) % this.capacity;
    this.q[this.rear] = value;
    this.size++;
    return true;
  }
  /**
   * @return {boolean}
   */
  deleteFront() {
    if (this.isEmpty()) return false;
    this.front = (this.front + 1) % this.capacity;
    this.size--;
    return true;
  }
  /**
   * @return {boolean}
   */
  deleteLast() {
    if (this.isEmpty()) return false;
    if (--this.rear < 0) this.rear += this.capacity;
    this.size--;
    return true;
  }
  /**
   * @return {number}
   */
  getFront() {
    return this.isEmpty() ? -1 : this.q[this.front];
  }
  /**
   * @return {number}
   */
  getRear() {
    return this.isEmpty() ? -1 : this.q[this.rear];
  }
  /**
   * @return {boolean}
   */
  isEmpty() {
    return this.size === 0;
  }
  /**
   * @return {boolean}
   */
  isFull() {
    return this.size === this.capacity;
  }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
