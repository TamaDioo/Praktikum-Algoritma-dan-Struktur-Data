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
<p>Ada lima atribut pada class Buku, yang terdiri dari: judul, pengarang, halaman, stok, dan harga.</p>

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

### 2.2.1 Langkah-langkah Percobaan
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
<p>Screenshot push dan commit</p>
<img src="Screenshot Code/Perc2src.png">

### 2.2.2 Verifikasi Hasil Percobaan
<img src="Screenshot Code/perc2output.png">  

### 2.2.3 Pertanyaan
1. Pada class BukuMain, tunjukkan baris kode program yang digunakan untuk proses instansiasi!
Apa nama object yang dihasilkan?
```java 
    Buku09 bk1 = new Buku09();
```
<p>Kode program di atas, digunakan untuk proses instansiasi dan <strong>bk1</strong> adalah nama objek yang dihasilkan.</p>

2. Bagaimana cara mengakses atribut dan method dari suatu objek?
<p>Untuk mengakses atribut dan method dari suatu objek dapat menggunakan tanda titik atau notasi dot. Untuk mengakses atribut dari suatu objek, nama objek diketik terlebih dahulu lalu diikuti oleh operator titik (".") dan kemudian diikuti dengan nama atribut yang ingin diakses. Contoh:</p>

```java
        bk1.judul = "Today Ends Tomorrow Comes";
        bk1.pengarang = "Denanda pratiwi";
        bk1.halaman = 198;
        bk1.stok = 13;
        bk1.harga = 71000;
```

<p>Untuk mengakses method dari suatu objek, nama objek diketik terlebih dahulu diikuti oleh operator titik (".") dan kemudian diikuti dengan nama metode yang ingin diakses, lalu tanda kurung (). Jika method memiliki parameter, maka nilai parameter harus dimasukkan dalam tanda kurung. Contoh:</p>

```java
bk1.tampilInformasi();
bk1.terjual(5);
bk1.gantiHarga(60000);
bk1.tampilInformasi();
```

3. Mengapa hasil output pemanggilan method tampilInformasi() pertama dan kedua berbeda?
<p>Karena objek bk1 telah diproses oleh method terjual() dan gantiHarga() sehingga atribut dari objek bk1 mengalami perubahan. Hal ini terjadi Karena posisi method method terjual() dan gantiHarga() berada diantara method tampilInformasi() pertama dan kedua. Mengapa demikian, karena kode pada Java dieksekusi dari atas ke bawah dan dari kiri ke kanan.</p>

```java
    bk1.tampilInformasi();
    bk1.terjual(5);
    bk1.gantiHarga(60000);
    bk1.tampilInformasi();
```

## Percobaan 3

### 2.3.1 Langkah-langkah Percobaan
<p>Class Buku<p>

```java
public class Buku09{
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
        if (stok > 0) {
            stok -= jml;
        } 
    }

    void restock(int jml) {
        stok += jml;
    }

    void gantiHarga(int hrg) {
        harga = hrg;
    }

    public Buku09() {

    }

    public Buku09(String jud, String pg, int hal, int stok, int har) {
        judul = jud;
        pengarang = pg;
        halaman = hal;
        this.stok = stok;
        harga = har;
    }
}
```
<p>Class Buku Main<p>

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

        Buku09 bk2 = new Buku09("Self Reward", "Maheera Ayesha", 160, 29, 59000);
        bk2.terjual(11);
        bk2.tampilInformasi();
    }
}
```

<p>Screenshot push dan commit</p>
<img src="Screenshot Code/perc3push.png">

### 2.3.2 Verifikasi Hasil Percobaan
<img src="Screenshot Code/perc3output.png">

### 2.3.3 Pertanyaan
1. Pada class Buku di Percobaan 3, tunjukkan baris kode program yang digunakan untuk
mendeklarasikan konstruktor berparameter!
```java
public Buku09(String jud, String pg, int hal, int stok, int har) {
        judul = jud;
        pengarang = pg;
        halaman = hal;
        this.stok = stok;
        harga = har;
    }
```
<p>Kode program di atas merupakan kode yang digunakan untuk mendeklarasikan konstruktor berparameter. Di dalam tanda kurung diberikan parameter dengan didahului tipe datanya.<p>

2. Perhatikan class BukuMain. Apa sebenarnya yang dilakukan pada baris program berikut?
```java
Buku09 bk2 = new Buku09("Self Reward", "Maheera Ayesha", 160, 29, 59000);
```
<p>Kode program di atas merupakan proses instansiasi yang menghasilkan objek <strong>bk2<strong> dengan mengisikan parameter dalam tanda kurung. Konstruktor yang digunakan adalah konstruktor berparameter sehingga perlu menambahkan nilai parameter saat menginstansiasi objek. Parameter yang dimasukkan harus urut sesuai dengan deklarasi konstruktor pada class Buku.<p>

3. Hapus konstruktor default pada class Buku, kemudian compile dan run program. Bagaimana
hasilnya? Jelaskan mengapa hasilnya demikian!
<img src="Screenshot Code/perc3no3.png">
<p>Program akan error, hal ini terjadi karena konstruktor defaultnya dihapus sehingga objek bk1 tidak dapat diinstansiasi pada class BukuMain. jika ingin kodenya berjalan maka harus menambah kembali konstruktor default atau sekalian menghapus semua konstruktor (konstruktor berparameter juga harus dihapus) dan tidak mengisikan nilai parameter dalam tanda kurung saat menginstansiasi objek.<p>

4. Setelah melakukan instansiasi object, apakah method di dalam class Buku harus diakses
secara berurutan? Jelaskan alasannya!
<p>Tidak, karena method bersifat fleksibel. Artinya method dapat dipanggil kapan saja dan tidak harus berurutan.<p>

5. Buat object baru dengan nama buku(Namamahasiswa) menggunakan konstruktor
berparameter dari class Buku!
```java
Buku09 bukuDio = new Buku09("Sukses Dunia Akhirat", "Dio Andika", 399, 42, 56000);
bukuDio.terjual(19);
bukuDio.restock(10);
bukuDio.tampilInformasi();
```

6. Commit dan push kode program ke Github

### Latihan Praktikum


