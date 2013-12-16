/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit. 
 */

public int maxProfit(int[] prices) {

    if (prices == null || prices.length <=1) return 0;
    
    int minStock = Integer.MAX_VALUE;
    int maxDifference = Integer.MIN_VALUE;
    
    for (int i = 0; i < prices.length; i++) {

        int thisStock = prices[i];
        
        minStock = min(minStock, thisStock);
        
        maxDifference = max(maxDifference, thisStock - minStock);
    }
    
    return maxDifference;
}

private int min(int x, int y) {
    return x < y ? x : y;
}

private int max(int x, int y) {
    return x > y ? x : y;
}
