# <p align ="center">Laporan Praktikum Pertemuan 15 Algoritma dan Struktur Data</p>
<br><br><br><br>

<p align="center">
   <img src="https://static.wikia.nocookie.net/logopedia/images/8/8a/Politeknik_Negeri_Malang.png/revision/latest?cb=20190922202558" width="30%"> </p>

<br><br><br><br><br>

<p align = "center"> Nama     : Dio Andika Pradana Mulia Tama </p>
<p align = "center"> NIM      : 2341720098 </p>
<p align = "center"> Prodi    : Teknik Informatika</p>
<p align = "center"> Kelas    : 1B </p>
<p align = "center"> Presensi : 09 </p>

# Jobsheet 14
# Tree

## 13.2 Kegiatan Praktikum 1
## Implementasi Binary Search Tree menggunakan Linked List

### 13.2.1 Percobaan 1
Kode program class Node09:
```java
public class Node09 {
    int data;
    Node09 left, right;

    public Node09(int data) {
        this.left = null;
        this.data = data;
        this.right = null;
    }

    public Node09() {

    }
}
```

Kode program class BinaryTree09:
```java
public class BinaryTree09 {
    Node09 root;
    int size;

    public BinaryTree09() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void add(int data) {
        if (isEmpty()) {
            root = new Node09(data);
        } else {
            Node09 current = root;
            while (true) {
                if (data > current.data) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node09(data);
                        break;
                    }
                } else if (data < current.data) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node09(data);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    boolean find(int data) {
        boolean result = false;
        Node09 current = root;
        while (current != null) {
            if (current.data == data) {
                result = true;
                break;  
            } else if (data > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    void traversePreOrder(Node09 node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traversePostOrder(Node09 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    void traverseInOrder(Node09 node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }
    
    Node09 getSuccessor(Node09 del) {
        Node09 successor = del.right;
        Node09 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left; 
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        Node09 parent = root;
        Node09 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.data == data) {
                break;  
            } else if (data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (data > current.data) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Couldn't find data!");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {
                Node09 successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                    successor.left = current.left;
                }
            }
        }
    }
}
```

Kode program class BinaryTreeMain09:
```java
public class BinaryTreeMain09 {
    public static void main(String[] args) {
        BinaryTree09 bt = new BinaryTree09();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(10);
        bt.add(15);
        System.out.print("Preorder Traversal : ");
        bt.traversePreOrder(bt.root);
        System.out.println("");
        System.out.print("inOrder Traversal : ");
        bt.traverseInOrder(bt.root);
        System.out.println("");
        System.out.print("PostOrder Traversal : ");
        bt.traversePostOrder(bt.root);  
        System.out.println("");
        System.out.println("Find Node : " + bt.find(5));
        System.out.println("Delete Node 8 ");
        bt.delete(8);
        System.out.println("");
        System.out.print("PreOrder Traversal : ");
        bt.traversePreOrder(bt.root);
        System.out.println("");
    }
}
```

Hasil running program:
<img src="pictures/percobaan1 Tree - output.png">

### 13.2.2 Pertanyaan Percobaan
1. Mengapa dalam binary search tree proses pencarian data bisa lebih efektif dilakukan dibanding binary tree biasa?<br>
Jawab: Karena pada binary search tree, semua left-child harus lebih kecil daripada right-child dan parent-nya sehingga binary search tree biasa disebut juga dengan ordered binary tree yaitu binary tree yang seluruh children dari tiap node terurut. Hal ini akan mempermudah dalam proses pencarian node tertentu dalam binary tree. Oleh karena itu, proses pencarian data pada binary search tree bisa lebih efektif jika dibandingkan dengan binary tree biasa. 

2. Untuk apakah di class **Node**, kegunaan dari atribut **left** dan **right**?<br>
Jawab: Atribut left pada class Node09 merupakan atribut untuk menyimpan pointer yang merujuk ke child kiri dari node saat ini (parent). Sebaliknya, atribut right pada class Node09 digunakan untuk menyimpan pointer yang merujuk ke child kanan dari node saat ini (parent).

3. a. Untuk apakah kegunaan dari atribut **root** di dalam class **BinaryTree**? <br> 
Jawab: Atribut root di dalam class BinaryTree09 digunakan untuk menyimpan node root (akar dari tree). Root merupakan node dalam tree yang tidak memiliki parent karena root merupakan elemen pertama dalam tree.<br>
b. Ketika objek tree pertama kali dibuat, apakah nilai dari **root**?<br>
Jawab: Ketika objek tree pertama kali dibuat, nilai dari root adalah null karena masih belum ada elemen dalam tree yang baru dibuat tersebut. Oleh karena itu, konstruktor dari BinaryTree09 menginisialisasi root dengan nilai null yang menandakan bahwa binary tree masih kosong dan belum ada elemen yang dimasukkan ke dalamnya.

4. Ketika tree masih kosong, dan akan ditambahkan sebuah node baru, proses apa yang akan terjadi?<br>
Jawab: Proses yang akan terjadi adalah penambahan node baru pada tree ketika tree masih kosong sehingga node baru yang ditambahkan dalam tree tersebut akan menjadi root. Hal ini karena pada saat node baru ditambahkan tree masih kosong dan belum ada elemen sama sekali sehingga node baru tersebut akan menjadi elemen pertama atau dapat disebut sebagi root.

