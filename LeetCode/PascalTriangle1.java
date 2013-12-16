/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public ArrayList<ArrayList<Integer>> generate(int numRows) {
    
    ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
    
    if (numRows < 1) return triangle;
    
    ArrayList<Integer> firstRow = new ArrayList<Integer>();
    
    firstRow.add(1);
    triangle.add(firstRow);
    
    ArrayList<Integer> thisRow = new ArrayList<Integer>();
    ArrayList<Integer> lastRow = firstRow;
    
    for (int i = 0; i < numRows - 1; i++) {
        
        for (int j = 0; j < lastRow.size() + 1; j++) {
            
            if (j == 0 || j == lastRow.size()) {
                thisRow.add(1);
            } 
            
            else {
                thisRow.add(lastRow.get(j-1) + lastRow.get(j));
            }
        }
        
        triangle.add(thisRow);
        
        lastRow = thisRow;
        thisRow = new ArrayList<Integer>();
    }
    
    return triangle;
}
