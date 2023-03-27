import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// class Solution {
//   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//     Set<String> dict = new HashSet<>(wordList);
//     if (!dict.contains(endWord))
//       return 0;

//     Queue<String> q = new LinkedList<>();
//     int res = 1;
//     q.offer(beginWord);
//     while (!q.isEmpty()) {
//       int size = q.size();
//       for (int i = 0; i < size; i++) {
//         String word = q.poll();
//         if (word.equals(endWord))
//           // In Java, == checks whether two references refer to the same object in memory,
//           // not whether the objects have the same value. To compare strings by value, you
//           // should use the equals() method instead of the == operator.
//           return res;
//         for (int j = 0; j < beginWord.length(); j++) {
//           for (char letter = 'a'; letter <= 'z'; letter++) {
//             StringBuilder next = new StringBuilder(word);
//             next.setCharAt(j, letter);
//             String nextWord = next.toString();
//             if (dict.contains(nextWord)) {
//               if (nextWord.equals(endWord))
//                 return res + 1;
//               dict.remove(nextWord);
//               q.offer(nextWord);
//             }
//           }
//         }
//       }
//       res++;
//     }
//     return 0;
//   }
// }

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    if (!dict.contains(endWord))
      return 0;

    Queue<String> q = new LinkedList<>();
    int res = 1;
    q.offer(beginWord);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String word = q.poll();
        if (word.equals(endWord))
          return res;
        char[] chs = word.toCharArray();
        for (int j = 0; j < beginWord.length(); j++) {
          for (char letter = 'a'; letter <= 'z'; letter++) {
            char pre = chs[j];
            chs[j] = letter;
            String nextWord = new String(chs);
            if (dict.contains(nextWord)) {
              if (nextWord.equals(endWord))
                return res + 1;
              dict.remove(nextWord);
              q.offer(nextWord);
            }
            chs[j] = pre;
          }
        }
      }
      res++;
    }
    return 0;
  }
}