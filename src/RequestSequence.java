//collection of the elements (currently arraylist) that is used as a request queue to the list of elements
//we can create new request queue and add elements to it

import java.util.ArrayList;

public class RequestSequence {
    //here we store sequence elements
    private ArrayList<Integer> sequence = new ArrayList<>();

    //current index in sequence
    private int currentIndex=0;

    //reset current index of the sequence to 0
    public void ResetIndex() {
        currentIndex=0;
    }

    //check if there are elements in the sequence
    public boolean HasNext() {
        if (currentIndex<sequence.size()) return true;
        return false;
    }

    public int GetElement() {
        return this.sequence.get(currentIndex);
    }

    //increase index of the sequence by 1
    //return true if success, false if index looks at the last element
    public boolean Next() {
        if (currentIndex<sequence.size()-1) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public int GetCurrentIndex() {
        return currentIndex;
    }

    //sequence size
    public int getSize() {
        return this.sequence.size();
    }

    public void addElement(int e) {
        this.sequence.add(e);
    }

    //merge two request queues and return the resulted queue
    public RequestSequence MergeQueues(RequestSequence rs1, RequestSequence rs2) {
        RequestSequence newRq = new RequestSequence();
        if (rs1.sequence.size()>0) newRq.sequence.addAll(rs1.sequence);
        if (rs2.sequence.size()>0) newRq.sequence.addAll(rs2.sequence);
        return newRq;
    }

    //generate queue of size size starting with value start and maximum value of start+size-1
    public RequestSequence GenerateConsecutiveQueue(int size, int start) {
        RequestSequence rs = new RequestSequence();
        for (int i = start; i < size; i++) {
            rs.sequence.add(i);
        }
        return rs;
    }

//serve queue q for the list l using MTF method and return total number of accesses
    public static int serveQueueMTF(RequestSequence rs, ListNode l) {
        return 0;
    }

    //print sequence, and then reset index to 0
    public static void PrintSequence(RequestSequence rs) {
        if (rs!=null) System.out.print(rs.sequence.get(rs.currentIndex));
        while (rs.HasNext()) {
            rs.Next();
            System.out.print(rs.sequence.get(rs.currentIndex));
        }
        rs.ResetIndex();
    }
}
