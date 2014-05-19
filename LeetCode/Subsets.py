class Solution:
    # @param S, a list of integer
    # @return a list of lists of integer
    def subsets(self, S):
        result = [[]]
        for num in sorted(S):
            these_sets = []
            for this_set in result:
                these_sets.append(this_set + [num])
            result.extend(these_sets)
        return result