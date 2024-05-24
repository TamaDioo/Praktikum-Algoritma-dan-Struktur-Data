# <p align ="center">Laporan Praktikum Pertemuan 12 Algoritma dan Struktur Data</p>
<br><br><br><br>

<p align="center">
   <img src="https://static.wikia.nocookie.net/logopedia/images/8/8a/Politeknik_Negeri_Malang.png/revision/latest?cb=20190922202558" width="30%"> </p>

<br><br><br><br><br>

<p align = "center"> Nama     : Dio Andika Pradana Mulia Tama </p>
<p align = "center"> NIM      : 2341720098 </p>
<p align = "center"> Prodi    : Teknik Informatika</p>
<p align = "center"> Kelas    : 1B </p>
<p align = "center"> Presensi : 09 </p>

# Jobsheet 12
# Double Linked List

## 12.2 Kegiatan Praktikum 1

### 12.2.1 Percobaan 1
Kode program class Node:
```java
package Pertemuan12.doublelinkedlists;

public class Node {
    int data;
    Node prev, next;

    Node(Node prev, int data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
```

Kode program class DoubleLinkedLists:
```java
package Pertemuan12.doublelinkedlists;

public class DoubleLinkedLists {
    Node head;
    int size;

    public DoubleLinkedLists() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item) {
        if (isEmpty()) {
            head = new Node(null, item, null);
        } else {
            Node newNode = new Node(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;     
            }
            Node newNode = new Node(current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(int item, int index) throws Exception {
        if (isEmpty()) {
            addFirst(item);     
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.prev == null) {
                Node newNode = new Node(null, item, current);
                current.prev = newNode;
                head = newNode;
            } else {
                Node newNode = new Node(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public int size() {
        return size;    
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked Lists kosong");
        }
    }
}
```

Kode program class DoubleLinkedListsMain:
```java
package Pertemuan12.doublelinkedlists;

public class DoubleLinkedListsMain {
    public static void main(String[] args) throws Exception {
        DoubleLinkedLists dll = new DoubleLinkedLists();
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
        dll.addFirst(3);
        dll.addLast(4);
        dll.addFirst(7);
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
        dll.add(40, 1);
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
        dll.clear();
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
    }
}
```

### 12.2.2 Verifikasi Hasil Percobaan
<img src="pictures/12.perc1-output.png">

### 12.2.3 Pertanyaan Percobaan
1. Jelaskan perbedaan antara single linked list dengan double linked lists!<br>
2. Perhatikan class Node, di dalamnya terdapat atribut next dan prev. Untuk apakah atribut tersebut?<br>
3. Perhatikan konstruktor pada class DoubleLinkedLists. Apa kegunaan inisialisasi atribut head dan size seperti pada gambar berikut ini?
```java
    public DoubleLinkedLists() {
        head = null;
        size = 0;
    }
```
4. Pada method **addFirst()**, kenapa dalam pembuatan object dari konstruktor class Node prev dianggap sama dengan null?
```java
    Node newNode = new Node(null, item, head);
```
5. Perhatikan pada method **addFirst()**. Apakah arti statement head.prev = newNode ?<br>
6. Perhatikan isi method **addLast()**, apa arti dari pembuatan object Node dengan mengisikan parameter prev dengan current, dan next dengan null?
```java
    Node newNode = new Node(current, item, null);
```
7. Pada method **add()**, terdapat potongan kode program sebagai berikut:
```java
    if (current.prev == null) {
        Node newNode = new Node(null, item, current);
        current.prev = newNode;
        head = newNode;
```
jelaskan maksud dari bagian yang ditandai dengan kotak kuning.<br>

## 12.3 Kegiatan Praktikum 2