5. Perhatikan method **add()**, di dalamnya terdapat baris program seperti di bawah ini. Jelaskan secara detil untuk apa baris program tersebut?
```java
if (data < current.data) {
        if (current.left != null) {
            current = current.left;
        } else {
            current.left = new Node09(data);
            break;
        }
}
```
Jawab: Baris program di atas bertujuan untuk menambahkan node baru ke child kiri dari node saat ini (current). Jika nilai data yang ingin dimasukkan lebih kecil daripada nilai data dari current, maka node baru akan dimasukkan sebagai child kiri dari current. Jika current (parent) sudah memiliki child kiri `(current.left != null)`, maka current akan digeser ke child kiri dari current (parent) hingga menemukan kondisi yang sesuai untuk memasukkan elemen baru. Namun jika current (parent) belum memiliki child kiri, maka node baru dengan nilai data akan ditambahkan sebagai child kiri dari current (parent) tersebut. 

## 13.3 Kegiatan Praktikum 2
## Implementasi binary tree dengan array

### 13.3.1 Tahapan Percobaan
Kode program class BinaryTreeArray09:
```java
public class BinaryTreeArray09 {
    int[] data;
    int idxLast;

    public BinaryTreeArray09() {
        data = new int[10];
    }

    void populateData(int data[], int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            System.out.print(data[idxStart] + " ");
            traverseInOrder(2 * idxStart + 2);
        }
    }
}
```

Kode program class BinaryTreeArrayMain09:
```java
public class BinaryTreeArrayMain09 {
    public static void main(String[] args) {
        BinaryTreeArray09 bta = new BinaryTreeArray09();
        int[] data = {6,4,8,3,5,7,9,0,0,0};
        int idxLast = 6;
        bta.populateData(data, idxLast);
        System.out.print("\nInOrder Traversal : ");
        bta.traverseInOrder(0);
        System.out.println("\n");
    }
}
```

Hasil running program:
<img src="pictures/percobaan2 Tree - output.png">

### 13.3.2 Pertanyaan Percobaan
1. Apakah kegunaan dari atribut data dan idxLast yang ada di class **BinaryTreeArray**?<br>
Jawab: Atribut data merupakan array bertipe integer yang digunakan untuk menyimpan elemen-elemen dalam binary tree. Setiap elemen dalam array mewakili sebuah node dalam binary tree. Indeks elemen array data menentukan posisi node dalam binary tree. Sedangkan atribut idxLast digunakan untuk menyimpan indeks terakhir pada array data yang terisi oleh elemen pada binary tree. Atribut ini digunakan untuk mengetahui batas akhir dari elemen binary tree yang diwakili dalam array, sehingga traversal atau operasi lain dapat dibatasi hingga indeks tersebut. Array data mungkin dialokasikan dengan ukuran tertentu (misalnya 10) namun tidak semua elemen terpakai untuk menyimpan node.  Oleh karena itu, atribut idxLast berperan untuk menunjukkan indeks terakhir yang masih sesuai dengan elemen yang terpakai dalam binary tree.

2. Apakah kegunaan dari method **populateData()**?<br>
Jawab: Method populateData() dalam class BinaryTreeArray09 berfungsi untuk menginisialisasi atribut data dengan parameter array data dan menginisialisasi atribut idxLast dengan parameter idxLast. 

3. Apakah kegunaan dari method **traverseInOrder()**?<br>   
Jawab: Metode traverseInOrder() digunakan untuk melakukan traversal secara in-order pada binary tree yang diimplementasikan dalam bentuk array. Method ini akan mengunjungi node dengan urutan in-order (subtree kiri, root, subtree kanan), dan mencetak nilai dari setiap node yang dikunjungi. 

4. Jika suatu node binary tree disimpan dalam array indeks 2, maka di indeks berapakah posisi left child dan rigth child masin-masing?<br>
Jawab: Implementasi binary tree dengan array dapat dimulai dengan indeks 0 atau bisa juga dimulai dengan indeks 1. Pada percobaan di atas, implementasi binary tree dengan array dimulai dengan indeks ke 0 sehingga berlaku rumus `child kiri = 2*i+1` dan `child kanan = 2*i+1`. Dengan demikian, jika suatu node binary tree disimpan dalam array indeks 2, maka posisi indeks left child dan right child-nya adalah:<br>
Left child = 2 * 2 + 1 = 5<br>
Right child = 2 * 2 + 2 = 6<br>
Jadi, node binary tree yang disimpan dalam array dengan indeks 2 akan memiliki posisi left child di indeks 5 dan right child di indeks 6.
 
5. Apa kegunaan statement int idxLast = 6 pada praktikum 2 percobaan nomor 4?<br>
Jawab: Statement int idxLast = 6 akan mengisi variabel idxLast dengan 6 yang kemudian variabel idxLast akan dimasukkan sebagai parameter pada method populateData(). Walaupun sebenarnya indeks maksimum dari array data adalah 9 (karena ada 10 elemen), tetapi yang digunakan hanya sampai indeks ke-6 saja, karena indeks 7-9 nilainya 0 sehingga tidak perlu dimasukkan ke dalam binary tree. Dengan menginisialisasi idxLast = 6, akan membuat program menjadi lebih efisien karena tidak perlu memproses elemen yang bernilai 0 yaitu pada indeks 7-9.

## 13.4 Tugas Praktikum
1. Buat method di dalam class **BinaryTree** yang akan menambahkan node dengan cara rekursif.
2. Buat method di dalam class **BinaryTree** untuk menampilkan nilai paling kecil dan yang paling besar yang ada di dalam tree.
3. Buat method di dalam class **BinaryTree** untuk menampilkan data yang ada di leaf.
4. Buat method di dalam class **BinaryTree** untuk menampilkan berapa jumlah leaf yang ada di dalam tree.
5. Modifikasi class **BinaryTreeArray**, dan tambahkan :
    - method **add(int data)** untuk memasukan data ke dalam tree
    - method **traversePreOrder()** dan **traversePostOrder()**