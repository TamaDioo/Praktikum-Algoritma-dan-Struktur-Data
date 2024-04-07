import java.util.Scanner;

public class Utama09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Meminta pengguna untuk menentukan kapasitas gudang
        System.out.print("Berapa kapasitas gudang yang Anda inginkan: ");
        int capacity = scanner.nextInt();
        Gudang09 gudang = new Gudang09(capacity);


        while (true) {
            System.out.println("\nMenu:");    
            System.out.println("1. Tambah barang");    
            System.out.println("2. Ambil barang");    
            System.out.println("3. Tampilkan tumpukan barang");    
            System.out.println("4. Lihat barang teratas"); //Menambahkan menu untuk melihat barang teratas
            System.out.println("5. Keluar");    
            System.out.print("Pilih operasi: ");    
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    int kode = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nama kategori: ");
                    String kategori = scanner.nextLine();
                    Barang09 barangBaru = new Barang09(kode, nama, kategori);
                    gudang.tambahBarang(barangBaru);
                    break;
                case 2:
                    gudang.ambilBarang();
                    break;
                case 3:
                    gudang.tampilkanBarang();
                    break;  
                case 4: //Menu lihat barang teratas
                    gudang.lihatBarangTeratas();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        }
    }
}