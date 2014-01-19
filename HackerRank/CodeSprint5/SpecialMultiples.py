"""
    You are given an integer N. 
    Can you find the least positive integer X made up of only 9’s and 0’s such that X is a multiple of N?

    Update

    X is made up of one or more occurences of 9 and zero or more occurences of 0.

    Input Format
    The first line contains an integer T which denotes the number of test cases. T lines follow.
    Each line contains the integer N for which the solution has to be found.

    Output Format
    Print the answer X to STDOUT corresponding to each test case. 
    The output should not contain any leading zeroes.

    Constraints
    1 <= T <= 104
    1 <= N <= 500

    Sample Input

    3
    5
    7
    1

    Sample Output

    90
    9009
    9

    Explanation

    90 is the smallest number made up of 9’s and 0’s divisible by 5. 
    You can derive similarly for other cases.
"""


def special_numbers():
    num = 1
    while True:
        yield int("".join(map(lambda d: '9' if d == '1' else '0', bin(num)[2:])))
        num += 1
        
def special_multiple(num):
    result = 0
    nums = special_numbers()
    while True:
        result = nums.next()
        if result % num == 0: break
    return result   

if __name__ == "__main__":
    num_tests = int(raw_input())
    for _ in xrange(num_tests):
        print special_multiple(int(raw_input()))