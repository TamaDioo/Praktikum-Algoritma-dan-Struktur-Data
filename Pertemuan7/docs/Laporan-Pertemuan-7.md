# <p align ="center">Laporan Praktikum Pertemuan 7 Algoritma dan Struktur Data</p>
<br><br><br><br>

<p align="center">
   <img src="https://static.wikia.nocookie.net/logopedia/images/8/8a/Politeknik_Negeri_Malang.png/revision/latest?cb=20190922202558" width="30%"> </p>

<br><br><br><br><br>

<p align = "center"> Nama     : Dio Andika Pradana Mulia Tama </p>
<p align = "center"> NIM      : 2341720098 </p>
<p align = "center"> Prodi    : TEKNIK INFOMATIKA</p>
<p align = "center"> Kelas    : 1B </p>
<p align = "center"> Presensi : 09 </p>

# Jobsheet 6
# Searching

## 6.2. Searching / Pencarian Menggunakan Agoritma Sequential Search

### 6.2.1. Langkah-langkah Percobaan Sequential Search
1. Buatlah Project baru pada dengan nama TestSearching
2. Kemuadian buat packages baru dengan nama P7
3. Buat class BukuNoAbsen, kemudian deklarasikan atribut berikut ini:
```java
public class Buku09 {
    int kodeBuku, tahunTerbit, stock;
    String judulBuku, pengarang;
```
4. Buatlah konstruktor dengan nama Buku dengan parameter (String kodeBuku, String judulBuku, int tahunTerbit, String pengarang, int stock) kemudian Isi konstruktor tersebut dengan kode berikut!
```java
    public Buku09(int kodeBuku, String judulBuku, int tahunTerbit, String pengarang, int stock) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.tahunTerbit = tahunTerbit;
        this.pengarang = pengarang;
        this.stock = stock;
    }
```
Catatan : Perhatikan konstruktor diatas! Apakah sudah benar? Jika belum, maka perbaiki
konstruktor diatas (konstruktor di atas sudah diperbaiki)
5. Buatlah method tampilDataBuku bertipe void.
```java
    public void tampilDataBuku() {
        System.out.println("===============================");
        System.out.println("Kode buku : " + kodeBuku);
        System.out.println("Judul buku : " + judulBuku);
        System.out.println("Tahun Terbit : " + tahunTerbit);
        System.out.println("Pengarang : " + pengarang);
        System.out.println("Stock : " + stock);
    }
```
6. Buat class baru dengan nama PencarianBukuNoAbsen seperti di bawah ini!
```java
public class PencarianBuku09 {
    Buku09 listBk[] = new Buku09[5];
    int idx;
}
```
7. Tambahkan method tambah() di dalam class tersebut! Method tambah() digunakan untuk menambahkan objek dari class Buku ke dalam atribut listBk.
```java
    void tambah(Buku09 m) {
        if (idx < listBk.length) {
            listBk[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }
```
8. Tambahkan method tampil() di dalam class PencarianBukuNoAbsen Method tampil() digunakan untuk menampilkan semua data buku yang ada di dalam class tersebut! Perhatikan penggunaan sintaks for yang menggunakan konsep for-each. Syntax tersebut akan memberikan tanda error berupa garis merah, Perbaiki agar tidak ada error!
```java
    void tampil() {
        for (Buku09 m : listBk) {
            m.tampilDataBuku();
        }
    }
```
Tidak perlu menuliskan "[]" pada array of objek listBk, karena dalam sintaks foreach yang perlu ditulis hanya nama array saja tidak diikuti "[]".
9. Tambahkan method FindSeqSearch bertipe integer dengan parameter cari bertipe int. Kemudian Deklarasikan isi method FindSeqSearch dengan algoritma pencarian data menggunakan teknik sequential searching.
```java
    public int FindSeqSearch(int cari) {
        int posisi = 2;
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].kodeBuku == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }
```
Terdapat kesalahan pada operasi assignment dalam blok kode if pada perulangan for. penulisan operasi assignment yang benar adalah posisi = j bukan j = posisi. Jika j = posisi, maka indeks yang nilainya sama dengan parameter cari akan diganti dengan 2. Penulisan yang benar adalah posisi = j, karena jika indeks yang nilainya sama dengan parameter cari ketemu maka variabel posisi akan diganti dengan indeks tersebut sehinggan nilai posisi yang direturn valid.

