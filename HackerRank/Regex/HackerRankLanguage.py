"""
    Every submission at hackerrank has a field called language 
    which indicates the language in which a hacker has made his submission at hackerrank

    C:CPP:JAVA:PYTHON:PERL:PHP:RUBY:CSHARP:HASKELL:CLOJURE:BASH:SCALA:
    ERLANG:CLISP:LUA:BRAINFUCK:JAVASCRIPT:GO:D:OCAML:R:PASCAL:SBCL:DART:
    GROOVY:OBJECTIVEC

    Sometimes, error prone API requests has an invalid language field. 
    Could you find out if a given submission has a valid language field or not.

    Input Format

    First line contains N. N API requests follow, each in a newline. 
    Each request has an integer api_id and a string language 
    which are the request parameters placed by the an API request.

    Constraints

    1 <= N <= 100  
    10^4 <= api_id < 10^5  
    a valid language is any of the languages listed above (case sensitive)

    Output Format

    For every api request given in input, 
    print “VALID” if it has a valid language string in it 
    or print “INVALID” otherwise.

    Sample Input

    3
    11011 LUA
    11022 BRAINFUCK
    11044 X

    Sample Output

    VALID
    VALID
    INVALID

    Explanation

    LUA and BRAINFUCK are valid languages as listed above. 
    As X is doesn’t appear in the list, it is an invalid request.
"""


import re

VALID_LANGUAGES = ["BASH",
                   "BRAINFUCK",
                   "C",
                   "CLISP",
                   "CLOJURE",
                   "CPP",
                   "CSHARP",
                   "D",
                   "DART",
                   "ERLANG",
                   "GO",
                   "GROOVY",
                   "HASKELL",
                   "JAVA",
                   "JAVASCRIPT",
                   "LUA",
                   "OBJECTIVEC",
                   "OCAML",
                   "PASCAL",
                   "PERL",
                   "PHP",
                   "PYTHON",
                   "R",
                   "RUBY",
                   "SBCL",
                   "SCALA",
                   ]

def has_valid_language(s):
    languages = '(' + '|'.join(VALID_LANGUAGES) + ')'
    return "VALID" if re.match("\d{4,5}\s"+languages+"$", s) is not None else "INVALID"

if __name__ == "__main__":
    num_tests = int(raw_input())
    for _ in xrange(num_tests):
        print has_valid_language(raw_input())
