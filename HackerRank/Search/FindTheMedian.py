"""
    In the Quicksort challenges, you sorted an entire array. 
    Sometimes, you just need specific information about a list of numbers, 
    and doing a full sort would be unnecessary. 
    Can you figure out a way to use your partition code to find the median in an array?

    Challenge
    Given a list of numbers, can you find the median?

    Input Format
    There will be two lines of input:

    n - the size of the array
    ar - n numbers that makes up the array
    Output Format
    Output one integer, the median.

    Constraints
    1<= n <= 1000001
    -10000 <= x <= 10000 , x ∈ ar 
    There will be an odd number of elements.

    Sample Input

    7
    0 1 2 4 6 5 3
    Sample Output

    3
"""


from random import randint

def swap(nums, i, j):
    nums[i], nums[j] = nums[j], nums[i]

def partition(nums, index):
    swap(nums, 0, index)
    pivot = nums[0]
    lesser_list = [x for x in nums[1:] if x <= pivot]
    greater_list = [x for x in nums[1:] if x > pivot]
    pivot_index = len(lesser_list)
    return pivot_index, lesser_list + [pivot] + greater_list
    
def median(nums):
    def helper(nums, index):
        median_num = -1
        rand_index, nums = partition(nums, randint(0, len(nums) - 1))
        result = nums[index]
        if rand_index < index: result = helper(nums[rand_index+1:], index - rand_index - 1)
        elif rand_index > index: result = helper(nums[:rand_index], index)
        return result
    return helper(nums, len(nums) / 2)
        
if __name__ == "__main__":
    _ = raw_input()
    nums = map(int, raw_input().split())
    if nums and len(nums) > 0:
        print median(nums)
