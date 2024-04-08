# <p align ="center">Laporan Praktikum Pertemuan 8 Algoritma dan Struktur Data</p>
<br><br><br><br>

<p align="center">
   <img src="https://static.wikia.nocookie.net/logopedia/images/8/8a/Politeknik_Negeri_Malang.png/revision/latest?cb=20190922202558" width="30%"> </p>

<br><br><br><br><br>

<p align = "center"> Nama     : Dio Andika Pradana Mulia Tama </p>
<p align = "center"> NIM      : 2341720098 </p>
<p align = "center"> Prodi    : Teknik Informatika</p>
<p align = "center"> Kelas    : 1B </p>
<p align = "center"> Presensi : 09 </p>

# Jobsheet 7
# Stack

# 2. Praktikum
## 2.1 Percobaan 1: Penyimpanan Tumpukan Barang dalam Gudang

### 2.1.1 Langkah-langkah Percobaan
#### 1. Class Barang
1. Buka text editor. Buat file baru, beri nama **Barang<NoAbsen>.java**
2. Lengkapi class **Barang** dengan atribut yang telah digambarkan di dalam class diagram Barang, yang terdiri dari atribut **kode, nama,** dan **kategori**
3. Tambahkan konstruktor berparameter pada class Barang sesuai dengan class diagram Barang
```java
public class Barang09 {
    int kode;
    String nama, kategori;

    public Barang09(int kode, String nama, String kategori) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
    }
}
```
#### 2. Class Gudang
4. Setelah membuat class Barang, selanjutnya perlu dibuat class **Gudang<NoAbsen>.java** sebagai 
tempat untuk mengelola tumpukan barang. Class Gudang merupakan penerapan dari Stack
5. Lengkapi class **Gudang** dengan atribut yang telah digambarkan di dalam class diagram Gudang, yang terdiri dari atribut **tumpukan, size,** dan **top**
```java
public class Gudang09 {
    Barang09[] tumpukan;
    int size, top;
}
```
6. Tambahkan konstruktor berparameter pada class Gudang untuk melakukan inisialisasi kapasitas maksimum data barang yang dapat disimpan di dalam stack, serta mengeset indeks awal dari pointer top
```java
    public Gudang09(int kapasitas) {
        size = kapasitas;
        tumpukan = new Barang09[size];
        top = -1;
    }
```
7. Pada class Gudang, buat method **cekKosong** bertipe boolean untuk mengecek apakah tumpukan barang di dalam gudang masih kosong
```java
    public boolean cekKosong() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
```
8. Selanjutnya, buat method **cekPenuh** bertipe boolean untuk mengecek apakah tumpukan barang di dalam gudang sudah terisi penuh sesuai kapasitas
```java
    public boolean cekPenuh() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }
```
9. Untuk dapat menambahkan barang ke dalam tumpukan di gudang, maka buat method **tambahBarang** yang merepresentasikan push. Method ini menerima parameter **brg** yang berupa object **Barang**
```java
    public void tambahBarang(Barang09 brg) {
        if (!cekPenuh()) {
            top++;
            tumpukan[top] = brg;
            System.out.println("Barang " + brg.nama + " berhasil ditambahkan ke Gudang");
        } else {
            System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
        }
    }
```
10. Pengambilan barang dari tumpukan di gudang dilakukan dengan menggunakan method **ambilBarang** yang merepresentasikan pop. Method ini tidak menerima parameter apapun karena barang yang diambil atau dikeluarkan pasti berada di posisi teratas
```java
    public Barang09 ambilBarang() {
        if (!cekKosong()) {
            Barang09 delete = tumpukan[top];
            top--;
            System.out.println("Barang " + delete.nama + " diambil dari Gudang");
            return delete;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }
```
*Catatan: Apabila diperlukan informasi mengenai data barang yang diambil, maka tipe kembalian harus berupa object Barang. Sebaliknya, tipe kembalian void dapat digunakan jika data barang yang dikeluarkan tidak akan diolah atau digunakan lagi*
11. Buat method **lihatBarangTeratas** yang merepresentasikan peek untuk dapat mengecek tumpukan barang di posisi paling atas
```java
    public Barang09 lihatBarangTeratas() {
        if (!cekKosong()) {
            Barang09 barangTeratas = tumpukan[top];
            System.out.println("Barang teratas: " + barangTeratas.nama);
            return barangTeratas;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }
```
***Perbaiki kode program, jika menurut Anda terdapat kesalahan***
12. Tambahkan method **tampilkanBarang** untuk dapat menampilkan semua rincian tumpukan barang di gudang
```java
    public void tampilkanBarang() {
        if (!cekKosong()) {
            System.out.println("Rincian tumpukan barang di Gudang:");
            //for (int i = top; i >= 0; i--) { Seharusnya ini yang benar
            for (int i = 0; i <= top; i++) {
                System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori); 
            }
        } else {
            System.out.println("Tumpukan barang kosong.");
        }
    }
```
Terdapat kesalahan dalam perulangan untuk menampilkan barang yaitu inisalisasi counter i yang salah, batas perulangan yang salah dan update counter i yang salah. Prinsip dari stack adalah LIFO (last in first out), jadi barang dengan posisi terataslah yang akan tampil terlebih dahulu. Jadi, perulangan yang benar adalah ``//for int i = top; i >= 0; i--)``
Kode yang benar:
```java
public void tampilkanBarang() {
        if (!cekKosong()) {
            System.out.println("Rincian tumpukan barang di Gudang:");
            for (int i = top; i >= 0; i--) {
            //for (int i = 0; i <= top; i++) {
                System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori); 
            }
        } else {
            System.out.println("Tumpukan barang kosong.");
        }
    }
```
#### 3. Class Utama
13. Buat file baru, beri nama **Utama<NoAbsen>.java**
14. Tuliskan struktur dasar bahasa pemrograman Java yang terdiri dari fungsi **main**
```java
public class Utama09 {
    public static void main(String[] args) {
        
    }
}
```
15. Di dalam fungsi main, lakukan instansiasi object Gudang bernama gudang dengan nilai parameternya adalah 7.
```java
    Gudang09 gudang = new Gudang09(7);
```
16. Deklarasikan Scanner dengan nama variabel **scanner**
```java
        Scanner scanner = new Scanner(System.in);
```
17. Tambahkan menu untuk memfasilitasi pengguna dalam memilih operasi Stack dalam mengelola data barang di gudang menggunakan struktur perulangan **While**
```java
        while (true) {
            System.out.println("\nMenu:");    
            System.out.println("1. Tambah barang");    
            System.out.println("2. Ambil Barang");    
            System.out.println("3. Tampilkan tumbukan barang");    
            System.out.println("4. Keluar");    
            System.out.println("Pilih operasi: ");    
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    int kode = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nama kategori: ");
                    String kategori = scanner.nextLine();
                    Barang09 barangBaru = new Barang09(kode, nama, kategori);
                    gudang.tambahBarang(barangBaru);
                    break;
                case 2:
                    gudang.ambilBarang();
                    break;
                case 3:
                    gudang.tampilkanBarang();
                    break;  
                case 4:
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        }
```
18. **Commit dan push kode program ke Github**
<img src="pictures/8.perc1-push.png">
19. Compile dan run program.

