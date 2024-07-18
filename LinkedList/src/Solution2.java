import java.util.List;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);

        dummyHead.next = head;

//        while (head != null && head.val == val) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
//        }
//
//        if (head == null) {
//            return null;
//        }

        ListNode prev = dummyHead;
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

        return dummyHead.next;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 6, 3, 4, 6, 8};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution2()).removeElements(head, 6);
        System.out.println(res);
    }
}
