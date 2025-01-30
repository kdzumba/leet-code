'''
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
'''
from collections import deque

class Solution:
    def is_valid(self, s: str) -> bool:
        n = len(s)

        # Early return if at base case with default False
        if n <= 1:
            return False

        q = deque()
        brackets = {
            "(": ")",
            "[": "]",
            "{": "}"
        }

        for char in s:
            if char in brackets.keys():
                q.appendleft(char)
            else:
                # It's a closing bracket, first make sure it's not the first one 
                # being inserted to the queue
                if len(q) == 0:
                    return False
                top = q[0]
                # Then check if it matches the opening bracket at the top of the stck
                if brackets[top] == char:
                    q.popleft()
                else:
                    return False
        return len(q) == 0
