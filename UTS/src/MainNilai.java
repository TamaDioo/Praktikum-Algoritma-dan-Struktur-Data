package UTS.src;
import java.util.Scanner;

public class MainNilai {
    static Scanner s = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        DaftarNilai dataNilai = new DaftarNilai();
        int jumNilai = 17;

        int[] kumpulanNilai = {7, 29, 26, 21, 3, 23, 17, 17, 46, 21, 44, 37, 24, 17, 38, 37, 21}; 
        System.out.println("Kumpulan nilai awal");
        for (int j = 0; j < kumpulanNilai.length; j++) {
            System.out.print(kumpulanNilai[j] + " ");
        }
        System.out.println();

        for (int i = 0; i < jumNilai; i++) {
            int nilai = kumpulanNilai[i];

            Nilai m = new Nilai(nilai);
            dataNilai.tambah(m);
        }

        char konfir;
            do {
                mainMenu(jumNilai, dataNilai);
                System.out.println("Apakah Anda ingin memilih menu lain? (y/n)");
                konfir = sc.next().charAt(0);
            } while (konfir == 'Y'|| konfir == 'y');
    }

    static void searchTidakUrut(int length, DaftarNilai data) {
        System.out.println("-------------------------------------------");
        System.out.println("Data keseluruhan Nilai (Belum tentu dalam keadaan sudah terurut): ");
        data.tampil();

        System.out.println("___________________________________________");
        System.out.println("___________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan nilai yang dicari : ");
        System.out.print("Nilai : ");
        int cari = s.nextInt();
        System.out.println("Menggunakan Binary Search");
        int posisi = data.FindBinarySearch(cari, 0, length - 1);
        data.Tampilposisi(cari, posisi);
    }

    static void menuBinAsc(int length, DaftarNilai data) {
        System.out.println("-------------------------------------------");
        System.out.println("Data keseluruhan Nilai (Urut dari terkecil ke terbesar): ");
        data.sortAscending();
        data.tampil();

        System.out.println("___________________________________________");
        System.out.println("___________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan nilai yang dicari : ");
        System.out.print("Nilai : ");
        int cari = s.nextInt();
        System.out.println("=================================");
        System.out.println("Menggunakan binary search");
        int posisi = data.FindBinarySearchAsc(cari, 0, length - 1);
        data.Tampilposisi(cari, posisi);
    }

    static void menuBinDesc(int length, DaftarNilai data) {
        System.out.println("-------------------------------------------");
        System.out.println("Data keseluruhan Nilai (Urut dari terbesar ke terkecil): ");
        data.sortDescending();
        data.tampil();

        System.out.println("___________________________________________");
        System.out.println("___________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan nilai yang dicari : ");
        System.out.print("Nilai : ");
        int cari = s.nextInt();
        System.out.println("=================================");
        System.out.println("menggunakan binary search");
        int posisi = data.FindBinarySearchDesc(cari, 0, length - 1);
        data.Tampilposisi(cari, posisi);
    }

    static void menuSort(DaftarNilai data) {
        System.out.println("-------------------------------------------");
        System.out.println("Pilih menu sorting");
        System.out.println("1. Ascending\n2. Descending");
        System.out.print("Masukkan pilihan Anda: ");
        short srt = s.nextShort();
        switch (srt) {
            case 1:
                data.sortAscending();
                data.tampil();
                break;
            case 2:
                data.sortDescending();
                data.tampil();
                break;
            default:
                System.out.println("Menu sorting yang Anda masukkan tidak valid!\n" +
                "Pilih menu sorting yang valid (1/2)");
                break;
        }
    }

    static void menuSearch(int length, DaftarNilai data) {
        System.out.println("-------------------------------------------");
        System.out.println("Pilih menu searching");
        System.out.println("1. Searching untuk data yang belum diurutkan\n2. Searching untuk data yang sudah diurutkan");
        System.out.print("Masukkan pilihan Anda: ");
        short srch = s.nextShort();
        switch (srch) {
            case 1:
                searchTidakUrut(length, data);
                break;
            case 2:
                menuBinSrch(length, data);
                break;
            default:
                System.out.println("Menu searching yang Anda masukkan tidak valid!\n" +
                "Pilih menu sorting yang valid (1/2)");
                break;
        }
    }

    static void menuBinSrch(int length, DaftarNilai data) {
        System.out.println("-------------------------------------------");
        System.out.println("Pilih metode binary search");
        System.out.println("1. Binary search dengan nilai yang diurutkan secara ascending\n2. Binary search dengan nilai yang diurutkan secara descending");
        System.out.print("Masukkan pilihan Anda: ");
        short menuSrch = s.nextShort();
        switch (menuSrch) {
            case 1:
                menuBinAsc(length, data);
                break;
            case 2:
                menuBinDesc(length, data);
                break;
            default:
                System.out.println("Metode binary search yang Anda masukkan tidak valid!\n" +
                "Pilih metode binary search yang valid (1/2)");
                break;
        }
    }

    static void mainMenu(int length, DaftarNilai data) {
        System.out.println("-------------------------------------------");
        System.out.println("Pilih menu operasi");
        System.out.println("1. Sorting\n2. Searching");
        System.out.print("Menu yang Anda pilih: ");
        byte menu = s.nextByte();
        if (menu == 1) {
            char knfrMenu1;
            do {
                menuSort(data);
                System.out.println("Apakah Anda ingin memilih metode sorting yang lain? (y/n)");
                knfrMenu1 = sc.next().charAt(0);
            } while (knfrMenu1 == 'Y'|| knfrMenu1 == 'y');
        } else if (menu == 2) {
            char knfrMenu2;
            do {
                menuSearch(length, data);
                System.out.println("Apakah Anda ingin memilih metode searching yang lain? (y/n)");
                knfrMenu2 = sc.next().charAt(0);
            } while (knfrMenu2 == 'Y'|| knfrMenu2 == 'y');
        } else {
            System.out.println("Menu yang Anda pilih tidak valid!");
        }  
    }
}