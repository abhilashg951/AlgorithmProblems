class Solution:
    # @param x, an integer
    # @return an integer
    def sqrt(self, x):
        def is_good_enough(estimate):
            return abs((estimate * estimate) - x) <= 0.001
        def improve(estimate):
            return (estimate + (x / estimate)) / 2.0
        def guess_sqrt(estimate):
            if is_good_enough(estimate):
                return estimate
            else:
                return guess_sqrt(improve(estimate))
        return int(guess_sqrt(1.0))