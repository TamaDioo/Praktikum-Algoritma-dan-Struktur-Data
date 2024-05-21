package Pertemuan11.minggu11;
import java.util.Scanner;

import Pertemuan10.Praktikum2.Nasabah;

public class MhsQueueMain {
    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Antrian paling belakang");
        System.out.println("5. Cek Semua Antrian");
        System.out.println("6. Keluar");
        System.out.println("--------------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in);

        MhsQueue mhsAntri = new MhsQueue();

        int pilih;

        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = s.nextLine();
                    System.out.print("NIM: ");
                    int nim = sc.nextInt();
                    mhsAntri.Enqueue(nim, nama);
                    break;
                case 2:
                    Mahasiswa data = mhsAntri.Dequeue();
                    if (data != null) {
                        System.out.println("Antrian yang keluar:\nNIM : " + data.NIM + ", Nama : " + data.nama);
                    } 
                    break;
                case 3:
                    mhsAntri.peek();
                    break;
                case 4:
                    mhsAntri.peekRear();
                    break;
                case 5:
                    mhsAntri.print();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu yang Anda masukkan tidak valid!");
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
    }
}