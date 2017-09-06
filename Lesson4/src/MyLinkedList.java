

public class MyLinkedList <T>{

    Node firstLink;
    Node lastLink;
    int size;

    public MyLinkedList() {
        this.size = 0;
    }


    public void add(T data){

        Node theNewLink = new Node(data, this.size);


        if(isEmpty()){

            firstLink = theNewLink;

        } else {

            lastLink.next = theNewLink;

            theNewLink.previous = lastLink;

        }

        lastLink = theNewLink;
        this.size++;

    }


    public boolean isEmpty(){

        return(firstLink == null);

    }


    public T get(int index) {

        if (index < 0 || index + 1 > this.size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");

        }

        Node currentNode = firstLink;

        for (int i = 1; i <= index; i++) {
            if (currentNode.next != null) {

                currentNode = currentNode.next;
            }
        }

        return currentNode.data;

    }


    public void remove(int index) {

        if (index < 0 || index + 1 > this.size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");

        }

        Node currentNode = lastLink;

        for (int i = this.size - 1; i > index; i--) {

                if (currentNode.previous != null) {

                    currentNode.index--;
                    currentNode = currentNode.previous;
                }
        }

        if (currentNode.previous == null) {
            firstLink = currentNode.next;
        } else {
            currentNode.previous.next = currentNode.next;
        }
        if (currentNode.next == null) {
            lastLink = currentNode.previous;
        } else {
            currentNode.next.previous = currentNode.previous;
        }

        size--;

    }


    public void add(T data, int index){

        Node theNewLink = new Node(data, index);

        Node futureNode = null;

        Node currentNode = lastLink;

        while((currentNode != null) && (index < currentNode.index)){

            currentNode.index++;
            currentNode = currentNode.previous;

        }

        if (currentNode.previous == null) {
            firstLink = theNewLink;
            currentNode.previous = theNewLink;
            currentNode.index++;
            theNewLink.next = currentNode;
            theNewLink.previous = null;

        } else if ((currentNode.next == null) && (currentNode.index == index)) {

            theNewLink.next = currentNode;
            theNewLink.previous = currentNode.previous;
            currentNode.previous.next = theNewLink;
            currentNode.previous = theNewLink;
            currentNode.index++;


        } else if (currentNode.next == null) {

            theNewLink.previous = currentNode;
            currentNode.next = theNewLink;
        }

        else {
            theNewLink.next = currentNode;
            theNewLink.previous = currentNode.previous;
            currentNode.previous.next = theNewLink;
            currentNode.previous = theNewLink;
            currentNode.index++;
        }

        this.size++;

    }

    public void display(){

        Node theLink = firstLink;

        while(theLink != null){

            theLink.display();

            System.out.println("Next Link: " + theLink.next + "     " + theLink.index);

            theLink = theLink.next;

            System.out.println();

        }

    }

    class Node {

        public T data;
        public int index;

        public Node next;

        public Node previous;

        public Node(T data, int index){

            this.data = data;
            this.index = index;

        }

        public void display(){

            System.out.println(data);

        }

    }

}