Kode program class Barang09:
```java
public class Barang09 {
    int kode;
    String nama, kategori;

    public Barang09(int kode, String nama, String kategori) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
    }
}
```

Kode program class Gudang09.java:
```java
public class Gudang09 {
    Barang09[] tumpukan;
    int size, top;

    public Gudang09(int kapasitas) {
        size = kapasitas;
        tumpukan = new Barang09[size];
        top = -1;
    }

    public boolean cekKosong() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cekPenuh() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void tambahBarang(Barang09 brg) {
        if (!cekPenuh()) {
            top++;
            tumpukan[top] = brg;
            System.out.println("Barang " + brg.nama + " berhasil ditambahkan ke Gudang");
        } else {
            System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
        }
    }

    public Barang09 ambilBarang() {
        if (!cekKosong()) {
            Barang09 delete = tumpukan[top];
            top--;
            System.out.println("Barang " + delete.nama + " diambil dari Gudang");
            return delete;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }

    public Barang09 lihatBarangTeratas() {
        if (!cekKosong()) {
            Barang09 barangTeratas = tumpukan[top];
            System.out.println("Barang teratas: " + barangTeratas.nama);
            return barangTeratas;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }

    public void tampilkanBarang() {
        if (!cekKosong()) {
            System.out.println("Rincian tumpukan barang di Gudang:");
            for (int i = top; i >= 0; i--) {
            //for (int i = 0; i <= top; i++) {
                System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori); 
            }
        } else {
            System.out.println("Tumpukan barang kosong.");
        }
    }
}
```

