/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public boolean isValid(String s) {
    
    if (s == null) return false;
    
    Stack<Character> brackets = new Stack<Character>();
    
    for (int i = 0; i < s.length(); i++) {
        
        char c = s.charAt(i);
        
        if (isOpeningBracket(c)) brackets.push(c);
        else if (isClosingBracket(c) 
            && (brackets.isEmpty() || ! isSameType(brackets.pop(), c))) return false;
    }

    return brackets.isEmpty();
}

private boolean isOpeningBracket(char c) {
    return c == '(' || c == '{' || c == '[';
}

private boolean isClosingBracket(char c) {
    return c == ')' || c == '}' || c == ']';
}

private boolean isSameType(char opening, char closing) {
    return (opening == '(' && closing == ')')  
        || (opening == '{' && closing == '}') 
        || (opening == '[' && closing == ']');
}
