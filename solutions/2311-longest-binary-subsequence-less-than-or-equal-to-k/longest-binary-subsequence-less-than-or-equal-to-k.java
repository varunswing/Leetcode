public class Solution {
    public int longestSubsequence(String s, int k) {
        int len = s.length();
        int count = 0;
        int zeros = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        long value = 0;
        int power = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (power < 32) { 
                    value += 1L << power;
                    if (value <= k) {
                        count++;
                    } else {
                        break;
                    }
                    power++;
                }
            } else {
                power++;
            }
        }

        return count + zeros;
    }
}