Kode program class Utama09:
```java
import java.util.Scanner;

public class Utama09 {
    public static void main(String[] args) {
        Gudang09 gudang = new Gudang09(7);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");    
            System.out.println("1. Tambah barang");    
            System.out.println("2. Ambil Barang");    
            System.out.println("3. Tampilkan tumpukan barang");    
            System.out.println("4. Keluar");    
            System.out.print("Pilih operasi: ");    
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    int kode = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nama kategori: ");
                    String kategori = scanner.nextLine();
                    Barang09 barangBaru = new Barang09(kode, nama, kategori);
                    gudang.tambahBarang(barangBaru);
                    break;
                case 2:
                    gudang.ambilBarang();
                    break;
                case 3:
                    gudang.tampilkanBarang();
                    break;  
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        }
    }
}
```

### 2.1.2 Verifikasi Hasil Percobaan
<img src="pictures/8.Perc-1-verif1.png">
<img src="pictures/8.Perc-1-verif2.png">

### 2.1.3 Pertanyaan
1. Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi hasil percobaan! Bagian mana saja yang perlu diperbaiki?<br>
Jawab: Bagian yang perlu diperbaiki adalah pada method tampilkanBarang dan method lihatBarangTeratas(). Ada juga kesalahan dalam class Utama09, yaitu pada menu keluar.
- Method tampilkanBarang():
```java
    public void tampilkanBarang() {
        if (!cekKosong()) {
            System.out.println("Rincian tumpukan barang di Gudang:");
            //for (int i = top; i >= 0; i--) { Seharusnya ini yang benar
            for (int i = 0; i <= top; i++) {
                System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori); 
            }
        } else {
            System.out.println("Tumpukan barang kosong.");
        }
    }
```
Terdapat kesalahan dalam perulangan untuk menampilkan barang yaitu inisalisasi counter i yang salah, batas perulangan yang salah dan update counter i yang salah. Prinsip dari stack adalah LIFO (last in first out), jadi barang dengan posisi terataslah yang akan tampil terlebih dahulu. Jadi, perulangan yang benar adalah ``//for int i = top; i >= 0; i--)``<br>
Kode yang benar:
```java
public void tampilkanBarang() {
        if (!cekKosong()) {
            System.out.println("Rincian tumpukan barang di Gudang:");
            for (int i = top; i >= 0; i--) {
            //for (int i = 0; i <= top; i++) {
                System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori); 
            }
        } else {
            System.out.println("Tumpukan barang kosong.");
        }
    }
```
- Method lihatBarangTeratas():
```java
    public Barang09 lihatBarangTeratas() {
        if (!isEmpty()) {
            Barang09 barangTeratas = tumpukan[top];
            System.out.println("Barang teratas: " + barangTeratas.nama);
            return barangTeratas;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }
```
Terdapat kesalahan pemanggilan method pada kondisi if dalam method lihatBarangTeratas(). Method isEmpty tidak terdefinisikan dalam class Gudang09. Seharusnya method yang dipanggil adalah method cekKosong() untuk memastikan apakah stack dalam keadaan kosong atau tidak.<br>
Kode yang benar:
```java
    public Barang09 lihatBarangTeratas() {
        if (!cekKosong()) {
            Barang09 barangTeratas = tumpukan[top];
            System.out.println("Barang teratas: " + barangTeratas.nama);
            return barangTeratas;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }
```
- Terdapat kesalahan pada menu keluar (case 4) pada class Utama09. Meskipun telah memilih menu untuk keluar program, program akan tetap berjalan dan tidak akan berhenti (infinite loop). Oleh karena itu perlu ditambahkan sintaks untuk menghentikan eksekusi program. Sintaks yang saya gunakan adalah `System.extit(0)`.
```java
                case 4:
                    System.exit(0);
                    break;
```
2. Berapa banyak data barang yang dapat ditampung di dalam tumpukan? Tunjukkan potongan kode programnya!<br>
Jawab: Data barang yang dapat ditampung di dalam tumpukan adalah sebanyak 7 barang karena dalam class Utama09, parameter konstruktor Gudang09 diisi dengan angka 7. Parameter tersebut dijadikan panjang array tumpukan.
Potongan kode program:
```java
    Gudang09 gudang = new Gudang09(7);
```
Konstruktor Gudang09 dalam class Gudang09:
```java
    public Gudang09(int kapasitas) { //kapasitas = 7
        size = kapasitas; //size = 7
        tumpukan = new Barang09[size]; //tumpukan = new Barang09[7]; 
        top = -1;
    }
```
3. Mengapa perlu pengecekan kondisi **!cekKosong()** pada method **tampilkanBarang**? Kalau kondisi tersebut dihapus, apa dampaknya?<br>
Jawab: Untuk memastikan tumpukan barang tidak dalam kondisi kosong. Karena jika tumpukan barang kosong, maka tidak ada barang yang bisa ditampilkan. Oleh karena itu, diperlukan pengecekan terlebih dahulu pada tumpukan barang untuk memastikan apakah barang yang akan ditampilkan ada atau masih kosong. Jika tumpukan barang kosong, maka proses perulangan untuk menampilkan rincian barang tidak akan dijalankan. Namun, jika kondisi tersebut dihapus, maka program akan mencoba untuk menampilkan rincian tumpukan barang tanpa mengecek terleih dahulu apakah tumpukan barang kosong atau tidak. Jadi, ketika tumpukan barang kosong, program tetap bisa dijalankan, tetapi tidak ada barang yang ditampilkan.<br>
<img src="pictures/8.perc1-pert3.png">

