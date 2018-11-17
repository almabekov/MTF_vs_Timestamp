import java.sql.Time;

public class Implementation {

    public static void main(String[] args) {
        System.out.println("MTF test");
        RequestSequence rsMTF = new RequestSequence();
        rsMTF.GenerateConsecutiveQueue(10,0);
        ListNode lMTF = ListNode.generateList(10);
        ListNode.printList(lMTF);
        ReturnValues rvMTF = RequestSequence.serveQueueMTF(rsMTF, lMTF);
        System.out.println(rvMTF.counter); //if we have 100 elements the average access is (10*11)/2, my response was 45, -1 less somehow
        ListNode.printList(rvMTF.head);

        System.out.println("Timestamp test");
        RequestSequence rsTimestamp = new RequestSequence();
        rsTimestamp.GenerateConsecutiveQueue(10,0);
        ListNode lTimestamp = ListNode.generateList(10);
        ListNode.printList(lTimestamp);
        ReturnValues rvTimestamp = RequestSequence.serveQueueDetermenisticTimestamp(rsTimestamp, lTimestamp);
        System.out.println(rvTimestamp.counter); //if we have 100 elements the average access is (10*11)/2, my response was 45, -1 less somehow
        ListNode.printList(rvTimestamp.head);

        /*
        ReturnValues rv = new ReturnValues();
        rv=Timestamp.GetElement(l,0,1);
        l=rv.head;
        ListNode.printList(l);
        rv=Timestamp.GetElement(l,1,2);
        l=rv.head;
        ListNode.printList(l);

        rv=Timestamp.GetElement(l,9,3);
        l=rv.head;
        ListNode.printList(l);

        rv=Timestamp.GetElement(l,9,4);
        l=rv.head;
        ListNode.printList(l);

        rv=Timestamp.GetElement(l,1,5);
        l=rv.head;
        ListNode.printList(l);

        rv=Timestamp.GetElement(l,1,6);
        l=rv.head;
        ListNode.printList(l);
        */
    }
}
