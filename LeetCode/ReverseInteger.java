/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */

public int reverse(int x) {
    boolean negative = x < 0;
    if (negative) x = -x;
    int result = 0;
    while (x > 0) {
        result = (result * 10) + (x % 10);
        x /= 10;
    }
    return negative ? -result : result;
}
