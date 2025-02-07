'''
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
'''
class ListNode:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next


class Solution:
    def delete_duplicates(self, head: ListNode | None) -> ListNode | None:
        current = head
        while current and current.next:
            curr_next = current.next
            while curr_next and curr_next.val == current.val:
                current.next = curr_next = curr_next.next
            current = current.next
        return head

    