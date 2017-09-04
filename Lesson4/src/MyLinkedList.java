

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

        if (index < 0 || index + 1 >= this.size) {
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


    public void add(T data, int index){

        Node theNewLink = new Node(data, index);

        Node previousNeighbor = null;

        Node currentNeighbor = firstLink;

        while((currentNeighbor != null) && (index > currentNeighbor.index)){

            previousNeighbor = currentNeighbor;

            currentNeighbor = currentNeighbor.next;

        }

        if(previousNeighbor == null){

            firstLink = theNewLink;

        } else {

            previousNeighbor.next = theNewLink;

        }

        theNewLink.next = currentNeighbor;
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
