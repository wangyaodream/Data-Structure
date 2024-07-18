public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                // 删除之后prev变成了下一个节点，但是这个节点依然有可能是需要删除的元素，所以还需要跑一遍逻辑
            }
            else{
                prev = prev.next;
            }
        }

        return head;

    }
}