10. Buatlah method Tampilpoisisi bertipe void dan Deklarasikan isi dari method Tampilpoisisi.
```java
    public void Tampilposisi(int x, int pos) {
        if (pos != -1) {
            System.out.println("data : " + x + "ditemukan pada indeks " + pos);
        } else {
            System.out.println("data : " + x + "tidak ditemukan");
        }
    }
```

11. Buatlah class baru dengan nama BukuMainNoAbsen tambahkan method main. buatlah sebuah objek PencarianMhs dan buatlah 5 objek buku kemudian tambahkan semua objek buku tersebut dengan memanggil fungsi tambah pada objek PencarianBuku.
```java
package Pertemuan7.TestSearching.src.P7;
import java.util.Scanner;

public class BukuMain09 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        Scanner s1 = new Scanner(System.in);
        
        PencarianBuku09 data = new PencarianBuku09();
        int jumBuku = 5;

        System.out.println("------------------------------------------------");
        System.out.println("Masukkan data Buku secara Urut dari KodeBuku Terkecil : ");
        for (int i = 0; i < jumBuku; i++) {
            System.out.println("------------------");
            System.out.print("Kode Buku \t: ");
            int kodeBuku = s.nextInt();
            System.out.print("Judul Buku \t: ");
            String judulBuku = s1.nextLine();
            System.out.print("Tahun Terbit \t: ");
            int tahunTerbit = s.nextInt();
            System.out.print("Pengarang \t: ");
            String pengarang = s1.nextLine();
            System.out.print("Stock \t\t: ");
            int stock = s.nextInt();

            Buku09 m = new Buku09(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
            data.tambah(m);
        }
        System.out.println("-------------------------------------------");
        System.out.println("Data keseluruhan Mahasiswa : ");
}

```
Note : perbaiki kode jika terdapat kesalahan. (kode di atas sudah diperbaiki)
Ada sedikit kesalahan pada pemanggilan konsruktor Buku, parameter yang dimasukkan tidak urut yaitu parameter stock mendahului pengarang. Parameter dalam konstruktor harus ditulis secara urut.<br>
Sebelum:
```java
Buku09 m = new Buku09(kodeBuku, judulBuku, tahunTerbit, stock, pengarang);
```
Sesudah:
```java
Buku09 m = new Buku09(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
```

12. Panggil method tampil() untuk melihat semua data yang telah dimasukan.
```java
        System.out.println("-------------------------------------------");
        System.out.println("Data keseluruhan Mahasiswa : ");
        data.tampil();
```

13. Untuk melakukan pencarian berdasarkan kode buku. Buatlah variable cari yang dapat menampung masukan dari keyboard lalu panggil method FindSeqSearch dengan isi parameternya adalah variable cari. Untuk menampilkan index data yang dicari panggil method TampilPosisi
```java
        System.out.println("___________________________________________");
        System.out.println("___________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan Kode Buku yang dicari : ");
        System.out.print("Kode Buku : ");
        int cari = s.nextInt();
        System.out.println("Menggunakan sequential Search");
        int posisi = data.FindSeqSearch(cari);
        data.Tampilposisi(cari, posisi);
```
Verifikasi hasil pencarian :<br>
```bash
------------------------------------------------
Masukkan data Buku secara Urut dari KodeBuku Terkecil :
------------------
Kode Buku       : 111
Judul Buku      : Algoritma
Tahun Terbit    : 2019
Pengarang       : Wahyuni
Stock           : 5
------------------
Kode Buku       : 123
Judul Buku      : Big Data
Tahun Terbit    : 2020
Pengarang       : Susilo
Stock           : 3
------------------
Kode Buku       : 125
Judul Buku      : Desain UI 
Tahun Terbit    : 2021
Pengarang       : Supriadi
Stock           : 3
------------------
Kode Buku       : 126
Judul Buku      : Web Programming
Tahun Terbit    : 2022
Pengarang       : Pustaka Adi
Stock           : 2
------------------
Kode Buku       : 127
Judul Buku      : Etika Mahasiswa
Tahun Terbit    : 2023
Pengarang       : Darmawan Adi
Stock           : 2
-------------------------------------------
Data keseluruhan Mahasiswa :
===============================
Kode buku : 111
Judul buku : Algoritma
Tahun Terbit : 2019
Pengarang : Wahyuni
Stock : 5
===============================
Kode buku : 123
Judul buku : Big Data
Tahun Terbit : 2020
Pengarang : Susilo
Stock : 3
===============================
Kode buku : 125
Judul buku : Desain UI
Tahun Terbit : 2021
Pengarang : Supriadi
Stock : 3
===============================
Kode buku : 126
Judul buku : Web Programming
Tahun Terbit : 2022
Pengarang : Pustaka Adi
Stock : 2
===============================
Kode buku : 127
Judul buku : Etika Mahasiswa
Tahun Terbit : 2023
Pengarang : Darmawan Adi
Stock : 2
___________________________________________
___________________________________________
Pencarian Data :
Masukkan Kode Buku yang dicari :
Kode Buku : 111
Menggunakan sequential Search
data : 111 ditemukan pada indeks 0
PS D:\Kuliah\Semester 2\Tugas Kuliah Semester 2\Algoritma dan Struktur Data\Praktikum-Algoritma dan Struktur Data>
```
Apakah pencarian pada program anda sudah sesuai? Jika belum perbaiki kode sehingga pencarian
sesuai. <br>
Pencarian pada program sudah sesuai.