4. Modifikasi kode program pada class **Utama** sehingga pengguna juga dapat memilih operasi lihat barang teratas, serta dapat secara bebas menentukan kapasitas gudang!<br>
Modifikasi kode program:
```java
import java.util.Scanner;

public class Utama09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Meminta pengguna untuk menentukan kapasitas gudang
        System.out.print("Berapa kapasitas gudang yang Anda inginkan: ");
        int capacity = scanner.nextInt();
        Gudang09 gudang = new Gudang09(capacity);


        while (true) {
            System.out.println("\nMenu:");    
            System.out.println("1. Tambah barang");    
            System.out.println("2. Ambil barang");    
            System.out.println("3. Tampilkan tumpukan barang");    
            System.out.println("4. Lihat barang teratas"); //Menambahkan menu untuk melihat barang teratas
            System.out.println("5. Keluar");    
            System.out.print("Pilih operasi: ");    
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    int kode = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nama kategori: ");
                    String kategori = scanner.nextLine();
                    Barang09 barangBaru = new Barang09(kode, nama, kategori);
                    gudang.tambahBarang(barangBaru);
                    break;
                case 2:
                    gudang.ambilBarang();
                    break;
                case 3:
                    gudang.tampilkanBarang();
                    break;  
                case 4: //Menu lihat barang teratas
                    gudang.lihatBarangTeratas();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        }
    }
}
```
Output kode program setelah dimodifikasi:<br>
<img src="pictures/8.Perc1-pert3.1.png">
<img src="pictures/8.Perc1-pert3.2.png">
<img src="pictures/8.Perc1-pert3.3.png">

