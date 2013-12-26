/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

int longestLength = 0;
    
public int lengthOfLongestSubstring(String s) {
    for (int i = 0; i < s.length(); i++) {
        lengthOfLongestSubstring(s, i);
    }
    return longestLength;
}

private void lengthOfLongestSubstring(String s, int start) {
    
    if (s == null || s.length() < 1) return;
    
    Set<Character> set = new HashSet<Character>();
    for (int i = start; i < s.length(); i++) {
        
        if (set.contains(s.charAt(i))) return;
        set.add(s.charAt(i));
        
        longestLength = max(longestLength, i - start + 1);
    }
    
}

private int max(int x, int y) {
    return x > y ? x : y;
}