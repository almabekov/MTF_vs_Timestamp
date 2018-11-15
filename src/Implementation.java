public class Implementation {

    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        ListNode nextNode = new ListNode(20);
        node.next=nextNode;
        System.out.println(node.next.getValue());
        System.out.println(node.listLength());
        ListNode l = ListNode.generateList(10);
        ListNode.printList(l);
        RequestSequence rs = new RequestSequence();
        rs.GenerateConsecutiveQueue(20,0);
        RequestSequence.PrintSequence(rs);
        rs.ShuffleSequence(100);
        RequestSequence.PrintSequence(rs);
    }
}
