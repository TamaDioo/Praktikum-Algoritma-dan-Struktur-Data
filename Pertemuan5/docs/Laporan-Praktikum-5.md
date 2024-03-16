# <p align ="center">Laporan Praktikum Pertemuan 3 Algoritma dan Struktur Data</p>
<br><br><br><br>

<p align="center">
   <img src="https://static.wikia.nocookie.net/logopedia/images/8/8a/Politeknik_Negeri_Malang.png/revision/latest?cb=20190922202558" width="30%"> </p>

<br><br><br><br><br>

<p align = "center"> Nama     : Dio Andika Pradana Mulia Tama </p>
<p align = "center"> NIM      : 2341720098 </p>
<p align = "center"> Prodi    : TEKNIK INFOMATIKA</p>
<p align = "center"> Kelas    : 1B </p>
<p align = "center"> Presensi : 09 </p>

# Jobsheet 4

## 4.2 Menghitung Nilai Faktorial dengan Algoritma Brute Force dan Divide and Conquer
Perhatikan Diagram Class berikut ini :<br>
<img src="pictures/4.2 ss 1.png"><br>
Berdasarkan diagram class di atas, akan dibuat program class dalam Java. Untuk menghitung nilai
faktorial suatu angka menggunakan 2 jenis algoritma, Brute Force dan Divide and Conquer. Jika
digambarkan terdapat perbedaan proses perhitungan 2 jenis algoritma tersebut sebagai berikut : <br>
Tahapan pencarian nilai faktorial dengan algoritma Brute Force :<br>
<img src="pictures/4.2 ss 2.png"><br>
Tahapan pencarian nilai faktorial dengan algoritma Divide and Conquer :<br>
<img src="pictures/4.2 ss 3.png">

### 4.2.1 Langkah-langkah Percobaan
1. Buat Project baru, dengan nama “BruteForceDivideConquer”. Buat package dengan nama
minggu5.
2. Buatlah class baru dengan nama Faktorial
3. Lengkapi class Faktorial dengan atribut dan method yang telah digambarkan di dalam diagram class di atas, sebagai berikut:<br>
    a) Tambahkan atribut nilai
    ```java
    public int nilai;
    ```
    b) Tambahkan method faktorialBF() nilai
    ```java
    int faktorialBF(int n) {
        int fakto = 1;
        for (int i = 1; i <= n; i++) {
            fakto = fakto * i;
        }
        return fakto;
    }
    ```
    c) Tambahkan method faktorialDC() nilai
    ```java
    int faktorialDC(int n) {
        if (n == 1) {
            return 1;
        } else {
            int fakto = n * faktorialDC(n - 1);
            return fakto;
        }
    }
    ```
4. Coba jalankan (Run) class Faktorial dengan membuat class baru MainFaktorial.<br>
    a) Di dalam fungsi main sediakan komunikasi dengan user untuk menginputkan jumlah angka yang akan dicari nilai faktorialnya
    ```java
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Masukkan jumlah elemen: ");
        int iJml = sc.nextInt();
    ```
    b) Buat Array of Objek pada fungsi main, kemudian inputkan beberapa nilai yang akan dihitung faktorialnya
    ```java
        Faktorial[] fk = new Faktorial[10];
        for (int i = 0; i < iJml; i++) {
            fk[i] = new Faktorial();
            System.out.println("Masukkan nilai data ke-" + (i+1) + ":");
            int iNilai = sc.nextInt();
        }
    ```
    c) Tampilkan hasil pemanggilan method faktorialDC() dan faktorialBF()
    ```java
        System.out.println("HASIL - BRUTE FORCE");
        for (int i = 0; i < iJml; i++) {
            System.out.println("Hasil perhitungan faktorial menggunakan Brute Force adalah " + fk[i].faktorialBF(fk[i].nilai));
        }
        System.out.println("HASIL - DIVIDE AND CONQUER");
        for (int i = 0; i < iJml; i++) {
            System.out.println("Hasil perhitungan faktorial menggunakan Brute Force adalah " + fk[i].faktorialDC(fk[i].nilai));
        }
    ```
    d) Pastikan program sudah berjalan dengan baik!<br>
    Sempat terjadi error pada class main karena atribut nilai pada objek fk belum diakses untuk diberikan nilai inputan dalam perulangan. <br>
    Sebelum:<br>
    ```java
    int iNilai = sc.nextInt();
    ```
    Sesudah:<br>
    ```java
    fk[i].nilai = sc.nextInt();
    ```
    
