/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */

var strStr = function (haystack, needle) {
  const length1 = haystack.length;
  const length2 = needle.length;
  if (length1 < length2) {
    return -1;
  }
  for (let i = 0; i <= length1 - length2; i++) {
    let flag = true;
    for (let j = 0; j < length2; j++) {
      if (haystack[i + j] !== needle[j]) {
        flag = false;
        break;
      }
    }
    if (flag) return i;
  }
  return -1;
};

// var strStr = function(haystack, needle) {
//     if(needle.length === 0) return 0
//     if(haystack.length < needle.length) return -1;
//     let l = 0;
//     let k = 0;
//     for (let r = 0; r < haystack.length; r++) {
//         if (haystack.charAt(r) === needle.charAt(k)) {
//             k++;
//             if (k === needle.length) {
//                 return l;
//             }
//         } else {
//             l++;
//             r = l - 1;
//             k = 0;
//         }
//     }
//     return -1;
// };