14. Buatlah method TampilData bertipe void pada class PencarianBukuNoAbsen dan tambahkan isi dari method TampilData.
```java
    public void TampilData(int x, int pos) {
        if (pos != -1) {
            System.out.println("Kode Buku\t : " + x);
            System.out.println("Judul\t\t : " + listBk[pos].judulBuku);
            System.out.println("Tahun Terbit\t : " + listBk[pos].tahunTerbit);
            System.out.println("Pengarang\t : " + listBk[pos].pengarang);
            System.out.println("Stock\t\t : " + listBk[pos].stock);
        } else {
            System.out.println("data " + x + "tidak ditemukan");
        }
    }
```
15. Di dalam method main(), Lakukan pemanggilan method TampilData dari class PencarianMhs.
```java
data.TampilData(cari, posisi);
```
16. Jalankan dan amati hasilnya.

### 6.2.2. Verifikasi Hasil Percobaan
Jika data ditemukan:
```bash
___________________________________________
Pencarian Data :
Masukkan Kode Buku yang dicari :
Kode Buku : 111
Menggunakan sequential Search
data : 111 ditemukan pada indeks 0
Kode Buku        : 111
Judul            : Algoritma
Tahun Terbit     : 2019
Pengarang        : Wahyuni
Stock            : 5
```
Jika data tidak ditemukan :
Ternyata masih ada kesalahan pada kode program method FindSeqSearch yaitu nilai posisi (indeks) yang tidak diubah jika tidak ditemukan kodeBuku yang sama dengan kodeBuku yang dicari. Jadi ketika tidak ada nilai kodeBuku yang sesuai, maka variabel posisi akan tetap terisi 2. Hal ini akan menyebabkan ketidak validan program. Oleh karena itu, perlu ditambahkan blok kode else dalam perulangan for agar ketika kode buku tidak ditemukan indeksnya juga tidak ditemukan. Dalam hal ini, ketika kode buku tidak ditemukan maka posisi akan diubah menjadi -1 (karena indeks array tidak ada nilai minus).
Perbaikan kode program:
```java
    public int FindSeqSearch(int cari) {
        int posisi = 2;
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].kodeBuku == cari) {
                posisi = j;
                break;
            } else { //Penambahan else untuk menangani kondisi kodeBuku yang di cari tidak ditemukan
                posisi = -1; //Merubah posisi menjadi -1
            }
        }
        return posisi;
    }
```
Output jika data tidak ditemukan:
```bash
___________________________________________
Pencarian Data :
Masukkan Kode Buku yang dicari :
Kode Buku : 124
Menggunakan sequential Search
data : 124 tidak ditemukan
data 124 tidak ditemukan
PS D:\Kuliah\Semester 2\Tugas Kuliah Semester 2\Algoritma dan Struktur Data\Praktikum-Algoritma dan Struktur Data> 
```

