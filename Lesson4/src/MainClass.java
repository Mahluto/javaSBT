

public class MainClass {

    public static void main(String[] args) {

        MyLinkedList <String> theLinkedList = new MyLinkedList <String> ();

        theLinkedList.add("Petunia Dursley");
        theLinkedList.add("Harry");
        theLinkedList.add("Ron");



        theLinkedList.display();
        System.out.println("__________________________");

        theLinkedList.add("Hermiona", 1);

        theLinkedList.display();

        System.out.println(theLinkedList.get(1));

        System.out.println(theLinkedList.size);

    }

}
