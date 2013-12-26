/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */

public int[] searchRange(int[] A, int target) {
    
    int[] result = {-1, -1};
    
    if (A == null || A.length < 1) return result;
    
    int index = binarySearch(A, target, 0, A.length - 1);
    
    if (index > -1) {
        result[0] = index == 0 ? 0 : findLeft(A, index);
        result[1] = index == A.length - 1 ? A.length - 1 : findRight(A, index);
    }
        
    return result;
}

private int binarySearch(int[] A, int target, int start, int end) {
    if (start > end) return -1;
    int middle = start + (end - start) / 2;
    
    if (A[middle] == target) return middle;
    if (A[middle] > target) return binarySearch(A, target, start, middle-1);
    return binarySearch(A, target, middle+1, end);
}

private int findLeft(int[] A, int index) {
    while (A[index] == A[index - 1]) {
        index--;
        if (index == 0) return index;
    }
    return index;
}

private int findRight(int[] A, int index) {
    while (A[index] == A[index + 1]) {
        index++;
        if (index == A.length - 1) return index;
    }
    return index;
}
