/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

public boolean isPalindrome(String s) {

    if (s == null || s.length() <= 1) return true;
    
    s = s.toLowerCase();
    
    for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {

        while(i < s.length() && ! isValidChar(s.charAt(i))) i++;
        while(j >= 0 && ! isValidChar(s.charAt(j))) j--;
        
        if (i > j) break;
        
        char left = s.charAt(i);
        char right = s.charAt(j);
         
        if (left != right) return false;
    }
    
    return true;
}

private boolean isValidChar(char c) {
    return isAlphabet(c) || isNumber(c);
}

private boolean isAlphabet(char c) {
    return c >= 'a' && c <= 'z';
}

private boolean isNumber(char c) {
    return c >= '0' && c <= '9';
}
