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
}
