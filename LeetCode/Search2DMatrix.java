/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */

public boolean searchMatrix(int[][] matrix, int target) {
    return searchMatrix(matrix, target, 0, 0);
}

private boolean searchMatrix(int[][] matrix, int target, int row, int col) {
    // Out of bounds -> Target not found
    if (row >= matrix.length || col >= matrix[row].length) {
        return false;
    }
    // Target found
    if (target == matrix[row][col]) {
        return true;
    }
    // Target is not in this row (greater than last element)
    if (target > matrix[row][matrix[row].length - 1]) {
        return searchMatrix(matrix, target, row+1, col);
    } 
    // Binary search on this row as target can only be in this row
    return binarySearch(matrix[row], target, 0, matrix[row].length - 1);
}

private boolean binarySearch(int[] row, int target, int start, int end) {
    if (start > end) return false;
    int middle = start + ((end - start) / 2);
    if (row[middle] == target) return true;
    if (row[middle] > target) return binarySearch(row, target, start, middle - 1);
    return binarySearch(row, target, middle + 1, end);
}