5. **Commit dan push kode program ke Github**<br>
<img src="pictures/8.perc1-push.png">

## 2.2 Percobaan 2: Konversi Kode Barang ke Biner 
### 2.2.1 Langkah-langkah Percobaan
1. Buka kembali file **Gudang<NoAbsen>.java**
2. Tambahkan method **konversiDesimalKeBiner** dengan menerima parameter **kode** bertipe int
```java
    public String konversiDesimalKeBiner(int kode) {
        StackKonversi09 stack = new StackKonversi09();
        while (kode > 0) {
            int sisa = kode % 2;
            stack.push(sisa);
            kode = kode / 2;
        }
        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();   
        }
        return biner;
    }
```
Pada method ini, terdapat penggunaan **StackKonversi** yang merupakan penerapan Stack, sama halnya dengan class Gudang. Hal ini bertujuan agar Stack untuk barang berbeda dengan Stack yang digunakan untuk biner. Oleh karena itu, buat file baru bernama **StackKonversi<NoAbsen>.java**
*Catatan: Perlu diingat bahwa pada dasarnya semua class Stack mempunyai operasi (method) yang sama. Hal yang membedakan adalah aktivitas spesifik yang perlu dilakukan, misalnya setelah menambah atau mengeluarkan data.*
3. Tambahkan empat method yaitu **isEmpty, isFull, push,** dan **pull** sebagai operasi utama Stack pada class **StackKonversi**
```java
    int size, top;
    int[] tumpukanbiner;

    public StackKonversi09() {
        this.size = 32; //asumsi 32 bit
        tumpukanbiner = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack penuh");
        } else {
            top++;
            tumpukanbiner[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return -1;
        } else {
            int data = tumpukanbiner[top];
            top--;
            return data;
        }
    }
```
4. Agar kode barang dikonversi ke dalam bentuk biner saat barang tersebut diambil atau dikeluarkan dari tumpukan, maka tambahkan baris kode program pada method **ambilBarang**
```java
    public Barang09 ambilBarang() {
        if (!cekKosong()) {
            Barang09 delete = tumpukan[top];
            top--;
            System.out.println("Barang " + delete.nama + " diambil dari Gudang");
            System.out.println("Kode unik dalam biner: " + konversiDesimalKeBiner(delete.kode));
            return delete;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }
```
5. Compile dan run program.
6. **Commit dan push kode program ke Github**
<img src="pictures/8.perc2-push.png">

Kode program class StackKonversi09:
```java
public class StackKonversi09 {
    int size, top;
    int[] tumpukanbiner;

    public StackKonversi09() {
        this.size = 32; //asumsi 32 bit
        tumpukanbiner = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack penuh");
        } else {
            top++;
            tumpukanbiner[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return -1;
        } else {
            int data = tumpukanbiner[top];
            top--;
            return data;
        }
    }
}
```

### 2.2.2 Verifikasi Hasil Percobaan
<img src="pictures/8.Perc-2-verif1.png">

