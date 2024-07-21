public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode res = removeElements(head.next, val);
        if (head.val == val)
            // 删除头结点，返回后续计算出的链表并进行递归计算
            return res;
        else{
            // 将之前的头链表和计算后的链表对接
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 6, 3, 4, 6, 8};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 6);
        System.out.println(res);
    }
}
