class Solution:
    def recursive_is_palindrome(self, x: int) -> bool:
        def str_palindrome(s: str) -> bool:
            n = len(s)
            if n == 1:
                return True
            if n == 2:
                return s[0] == s[1]
            if s[0] == s[n - 1]:
                next_str = s[1:n - 1]
                return str_palindrome(next_str)
            return False
        
        str_val = str(x)
        return str_palindrome(str_val)
    
    def two_ptr_is_palindrome(self, x: int) -> bool:
        str_val = str(x)
        n = len(str_val)

        for i in range(n // 2):
            front = i
            back = n - (front + 1)
            if str_val[front] != str_val[back]:
                return False
        return True
        