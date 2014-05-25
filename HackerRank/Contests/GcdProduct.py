
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