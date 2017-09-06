

public class MainClass {

    public static void main(String[] args) {

        MyLinkedList <String> theLinkedList = new MyLinkedList <String> ();

        theLinkedList.add("Petunia");
        theLinkedList.add("Harry");
        theLinkedList.add("Ron");
        theLinkedList.add("Nevil");

        theLinkedList.display();
        System.out.println("__________________________");

        theLinkedList.add("Hermiona", 3);
        theLinkedList.display();
        System.out.println("__________________________");
        theLinkedList.remove(4);
        theLinkedList.display();

        System.out.println(theLinkedList.size);


    }

}