Kode program class Faktorial :
```java
package Pertemuan5.BruteForceDivideConquer.minggu5;

public class Faktorial {
    public int nilai;

    int faktorialBF(int n) {
        int fakto = 1;
        for (int i = 1; i <= n; i++) {
            fakto = fakto * i;
        }
        return fakto;
    }

    int faktorialDC(int n) {
        if (n == 1) {
            return 1;
        } else {
            int fakto = n * faktorialDC(n - 1);
            return fakto;
        }
    }
}
```
Kode program class MainFaktorial :
```java
package Pertemuan5.BruteForceDivideConquer.minggu5;
import java.util.Scanner;

public class MainFaktorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Masukkan jumlah elemen: ");
        int iJml = sc.nextInt();

        Faktorial[] fk = new Faktorial[10];
        for (int i = 0; i < iJml; i++) {
            fk[i] = new Faktorial();
            System.out.println("Masukkan nilai data ke-" + (i+1) + ":");
            fk[i].nilai = sc.nextInt();
        }

        System.out.println("HASIL - BRUTE FORCE");
        for (int i = 0; i < iJml; i++) {
            System.out.println("Hasil perhitungan faktorial menggunakan Brute Force adalah " + fk[i].faktorialBF(fk[i].nilai));
        }
        System.out.println("HASIL - DIVIDE AND CONQUER");
        for (int i = 0; i < iJml; i++) {
            System.out.println("Hasil perhitungan faktorial menggunakan Brute Force adalah " + fk[i].faktorialDC(fk[i].nilai));
        }
    }
}
```

### 4.2.2 Verifikasi Hasil Percobaan
<img src="pictures/4.2.2 verif perc.png">

### 4.2.3 Pertanyaan
1. Pada base line Algoritma Divide Conquer untuk melakukan pencarian nilai faktorial, jelaskan perbedaan bagian kode pada penggunaan if dan else!<br>
Jawab: Pada base line Algoritma Divide Conquer untuk melakukan pencarian nilai faktorial menggunakan fungsi rekursif untuk menghitung nilai faktorial dari suatu bilangan. Kondisi if merupakan base case dari fungsi rekursif (n = 1), sedangkan kondisi else merupakan recursion call yang digunakan untuk memecah masalah menjadi submasalah yang lebih kecil (n - 1) sampai mendekati kondisi base case.
Jika n memenuhi kondisi if (n = 1), maka maka fungsi akan mengembalikan nilai 1. Jika nilai n tidak sama dengan 1, maka bagian kode else akan dieksekusi. Pada bagian kode else, dilakukan perhitungan faktorial dengan memanggil kembali fungsi faktorialDC dengan parameter n - 1. Hasil perhitungan tersebut dikalikan dengan nilai n, kemudian hasilnya dikembalikan sebagai faktorial dari n.

2. Apakah memungkinkan perulangan pada method faktorialBF() dirubah selain menggunakan for?Buktikan!<br>
Jawab: Ya, perulangan pada method faktorialBF() dapat menggunakan perulangan selain for seperi while atau do while.<br>
Menggunakan perulangan while:<br>
```java
    int faktorialBF(int n) {
        int fakto = 1, i = 1;
        while (i <= n) {
            fakto *= i;
            i++;
        }
        return fakto;
    }
```
Menggunakan perulangan do while:<br>
```java
    int faktorialBF(int n) {
        int fakto = 1, i = 1;
        do {
            fakto *= i;
            i++;
        } while (i <= n);
        return fakto;
    }
```
Outputnya akan tetap sama seperti pada perulangan for:<br>
<img src="pictures/4.2 pert 2.png">

