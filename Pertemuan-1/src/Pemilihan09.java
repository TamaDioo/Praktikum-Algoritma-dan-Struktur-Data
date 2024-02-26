import java.util.Scanner;
public class Pemilihan09 {
    public static void main(String[] args) {
        Scanner input09 = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("===========================");

        System.out.print("Masukkan Nilai Tugas  : ");
        float tugas = input09.nextFloat();
        System.out.print("Masukkan Nilai Kuis   : ");
        float kuis = input09.nextFloat();
        System.out.print("Masukkan Nilai UTS    : ");
        float uts = input09.nextFloat();
        System.out.print("Masukkan Nilai UAS    : ");
        float uas = input09.nextFloat();

        System.out.println("===========================");
        System.out.println("===========================");

        if (uas < 0 || uas > 100) {
            notValid();
        } else if (uts < 0 || uts > 100) {
            notValid();
        } else if (kuis < 0 || kuis > 100) {
            notValid();
        } else if (tugas < 0 || tugas > 100) {
            notValid();
        } else {
            float total = (uas * 0.3F) + (uts * 0.3F) + (kuis * 0.2F) + (tugas * 0.2F);

            String nilaiHuruf;
            if (total > 80 && total <= 100) {
                nilaiHuruf = "A";
            } else if (total > 73 && total <= 80) {
                nilaiHuruf = "B+";        
            } else if (total > 65 && total <= 73) {
                nilaiHuruf = "B";
            } else if (total > 60 && total <= 65) {
                nilaiHuruf = "C+";
            } else if (total > 50 && total <= 60) {
                nilaiHuruf = "C";
            } else if (total > 39 && total <= 50) {
                nilaiHuruf = "D";
            } else {
                nilaiHuruf = "E";
            }
            System.out.println("Nilai akhir : " + total);
            System.out.println("Nilai huruf: " + nilaiHuruf);

            System.out.println("===========================");
            System.out.println("===========================");

            String message = total <= 50 ? "MAAF ANDA TIDAK LULUS" : "SELAMAT ANDA LULUS";
            System.out.println(message);
        }
    }
    
    static void notValid() {
        System.out.println("nilai tidak valid");
        System.out.println("===========================");
        System.out.println("===========================");
    }
}