package Pertemuan6.bubbleSelectionInsertion.jobsheet6;
import java.util.Scanner;

public class MainHotel {
    static Scanner input = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        HotelService daftar = new HotelService();
        Hotel H1 = new Hotel("Savana", "Malang", 340000, (byte)5);
        Hotel H2 = new Hotel("YellowDoorz", "Malang", 210000, (byte)4);
        Hotel H3 = new Hotel("Violet Hotel", "Malang", 399000, (byte)3);
        Hotel H4 = new Hotel("Huge Star", "Surabaya", 500000, (byte)1);
        Hotel H5 = new Hotel("Quin Hotel", "Malang", 150000, (byte)2);

        daftar.tambah(H1);
        daftar.tambah(H2);
        daftar.tambah(H3);
        daftar.tambah(H4);
        daftar.tambah(H5);

        System.out.println("Informasi Penginapan");
        System.out.println("==========================");
        System.out.println("Daftar penginapan yang tersedia: ");
        System.out.println("--------------------------");
        daftar.tampilAll();

        char konfir;
            do {
                menuFilter(daftar);
                System.out.println("Apakah Anda ingin memilih filter lain? (y/n)");
                konfir = sc.next().charAt(0);
                if (konfir == 'Y'|| konfir == 'y') {
                    System.out.println("==========================");
                } 
            } while (konfir == 'Y'|| konfir == 'y');
    }

    static void menuHarga(HotelService list) {
        System.out.println("==========================");
        System.out.println("Metode Sorting harga penginapan");
        System.out.println("1) Bubble Sort\n" + "2) Selection Sort");
        System.out.print("Pilih metode sorting: ");
        byte menuSort = input.nextByte();
        System.out.println("==========================");

        switch (menuSort) {
            case 1 :
                System.out.println("Sorting harga penginapan menggunakan bubble sort");
                System.out.println("--------------------------");
                list.bubbleSortHarga();
                list.tampilAll();
                break;
            case 2:
                System.out.println("Sorting harga penginapan menggunakan selection sort");
                System.out.println("--------------------------");
                list.selectionSortHarga();
                list.tampilAll();
                break;
            default:
                System.out.println("Menu sorting yang Anda masukkan tidak valid!\n" +
                "Pilih menu sorting yang valid (1/2)");
                break;
        }
    }

    static void menuRating(HotelService list) {
        System.out.println("==========================");
        System.out.println("Metode Sorting rating penginapan");
        System.out.println("1) Bubble Sort\n" + "2) Selection Sort");
        System.out.print("Pilih metode sorting: ");
        byte menuSort = input.nextByte();
        System.out.println("==========================");

        switch (menuSort) {
            case 1 :
                System.out.println("Sorting rating penginapan menggunakan bubble sort");
                list.bubbleSortRating();
                list.tampilAll();
                break;
            case 2:
                System.out.println("Sorting rating penginapan menggunakan selection sort");
                list.selectionSortRating();
                list.tampilAll();
                break;
            default:
                System.out.println("Menu sorting yang Anda masukkan tidak valid!\n" + 
                "Pilih menu sorting yang valid (1/2)");
                break;
        }
    }

    //Ini merupakan fungsi untuk pemilihan filter (harga/rating).
    static void menuFilter(HotelService list) {
        System.out.println("Fitur filter penginapan");
        System.out.println("1. Harga (dimulai dari harga termurah ke harga tertinggi)\n" + 
                           "2. Rating bintang penginapan (dari bintang tertinggi (5) ke terendah (1))\"");
        System.out.print("Pilih filter untuk menampilkan daftar penginapan yang tersedia: ");
        byte menu = input.nextByte();

        if (menu == 1) {
            char konfir1;
            do {
                menuHarga(list);//Pemanggilan fungsi submenu harga penginapan (metode sorting bubble/selection)
                System.out.println("Apakah Anda ingin menggunakan metode sorting lain? (y/n)");
                konfir1 = sc.next().charAt(0);
            } while (konfir1 == 'Y'|| konfir1 == 'y');
        } else if (menu == 2) {
            char konfir2;
            do {
                menuRating(list);//Pemanggilan fungsi submenu rating penginapan (metode sorting bubble/selection)
                System.out.println("Apakah Anda ingin menggunakan metode sorting lain? (y/n)");
                konfir2 = sc.next().charAt(0);
            } while (konfir2 == 'Y'|| konfir2 == 'y');
        } else {
            System.out.println("Filter yang Anda pilih tidak valid!\nPilih filter yang tersedia (1/2)");
        }
    }
}