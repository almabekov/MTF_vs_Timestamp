//collection of the elements (currently arraylist) that is used as a request queue to the list of elements
//we can create new request queue and add elements to it

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
        if (currentIndex<sequence.size()-1) return true;
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

    public void AddElement(int e) {
        this.sequence.add(e);
    }

    //merge two request queues and return the resulted queue
    public static RequestSequence MergeQueues(RequestSequence rs1, RequestSequence rs2) {
        RequestSequence newRq = new RequestSequence();
        if (rs1.sequence.size()>0) newRq.sequence.addAll(rs1.sequence);
        if (rs2.sequence.size()>0) newRq.sequence.addAll(rs2.sequence);
        return newRq;
    }

    //generate queue of size size starting with value start and maximum value of start+size-1
    public void GenerateConsecutiveQueue(int size, int start) {

        for (int i = 0; i < size; i++) {
            this.AddElement(i+start);
        }
    }

    //print sequence, and then reset index to 0
    public static void PrintSequence(RequestSequence rs) {
        if (rs!=null && rs.sequence.size()>0) System.out.print(rs.sequence.get(rs.currentIndex)+" ");
        while (rs.HasNext()) {
            rs.Next();
            System.out.print(rs.sequence.get(rs.currentIndex)+" ");
        }
        System.out.println();
        rs.ResetIndex();
    }

    //shuffle sequence randomly
    //use int seed for random generator seed value
    //with help from this source
    //https://stackoverflow.com/questions/6284589/setting-a-seed-to-shuffle-arraylist-in-java-deterministically
    public void ShuffleSequence(int seed) {
        Collections.shuffle(this.sequence, new Random(seed));
    }

    //serve queue q for the list l using MTF method and return total number of accesses
    public static ReturnValues serveQueueMTF(RequestSequence rs, ListNode l)
    {
        ReturnValues rv = new ReturnValues();
        rv.counter=0;
        rv.head=l;
        ReturnValues temp;
        if (l==null) return rv;
        if (rs.getSize()==0) return rv;
        temp=MTF.GetElement(l,rs.GetElement());
        l=temp.head;
        rv.counter+=temp.counter;
        while(rs.Next()) {
            //serve all sequence here
            temp=MTF.GetElement(l,rs.GetElement());
            l=temp.head;
            rv.counter+=temp.counter;
        }
        rv.head=l;
        rs.ResetIndex();
        return rv;
    }


}
