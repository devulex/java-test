package patterns.linkedlist;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("Москва");
        list.add("Санкт-Петербург");
        list.add("Казань");
        list.add("Череповец");
        System.out.println(list.asString());
        list.reverse();
        System.out.println(list.asString());
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    static class Node {
        Node next;
        Object value;

        Node(Node next, Object value) {
            this.next = next;
            this.value = value;
        }
    }

    public void add(Object o) {
        if (size == 0) {
            last = first = new Node(null, o);
        } else {
            last.next = new Node(null, o);
            last = last.next;
        }
        size++;
    }

    public String asString() {
        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current != null) {
            sb.append(current.value.toString()).append(",");
            current = current.next;
        }
        return sb.toString();
    }

    public void reverse() {
        Node prev = null;
        Node current = first;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }
}