3. Jelaskan perbedaan antara fakto *= i; dan int fakto = n * faktorialDC(n-1); !<br>
Jawab: Perbedaannya adalah pada cara penghitungan faktorial. Method faktorialBF menggunakan perulangan untuk mengitung faktorial. Statement fakto *= i; melakukan operasi perkalian antara variabel fakto dan i, lalu menyimpan hasilnya pada variabel fakto. Statement fakto *= i; akan dieksekusi secara berulang sampai kondisi i <= n terpenuhi<br>
Sedangkan pada method faktorialDC() menggunakan pendekatan rekursif Divide and Conquer untuk menghitung faktorial. Statetement int fakto = n * faktorialDC(n-1); pada blok else akan mengalikan n dengan method faktorialDC(n-1). Proses ini terjadi secara rekursif hingga mencapai base case yaitu saat n sama dengan 1.

## 4.3 Menghitung Hasil Pangkat dengan Algoritma Brute Force dan Divide and Conquer
Pada praktikum ini kita akan membuat program class dalam Java. Untuk menghitung nilai pangkat suatu angka menggunakan 2 jenis algoritma, Brute Force dan Divide and Conquer.

### 4.3.1 Langkah-langkah Percobaan
1. Di dalam paket minggu5, buatlah class baru dengan nama Pangkat. Dan di dalam class Pangkat tersebut, buat atribut angka yang akan dipangkatkan sekaligus dengan angka pemangkatnya
```java
public int nilai, pangkat;
```
2. Pada class Pangkat tersebut, tambahkan method PangkatBF()
```java
    int pangkatBF(int a, int n) {
        int hasil = 0;
        for (int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }
```
3. Pada class Pangkat juga tambahkan method PangkatDC()
```java
    int pangkatDC(int a, int n) {
        if (n == 1) {
            return 1;
        } else {
            if (n % 2 == 1) {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2)*a);
            } else {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2));
            }
        }
    }
```
4. Perhatikan apakah sudah tidak ada kesalahan yang muncul dalam pembuatan class Pangkat<br>
Jawab : Ada beberapa kesalahan dalam method class Pangkat. 
- Kesalahan inisialisasi variable hasil pada method pangkatBF()
```java
    int pangkatBF(int a, int n) {
        int hasil = 0;
        for (int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }
```
Variabel hasil seharusnya di inisialisasi dengan 1 karena operasi pangkat melibatkan perkalian jadi nilai awal seharusnya adalah 1 bukan 0. Jika hasil diinisialisasi dengan 0 maka berapapun bilangan yang dipangkatkan maka hasilnya akan tetap 0. Berikut perbaikan kode pada fungsi pangkatBF():
```java
    int pangkatBF(int a, int n) {
        int hasil = 1;
        for (int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }
```
- Kesalahan kondisi base pada fungsi pangkatDC(). 
```java
    int pangkatDC(int a, int n) {
        if (n == 1) {
            return 1;
        } else {
            if (n % 2 == 1) {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2)*a);
            } else {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2));
            }
        }
    }
```
Kesalahan kondisi base if (n == 1). Ketika pangkat menjadi 1, seharusnya mengembalikan a karena berapapun bilangannya jika dipangkatkan dengan 1 hasilnya adalah bilangan itu sendiri, bukan 1. Return value dapat bernilai 1 apabila kondisi base if (n == 0) karena berapapun berapapun bilangannya jika dipangkatkan 0 maka hasilnya adalah 1. Berikut perbaikan kode pada fungsi pangkatDC():
```java
    int pangkatDC(int a, int n) {
        if (n == 0) {
            return 1;
        } else {
            if (n % 2 == 1) {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2)*a);
            } else {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2));
            }
        }
    }
```
Ada juga alternatif lain yaitu dengan mengganti return value yang semula 1 menjadi a karena berapapun dipangkatkan dengan 1 adalah bilangan itu sendiri.
```java
    int pangkatDC(int a, int n) {
        if (n == 1) {
            return a;
        } else {
            if (n % 2 == 1) {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2)*a);
            } else {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2));
            }
        }
    }
```

