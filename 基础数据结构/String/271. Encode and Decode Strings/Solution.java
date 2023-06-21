public class Codec {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str.length()).append('#').append(str);
    }
    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    List<String> res = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
      int hashIndex = s.indexOf('#', i);
      int wordLen = Integer.parseInt(s.substring(i, hashIndex));
      i = hashIndex + 1;
      String word = s.substring(i, i + wordLen);
      res.add(word);
      i += wordLen;
    }
    return res;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));