"""
    Sid is obsessed about reading short stories. Being a CS student, he is doing some interesting frequency analysis with the books. From two short story books, he choses strings having length a from the first and strings having length b from the second one. The strings are such that the difference of length is <= 1

    i.e.

    |a-b|<=1, where |x| represents the absolute value function.
    He believes that both the strings should be anagrams based on his experiment. 
    Your challenge is to help him find the minimum number of characters of the first string 
    he needs to change to make it an anagram of the second string. 
    Neither can he add a character nor delete a character from the first string. 
    Only replacement of the characters with new ones is allowed.

    Input Format

    First line will contain an integer T representing the number of test cases 
    Each test case will contain a string having length (a+b) 
    which will be concatenation of both the strings described in problem. 
    The string will only contain small letters and without any spaces.

    Output Format

    An integer corresponding to each test case is printed in a different line 
    i.e., the number of changes required for each test case. 
    Print ‘-1’ if it is not possible.

    Constraints

    1<=T<=100
    length of input string i.e. 1<=a+b<=10000

    Sample Input

    5
    aaabbb
    ab
    abc
    mnop
    xyyx

    Sample Output

    3
    1
    -1
    2
    0 
    
    Explanation

    In fifth test case, first string will be “xy” while second string will be “yx” . so a = 2 and b = 2, where a and b are length of strings. As we can see that a and b are following relation

    |a-b|<=1
    and both strings are anagrams.So number of changes required = 0.
"""


def num_changes_anagram(s):
    if len(s) % 2 != 0: return -1 # Odd length -> Not possible!
    a, b = s[:len(s)/2], s[len(s)/2:]
    num_changes = 0
    
    # Build char dict from a
    char_dict = {}
    for c in a:
        if c not in char_dict: char_dict[c] = 1
        else: char_dict[c] += 1
    
    # Check number of differences in b from char_dict
    for c in b:
        if c not in char_dict: num_changes += 1
        else: 
            char_dict[c] -= 1
            if char_dict[c] == 0: del char_dict[c]
    
    return num_changes

if __name__ == "__main__":
    num_tests = int(raw_input())
    for _ in xrange(num_tests):
        print num_changes_anagram(raw_input())
