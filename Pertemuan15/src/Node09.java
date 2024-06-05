package Pertemuan15.src;

public class Node09 {
    int data, jarak;
    Node09 prev, next;

    Node09(Node09 prev, int data, int jarak, Node09 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
        this.jarak = jarak;
    }
}