### 2.2.3 Pertanyaan
1. Pada method **konversiDesimalKeBiner**, ubah kondisi perulangan menjadi **while (kode != 0)**, bagaimana hasilnya? Jelaskan alasannya!<br>
Jawab: Hasilnya sama saja, tidak ada perubahan jika menggunakan `while (kode != 0)`.<br>
Perubahan kode program:
```java
        while (kode != 0) {
            int sisa = kode % 2;
            stack.push(sisa);
            kode = kode / 2;
        }
```
Output:<br>
<img src="pictures/8.Perc-2-pert1.png"><br>
Berdasarkan percobaan di atas, didapatkan kesimpulan bahwa meskipun perulangan diubah menjadi ``
while (kode != 0)``, hasilnya akan tetap sama. Keduanya akan menghasilkan biner yang sama untuk nilai desimal yang diberikan. Hal ini terjadi karena proses konversi bilangan desimal ke biner menggunakan pembagian bilangan desimal dengan 2 dan menyimpan (push ke stack) sisa hasil baginya. Ketika nilai kode sudah mencapai 0, proses konversi selesai karena tidak ada sisa bagi yang tersisa untuk dibagi lagi (0 / 2 = 0). Kedua kondisi perulangan baik ``while (kode > 0)`` maupun ``while (kode != 0)``, akan menghentikan proses pembagian ketika kode = 0, sehingga hasil akhirnya akan sama.

2. Jelaskan alur kerja dari method **konversiDesimalKeBiner!**<br>
Jawab: Berikut adalah alur kerja dari method **konversiDesimalKeBiner!**:
    1. Instansiasi objek `stack` dari class StackKonversi09 
    2. Selama nilai parameter kode lebih besar dari 0, perulangan while pertama akan dijalankan. Dalam perulangan while pertama, variabel `sisa` bertipe integer dideklarasikan dan diisi dengan nilai `kode % 2`. Setelah itu, method push pada objek stack akan diakses dengan `sisa` sebagai parameternya. Lalu variabel `kode` akan diassignment dengan nilai `kode / 2`. Proses ini akan terus berlanjut sampai nilai `kode <= 0`.
    3. Setelah perulangan while pertama selesai, variabel dengan nama `biner` yang bertipe String dibuat dan diinisialisasi dengan string kosong. 
    4. Kemudian perulangan while kedua akan dijalankan selama objek `stack` tidak kosong. Dalam perulangan ini, elemen teratas dari `stack` dikeluarkan (pop) dan ditambahkan ke string `biner`.
    5. Setelah itu, method akan mengembalikan nilai variabel `biner` (bertipe String) yang berisi bilangan biner hasil konversi.

