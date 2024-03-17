package Pertemuan5.BruteForceDivideConquer.minggu5;
import java.util.Scanner;

public class MainSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner nm = new Scanner(System.in);
        System.out.println("===================================================================");
        System.out.println("Program menghitung Keuntungan Total (Satuan Juta. Misal 5.9)");

        System.out.print("Jumlah perusahaan: ");
        short comp = sc.nextShort();
        Sum[] sm = new Sum[comp];

        for (int x = 0; x < sm.length; x++) {
            System.out.println("Perusahaan ke-" + (x+1));
            System.out.print("Masukkan jumlah bulan : ");
            int elm = sc.nextInt();
            sm[x] = new Sum(elm);
            System.out.print("Masukkan nama perusahaan: ");
            sm[x].compName = nm.nextLine();

            System.out.println("===================================================================");
            for (int i = 0; i < sm[x].elemen; i++) {
                System.out.print("Masukkan untung bulan ke - " + (i + 1) + " = ");
                sm[x].keuntungan[i] = sc.nextDouble();
            }
        }

        for (int j = 0; j < sm.length; j++) {
            System.out.println("===================================================================");
            System.out.println("Algoritma Brute Force");
            System.out.println("Perusahaan ke-" + (j+1));
            System.out.println("Total keuntungan perusahaan " + sm[j].compName + " selama " + sm[j].elemen + " bulan adalah = " + sm[j].totalBF(sm[j].keuntungan));
            System.out.println("===================================================================");
            System.out.println("Algoritma Divide Conquer");
            System.out.println("Perusahaan ke-" + (j+1));
            System.out.println("Total keuntungan perusahaan " + sm[j].compName + " selama " + sm[j].elemen + " bulan adalah = " + sm[j].totalDc(sm[j].keuntungan, 0, sm[j].elemen-1));
        }
    }
}