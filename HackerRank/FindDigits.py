"""
    Problem Statement

    Given a number you have to print how many digits in that number exactly divides that number.

    Input format

    The first line contains T (number of test cases followed by t lines each containing n

    Constraints
    1 <=T <= 15
    0 < N < 1010

    Output Format
    Number of digits in that number exactly divides that number.

    Input

    1  
    12
    
    Output

    2
"""


def find_digits(num):
    return len([x for x in num if int(x) > 0 and int(num)%int(x) == 0])
    
if __name__ == "__main__":
    num_tests = int(raw_input())
    for _ in xrange(num_tests):
        print find_digits(raw_input())