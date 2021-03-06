import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Random;

public class ListNode {
    private int value;
    private int lastAccess;
    ListNode next;

    ListNode(int value) {
        this.value=value;
        lastAccess=-1;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int newValue) {
        this.value=newValue;
    }

    public int getLastAccess() {
        return this.lastAccess;
    }

    public void setLastAccess(int newLastAccess) {
        this.lastAccess=newLastAccess;
    }

    //return how many elements are in the list starting from this element (including this element)
    public int listLength() {
        if (this==null) return 0;
        int count=1;
        ListNode head = this;
        while (head.next!=null) {
            count++;
            head=head.next;
        }
        return count;
    }

    //generate list of n elements in consecutive order from head with value 0 to last element with value n-1
    //and return the head element
    public static ListNode generateList(int n) {
        if (n<1) return null;
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        n--;
        int value=1;
        while (n>0) {
            pointer.next=new ListNode(value);
            pointer=pointer.next;
            n--;
            value++;
        }
        return head;
    }
    //print all values of the list in one line;
    public static void printList(ListNode l) {
        if (l==null) return;
        while (l!=null) {
            System.out.print(l.getValue()+"("+l.getLastAccess()+") ");
            l=l.next;
        }
        System.out.println();
    }

    //generate list of size n, with the maximum possible value of element maxValue
    public static ListNode generateRandomList(int n, int maxValue, int seed) {
        if (n < 1) return null;
        Random rand = new Random();
        rand.setSeed(seed);
        ListNode head = new ListNode(rand.nextInt(maxValue));
        ListNode pointer = head;
        n--;
        while (n > 0) {
            pointer.next = new ListNode(rand.nextInt(maxValue));
            pointer = pointer.next;
            n--;
        }
        return head;
    }
    //providing the filename we create list of unique characters (alphabet),
    //that will be then used to serve the sequence
    public static ListNode GenerateListFromFile(String filename) {
        ListNode l = new ListNode(0);
        ListNode head;
        try
        {
            HashSet<Integer> alphabet = new HashSet<Integer>();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int character;
            while ((character = reader.read()) != -1)
            {
                //System.out.println(character);
                if (!alphabet.contains(character)) {
                    alphabet.add(character);
                }
            }
            System.out.println("Alphabet size is: "+alphabet.size());
            /*
            for (Integer i : alphabet) {
                System.out.println(i);
            }
            */
            reader.close();
            if (alphabet.size()==0) return null;
            head = l;
            for (Integer i : alphabet) {
                l.next = new ListNode(i);
                l=l.next;
            }

        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }



        return head;
    }
}