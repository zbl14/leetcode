// TC = O(1)
const FreqStack = function () {
  this.map = new Map(); // <element, freq>
  this.freqToElement = new Map(); // <freq, elements>
  this.maxFreq = 0;
};

FreqStack.prototype.push = function (x) {
  this.map.set(x, (this.map.get(x) || 0) + 1);
  let curFreq = this.map.get(x);
  if (!this.freqToElement.has(curFreq)) this.freqToElement.set(curFreq, []);
  this.freqToElement.get(curFreq).push(x);
  this.maxFreq = Math.max(curFreq, this.maxFreq);
};

FreqStack.prototype.pop = function () {
  let x = this.freqToElement.get(this.maxFreq).pop();
  if (this.freqToElement.get(this.maxFreq).length === 0) this.maxFreq--;
  this.map.set(x, this.map.get(x) - 1);
  return x;
};