## 2.3 Percobaan 3: Konversi Notasi Infix ke Postfix
### 2.3.1 Langkah-langkah Percobaan
1. Buat file baru bernama **Postfix<NoAbsen>.java**
2. Tambahkan atribut **n, top**, dan **stack** sesuai Class Diagram Postfix tersebut
```java
public class Postfix09 {
    int n, top;
    char[] stack;
}
```
3. Tambahkan pula konstruktor berparameter seperti gambar berikut ini.
```java
    public Postfix09(int total) {
        n = total;
        top = -1;
        stack = new char[n];
        push('(');
    }
```
4. Buat method **push** dan **pop** bertipe void.
```java
    public void push(char c) {
        top++;
        stack[top] = c;
    }

    public char pop() {
        char item = stack[top];
        top--;
        return item;
    }
```
5. Buat method **IsOperand** dengan tipe boolean yang digunakan untuk mengecek apakah elemen data berupa operand.
```java
    public boolean IsOperand(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == ' ' || c == '.') {
            return true;
        } else {
            return false;
        }
    }
```
6. Buat method **IsOperator** dengan tipe boolean yang digunakan untuk mengecek apakah elemen data berupa operator.
```java
    public boolean IsOperator(char c) {
        if (c == '^' || c == '%' || c == '/' || c == '*' || c == '-' || c == '+') {
            return true;
        } else {
            return false;
        }
    }
```
7. Buat method **derajat** yang mempunyai nilai kembalian integer untuk menentukan derajat operator.
```java
    public int derajat(char c) {
        switch (c) {
            case '^':
                return 3;
            case '%':
                return 2;
            case '/':
                return 2;
            case '*':
                return 2;
            case '-':
                return 1;
            case '+':
                return 1;
            default:
                return 0;
        }
    }
```
8. Buat method **konversi** untuk melakukan konversi notasi infix menjadi notasi postfix dengan cara mengecek satu persatu elemen data pada **String Q** sebagai parameter masukan.
```java
    public String konversi(String Q) {
        String P = "";
        char c;
        for (int i = 0; i < n; i++) {
            c = Q.charAt(i);
            if (IsOperand(c)) {
                P = P + c;
            } 
            if (c == '(') {
                push(c);
            }
            if (c == ')') {
                while (stack[top] != '(') {
                    P = P + pop();
                }
                pop();
            }
            if (IsOperator(c)) {
                while (derajat(stack[top]) >= derajat(c)) {
                    P = P + pop();
                }
                push(c);    
            }
        }
        return P;
    }
```
9. Selanjutnya, buat class baru dengan nama **PostfixMain<NoAbsen>.java**. Buat method main, 
kemudian buat variabel **P** dan **Q**. Variabel P digunakan untuk menyimpan hasil akhir notasi postfix 
setelah dikonversi, sedangkan variabel Q digunakan untuk menyimpan masukan dari pengguna 
berupa ekspresi matematika dengan notasi infix. Deklarasikan variabel Scanner dengan nama sc, 
kemudian panggil fungsi built-in **trim** yang digunakan untuk menghapus adanya spasi di depan 
atau di belakang teks dari teks persamaan yang dimasukkan oleh pengguna.
```java
        Scanner sc = new Scanner(System.in);
        String P, Q;
        System.out.println("Masukkan ekspresi matematika (infix): ");
        Q = sc.nextLine();
        Q = Q.trim();
        Q = Q + ")";
```
Penambahan string **“)”** digunakan untuk memastikan semua simbol/karakter yang masih berada di stack setelah semua persamaan terbaca, akan dikeluarkan dan dipindahkan ke postfix.
10. Buat variabel total untuk menghitung banyaknya karakter pada variabel Q.
```java
        int total = Q.length();
```
11. Lakukan instansiasi objek dengan nama **post** dan nilai parameternya adalah total. Kemudian panggil method **konversi** untuk melakukan konversi notasi infix Q menjadi notasi postfix P.
```java
        Postfix09 post = new Postfix09(total);
        P = post.konversi(Q);
        System.out.println("Postfix: " + P);
```
12. Compile dan run program.
13. **Commit dan push kode program ke Github**

Kode program class Postfix09:
```java
public class Postfix09 {
    int n, top;
    char[] stack;

    public Postfix09(int total) {
        n = total;
        top = -1;
        stack = new char[n];
        push('(');
    }

    public void push(char c) {
        top++;
        stack[top] = c;
    }

    public char pop() {
        char item = stack[top];
        top--;
        return item;
    }

    public boolean IsOperand(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == ' ' || c == '.') {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsOperator(char c) {
        if (c == '^' || c == '%' || c == '/' || c == '*' || c == '-' || c == '+') {
            return true;
        } else {
            return false;
        }
    }

    public int derajat(char c) {
        switch (c) {
            case '^':
                return 3;
            case '%':
                return 2;
            case '/':
                return 2;
            case '*':
                return 2;
            case '-':
                return 1;
            case '+':
                return 1;
            default:
                return 0;
        }
    }

    public String konversi(String Q) {
        String P = "";
        char c;
        for (int i = 0; i < n; i++) {
            c = Q.charAt(i);
            if (IsOperand(c)) {
                P = P + c;
            } 
            if (c == '(') {
                push(c);
            }
            if (c == ')') {
                while (stack[top] != '(') {
                    P = P + pop();
                } 
                pop();
            } 
            if (IsOperator(c)) {
                while (derajat(stack[top]) >= derajat(c)) {
                    P = P + pop();
                }
                push(c);    
            }
        }
        return P;
    }
}
```
Kode program class PostfixMain09:
```java
import java.util.Scanner;

public class PostfixMain09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String P, Q;
        System.out.println("Masukkan ekspresi matematika (infix): ");
        Q = sc.nextLine();
        Q = Q.trim();
        Q = Q + ")";

        int total = Q.length();

        Postfix09 post = new Postfix09(total);
        P = post.konversi(Q);
        System.out.println("Postfix: " + P);
    }
}
```

