"""
    Given a string consisting of a,b and c’s, we can perform the following operation: Take any two adjacent distinct characters and replace it with the third character. For example, if ‘a’ and ‘c’ are adjacent, they can replaced with ‘b’. What is the smallest string which can result by applying this operation repeatedly?

    Input:
    The first line contains the number of test cases T. T test cases follow. Each case contains the string you start with.

    Output:
    Output T lines, one for each test case containing the smallest length of the resultant string after applying the operations optimally.

    Constraints:
    1 <= T <= 100
    The string will have at most 100 characters.

    Sample Input:
    3
    cab
    bcab
    ccccc

    Sample Output:
    2
    1
    5

    Explanation:
    For the first case, you can either get cab -> cc or cab -> bb, resulting in a string of length 2.
    For the second case, one optimal solution is: bcab -> aab -> ac -> b. No more operations can be applied and the resultant string has length 1.
    For the third case, no operations can be performed and so the answer is 5.
"""


def string_reduction(s):
    
    char_counts = [s.count('a'), s.count('b'), s.count('c')]
    zeroes = char_counts.count(0)
    all_even = num_evens(char_counts) == len(char_counts)
    all_odd = num_odds(char_counts) == len(char_counts)
    
    return sum(char_counts) if zeroes >= 2 else 2 if all_even or all_odd else 1

def num_evens(nums):
    return len(filter(lambda x: x%2 == 0, nums))

def num_odds(nums):
    return len(filter(lambda x: x%2 != 0, nums))

if __name__ == '__main__':
    t = input()
    for i in range(0,t):
        s = raw_input()
        print string_reduction(s)
