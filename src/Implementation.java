import java.sql.Time;
import java.util.Random;

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

        System.out.println("Probabilistic Timestamp test");
        RequestSequence rsPrTimestamp = new RequestSequence();
        rsPrTimestamp.GenerateConsecutiveQueue(10,0);
        ListNode lPrTimestamp = ListNode.generateList(10);
        ListNode.printList(lPrTimestamp);
        ReturnValues rvPrTimestamp = RequestSequence.serveQueueProbabilisticTimestamp(rsPrTimestamp, lPrTimestamp,0.5f);
        System.out.println(rvPrTimestamp.counter); //if we have 100 elements the average access is (10*11)/2, my response was 45, -1 less somehow
        ListNode.printList(rvPrTimestamp.head);

        Random rand = new Random();
        RequestSequence MTFrs1=new RequestSequence();
        MTFrs1.GenerateRandomSequence(100,10,1);
        RequestSequence TimestampDrs1=new RequestSequence();
        TimestampDrs1.GenerateRandomSequence(100,10,1);
        RequestSequence TimestampPrs1=new RequestSequence();
        TimestampPrs1.GenerateRandomSequence(100,10,1);

        ListNode MTFl1= ListNode.generateRandomList(100,100, 1);
        ListNode TimestampDl1= ListNode.generateRandomList(100,100, 1);
        ListNode TimestampPl1= ListNode.generateRandomList(100,100, 1);

        ReturnValues rvMTF1 = RequestSequence.serveQueueMTF(MTFrs1, MTFl1);
        ReturnValues rvTimestampD1 = RequestSequence.serveQueueDetermenisticTimestamp(TimestampDrs1, TimestampDl1);
        ReturnValues rvTimestampP1 = RequestSequence.serveQueueProbabilisticTimestamp(TimestampPrs1, TimestampPl1,0.5f);

        System.out.println("MTF result "+rvMTF1.counter);
        System.out.println("Deterministic Timestamp result "+rvTimestampD1.counter);
        System.out.println("Probabilistic Timestamp result "+rvTimestampP1.counter);

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
