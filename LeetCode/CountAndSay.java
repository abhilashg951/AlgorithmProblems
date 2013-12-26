/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */

public String countAndSay(int n) {
    if (n == 1) return "1";
    
    StringBuffer sb = new StringBuffer();
    String prevResult = countAndSay(n - 1);
    for (int i = 0; i < prevResult.length(); i++) {
        int num = prevResult.charAt(i) - '0';
        int numNum = numberConsecutive(prevResult, i);
        sb.append(String.valueOf(numNum));
        sb.append(String.valueOf(num));
        i += numNum - 1;
    }
    return sb.toString();
}

private int numberConsecutive(String s, int start) {
    int result = 1;
    char num = s.charAt(start);
    for (int i = start + 1; i < s.length(); i++) {
        if (s.charAt(i) == num) result++;
        else break;
    }
    return result;
}
