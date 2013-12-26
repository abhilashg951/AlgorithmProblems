/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

Map<Integer, Integer> results = new HashMap<Integer, Integer>();
    
public int climbStairs(int n) {
    if (n == 0) return 1;
    if (n < 0) return 0;

    if ( ! results.containsKey(n)) results.put(n, climbStairs(n - 1) + climbStairs(n - 2));
    return results.get(n);
}