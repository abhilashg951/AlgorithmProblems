/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */

public int lengthOfLastWord(String s) {
    int result = 0;
    int i = s.length() - 1;
    // Skip over spaces from the end
    while (i >= 0 && s.charAt(i) == ' ') i--;
    // Find length of last word
    while (i >= 0 && s.charAt(i) != ' ') {
        i--;
        result++;
    }
    return result;
}