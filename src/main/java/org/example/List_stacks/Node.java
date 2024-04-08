package org.example.List_stacks;

public class Node<E> {
   protected E element;
   protected Node<E>  next;


    Node(){};
    Node(E element){
        this.element = element;
    }
//    public static void main(){
//        Node<String > head;
//        Node<String> tail = null;
//        head = new Node<>("lambda");
//        tail.next = head; // pointing to same node.
//        tail.next = new Node<>("Denver Nuggets"); // de-referencing the tail
//        Node<String> current = head;
//        while(current != null){
//            System.out.println(current.element);
//            current = current.next;
//        }
//
//    }

}