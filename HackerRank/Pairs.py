"""
    Given N integers, count the total pairs of integers that have a difference of K.

    Input Format 
    1st line contains N & K (integers).
    2nd line contains N numbers of the set. All the N numbers are assured to be distinct.

    Output Format
    One integer saying the number of pairs of numbers that have a diff K.

    Constraints:
    N <= 10^5
    0 < K < 10^9
    Each integer will be greater than 0 and at least K away from 2^31-1

    Sample Input #00:
    5 2  
    1 5 3 4 2  

    Sample Output #00:
    3
"""


def pairs(a, k):
    nums_set = set()
    answer = 0

    for num in a:
        if num - k in nums_set:
            answer += 1
        if num + k in nums_set:
            answer += 1
        nums_set.add(num)

    return answer

if __name__ == '__main__':
    a = map(int, raw_input().strip().split(" "))
    _a_size = a[0]
    _k = a[1]
    b = map(int, raw_input().strip().split(" "))
    print pairs(b, _k)
