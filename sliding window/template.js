//本质为two pointer，三步走 进-出-算
const temp = (str, k) => {
  const map = new Map();
  let l = 0,
    res = 0;
  for (let r = 0; r < str.length; r++) {
    const cur = str.charAt(r);
    map.set(cur, (map.get(cur) || 0) + 1); //1. 当前遍历的r进入窗口
    while (map.size > k) {
      //2. 当窗口不符合条件时left持续退出窗口
      const leftChar = s.charAt(l);
      map.set(cur.map.get(leftChar) - 1);
      if (map.get(leftChar) === 0) map.delete(leftChar);
      l++; //出的时候注意移动left pointer
    }
    res = Math.max(res, r - l + 1); //3. 窗口valid了，我们计算结果
  }
  return res;
};
