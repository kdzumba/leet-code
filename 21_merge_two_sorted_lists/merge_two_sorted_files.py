'''You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
'''
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def merge_two_lists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        # Lists can be empty, meaning head of the list should be None. Either take the non-empty list or return None
        if not list1:
            return list2
        elif not list2:
            return list1
        
        # The two lists are sorted, so min(list1.val, list2.val) becomes the head of the merged list
        recently_added = head = None

        # Keep track of the heads of the remaining unprocessed list. 
        # Compare 2 elements at a time, one from each list
        front_1 = list1
        front_2 = list2

        if list1.val < list2.val:
            head = recently_added = list1
            front_1 = recently_added.next
        else:
            head = recently_added = list2
            front_2 = recently_added.next

        while front_1 and front_2:
            if front_1.val < front_2.val:
                recently_added.next = front_1
                recently_added = front_1
                front_1 = front_1.next
            else:
                recently_added.next = front_2
                recently_added = front_2
                front_2 = front_2.next

        # If one of the lists still has items, add them all to the back of the new list in their original order
        if front_1:
            recently_added.next = front_1
        elif front_2:
            recently_added.next = front_2

        return head
        