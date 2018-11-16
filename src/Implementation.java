import java.sql.Time;

public class Implementation {

    public static void main(String[] args) {
        RequestSequence rs = new RequestSequence();
        rs.GenerateConsecutiveQueue(10,0);
        //RequestSequence.PrintSequence(rs);


        ListNode l = ListNode.generateList(10);
        ListNode.printList(l);

        /*
        ReturnValues rv = RequestSequence.serveQueueMTF(rs, l);
        System.out.println(rv.counter); //if we have 100 elements the average access is (10*11)/2, my response was 45, -1 less somehow
        ListNode.printList(rv.head);
        */

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
        
    }
}