### 6.2.3. Pertanyaan
1. Jelaskan fungsi break yang ada pada method FindSeqSearch!
2. Jika Data Kode Buku yang dimasukkan tidak terurut dari kecil ke besar. Apakah program masih dapat berjalan? Apakah hasil yang dikeluarkan benar? Tunjukkan hasil screenshoot untuk bukti dengan kode Buku yang acak. Jelaskan Mengapa hal tersebut bisa terjadi?
3. Buat method baru dengan nama FindBuku menggunakan konsep sequential search dengan tipe method dari FindBuku adalah BukuNoAbsen. Sehingga Anda bisa memanggil method tersebut pada class BukuMain seperti gambar berikut :
```java
Buku dataBuku = data.FindBuku(cari);
dataBuku.tampilDataBuku();
```

## 6.3. Searching / Pencarian Menggunakan Binary Search

### 6.3.1. Langkah-langkah Percobaan Binary Search
1. Pada percobaan 6.2.1 (sequential search) tambahkan method FindBinarySearch bertipe integer pada class PencarianBukuNoAbsen. Kemudian Deklarasikan isi method FindBinarySearch dengan algoritma pencarian data menggunakan teknik binary searching.
```java

```
2. Panggil method FindBinarySearch di kelas BukuMainNoAbsen. Kemudia panggil method tampilposisi dan tampilData
```java

```
3. Jalankan dan amati hasilnya.

### 6.3.2. Verifikasi Hasil Percobaan

### 6.3.3. Pertanyaan
1. Tunjukkan pada kode program yang mana proses divide dijalankan!
2. Tunjukkan pada kode program yang mana proses conquer dijalankan!
4. Jika data Kode Buku yang dimasukkan tidak urut. Apakah program masih dapat berjalan? Mengapa demikian! Tunjukkan hasil screenshoot untuk bukti dengan kode Buku yang acak. Jelaskan Mengapa hal tersebut bisa terjadi?
3. Jika Kode Buku yang dimasukkan dari Kode Buku terbesar ke terkecil (missal : 20215, 20214, 20212, 20211, 20210) dan elemen yang dicari adalah 20210. Bagaimana hasil dari binary search? Apakah sesuai? Jika tidak sesuai maka ubahlah kode program binary seach agar hasilnya sesuai!

## 6.4. Percobaan Pengayaan Divide and Conquer

### 6.4.1. Langkah-langkah Percobaan Merge Sort
1. Buatlah Package baru didalam package P5 dengan nama MergeSortTest
2. Tambahkan class MergeSortingNoAbsen pada package tersebut
3. Pada class MergeSortingNoAbsen buatlah method mergeSort yang menerima parameter data array yang akan diurutkan
```java

```
4. Buatlah method merge untuk melakukan proses penggabungan data dari bagian kiri dan kanan.
```java

```
5. Implementasikan proses merge sebagai berikut.
```java

```
6. Buatlah method sort
```java

```
7. Implementasikan kode berikut pada method sort
```java

```
8. Pada method mergeSort, panggil method sort dengan parameter data yang ingin diurutkan serta range data awal sampai dengan akhir.
9. Tambahkan method printArray
```java

```
10. Sebagai langkah terakhir, deklarasikan data yang akan diurutkan kemudian panggil proses sorting pada class MergeSortMainNoAbsen. Tambahkan fungsi main pada kelas tersebut, kemudian tuliskan kode berikut didalam fungsi main.
```java

```

### 6.4.2. Verifikasi Hasil Percobaan

## 6.5. Latihan Praktikum
1. Modifikasi percobaan searching diatas dengan ketentuan berikut ini
- Ubah tipe data dari kode Buku yang awalnya int menjadi String
- Tambahkan method untuk pencarian kode Buku (bertipe data String) dengan menggunakan sequential search dan binary search.
2. Modifikasi percobaan searching diatas dengan ketentuan berikut ini
- Tambahkan method pencarian judul buku menggunakan sequential search dan binary search. Sebelum dilakukan searching dengan binary search data harus dilakukan pengurutan dengan menggunakan algoritma Sorting (bebas pilih algoritma sorting apapun)! Sehingga ketika input data acak, maka algoritma searching akan tetap berjalan
- Buat aturan untuk mendeteksi hasil pencarian judul buku yang lebih dari 1 hasil dalam bentuk kalimat peringatan! Pastikan algoritma yang diterapkan sesuai dengan kasus yang diberikan!