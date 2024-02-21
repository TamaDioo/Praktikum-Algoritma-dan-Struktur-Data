# Laporan Praktikum Pertemuan 2

## Nama : Dio Andika Pradana Mulia Tama
## NIM : 2341720098
## Kelas : TI-1B

## Percobaan 1

### 2.1.1 Langkah-langkah Percobaan
```java
    public class Buku {
    String judul, pengarang;
    int halaman, stok, harga;

    void tampilInformasi() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa Stock: " + stok);
        System.out.println("Harga: Rp " + harga);
    }
    void terjual(int jml) {
        stok -= jml;
    }

    void restock(int jml) {
        stok += jml;
    }

    void gantiHarga(int hrg) {
        harga = hrg;
    }
}
```


### 2.1.2 Verifikasi Hasil Percobaan
<img src="Screenshot Code/error perc1.png">

### 2.1.3 Pertanyaan
1. Sebutkan dua karakteristik class atau object!<br>
    <p>Atribut (State)
Atribut merepresentasikan data atau informasi yang dimiliki oleh class atau object. Jika diibaratkan sebuah motor, atributnya bisa berupa merk, warna, tahun produksi, dan spesifikasi mesin. Atribut dapat berupa nilai statis (seperti merk) atau nilai dinamis (seperti kecepatan saat motor bergerak).</p>
    <p>Behavior (Tingkah Laku)
Behavior merepresentasikan tindakan atau fungsi yang dapat dilakukan oleh class atau object. Ibarat motor, behaviornya bisa berupa jalan, berhenti, belok, dan klakson. Behavior didefinisikan sebagai method atau fungsi yang dapat dipanggil untuk memanipulasi atribut atau menghasilkan suatu output.</p>
    <p> Class adalah rancangan atau desain dari sebuah object, sedangkan object adalah hasil nyata dari suatu class. Jika objek diibaratkan sebagai rumah, maka class akan memberikan gambaran tentang rancangan atau desain untuk membangun rumah tersebut.</p>

2. Perhatikan class Buku pada Praktikum 1 tersebut, ada berapa atribut yang dimiliki oleh class
Buku? Sebutkan apa saja atributnya!
<p>Ada lima atribut pada class Buku, yang terdiri dari judul, pengarang, halaman, stok, dan harga.</p>

3. Ada berapa method yang dimiliki oleh class tersebut? Sebutkan apa saja methodnya!
<p>Ada empat method yang dimiliki class tersebut, yang terdiri dari method tampilInformasi(), terjual(jml: int), restock(n: int), dan gantiHarga()hrg: int</p>

4. Perhatikan method terjual() yang terdapat di dalam class Buku. Modifikasi isi method tersebut
sehingga proses pengurangan hanya dapat dilakukan jika stok masih ada (lebih besar dari 0)!
```java 
    void terjual(int jml) {
        if (stok > 0) {
            stok -= jml;
        }
    }
```
5. Menurut Anda, mengapa method restock() mempunyai satu parameter berupa bilangan int?
<p>Karena method restock() digunakan untuk menambah stok buku sehingga membutuhkan parameter berupa bilangan bulat yang menunjukkan berapa buku yang ditambah ke dalam stok.</p>
6. Commit dan push kode program ke Github
<img src="Screenshot Code/ModifPerc1.png">


## Percobaan 2

### 2.2 Percobaan 2: Instansiasi Object, serta Mengakses Atribut dan Method
```java
public class BukuMain09 {
    public static void main(String[] args) {
        Buku09 bk1 = new Buku09();
        bk1.judul = "Today Ends Tomorrow Comes";
        bk1.pengarang = "Denanda pratiwi";
        bk1.halaman = 198;
        bk1.stok = 13;
        bk1.harga = 71000;

        bk1.tampilInformasi();
        bk1.terjual(5);
        bk1.gantiHarga(60000);
        bk1.tampilInformasi();
    }
}
```
### 2.2.1 Langkah-langkah Percobaan

### 2.2.2 Verifikasi Hasil Percobaan

### 2.2.3 Pertanyaan