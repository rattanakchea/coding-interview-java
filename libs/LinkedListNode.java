public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public static void main(String[] args) {
        LinkedListNode linkedList = new LinkedListNode(1);
        linkedList.next = new LinkedListNode(2);

        print(linkedList);

        // linkedList = linkedList.reverse(linkedList); //static method call not
        // recommended
        linkedList = reverse(linkedList);

        print(linkedList);
    }

    public LinkedListNode(int value) {
        this.value = value;
    }

    public static void print(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("null\n");

    }

    public static LinkedListNode reverse(LinkedListNode headOfList) {
        LinkedListNode currentNode = headOfList;
        LinkedListNode previousNode = null;
        LinkedListNode nextNode = null;

        // until we have 'fallen off' the end of the list
        while (currentNode != null) {

            // copy a pointer to the next element
            // before we overwrite currentNode.next
            nextNode = currentNode.next;

            // reverse the 'next' pointer
            currentNode.next = previousNode;

            // step forward in the list
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }
}