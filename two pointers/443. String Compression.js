/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function (chars) {
  let i = 0,
    res = 0;
  while (i < chars.length) {
    let groupLength = 1;
    while (
      i + groupLength < chars.length &&
      chars[i + groupLength] == chars[i]
    ) {
      groupLength++;
    }
    chars[res] = chars[i];
    res++;
    if (groupLength > 1) {
      let groupLengthStr = groupLength.toString();
      for (let j = 0; j < groupLengthStr.length; j++) {
        chars[res] = groupLengthStr.charAt(j);
        res++;
      }
    }
    i += groupLength;
  }
  return res;
};
