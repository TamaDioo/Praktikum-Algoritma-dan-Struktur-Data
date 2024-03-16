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
            System.out.println("Masukkan nilai yang hendak dipangkatkan: ");
            int nilai = sc.nextInt();
            System.out.println("Masukkan nilai pemangkat: ");
            int pangkat = sc.nextInt();
            png[i] = new Pangkat(nilai, pangkat);
        }

        System.out.println("=======================================");
        System.out.print
        ("Method untuk menghitung nilai pangkat" + 
            "\n 1. Method Brute Force \n 2. Method Divide and Conquer \n" +
            "Pilih method yang akan dijalankan: ");
        short menu = sc.nextShort();
        System.out.println("=======================================");

        switch (menu) {
            case 1:
                System.out.println("HASIL PANGKAT - BRUTE FORCE");
                for (int i = 0; i < elemen; i++) {
                    System.out.println("Hasil dari " + png[i].nilai + " pangkat "
                        + png[i].pangkat + " adalah "
                        + png[i].pangkatBF(png[i].nilai, png[i].pangkat));
                }
                break;
            case 2:
                System.out.println("HASIL PANGKAT - DIVIDE AND CONQUER");
                for (int i = 0; i < elemen; i++) {
                    System.out.println
                    ("Hasil dari " + png[i].nilai + " pangkat "
                        + png[i].pangkat + " adalah "
                        + png[i].pangkatDC(png[i].nilai, png[i].pangkat));
                }
                break;
            default:
                System.out.println("Menu yang Anda masukkan tidak valid!");
                break;
        }
    }
}