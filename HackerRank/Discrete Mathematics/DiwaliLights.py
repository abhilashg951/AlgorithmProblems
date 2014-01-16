"""
    On the eve of Diwali, Hari is decorating his house with a serial light bulb set. 
    The serial light bulb set has N bulbs placed sequentially on a string 
    which is programmed to change patterns every second. 
    If atleast one bulb in the set is on at any given instant of time, 
    how many different patterns of light can the serial light bulb set produce?

    Note: Lighting two bulbs *-* is different from **-

    Input Format
    The first line contains the number of test cases T, T lines follow. 
    Each line contains an integer N, the number of bulbs in the serial light bulb set.

    Output Format
    Print the total number of patterns modulo 105

    Constraints
    1 <= T <= 1000
    0< N < 104

    Sample Input

    2
    1
    2
    Sample Output

    1
    3
    Explanation

    Case 1: 1 bulb can be lit in only 1 way.
    Case 2: 2 bulbs can be lit in -*, *-, ** i.e. 3 ways.
"""


def num_ways_to_light(num_lightbulbs):
    return ((2 ** num_lightbulbs) - 1) % (10 ** 5)

if __name__ == "__main__":
    num_tests = int(raw_input())
    for _ in xrange(num_tests):
        print num_ways_to_light(int(raw_input()))
