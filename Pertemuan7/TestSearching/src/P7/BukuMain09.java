package P7;
import java.util.Scanner;

public class BukuMain09 {
    static Scanner s = new Scanner(System.in); 
    static Scanner s1 = new Scanner(System.in);
    public static void main(String[] args) {
        
        PencarianBuku09 data = new PencarianBuku09();
        int jumBuku = 5;

        System.out.println("------------------------------------------------");
        System.out.println("Masukkan data Buku (tidak harus terurut): ");
        for (int i = 0; i < jumBuku; i++) {
            System.out.println("------------------");
            System.out.print("Kode Buku \t: ");
            String kodeBuku = s1.nextLine();
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
        System.out.println("Fitur Searching Buku");
        System.out.println("1. Searching berdasarkan kode buku\n" + 
                           "2. Searching berdasarkan judul buku");
        System.out.print("Pilih menu searching untuk mencari buku: ");
        byte menu = s.nextByte();
        if (menu == 1) {
            menuKodeBK(jumBuku, data);;//Pemanggilan fungsi search berdasarkan kode buku
        } else if (menu == 2) {
            menuJdl(jumBuku, data);//Pemanggilan fungsi search berdasarkan judul buku
        } else {
            System.out.println("Menu searching yang Anda pilih tidak valid!");
        }
    }

    static void menuKodeBK(int length, PencarianBuku09 data) {
        System.out.println("-------------------------------------------");
        System.out.println("Data keseluruhan Buku (Urut berdasarkan kode buku): ");
        data.insertionSortKodeBK();//Mengurutkan kode buku terlebih dahulu dengan algoritma insertion sort
        data.tampil();

        System.out.println("___________________________________________");
        System.out.println("___________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan Kode Buku yang dicari : ");
        System.out.print("Kode Buku : ");
        String cari = s1.nextLine();
        System.out.println("Menggunakan sequential Search");
        int posisi = data.FindSeqSearch(cari);
        data.Tampilposisi(cari, posisi);
        data.TampilData(cari, posisi);

        System.out.println("Menggunakan method FindBuku()");
        Buku09 dataBuku = data.FindBuku(cari);
        if (dataBuku != null) {
            dataBuku.tampilDataBuku();
        } else {
            System.out.println("Buku tidak ditemukan.");
        }

        System.out.println("=================================");
        System.out.println("menggunakan binary search");
        posisi = data.FindBinarySearch(cari, 0, length - 1);
        data.Tampilposisi(cari, posisi);
        data.TampilData(cari, posisi);
    }

    static void menuJdl(int length, PencarianBuku09 data) {
        System.out.println("-------------------------------------------");
        System.out.println("Data keseluruhan Buku (Urut berdasarkan judul buku): ");
        data.selectionSortJdl();//Mengurutkan judul buku terlebih dahulu dengan algoritma selection sort
        data.tampil();

        System.out.println("___________________________________________");
        System.out.println("___________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan judul Buku yang dicari : ");
        System.out.print("Judul Buku : ");
        String jdl = s1.nextLine();
        System.out.println("Menggunakan sequential Search");
        int posJdl = data.FindJudulSeqSearch(jdl);
        data.Tampilposisi(jdl, posJdl);
        data.TampilData(jdl, posJdl);

        System.out.println("Menggunakan method FindBuku()");
        Buku09 dataJdl = data.FindJudulBuku(jdl);
        if (dataJdl != null) {
            dataJdl.tampilDataBuku();
        } else {
            System.out.println("Buku tidak ditemukan.");
        }

        System.out.println("=================================");
        System.out.println("menggunakan binary search");
        posJdl = data.FindJdlBinSearch(jdl, 0, length - 1);
        data.Tampilposisi(jdl, posJdl);
        data.TampilData(jdl, posJdl);
    }
}