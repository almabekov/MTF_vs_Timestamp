public class Timestamp {
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
        //if our element already is the head
        //we only update sequence and return the same list;
        //System.out.println("Head value is "+l.getValue()+" we are looking for "+elementValue);
        if (l.getValue()==elementValue) {
            //System.out.println("Head element accessed");
            l.setLastAccess(sequence);
            return rv;
        }

        rv.counter++;
        //otherwise we search for the necessary element
        while (l.next!=null && l.next.getValue()!=elementValue) {
            rv.counter++;
            l=l.next;
        }

        ListNode previousElement=l;
        ListNode ourElement=l.next;

        //if element was found in the list
        if (ourElement!=null && ourElement.getValue()==elementValue) {
            int lastAccess=ourElement.getLastAccess();



            //we should swap element only if it was requested at least once before
            //we need to search from the beginning where we should paste our element
            if (ourElement.getLastAccess()!=-1) {
                //System.out.println("element with last time not equal -1 accessed");
                ListNode tempHead = oldhead;
                previousElement.next=ourElement.next;
                //if we should put requested element as a new head
                if (tempHead.getLastAccess() < lastAccess) {
                    //System.out.println("We should switch our element with head element");
                    rv.head = ourElement;
                    rv.head.setLastAccess(sequence);
                    //previousElement.next=ourElement.next;
                    ourElement.next=oldhead;
                    return rv;
                } else {
                    //System.out.println("Element that is not head and with last access not -1 accessed");
                    //search for the closest to the head element, that was accessed before the current element was accessed last time
                    while (tempHead.next != null && tempHead.next.getLastAccess() > lastAccess) {
                        tempHead = tempHead.next;
                    }

                    //if we found such element between head and our element it is tempHead.next

                    if (tempHead.next != null) {
                        //if we swap two consecutive elements
                        /*
                        if (tempHead.next.next==ourElement) {
                            tempHead.next.next=ourElement.next;
                        }
                        */
                        ourElement.next = tempHead.next;
                        tempHead.next = ourElement;
                    }
                }
            } else {
                //System.out.println("Element with last access time -1 accessed. No specific actions needed.");
            }
            ourElement.setLastAccess(sequence);
        }
        return rv;
    }
}
