'''
Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
'''

class Solution:
    index_offset = 0

    def search_insert(self, nums: list[int], target: int) -> int:
        n = len(nums)

        if not nums:
            return self.index_offset

        if n == 1:
            if target == nums[0]:
                return self.index_offset
            elif target < nums[0]:
                return self.index_offset
            elif target > nums[0]:
                return self.index_offset + 1

        middle_index = n // 2
        middle_element = nums[middle_index]

        if target == middle_element:
            return middle_index + self.index_offset
        elif target < middle_element:
            return self.search_insert(nums[0:middle_index], target)
        elif target > middle_element:
            self.index_offset += middle_index + 1
            return self.search_insert(nums[middle_index + 1:n], target)
