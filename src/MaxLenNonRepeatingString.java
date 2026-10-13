public class MaxLenNonRepeatingString {

  private class Solution {

    public int lengthOfLongestSubstring(String str) {
      String Map<Character, Integer> map = new HashMap<>();
      int maxlen = 0;
      int left = 0;
      for (int i = 0; i < str.length(); i++) {
        char chr = str.charAt(i);
        System.out.println("step " + i + "; str=" + str);
        
        System.out.println(chr);
        if (map.containsKey(chr)) {
          left = Math.max(left, map.get(chr) + 1);
        }
        map.put(chr, i);
        maxlen = Math.max(maxlen, i - left + 1);
        System.out.println("maxlen=" + maxlen);
      }
      return maxlen;
    }
  }
}
