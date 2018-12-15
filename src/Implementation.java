import sun.misc.Request;

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

        //Test 2
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


        //Test 3
        System.out.println("Test 3. List of 0-999, sequence 0-999 two times shuffled");
        lMTF = ListNode.generateList(1000);
        lTimestamp = ListNode.generateList(1000);
        lPrTimestamp = ListNode.generateList(1000);
        //MTF
        RequestSequence MTFtest3part1 = new RequestSequence();
        RequestSequence MTFtest3part2 = new RequestSequence();
        MTFtest3part1.GenerateConsecutiveQueue(1000,0);
        MTFtest3part2.GenerateConsecutiveQueue(1000,0);
        RequestSequence MTFtest3combined=RequestSequence.MergeQueues(MTFtest3part1,MTFtest3part2);
        MTFtest3combined.ShuffleSequence(0);
        ReturnValues MTFtest3 = RequestSequence.serveQueueMTF(MTFtest3combined,lMTF);
        System.out.println("MTF count: "+MTFtest3.counter);

        //Timestamp
        RequestSequence TimestampTest3part1 = new RequestSequence();
        RequestSequence TimestampTest3part2 = new RequestSequence();
        TimestampTest3part1.GenerateConsecutiveQueue(1000,0);
        TimestampTest3part2.GenerateConsecutiveQueue(1000,0);
        RequestSequence TimestampTest3combined=RequestSequence.MergeQueues(TimestampTest3part1,TimestampTest3part2);
        TimestampTest3combined.ShuffleSequence(0);
        ReturnValues TimestampTest3 = RequestSequence.serveQueueDetermenisticTimestamp(TimestampTest3combined,lTimestamp);
        System.out.println("Timestamp count: "+TimestampTest3.counter);

        //Timestamp probabilistic
        RequestSequence TimestampPTest3part1 = new RequestSequence();
        RequestSequence TimestampPTest3part2 = new RequestSequence();
        TimestampPTest3part1.GenerateConsecutiveQueue(1000,0);
        TimestampPTest3part2.GenerateConsecutiveQueue(1000,0);
        RequestSequence TimestampPTest3combined=RequestSequence.MergeQueues(TimestampPTest3part1,TimestampPTest3part2);
        TimestampPTest3combined.ShuffleSequence(0);
        ReturnValues TimestampPTest3 = RequestSequence.serveQueueProbabilisticTimestamp(TimestampPTest3combined,lPrTimestamp,0.5f,0);
        System.out.println("Timestamp probabilistic count: "+TimestampPTest3.counter);



        //Test4
        System.out.println("Test 4. List of 0-999, sequence 0-100 ten times + 0-999 one time shuffled");
        lMTF = ListNode.generateList(1000);
        lTimestamp = ListNode.generateList(1000);
        lPrTimestamp = ListNode.generateList(1000);

        //MTF
        RequestSequence MTFtest4part1 = new RequestSequence();
        RequestSequence MTFtest4part2 = new RequestSequence();
        MTFtest4part1.GenerateRandomSequence(10000,1000,0);
        //MTFtest4part2.GenerateConsecutiveQueue(1000,0);
        RequestSequence MTFtest4combined = RequestSequence.MergeQueues(MTFtest4part1,MTFtest4part2);
        MTFtest4combined.ShuffleSequence(0);
        RequestSequence.PrintSequence(MTFtest4combined);
        ReturnValues MTFtest4 = RequestSequence.serveQueueMTF(MTFtest4combined,lMTF);
        System.out.println("MTF count: "+MTFtest4.counter);

        //Timestamp
        RequestSequence TimestampTest4part1 = new RequestSequence();
        RequestSequence TimestampTest4part2 = new RequestSequence();
        TimestampTest4part1.GenerateRandomSequence(10000,1000,0);
        //TimestampTest4part2.GenerateConsecutiveQueue(1000,0);
        RequestSequence TimestampTest4combined = RequestSequence.MergeQueues(TimestampTest4part1,TimestampTest4part2);
        TimestampTest4combined.ShuffleSequence(0);
        ReturnValues TimestampTest4 = RequestSequence.serveQueueDetermenisticTimestamp(TimestampTest4combined,lTimestamp);
        System.out.println("Timestamp count: "+TimestampTest4.counter);

        //Probabilistic Timestamp
        RequestSequence TimestampPTest4part1 = new RequestSequence();
        RequestSequence TimestampPTest4part2 = new RequestSequence();
        TimestampPTest4part1.GenerateRandomSequence(10000,1000,0);
        //TimestampPTest4part2.GenerateConsecutiveQueue(1000,0);
        RequestSequence TimestampPTest4combined = RequestSequence.MergeQueues(TimestampPTest4part1,TimestampPTest4part2);
        TimestampPTest4combined.ShuffleSequence(0);
        ReturnValues TimestampPTest4 = RequestSequence.serveQueueProbabilisticTimestamp(TimestampPTest4combined,lPrTimestamp,0.5f,0);
        System.out.println("Timestamp probabilistic count: "+TimestampPTest4.counter);


        //Test 5
        //0-100 9 times + 0-1000 1 time, combined shuffled.

        lMTF = ListNode.generateList(1000);
        lTimestamp = ListNode.generateList(1000);
        lPrTimestamp = ListNode.generateList(1000);

        //MTF
        System.out.println("Test 5 0-100 9 times + 0-1000 1 time, combined shuffled.");
        RequestSequence MTFTest5part1 = new RequestSequence();
        RequestSequence MTFTest5part2 = new RequestSequence();
        MTFTest5part1.GenerateRandomSequence(1000,100,0);
        MTFTest5part2.GenerateRandomSequence(100,1000,0);
        RequestSequence MTFTest5combined = RequestSequence.MergeQueues(MTFTest5part1,MTFTest5part2);
        MTFTest5combined.ShuffleSequence(0);
        ReturnValues MTFTest5 = RequestSequence.serveQueueMTF(MTFTest5combined,lMTF);
        System.out.println("MTF count: "+MTFTest5.counter);

        //Timestamp
        RequestSequence TimestampTest5part1 = new RequestSequence();
        RequestSequence TimestampTest5part2 = new RequestSequence();
        TimestampTest5part1.GenerateRandomSequence(1000,100,0);
        TimestampTest5part2.GenerateRandomSequence(100,1000,0);
        RequestSequence TimestampTest5combined = RequestSequence.MergeQueues(TimestampTest5part1,TimestampTest5part2);
        TimestampTest5combined.ShuffleSequence(0);
        ReturnValues TimestampTest5 = RequestSequence.serveQueueDetermenisticTimestamp(TimestampTest5combined,lTimestamp);
        System.out.println("Timestamp count: "+TimestampTest5.counter);


        //Probabilistic Timestamp
        RequestSequence TimestampPTest5part1 = new RequestSequence();
        RequestSequence TimestampPTest5part2 = new RequestSequence();
        TimestampPTest5part1.GenerateRandomSequence(1000,100,0);
        TimestampPTest5part2.GenerateRandomSequence(100,1000,0);
        RequestSequence TimestampPTest5combined = RequestSequence.MergeQueues(TimestampPTest5part1,TimestampPTest5part2);
        TimestampPTest5combined.ShuffleSequence(0);
        ReturnValues TimestampPTest5 = RequestSequence.serveQueueProbabilisticTimestamp(TimestampPTest5combined,lPrTimestamp,0.5f,0);
        System.out.println("Timestamp probabilistic count: "+TimestampPTest5.counter);


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


        ListNode list = ListNode.generateList(5);
        RequestSequence r = new RequestSequence();
        r.AddElement(0);
        r.AddElement(0);
        r.AddElement(1);
        r.AddElement(1);
        r.AddElement(2);
        r.AddElement(2);
        r.AddElement(3);
        r.AddElement(3);
        r.AddElement(4);
        r.AddElement(4);
        rv=RequestSequence.serveQueueDetermenisticTimestamp(r,list);
        System.out.println(rv.counter);
        ListNode.printList(rv.head);


    //Calgary corpus test

        //MTF
        ListNode lbook = ListNode.GenerateListFromFile("book1");
        System.out.println("Printing the book alphabet");
        RequestSequence rsBook = RequestSequence.GenerateSequenceFromFile("book1");
        ReturnValues rvBookMTF = RequestSequence.serveQueueMTF(rsBook,lbook);
        System.out.println("MTF cost to serve a book: "+rvBookMTF.counter);

        //Timestamp
        lbook = ListNode.GenerateListFromFile("book1");
        System.out.println("Printing the book alphabet");
        rsBook = RequestSequence.GenerateSequenceFromFile("book1");
        ReturnValues rvBookTimestamp = RequestSequence.serveQueueDetermenisticTimestamp(rsBook,lbook);
        System.out.println("Timestamp cost to serve a book: "+rvBookTimestamp.counter);

        //Probabilistic Timestamp
        lbook = ListNode.GenerateListFromFile("book1");
        System.out.println("Printing the book alphabet");
        rsBook = RequestSequence.GenerateSequenceFromFile("book1");
        ReturnValues rvBookPTimestamp = RequestSequence.serveQueueProbabilisticTimestamp(rsBook,lbook,0.5f,0);
        System.out.println("Timestamp probabilistic cost to serve a book: "+rvBookPTimestamp.counter);

    }

}