5. Selanjutnya buat class baru yang di dalamnya terdapat method main. Class tersebut dapat dinamakan MainPangkat. Tambahkan kode pada class main untuk menginputkan jumlah nilai yang akan dihitung pangkatnya.<br>
```java
    Scanner sc = new Scanner(System.in);
    System.out.println("=======================================");
    System.out.println("Masukkan jumlah elemen yang dihitung: ");
    int elemen = sc.nextInt();
```
6. Nilai pada tahap 5 selanjutnya digunakan untuk instansiasi array of objek. Di dalam Kode berikut ditambahkan proses pengisian beberapa nilai yang akan dipangkatkan sekaligus dengan pemangkatnya.
```java
Pangkat[] png = new Pangkat[elemen];
for (int i = 0; i < elemen; i++) {
    png[i] = new Pangkat();
    System.out.println("Masukkan nilai yang hendak dipangkatkan: ");
    int nilai = sc.nextInt();
    System.out.println("Masukkan nilai pemangkat: ");
    int pangkat = sc.nextInt()
}
```
Pada kode di atas terdapat kesalahan yaitu atribut objek png belum diakses untuk diberikan nilai dari inputan scanner. Berikut kode yang benar:<br>
```java
    Pangkat[] png = new Pangkat[elemen];
    for (int i = 0; i < elemen; i++) {
        png[i] = new Pangkat();
        System.out.println("Masukkan nilai yang hendak dipangkatkan: ");
        png[i].nilai = sc.nextInt();
        System.out.println("Masukkan nilai pemangkat: ");
        png[i].pangkat = sc.nextInt();
    }
```

7. Kemudian, panggil hasil nya dengan mengeluarkan return value dari method PangkatBF() dan PangkatDC().
```java
    System.out.println("HASIL PANGKAT - BRUTE FORCE");
    for (int i = 0; i < elemen; i++) {
        System.out.println
        ("Hasil dari "
                + png[i].nilai + " pangkat "
                + png[i].pangkat + " adalah "
                + png[i].pangkatBF(png[i].nilai, png[i].pangkat));
    }
    System.out.println("HASIL PANGKAT - DIVIDE AND CONQUER");
    for (int i = 0; i < elemen; i++) {
        System.out.println
        ("Hasil dari "
                + png[i].nilai + " pangkat "
                + png[i].pangkat + " adalah "
                + png[i].pangkatDC(png[i].nilai, png[i].pangkat));
}
```
Kode program class Pangkat:
```java
package Pertemuan5.BruteForceDivideConquer.minggu5;

public class Pangkat {
    public int nilai, pangkat;

    int pangkatBF(int a, int n) {
        int hasil = 1;
        for (int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }

    int pangkatDC(int a, int n) {
        if (n == 0) {
            return 1;
        } else {
            if (n % 2 == 1) {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2)*a);
            } else {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2));
            }
        }
    }
}
```
Kode program class MainPangkat:
```java
package Pertemuan5.BruteForceDivideConquer.minggu5;
import java.util.Scanner;

public class MainPangkat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("Masukkan jumlah elemen yang dihitung: ");
        int elemen = sc.nextInt();

        Pangkat[] png = new Pangkat[elemen];
        for (int i = 0; i < elemen; i++) {
            png[i] = new Pangkat();
            System.out.println("Masukkan nilai yang hendak dipangkatkan: ");
            png[i].nilai = sc.nextInt();
            System.out.println("Masukkan nilai pemangkat: ");
            png[i].pangkat = sc.nextInt();
        }

        System.out.println("HASIL PANGKAT - BRUTE FORCE");
        for (int i = 0; i < elemen; i++) {
            System.out.println
            ("Hasil dari "
                    + png[i].nilai + " pangkat "
                    + png[i].pangkat + " adalah "
                    + png[i].pangkatBF(png[i].nilai, png[i].pangkat));
        }
        System.out.println("HASIL PANGKAT - DIVIDE AND CONQUER");
        for (int i = 0; i < elemen; i++) {
            System.out.println
            ("Hasil dari "
                    + png[i].nilai + " pangkat "
                    + png[i].pangkat + " adalah "
                    + png[i].pangkatDC(png[i].nilai, png[i].pangkat));
        }
    }
}
```

### 4.3.2 Verifikasi Hasil Percobaan
<img src="pictures/4.2.3 verif perc.png">

