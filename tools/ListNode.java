/**
 * Created by hzlizx on 2019/4/10
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void print() {
        print(this);
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
