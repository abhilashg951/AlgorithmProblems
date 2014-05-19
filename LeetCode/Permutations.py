class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permute(self, num):
        result = [[]]
        for this_num in num:
            previous_result = result
            result = []
            for permutation in previous_result:
                # Base case where previous_result = [[]]
                if not permutation:
                    result.append([this_num])
                # Normal case where previous_result contains all permutations in list num up to this_num
                # Insert this_num in all possible positions in the previous_result, then append to result
                else:
                    for slice_index in xrange(len(permutation) + 1):
                        result.append(permutation[:slice_index] + [this_num] + permutation[slice_index:])
        return result