### 4.3.3 Pertanyaan
1. Jelaskan mengenai perbedaan 2 method yang dibuat yaitu PangkatBF() dan PangkatDC()!
2. Apakah tahap combine sudah termasuk dalam kode tersebut?Tunjukkan!
3. Modifikasi kode program tersebut, anggap proses pengisian atribut dilakukan dengan konstruktor.
4. Tambahkan menu agar salah satu method yang terpilih saja yang akan dijalankan menggunakan switch-case!

## 4.4 Menghitung Sum Array dengan Algoritma Brute Force dan Divide and Conquer
Di dalam percobaan ini, kita akan mempraktekkan bagaimana proses divide, conquer, dan
combine diterapkan pada studi kasus penjumlahan keuntungan suatu perusahaan dalam beberapa
bulan.

### 4.4.1 Langkah-langkah Percobaan
1. Pada paket minggu5. Buat class baru yaitu class Sum. DI salam class tersebut terdapat beberapa atribut jumlah elemen array, array, dan juga total. Tambahkan pula konstruktor pada class Sum.
```java
int elemen;
double keuntungan[], total;

    Sum(int elemen) {
        this.elemen = elemen;
        this.keuntungan = new double[elemen];
        this.total = 0;
    }
```
2. Tambahkan method TotalBF() yang akan menghitung total nilai array dengan cara iterative.
```java
    double totalBF(double arr[]) {
        for (int i = 0; i < elemen; i++) {
            total = total + arr[i];
        }
        return total;
    }
```
3. Tambahkan pula method TotalDC() untuk implementasi perhitungan nilai total array menggunakan algoritma Divide and Conquer.
```java
    double totalDc(double arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        } else if (l < r) {
            int mid = (l/r)+2;
            double lsum = totalDc(arr, l, mid-l);
            double rsum = totalDc(arr, mid+l, r);
            return lsum+rsum+arr[mid];
        }
        return 0;
    }
```
Terdapat kesalahan pada method totalDC() di atas, yaitu pada inisialisasi variabel mid dan pemberian nilai parameter fungsi totalDC() untuk mengisi variabel lsum dan rsum. Berikut penjelasannya:
- Formula untuk mendapatkan nilai tengah pada variabel mid salah. Rumus yang benar adalah menambah l dan r kemudian membaginya dengan 2 ((l + r) / 2) bukan membagi l dengan r lalu ditambah 2 ((l/r)+2).
- Pemberian nilai parameter yang salah pada pemanggilan method totalDC() untuk mengisi variabel lsum. parameter ketiga seharusnya adalah mid - 1 bukan mid - l. Jika parameter ketiga adalah mid - l, maka kondisi base case l == r tidak akan terpenuhi. Hal ini akan menyebabkan pemanggilan fungsi akan terjadi secara terus menerus (tak terbatas) dan akhirnya terjadi error stack over flow.
- Pemberian nilai parameter yang salah pada pemanggilan method totalDC() untuk mengisi variabel rsum. parameter kedua seharusnya adalah mid + 1 bukan mid + l. Jika parameter kedua adalah mid + l, maka kondisi base case l == r tidak akan terpenuhi. Hal ini akan menyebabkan pemanggilan fungsi akan terjadi secara terus menerus (tak terbatas) dan akhirnya terjadi error stack over flow.<br>
Berikut perbaikan kode program method totalDC():
```java
    double totalDc(double arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        } else if (l < r) {
            int mid = (l + r) / 2;
            double lsum = totalDc(arr, l, mid - 1);
            double rsum = totalDc(arr, mid + 1, r);
            return lsum+rsum+arr[mid];
        }
        return 0;
    }
```
4. Buat class baru yaitu MainSum. Di dalam kelas ini terdapat method main. Pada method ini user dapat menuliskan berapa bulan keuntungan yang akan dihitung. Dalam kelas ini sekaligus dibuat instansiasi objek untuk memanggil atribut ataupun fungsi pada class Sum
```java
    Scanner sc = new Scanner(System.in);
    System.out.println("================================================================");
    System.out.println("Program menghitung Keuntungan Total (Satuan Juta. Misal 5.9)");
    System.out.print("Masukkan jumlah bulan : ");
    int elm = sc.nextInt();
```
5. Karena yang akan dihitung adalah total nilai keuntungan, maka ditambahkan pula pada method main mana array yang akan dihitung. Array tersebut merupakan atribut yang terdapat di class Sum, maka dari itu dibutuhkan pembuatan objek Sum terlebih dahulu.
```java
    Sum sm = new Sum(elm);
    System.out.println("====================================================================");
    for (int i = 0; i < sm.elemen; i++) {
        System.out.print("Masukkan untung bulan ke - " + (i + 1) + " = ");
        sm.keuntungan[i] = sc.nextDouble();
    }
```
6. Tampilkan hasil perhitungan melalui objek yang telah dibuat untuk kedua cara yang ada (Brute Force dan Divide and Conquer)
```java
    System.out.println("===================================================================");
    System.out.println("Algoritma Brute Force");
    System.out.println("Total keuntungan perusahaan selama " + sm.elemen + " bulan adalah = " + sm.totalBF(sm.keuntungan));
    System.out.println("===================================================================");
    System.out.println("Algoritma Divide Conquer");
    System.out.println("Total keuntungan perusahaan selama " + sm.elemen + " bulan adalah = " + sm.totalDc(sm.keuntungan, 0, sm.elemen-1));
```

