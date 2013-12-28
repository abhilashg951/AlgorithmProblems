/** 
 * Given a roman numeral, convert it to an integer.
 */

public int romanToInt(String s) {
    int result = 0;
    int i = s.length() - 1;
    while (i >= 0) {
        boolean combo = i > 0 && isCombination(s.charAt(i-1), s.charAt(i));
        result += combo 
            ? convert(new StringBuilder().append(s.charAt(i-1)).append(s.charAt(i)).toString())
            : convert(new StringBuilder().append(s.charAt(i)).toString());
        i -= combo ? 2 : 1;
    }
    return result;
}

private boolean isCombination(char c, char d) {
    return (c == 'I' && (d == 'V' || d == 'X')) 
        || (c == 'X' && (d == 'L' || d == 'C'))
        || (c == 'C' && (d == 'D' || d == 'M'));
}

private int convert(String s) {
    int result = 0;
    
    if (s.equals("I"))          result = 1;
    else if (s.equals("IV"))    result = 4;
    else if (s.equals("V"))     result = 5;
    else if (s.equals("IX"))    result = 9;
    else if (s.equals("X"))     result = 10;
    else if (s.equals("XL"))    result = 40;
    else if (s.equals("L"))     result = 50;
    else if (s.equals("XC"))    result = 90;
    else if (s.equals("C"))     result = 100;
    else if (s.equals("CD"))    result = 400;
    else if (s.equals("D"))     result = 500;
    else if (s.equals("CM"))    result = 900;
    else if (s.equals("M"))     result = 1000;
    
    return result;
}
