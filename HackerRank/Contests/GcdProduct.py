"""
	This time your assignment is really simple.

	Calculate GCD(1, 1) * GCD(1, 2) * … * GCD(1, M) * GCD(2, 1) * GCD(2, 2) * … * GCD(2, M) * … * GCD(N, 1) * GCD(N, 2) * … * GCD(N, M).

	where GCD is defined as the Greatest Common Devisor.

	Input Format

	The first and only line contains two space separated integers N and M.

	Output Format

	Output the required product modulo 109+7.

	Constraints

	1 <= N, M <= 1.5 * 107

	Sample input:

	4 4
	Sample output:

	96
	Explanation

	For the above testcase, N = 4, M = 4. So,

	GCD(1, 1) * GCD(1, 2) * …… * GCD(4, 4) = 1 * 1 * 1 * 1 * 1 * 2 * 1 * 2 * 1 * 1 * 3 * 1 * 1 * 2 * 1 * 4 = 96.
"""

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

n, m = map(int, raw_input().split())

gcd_results = []
for i in xrange(1, n+1):
    for j in xrange(1, m+1):
        gcd_results.append(gcd(i,j))

print reduce(lambda x, y: x * y, gcd_results, 1)