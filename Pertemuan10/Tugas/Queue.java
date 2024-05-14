package Pertemuan10.Tugas;

public class Queue {
    Pembeli[] antrian;
    int front, rear, max, size;

    public Queue(int n) {
        max = n;
        antrian = new Pembeli[max];
        front = rear = -1;
        size = 0;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;   
        }
    }

        public void Enqueue(Pembeli antri) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;     
                }
            }
            antrian[rear] = antri;
            size++;
        }
    }

    public Pembeli Dequeue() {
        Pembeli antri = new Pembeli();
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            antri = antrian[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return antri;
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i].nama + " " + antrian[i].noHP);
                i = (i + 1) % max;  
            }
            System.out.println(antrian[i].nama + " " + antrian[i].noHP);
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + antrian[front].nama + " " + antrian[front].noHP);
        } else {
            System.out.println("Queue masih kosong");   
        }
    }

    public void peekRear() {
        if (!IsEmpty()) {
            System.out.println("Elemen terakhir: " + antrian[rear].nama + " " + antrian[rear].noHP);
        } else {
            System.out.println("Queue masih kosong");   
        }
    }

    public void daftarPembeli() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i].nama + " " + antrian[i].noHP);
                i = (i + 1) % max;  
            }
            System.out.println(antrian[i].nama + " " + antrian[i].noHP);
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void peekPosition(String nama) {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                if (antrian[i].nama.equalsIgnoreCase(nama)) {
                    System.out.println("Pembeli dengan nama " + nama + " berada di posisi ke-" + (i));
                    return;
                }
                i = (i + 1) % max;
            }
            if (antrian[i].nama.equalsIgnoreCase(nama)) {
                System.out.println("Pembeli dengan nama " + nama + " berada di posisi ke-" + (i));
            } else {
                System.out.println("Pembeli dengan nama " + nama + " tidak ditemukan dalam antrian");
            }
        }
    }
}