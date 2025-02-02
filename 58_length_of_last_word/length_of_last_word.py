'''
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal 
substring
 consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
'''

class Solution:
    def length_of_last_word(self, s: str) -> int:
        s_list = s.split()
        return len(s_list[-1])
    
    def length_of_last_word_no_split(self, s: str) -> int:
        length = 0
        n = len(s)

        if n == 1:
            return 0 if s.isspace() else 1
        
        for i in range(n - 1,-1,-1):
            if not s[i].isspace():
                length += 1
            elif length == 0:
                continue
            else:
                break
        return length
