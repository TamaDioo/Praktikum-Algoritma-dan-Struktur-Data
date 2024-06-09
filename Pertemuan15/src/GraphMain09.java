package Pertemuan15.src;
import java.util.Scanner;

public class GraphMain09 {
    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Add Edge");
        System.out.println("2. Remove Edge");
        System.out.println("3. Degree");
        System.out.println("4. Print Graph");
        System.out.println("5. Cek Edge");
        System.out.println("6. Update Jarak");
        System.out.println("7. Hitung Edge");
        System.out.println("8. keluar");
        System.out.println("--------------------------");
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a, t, pilih;
        Graph09 gedung = new Graph09(6);

        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.println("Tambahkan lintasan antar gedung");
                    System.out.print("Masukkan index node (gedung) asal: ");
                    a = sc.nextInt();
                    System.out.print("Masukkan index node (gedung) tujuan: ");
                    t = sc.nextInt();
                    System.out.print("Masukkan jarak lintasan dari node awal ke node tujuan (satuan meter): ");
                    int m = sc.nextInt();
                    gedung.addEdge(a, t, m);
                    break;
                case 2:
                    System.out.println("Hapus lintasan antar gedung");
                    System.out.print("Masukkan index node (gedung) asal: ");
                    a = sc.nextInt();
                    System.out.print("Masukkan index node (gedung) tujuan: ");
                    t = sc.nextInt();
                    gedung.removeEdge(a, t);
                    break;
                case 3:
                    System.out.print("Masukkan index node yang ingin dicek degree-nya: ");
                    a = sc.nextInt();
                    gedung.degree(a);
                    break;
                case 4:
                    System.out.println("Cetak semua node (gedung) yang ada pada graf:");
                    gedung.printGraph();
                    break;
                case 5:
                    System.out.println("Cek lintasan antar node (gedung)");
                    System.out.print("Masukkan index node asal: ");
                    a = sc.nextInt();
                    System.out.print("Masukkan index node tujuan: ");
                    t = sc.nextInt();
                    gedung.cekEdge(a, t);
                    break;
                case 6:
                    System.out.println("Ubah jarak lintasan antar gedung");
                    System.out.print("Masukkan index node (gedung) asal: ");
                    a = sc.nextInt();
                    System.out.print("Masukkan index node (gedung) tujuan: ");
                    t = sc.nextInt();
                    System.out.print("Masukkan jarak baru lintasan (satuan meter): ");
                    int newJarak = sc.nextInt();
                    gedung.updateJarak(a, t, newJarak);
                    break;
                case 7:
                    System.out.println("Jumlah edge (lintasan) di dalam graph: " + gedung.hitungEdge());
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (pilih <= 8 && pilih > 0);
    }
}