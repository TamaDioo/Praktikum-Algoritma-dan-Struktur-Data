package Pertemuan10.Tugas;
import java.util.Scanner;

public class PembeliMain {
    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Antrian paling belakang");
        System.out.println("5. Cek Semua Antrian");
        System.out.println("6. Cari posisi pembeli");
        System.out.println("--------------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc.nextInt();
        Queue ngantri = new Queue(jumlah);

        int pilih;

        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = s.nextLine();
                    System.out.print("noHP: ");
                    int noHP = sc.nextInt();
                    Pembeli nb = new Pembeli(nama, noHP);
                    ngantri.Enqueue(nb);
                    break;
                case 2:
                    Pembeli data = ngantri.Dequeue();
                    if (!"".equals(data.nama) && data.noHP != 0) {
                        System.out.println("Antrian yang keluar: " + data.nama + " " + data.noHP);
                        break;
                    }
                case 3:
                    ngantri.peek();
                    break;
                case 4:
                    ngantri.peekRear();
                    break;
                case 5:
                    ngantri.daftarPembeli();
                    break;
                case 6:
                    System.out.print("Masukkan nama pembeli yang Anda cari: ");
                    String findNama = s.nextLine();
                    ngantri.peekPosition(findNama);;
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6);
    }
}