### 12.3.1 Tahapan Percobaan
Kode program tambahan method untuk menghapus isi double linked lists pada class DoubleLinkedLists:
```java
    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked list masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked list masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size --;
            return;
        } 
        Node current = head;
        while (current.next.next != null) {
            current = current.next;     
        }
        current.next = null;
        size--;
    }

    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks diluar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }
```
Kode program tambahan pada class DoubleLinkedListsMain untuk mengeksekusi method yang baru saja dibuat:
```java
        dll.addLast(50);
        dll.addLast(40);
        dll.addLast(10);
        dll.addLast(20);
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
        dll.removeFirst();
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
        dll.removeLast();
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
        dll.remove(1);
        dll.print();
        System.out.println("Size : "+dll.size);
```

### 12.3.2 Verifikasi Hasil Percobaan
<img src="pictures/12.perc2-output.png">

### 12.3.3 Pertanyaan Percobaan
1. Apakah maksud statement berikut pada method **removeFirst()**?
```java
    head = head.next;
    head.prev = null;
```
2. Bagaimana cara mendeteksi posisi data ada pada bagian akhir pada method **removeLast()**?<br>
3. Jelaskan alasan potongan kode program di bawah ini tidak cocok untuk perintah **remove**!
```java
    Node tmp = head.next;

    head.next=tmp.next;
    tmp.next.prev=head;
```
4. Jelaskan fungsi kode program berikut ini pada fungsi **remove**!
```java
    current.prev.next = current.next;
    current.next.prev = current.prev;
```

## 12.4 Kegiatan Praktikum 3

### 12.4.1 Tahapan Percobaan
Kode program tambahan method get pada class DoubleLinkedLists:
```java
    public int getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        return head.data;
    }

    public int getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        } 
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }
```

Kode program tambahan pada class DoubleLinkedListsMain untuk mengeksekusi method yang baru saja dibuat:
```java
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
        dll.addFirst(3);
        dll.addLast(4);
        dll.addFirst(7);
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
        dll.add(40, 1);
        dll.print();
        System.out.println("Size : "+dll.size);
        System.out.println("======================================");
        System.out.println("Data awal pada Linked Lists adalah " + dll.getFirst());
        System.out.println("Data akhir pada Linked Lists adalah " + dll.getLast());
        System.out.println("Data indeks ke-1 pada Linked Lists adalah " + dll.get(1));
```

### 12.4.2 Verifikasi Hasil Percobaan
<img src="pictures/12.perc3-output.png">

### 12.4.3 Pertanyaan Percobaan
1. Jelaskan method **size()** pada class DoubleLinkedLists!<br>
2. Jelaskan cara mengatur indeks pada double linked lists supaya dapat dimulai dari indeks ke-1!<br>
3. Jelaskan perbedaan karakteristik fungsi **Add** pada Double Linked Lists dan Single Linked Lists!<br>
4. Jelaskan perbedaan logika dari kedua kode program di bawah ini!<br>
<img src="pictures/12.4.3 no 4.png"><br>

## 12.5 Tugas Praktikum
1. Buat program antrian vaksinasi menggunakan queue berbasis double linked list sesuai ilustrasi dan menu di bawah ini! **(counter jumlah antrian tersisa di menu cetak(3) dan data orang yang telah divaksinasi di menu Hapus Data(2) harus ada)**<br>
**Contoh Ilustrasi Program**<br>
*Menu Awal dan Penambahan Data*
<img src="pictures/12.Tugas1.1.png">

*Cetak Data (**Komponen di area merah harus ada**)*
<img src="pictures/12.Tugas1.2.png">

*Hapus Data (**Komponen di area merah harus ada**)*
<img src="pictures/12.Tugas1.3.png">

2. Buatlah program daftar film yang terdiri dari id, judul dan rating menggunakan double linked lists, bentuk program memiliki fitur pencarian melalui ID Film dan pengurutan Rating secara descending. Class Film wajib diimplementasikan dalam soal ini.<br>
**Contoh Ilustrasi Program**<br>
*Menu Awal dan Penambahan Data*
<img src="pictures/12.Tugas2.1.png">
<img src="pictures/12.Tugas2.2.png">

*Cetak Data*
<img src="pictures/12.Tugas2.3.png">

*Pencarian Data*
<img src="pictures/12.Tugas2.4.png">

# <p align ="center">--- *** ---</p>