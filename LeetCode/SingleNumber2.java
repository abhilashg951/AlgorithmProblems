/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 */

public int singleNumber(int[] A) {
        
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for (int i = 0; i < A.length; i++) {
        int thisNum = A[i];
        map.put(thisNum, map.containsKey(thisNum) ? map.get(thisNum) + 1 : 1);
    }
    
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() != 3) return entry.getKey();
    }
    
    return 0;
}