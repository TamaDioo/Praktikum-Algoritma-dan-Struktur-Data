import java.util.Scanner;

public class Tugas209 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char konfir;
        System.out.println("====================================================");
        System.out.println("Program Perhitungan Rumus Jarak, Kecepatan dan Waktu");
        System.out.println("====================================================");
        do {
            pilihMenu();
            System.out.println("Apakah Anda ingin menghitung kembali? (y/n)");
            konfir = sc.nextLine().charAt(0);
        } while (konfir == 'Y'|| konfir == 'y');
        sc.close();
    }

    static void pilihMenu() {
        System.out.println("1) Hitung Kecepatan");
        System.out.println("2) Hitung Jarak");
        System.out.println("3) Hitung Waktu");
        System.out.print("Pilih rumus yang akan dihitung: ");
        short menu = input.nextShort();

        switch (menu) {
            case 1 :
                System.out.println("=========================");
                System.out.println("Hitung Kecepatan");
                System.out.println("=========================");
                hitungKecepatan();
                break;
            case 2:
                System.out.println("=========================");
                System.out.println("Hitung Jarak");
                System.out.println("=========================");
                hitungJarak();
                break;
            case 3:
                System.out.println("=========================");
                System.out.println("Hitung Waktu"); 
                System.out.println("=========================");
                hitungWaktu();
                break;
            default:
                System.out.println("Menu yang Anda masukkan tidak valid");
                break;
        }
    }

    static void hitungKecepatan() {
        System.out.print("Masukkan jarak (km): ");
        double jarak = input.nextDouble();
        System.out.print("Masukkan waktu (jam): ");
        double waktu = input.nextDouble();
        
        double kecepatan = jarak / waktu;
        System.out.println("======================================");
        System.out.println("Hasil perhitungan kecepatan: " + kecepatan + " km/jam");
        System.out.println("======================================");
    }

    static void hitungJarak() {
        System.out.print("Masukkan kecepatan (km/jam): ");
        double kecepatan = input.nextDouble();
        System.out.print("Masukkan waktu (jam): ");
        double waktu = input.nextDouble();
        
        double jarak = kecepatan * waktu;
        System.out.println("======================================");
        System.out.println("Hasil perhitungan jarak: " + jarak + " km");
        System.out.println("======================================");
    }

    static void hitungWaktu() {
        System.out.print("Masukkan kecepatan (km/jam): ");
        double kecepatan = input.nextDouble();
        System.out.print("Masukkan jarak(km): ");
        double jarak = input.nextDouble();
        
        double waktu = jarak / kecepatan;
        System.out.println("======================================");
        System.out.println("Hasil perhitungan waktu: " + waktu + " jam");
        System.out.println("======================================");
    }
}