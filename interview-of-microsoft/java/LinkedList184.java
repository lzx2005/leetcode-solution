/**
 * https://leetcode.com/explore/interview/card/microsoft/32/linked-list/184/
 * Created by hzlizx on 2019/4/10
 */
public class LinkedList184 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode p1 = head.next;
        ListNode p2 = p1.next;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            ListNode p2next = p2.next;
            if (p2next == null) {
                return false;
            }
            p2 = p2.next.next;
        }
        return false;
    }
}
