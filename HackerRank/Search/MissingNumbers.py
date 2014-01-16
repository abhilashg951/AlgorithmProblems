"""
    Sometimes you need to compare lists of number, but sorting each one normally will take too much time. 
    Instead you can use alternative methods to find the differences between each list.

    Challenge
    Numeros The Artist was arranging two identical lists A and B into specific orders. 
    The arrangements of the two arrays were random, Numeros was very proud of his arrangements. 
    Unfortunately, some numbers got left out of List A. 
    Can you find the missing numbers from A without messing up his order?

    Details
    There are many duplicates in the lists, but you need to find the extra numbers, i.e. B - A. 
    Print the numbers in numerical order. Print each missing number once, even if it is missing multiple times. 
    The numbers are all within a range of 100 from each other.

    Input Format
    There will be four lines of input:

    n - the size of the first list
    This is followed by n numbers that makes up the first list.
    m - the size of the second list
    This is followed by m numbers that makes up the second list.

    Output Format
    Output all the numbers (in ascending order) that are in B but not in A.

    Constraints
    1<= n,m <= 1000001
    -10000 <= x <= 10000 , x ∈ B
    Xmax - Xmin < 101

    Sample Input

    10
    203 204 205 206 207 208 203 204 205 206
    13
    203 204 204 205 206 207 205 208 203 206 205 206 204
    Sample Output

    204 205 206
    Explanation
    Although 204 presented in both arrays, but 204’s frequency in A is smaller than that of B. 
    Similarly 205 and 206 occur twice in A but thrice in B. 
    So, these three numbers constitute the output. 
    The rest of the numbers occur at least as many times in A as they do in B - so they are not “missing numbers”.
"""


def remove_duplicates(sorted_arr):
    i = 0
    while i < len(sorted_arr) - 1:
        if sorted_arr[i] == sorted_arr[i+1]:
            del sorted_arr[i]
        else:
            i += 1
    return sorted_arr

def difference_list(a, b):
    nums_dict = {}
    result = []
    for num in a:
        if num not in nums_dict: nums_dict[num] = 1
        else: nums_dict[num] += 1
    for num in b:
        if num not in nums_dict: result.append(num)
        else: 
            nums_dict[num] -= 1
            if nums_dict[num] == 0: del nums_dict[num]
    return remove_duplicates(sorted(result))      

if __name__ == "__main__":
    _, a = raw_input(), map(int, raw_input().split())
    _, b = raw_input(), map(int, raw_input().split())
    print " ".join(map(str, difference_list(a, b)))
