 /**
 *  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 *   Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 *  Some examples:
 *     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *     ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public int evalRPN(String[] tokens) {
    
    if (tokens == null) return 0;
    
    Stack<Integer> numberStack = new Stack<Integer>();

    for (int i = 0; i < tokens.length; i++) {
        String s = tokens[i];
        
        if (isOperator(s)) {
            
            int n2 = numberStack.pop();
            int n1 = numberStack.pop();
            
            char c = s.charAt(0);
            
            if (c == '+') {
                numberStack.push(n1 + n2);
            } else if (c == '-') {
                numberStack.push(n1 - n2);
            } else if (c == '*') {
                numberStack.push(n1 * n2);
            } else if (c == '/') {
                numberStack.push(n1 / n2);
            }
        } 
        
        else {
            numberStack.push(Integer.valueOf(s));
        }
    }
    return numberStack.pop();
}

private boolean isOperator(String s) {
    if (s == null || s.length() != 1) return false;
    char c = s.charAt(0);
    return c == '+' || c == '-' || c == '*' || c =='/';
}

