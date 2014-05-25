def get_tree_height(n):
    result = 1
    for i in xrange(1, n+1):
        result = (result + 1) if (i % 2 == 0) else (result * 2)
    return result

num_tests = int(raw_input())
for _ in xrange(num_tests):
    N = int(raw_input())
    print get_tree_height(N)