class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        i, j = m - 1, n - 1
        current_index = m + n - 1
        while i >= 0 and j >= 0:
            A[current_index] = max(A[i], B[j])
            if A[i] == A[current_index]:
                i -= 1
            else:
                j -= 1
            current_index -= 1
        while i >= 0:
            A[current_index] = A[i]
            current_index -= 1
            i -= 1
        while j >= 0:
            A[current_index] = B[j]
            current_index -= 1
            j -= 1