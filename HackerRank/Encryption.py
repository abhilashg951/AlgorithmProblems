"""
    One classic method for composing secret messages is called a square code.  
    The spaces are removed from the english text and the characters are written into a square (or rectangle). 
    The width and height of the rectangle have the constraint,

    floor(sqrt(word)) <= width, height <= ceil(sqrt(word))

    Among the possible squares, choose the one with the minimum area.

    in case of rectangle number of rows is kept smaller than number of columns) . 
    For example, the sentence “if man was meant to stay on the ground god would have given us roots” 
    is 54 characters long, so it is written into a rectangle with 7 rows and 8 columns.

        ifmanwas
        meanttos        
        tayonthe
        groundgo
        dwouldha
        vegivenu
        sroots

    The coded message is obtained by reading down the columns going left to right. 
    For example, the message above is coded as:

    imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau

    You will be given a message in english with no spaces between the words.
    The maximum message length be 81 characters. 
    Print the encoded message. 
    In the encoded message there should be a space between any two consecutive words.

    Here are some more examples:

    Sample Input:

    haveaniceday

    Sample Output:

    hae and via ecy

    Sample Input:

    feedthedog    

    Sample Output:

    fto ehg ee dd

    Sample Input:

    chillout

    Sample Output:

    clu hlt io
"""


import math, sys

def best_w_h(min_val, max_val, msg_len):
    result_width, result_height, min_diff = 0, 0, sys.maxint
    for height in xrange(min_val, max_val+1):
        width = int(math.ceil(msg_len / float(height)))
        area = width * height
        diff = abs(width - height)
        if area >= msg_len and diff < min_diff:
            result_width, result_height = width, height
            min_diff = diff
    return result_width, result_height

def squared_msg(msg, width, height):
    result = []
    for i in xrange(height):
        start = i * width
        result.append(msg[start:start+width])
    return result
    
def encoded_msg(msg_square, width, height):
    result = []
    for i in xrange(width):
        for j in xrange(height):
            if i < len(msg_square[j]):
                result.append(msg_square[j][i])
        result.append(' ')
    return "".join(result[:-1])
            
if __name__ == "__main__":
    msg = raw_input()
    min_val = int(math.floor(math.sqrt(len(msg))))
    max_val = int(math.ceil(math.sqrt(len(msg))))
    width, height = best_w_h(min_val, max_val, len(msg))
    print encoded_msg(squared_msg(msg, width, height), width, height)
