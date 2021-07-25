public class MergeTwoSortedLLusingRecursion {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l = Merge(new ListNode(5), l1);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    static ListNode Merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1 == null && l2 == null)
            return null;
        ListNode temp1 = l1;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = l2;
        ListNode temp2 = sort(l1, l1.next);
        return temp2;
    }

    static ListNode sort(ListNode l, ListNode temp) {
        if (l == null)
            return l;
        if (l.next == null)
            return l;
        ListNode c = l;
        c.next = null;
        ListNode temp1 = sort(temp, temp.next);
        if (c.val <= temp1.val) {
            c.next = temp1;
            return c;
        } else {
            ListNode x = temp1;
            while (x.next != null) {
                if (c.val <= x.next.val) {
                    ListNode y = x.next;
                    x.next = c;
                    c.next = y;
                }
                x = x.next;
                if(x.next == null) {
                    x.next = c;
                    return temp1;
                }
            }
            return temp1;
        }
    }
}
