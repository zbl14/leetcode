// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         char res = ' ';
//         for(char c : letters){
//             if(c > target) {
//                 res = c;
//                 break;
//             }
//         }
//         return res == ' ' ? letters[0] : res;
//     }
// }

class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    char res = letters[0];
    int l = 0;
    int r = letters.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (letters[mid] > target) {
        res = letters[mid];
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return res;
  }
}