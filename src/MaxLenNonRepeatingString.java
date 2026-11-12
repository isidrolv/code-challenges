public class MaxLenNonRepeatingString {
    import java.util.HashMap;
    import java.util.Map;
    
  private class Solution {

    public int lengthOfLongestSubstring(String str) {
      Map<Character, Integer> map = new HashMap<>();
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


  public static void main(String[] args) {
    Solution solution = new MaxLenNonRepeatingString().new Solution();
    String testStr = "abcabcbb";
    int result = solution.lengthOfLongestSubstring(testStr);
    System.out.println("Test string: " + testStr);
    System.out.println("Max length: " + result);

    result = solution.lengthOfLongestSubstring("1R1T7R");
    System.out.println("Test string: " + "1R1T7R");
    System.out.println("Max length: " + result);
  }

}
