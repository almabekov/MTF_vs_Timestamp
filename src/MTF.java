public class MTF {
    //methods to get the element using the MTF list update algorithm

    //get the element elementValue from the list l.
    //method return number of comparisons during the traversal of the list till necessary element was found
    // 1 if it was the first element in the list
    // until n+1 if element is not found
    //we also put the elment that was found to the head of the list
    //sequence is the requested element position in the sequence (to remember when that element was requested last time)
    public static ReturnValues GetElement(ListNode l, int elementValue, int sequence) {
        ReturnValues rv = new ReturnValues();
        rv.head=null;
        rv.counter=0;

        if (l==null) return rv;
        rv.counter=1;
        rv.head=l;
        ListNode oldhead=l;
        if (l.getValue()==elementValue) {
            l.setLastAccess(sequence);
            return rv;
        }
        rv.counter++;
        while (l.next!=null && l.next.getValue()!=elementValue) {
            rv.counter++;
            l=l.next;
        }
        if (l.next!=null && l.next.getValue()==elementValue) {
            l.next.setLastAccess(sequence);
            rv.head=l.next;
            l.next=l.next.next;
            rv.head.next=oldhead;
        }
        return rv;
    }
}
