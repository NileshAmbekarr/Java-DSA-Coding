package LInkedList;

public class LinkedList {
    public  int length(Node head){
        int count = 0;
        while(head!= null){
            head = head.next;
            count++;
        }
        return count ;
    }
    public  void displayR(Node head){
        if (head == null){
            System.out.println();
            return ;
        }
        System.out.print(head.data + " ");
        displayR(head.next);
    }
    public static void display(Node head){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node head;
    public static Node tail;

    public static void addFirst(int data){
        // creating a new node
        Node NewNode = new Node(data);

        // store the head in the Next of the NewNode
        NewNode.next = head ;
        // head = new node
        head = NewNode;
        if (tail == null) {
            tail = head;  // If the list was empty, update the tail as well
        }

    }
    public static void addLast(int data) {
        Node newNode = new Node(data);
        tail.next = newNode ;
        tail = newNode;

    }
    public static void add(int idx , int data){
        if(head == null){
            addFirst(data);
            return;
        }
        // Create a temporary Node to find Indexes
        Node temp = head;
        int i = 0;
        // iterate on the LL till we find the previous indexed Node
        while(i < idx - 1){
            temp = temp.next;
            i++;
        }
        // Once found create a new node which we will be inserting in the LL
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public static int removeFirst(){
        if(head == null){
            System.out.println("Empty LL !!");
            return 0;
        }
        if(head == tail){
            int value = head.data;
            head = tail = null ;
            return value ;
        }
        int val = head.data; // stored the first node in val variable
        head = head.next; // updated the value of the head
        return val; // return the stored value
    }
    public static int removeLast(){
        if(head == null){
            System.out.println("Empty LL !!");
            return 0;
        }
        if(head == tail){
            int value = head.data;
            head = tail = null ;
            return value ;
        }

        int val = tail.data;


        return 0;

    }
    public static int searchElement(int key){
        int idx = 0;
        Node temp = head ;
        while(temp != null){
            if(temp.data == key){
                return idx ;
            }else{
                temp = temp.next;
                idx++;
            }
        }
        return -1;
    }
    public static int searchUsingRecursion(int key , Node head){
        if(head.data == key){
            return 0;
        }
        if (head.next == null ) return -1;
        int idx = searchUsingRecursion(key, head.next);
        if (idx == -1) return -1;
        return idx + 1;

    }
    public void reverse(){
        Node prev = null;
        Node curr = tail = head ;
        Node next ;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int EndIdx){
        // calculate Size of ll
        int size = 0;
        Node temp = head ;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        //edge case :- if the EndIndex = size , it will be first element form the starting.
        if (EndIdx == size){
            head = head.next;
            return;
        }

        // find the index of node form the starting
        int idx = size - EndIdx;
        temp = head ;
        int i = 1;
        while (i < idx){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    public Node findMid(Node head){ // SLOW - FAST APPROACH
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow  = slow.next ; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow will be my MidNode
    }
    public boolean checkPalindrome(){
        if(head == null || head.next == null ){
            return true;
        }
        // find MidNode
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow  = slow.next ; // +1
            fast = fast.next.next; // +2
        }
        Node midNode = slow;
        // Reverse 2nd Half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // The prev Node will be the head of the 2nd half LL
        Node right = prev;
        Node left = head;
        // check Left right Half
        while(right != null){
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean isCycle(){
        Node slow = head ;
        Node fast = head ;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }
    public void removeCycle(){
        // detect cycle
        Node slow = head ;
        Node fast = head;
        boolean isCycle = false ;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if (!isCycle) return;
        // find meeting point
        slow = head;
        Node prev = null;
        while (true){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
            if (slow == fast) break;
        }

        // remove cycle
        prev.next = null;
    }

    public Node mergeSortLL(Node head){
        // base case
        if(head == null || head.next == null){
            return head;
        }
        // find midNode of the LL
        Node midNode = findMid(head);
        // divide the LinkedList into two halves
        Node rHead = midNode.next;
        Node lHead = head;
        midNode.next = null;
        // sort both the two parts using mergeSort
        Node newLeft = mergeSortLL(lHead);
        Node newRight = mergeSortLL(rHead);

        // merge both the sorted parts
        Node temp = new Node(-1);
        Node mergeHead = temp;
        while(newLeft != null && newRight != null){
            if(newLeft.data <= newRight.data){
                temp.next = newLeft;
                newLeft = newLeft.next;
            }else{
                temp.next = newRight;
                newRight = newRight.next;
            }
            temp = temp.next;
        }
        while(newLeft != null){
            temp.next = newLeft;
            newLeft = newLeft.next;
            temp = temp.next;
        }
        while(newRight != null){
            temp.next = newRight;
            newRight = newRight.next;
            temp = temp.next;
        }
        return mergeHead.next;
    }
    public void zigzagLL(){
       // find mid
        Node slow = head ;
        Node fast = head ;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse the 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL , nextR;

        // zigzag merge
        while (left != null && right != null){
            nextL = left.next;
            left.next = right ;
            nextR = right.next ;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(0, 11);
        ll.addLast(9);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(2);// 11 -> 9 -> 3 -> 4 -> 5 -> 2
        display(head);
        ll.zigzagLL();
        display(head);



    }
}
