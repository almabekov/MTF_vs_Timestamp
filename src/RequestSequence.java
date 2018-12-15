//collection of the elements (currently arraylist) that is used as a request queue to the list of elements
//we can create new request queue and add elements to it

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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

    public void GenerateRandomSequence(int size, int maxValue, int seed) {
        Random rand=new Random();
        rand.setSeed(seed);
        for (int i=0;i<size;i++) {
            this.AddElement(rand.nextInt(maxValue));
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
        temp=MTF.GetElement(l,rs.GetElement(),1);
        l=temp.head;
        rv.counter+=temp.counter;
        int sequence=1;
        while(rs.Next()) {
            sequence++;
            //serve all sequence here
            temp=MTF.GetElement(l,rs.GetElement(),sequence);
            l=temp.head;
            rv.counter+=temp.counter;
        }
        rv.head=l;
        rs.ResetIndex();
        return rv;
    }

    public static ReturnValues serveQueueDetermenisticTimestamp(RequestSequence rs, ListNode l)
    {
        ReturnValues rv = new ReturnValues();
        rv.counter=0;
        rv.head=l;
        ReturnValues temp;
        if (l==null) return rv;
        if (rs.getSize()==0) return rv;
        temp=Timestamp.GetElement(l,rs.GetElement(),1);
        l=temp.head;
        rv.counter+=temp.counter;
        int sequence=1;
        while(rs.Next()) {
            sequence++;
            //serve all sequence here
            temp=Timestamp.GetElement(l,rs.GetElement(),sequence);
            l=temp.head;
            rv.counter+=temp.counter;
        }
        rv.head=l;
        rs.ResetIndex();
        return rv;
    }

    //with probability p execute MTF request, with probability 1-p execute deterministic timestamp request
    public static ReturnValues serveQueueProbabilisticTimestamp(RequestSequence rs, ListNode l, float probability, int seed)
    {

        ReturnValues rv = new ReturnValues();
        if (probability <0 || probability > 1 ) {
            ReturnValues defaultRv= new ReturnValues();
            defaultRv.counter=-1;
            defaultRv.head=null;
            return defaultRv;
        }

        Random rand = new Random();
        rand.setSeed(seed);
        rv.counter=0;
        rv.head=l;
        ReturnValues temp;
        if (l==null) return rv;
        if (rs.getSize()==0) return rv;
        if (rand.nextFloat()<=probability) temp=MTF.GetElement(l,rs.GetElement(),1);
        else temp=Timestamp.GetElement(l,rs.GetElement(),1);

        l=temp.head;
        rv.counter+=temp.counter;
        int sequence=1;
        while(rs.Next()) {
            sequence++;
            //serve all sequence here
            //depending on probability use MTF or deterministic Timestamp
            if (rand.nextFloat()<=probability) {
                temp = MTF.GetElement(l, rs.GetElement(), sequence);
            }
            else {
                temp = Timestamp.GetElement(l, rs.GetElement(), sequence);
            }
            l=temp.head;
            rv.counter+=temp.counter;
        }
        rv.head=l;
        rs.ResetIndex();
        return rv;
    }

    public static RequestSequence GenerateSequenceFromFile(String filename) {
            RequestSequence rs = new RequestSequence();
            try
            {
                HashSet<Integer> alphabet = new HashSet<Integer>();
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                int character;
                while ((character = reader.read()) != -1)
                {
                    rs.AddElement(character);
                }
                System.out.println("Request sequence length is: "+rs.getSize());
            }
            catch (Exception e)
            {
                System.err.format("Exception occurred trying to read '%s'.", filename);
                e.printStackTrace();
                return null;
            }
            return rs;
    }
}