### 2.3.2 Verifikasi Hasil Percobaan
<img src="pictures/8.Perc-3-verif.png">

### 2.3.3 Pertanyaan
1. Pada method **derajat**, mengapa return value beberapa case bernilai sama? Apabila return value diubah dengan nilai berbeda-beda setiap case-nya, apa yang terjadi?<br>
Jawab: Karena return value menunjukkan derajat (prioritas) operator aritmatika sehingga ada beberapa case yang bernilai sama. Contohnya adalah operator `/` `*` dan `%` memiliki derajat yang sama sehingga return value nya sama (dalam konteks program ini adalah 3). Begitupun dengan operator `+` dan `-` yang juga memiliki derajat yang sama sehingga return value nya pun sama (dalam konteks program ini adalah 2). Apabila return value diubah dengan nilai berbeda-beda setiap case-nya, maka operator yang memiliki derajat sama akan dianggap berbeda derajatnya. Jadi, operator seperti `/` `*` dan `%` akan memiliki urutan prioritas yang berbeda. Hal ini akan menyebabkan kesalahan dalam mengkonversi notasi infix menjadi postfix .

2. Jelaskan alur kerja method **konversi**!<br>
Jawab: Berikut adalah alur kerja dari method **konversi**:
    1. Inisialisasi variabel `P` dengan string kosong untuk menyimpan hasil konversi.
    2. Membuat variabel `c` yang nantinya akan diisi dengan character dari parameter String `Q` dalam setiap iterasi perulangan for. Tentunya pada setiap iterasi, variabel `c` akan diupdate untuk menyimpan karakter `Q` selanjutnya.
    3. Dalam perulangan for, dilakukan pengecekan kondisi. 
        - Jika karakter Q saat ini yang disimpan pada variabel c merupakan operand, maka `c` akan langsung ditambahkan ke String `P`. 
        - Jika `c` adalah `(` (kurung buka), maka `c` akan dimasukkan (push) ke dalam stack.
        - Jika `c` adalah `)` (kurung tutup), maka stack akan dikosongkan (pop) dan menambahkan setiap operator yang diambil dari stack ke String `P` sampai menemukan tanda `(` (kurung buka).
        - Jika `c` adalah operator, maka dilakukan pengecekan untuk memastikan urutan prioritas (derajat) operator. Operator yang dibandingkan adalah operator yang ada dalam stack (yang menjadi top of stack) dengan `c`. Jika operator di dalam stack (top of stack) memiliki derajat yang lebih tinggi atau sama, maka operator tersebut diambil (pop) dari stack dan ditambahkan ke dalam String `P`.
    4. Method akan mengembalikan `P` sebagai return value. `P` merupakan hasil dari konversi notasi infix menjadi postfix.
3. Pada method konversi, apa fungsi dari potongan kode berikut? 
```java
    c = Q.charAt(i);
```
Jawab: Mengambil karakter dari String `Q` pada indeks ke `i` dalam iterasi perulangan for pada method konversi (i akan diupdate pada setiap iterasi) dan akan menyimpannya ke dalam variabel `c`. 

## 2.4 Latihan Praktikum
Perhatikan dan gunakan kembali kode program pada Percobaan 1. Tambahkan dua method berikut pada class Gudang:
- Method **lihatBarangTerbawah** digunakan untuk mengecek barang pada tumpukan terbawah
- Method **cariBarang** digunakan untuk mencari ada atau tidaknya barang berdasarkan kode barangnya atau nama barangnya
