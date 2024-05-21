package Pertemuan11.minggu11;

import Pertemuan10.Tugas.Pembeli;

public class MhsQueue {
    Mahasiswa head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(int nim, String nama) {
        Mahasiswa ndInput = new Mahasiswa(nim, nama, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(int nim, String nama) {
        Mahasiswa ndInput = new Mahasiswa(nim, nama, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong!");
        } else {
            Mahasiswa tmp = head;
            System.out.println("Cek semua antrian: ");
            while (tmp != null) {
                System.out.println("NIM : " + tmp.NIM + ", Nama : " + tmp.nama);
                tmp = tmp.next;
            }
            System.out.println("");
        }
    }

    void Enqueue(int nim, String nama) {
        if (isEmpty()) {
            addFirst(nim, nama);
        } else {
            addLast(nim, nama);
        }
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong!");   
        } else {
            System.out.println("Elemen terdepan:\nNama : " + head.nama + ", NIM :" + head.NIM);
        }
    }

    void peekRear() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong!");   
        } else {
            System.out.println("Elemen terakhir:\nNama : " + tail.nama + ", NIM :" + tail.NIM);
        }
    }

    Mahasiswa Dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong, tidak dapat dihapus!");
            return null;
        } else if (head == tail) {
            Mahasiswa eq = head;
            head = tail = null;
            return eq;
        } else {
            Mahasiswa eq = head;
            head = head.next;
            return eq;
        }      
    }
}