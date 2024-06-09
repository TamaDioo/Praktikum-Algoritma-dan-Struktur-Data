package Pertemuan15.src;
import java.util.Scanner;

public class GraphMain09 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a, t;
        Graph09 gedung = new Graph09(6);
        gedung.addEdge(0, 1, 50);
        gedung.addEdge(0, 2, 100);
        gedung.addEdge(1, 3, 70);
        gedung.addEdge(2, 3, 40);
        gedung.addEdge(3, 4, 60);
        gedung.addEdge(4, 5, 80);
        System.out.print("Masukkan gedung asal: ");
        a = sc.nextInt();
        System.out.print("Masukkan gedung tujuan: ");
        t = sc.nextInt();
        gedung.cekEdge(a, t);
        System.out.println();
        System.out.print("Masukkan gedung asal: ");
        a = sc.nextInt();
        System.out.print("Masukkan gedung tujuan: ");
        t = sc.nextInt();
        gedung.cekEdge(a, t);
        System.out.println();
        gedung.degree(0);
        gedung.printGraph();
        
        gedung.removeEdge(1, 3);
        gedung.printGraph();
        
        // GraphMatriks09 gdg = new GraphMatriks09(4);
        // gdg.makeEdge(0, 1, 50);
        // gdg.makeEdge(1, 0, 60);
        // gdg.makeEdge(1, 2, 70);
        // gdg.makeEdge(2, 1, 80);
        // gdg.makeEdge(2, 3, 40);
        // gdg.makeEdge(3, 0, 90);
        // gdg.printGraph();
        // gdg.degree(0);
        // gdg.degree(1);
        // gdg.degree(2);
        // gdg.degree(3);
        // System.out.println("Hasil setelah penghapusan edge");
        // gdg.removeEdge(2, 1);
        // gdg.printGraph();
        // gdg.degree(1);
    }
}