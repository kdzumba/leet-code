'''
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
'''

from typing import List

class Solution:
    longest_common_prefix = ""

    def lcp(self, strs: List[str]) -> str:

        # Find the LCP between 2 given strings
        def find_lcp(first: str, second: str) -> str:
            cursor = 0
            self.longest_common_prefix = ""
            while cursor < len(first) and cursor < len(second):
                if first[cursor] != second[cursor]:
                    return self.longest_common_prefix
                else:
                    self.longest_common_prefix += first[cursor]
                cursor += 1
            return self.longest_common_prefix
        
        n = len(strs)

        # If only one string given, then that's the LCP
        if n == 1:
            return strs[0]
        
        # Initialise the problem's LCP to the LCP between the 2 first strs
        self.longest_common_prefix = find_lcp(strs[0], strs[1])

        if self.longest_common_prefix:
            # First 2 strs have already given us the LCP. We slide this through
            # the rest of the strs in the list, return empty if one of the strs
            # in the list doesn't match, and the LCP if all match it
            for i in range(2,n):
                if find_lcp(strs[i], self.longest_common_prefix):
                    continue
                else:
                    return ""
            return self.longest_common_prefix
        else:
            return ""
    