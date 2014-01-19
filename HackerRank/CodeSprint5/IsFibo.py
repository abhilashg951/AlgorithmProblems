"""
    You are given an integer N, can you check if the number is an element of fibonacci series? 
    The first few elements of fibonacci series are 0,1,1,2,3,5,8,13…. 
    A fibonacci series is one where every element is a sum of the previous two elements in the series. 
    The first two elements are 0 and 1.

    Formally:

    fib0 = 0
    fib1 = 1
    fibn = fibn-1 + fibn-2 ∀ n > 1

    Input Format
    First line contains T, number of test cases. 
    T lines follows. Each line will contain an integer N.

    Output Format
    Output “IsFibo” (without quotes) if N is a fibonacci number and “IsNotFibo” (without quotes) 
    if it is not a fibonacci number, in a new line corresponding to each test case.

    Constraints
    1 <= T <= 105
    1 <= N <= 1010

    Sample Input

    3
    5
    7
    8
    
    Sample Output

    IsFibo
    IsNotFibo
    IsFibo

    Explanation

    5 is a Fibonacci number given by fib5 = 3 + 2
    7 is not a Fibonacci number
    8 is a Fibonacci number given by fib6 = 5 + 3
"""


import sys
from collections import deque

def is_fibo(num):
    greatest_fibo = 0
    fibos_stream = deque([0,1])
    while greatest_fibo < num:
        greatest_fibo = sum(fibos_stream)
        fibos_stream.append(greatest_fibo)
        fibos_stream.popleft()
    return "IsFibo" if greatest_fibo == num else "IsNotFibo"
        

if __name__ == "__main__":
    num_tests = int(raw_input())
    for _ in xrange(num_tests):
        print is_fibo(int(raw_input()))