Kode program class Sum:
```java
package Pertemuan5.BruteForceDivideConquer.minggu5;

public class Sum {
    int elemen;
    double keuntungan[], total;

    Sum(int elemen) {
        this.elemen = elemen;
        this.keuntungan = new double[elemen];
        this.total = 0;
    }

    double totalBF(double arr[]) {
        for (int i = 0; i < elemen; i++) {
            total = total + arr[i];
        }
        return total;
    }

    double totalDc(double arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        } else if (l < r) {
            int mid = (l + r) / 2;
            double lsum = totalDc(arr, l, mid - 1);
            double rsum = totalDc(arr, mid + 1, r);
            return lsum+rsum+arr[mid];
        }
        return 0;
    }
}
```
Kode program class MainSum:
```java
package Pertemuan5.BruteForceDivideConquer.minggu5;
import java.util.Scanner;

public class MainSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================================");
        System.out.println("Program menghitung Keuntungan Total (Satuan Juta. Misal 5.9)");
        System.out.print("Masukkan jumlah bulan : ");
        int elm = sc.nextInt();

        Sum sm = new Sum(elm);
        System.out.println("====================================================================");
        for (int i = 0; i < sm.elemen; i++) {
            System.out.print("Masukkan untung bulan ke - " + (i + 1) + " = ");
            sm.keuntungan[i] = sc.nextDouble();
        }

        System.out.println("===================================================================");
        System.out.println("Algoritma Brute Force");
        System.out.println("Total keuntungan perusahaan selama " + sm.elemen + " bulan adalah = " + sm.totalBF(sm.keuntungan));
        System.out.println("===================================================================");
        System.out.println("Algoritma Divide Conquer");
        System.out.println("Total keuntungan perusahaan selama " + sm.elemen + " bulan adalah = " + sm.totalDc(sm.keuntungan, 0, sm.elemen-1));
    }
}
```

### 4.4.2 Verifikasi Hasil Percobaan
<img src="pictures/4.4.2 verif perc.png">

### 4.4.3 Pertanyaan
1. Mengapa terdapat formulasi return value berikut?Jelaskan!
2. Kenapa dibutuhkan variable mid pada method TotalDC()?
3. Program perhitungan keuntungan suatu perusahaan ini hanya untuk satu perusahaan saja. Bagaimana cara menghitung sekaligus keuntungan beberapa bulan untuk beberapa perusahaan.(Setiap perusahaan bisa saja memiliki jumlah bulan berbeda-beda)? Buktikan dengan program!

## 4.5 Latihan Praktikum
1. Sebuah showroom memiliki daftar mobil dengan data sesuai tabel di bawah ini<br>
<img src="pictures/4.5 Latprak.png">
Tentukan:<br>
    a) top_acceleration tertinggi menggunakan Divide and Conquer!<br>
    b) top_acceleration terendah menggunakan Divide and Conquer!<br>
    c) Rata-rata top_power dari seluruh mobil menggunakan Brute Force!<br>