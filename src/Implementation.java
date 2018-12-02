import java.sql.Time;
import java.util.Random;

public class Implementation {

    public static void main(String[] args) {

        System.out.println("Test 1 0-999 list, 0-999 shuffled sequence:");
        System.out.println("MTF test");
        RequestSequence rsMTF = new RequestSequence();
        rsMTF.GenerateConsecutiveQueue(1000,0);
        rsMTF.ShuffleSequence(0);
        ListNode lMTF = ListNode.generateList(1000);
        ListNode.printList(lMTF);
        RequestSequence.PrintSequence(rsMTF);
        ReturnValues rvMTF = RequestSequence.serveQueueMTF(rsMTF, lMTF);
        System.out.println(rvMTF.counter); //if we have 100 elements the average access is (10*11)/2, my response was 45, -1 less somehow
        ListNode.printList(rvMTF.head);

        System.out.println("Timestamp test");
        RequestSequence rsTimestamp = new RequestSequence();
        rsTimestamp.GenerateConsecutiveQueue(1000,0);
        rsTimestamp.ShuffleSequence(0);
        ListNode lTimestamp = ListNode.generateList(1000);
        ListNode.printList(lTimestamp);
        RequestSequence.PrintSequence(rsTimestamp);
        ReturnValues rvTimestamp = RequestSequence.serveQueueDetermenisticTimestamp(rsTimestamp, lTimestamp);
        System.out.println(rvTimestamp.counter); //if we have 100 elements the average access is (10*11)/2, my response was 45, -1 less somehow
        ListNode.printList(rvTimestamp.head);

        System.out.println("Probabilistic Timestamp test");
        RequestSequence rsPrTimestamp = new RequestSequence();
        rsPrTimestamp.GenerateConsecutiveQueue(1000,0);
        rsPrTimestamp.ShuffleSequence(0);
        ListNode lPrTimestamp = ListNode.generateList(1000);
        ListNode.printList(lPrTimestamp);
        RequestSequence.PrintSequence(rsPrTimestamp);
        ReturnValues rvPrTimestamp = RequestSequence.serveQueueProbabilisticTimestamp(rsPrTimestamp, lPrTimestamp,0.5f, 1);
        System.out.println(rvPrTimestamp.counter); //if we have 100 elements the average access is (10*11)/2, my response was 45, -1 less somehow
        ListNode.printList(rvPrTimestamp.head);


        System.out.println("Test 2. List of 0-999, sequence 0-100 two times shuffled");
        lMTF = ListNode.generateList(1000);
        lTimestamp = ListNode.generateList(1000);
        lPrTimestamp = ListNode.generateList(1000);
        //MTF
        RequestSequence MTFtest2part1 = new RequestSequence();
        RequestSequence MTFtest2part2 = new RequestSequence();
        MTFtest2part1.GenerateConsecutiveQueue(100,0);
        MTFtest2part2.GenerateConsecutiveQueue(100,0);
        RequestSequence MTFtest2combined=RequestSequence.MergeQueues(MTFtest2part1,MTFtest2part2);
        MTFtest2combined.ShuffleSequence(0);
        ReturnValues MTFtest2 = RequestSequence.serveQueueMTF(MTFtest2combined,lMTF);
        System.out.println("MTF count: "+MTFtest2.counter);

        //Timestamp
        RequestSequence TimestampTest2part1 = new RequestSequence();
        RequestSequence TimestampTest2part2 = new RequestSequence();
        TimestampTest2part1.GenerateConsecutiveQueue(100,0);
        TimestampTest2part2.GenerateConsecutiveQueue(100,0);
        RequestSequence TimestampTest2combined=RequestSequence.MergeQueues(TimestampTest2part1,TimestampTest2part2);
        TimestampTest2combined.ShuffleSequence(0);
        ReturnValues TimestampTest2 = RequestSequence.serveQueueDetermenisticTimestamp(TimestampTest2combined,lTimestamp);
        System.out.println("Timestamp count: "+TimestampTest2.counter);

        //Timestamp probabilistic
        RequestSequence TimestampPTest2part1 = new RequestSequence();
        RequestSequence TimestampPTest2part2 = new RequestSequence();
        TimestampPTest2part1.GenerateConsecutiveQueue(100,0);
        TimestampPTest2part2.GenerateConsecutiveQueue(100,0);
        RequestSequence TimestampPTest2combined=RequestSequence.MergeQueues(TimestampPTest2part1,TimestampPTest2part2);
        TimestampPTest2combined.ShuffleSequence(0);
        ReturnValues TimestampPTest2 = RequestSequence.serveQueueProbabilisticTimestamp(TimestampPTest2combined,lPrTimestamp,0.5f,0);
        System.out.println("Timestamp probabilistic count: "+TimestampPTest2.counter);


        ListNode l = new ListNode(0);
        l = ListNode.generateList(6);

        ReturnValues rv;
        rv=Timestamp.GetElement(l,0,1);
        l=rv.head;
        ListNode.printList(l);
        rv=Timestamp.GetElement(l,1,2);
        l=rv.head;
        ListNode.printList(l);

        rv=Timestamp.GetElement(l,5,3);
        l=rv.head;
        ListNode.printList(l);

        rv=Timestamp.GetElement(l,5,4);
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
