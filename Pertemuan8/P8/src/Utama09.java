import java.util.Scanner;

public class Utama09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

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
            System.out.println("5. Lihat barang terbawah"); //Menambahkan menu untuk melihat barang terbawah
            System.out.println("6. Cari barang berdasarkan kode"); //Menambahkan menu untuk mencari barang berdasarkan kode
            System.out.println("7. Cari barang berdasarkan nama"); //Menambahkan menu untuk mencari barang berdasarkan nama
            System.out.println("8. Keluar");    
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
                case 5: //Menu lihat barang terbawah
                    gudang.lihatBarangTerbawah();
                    break;
                case 6: //Menu cari barang berdasarkan kode
                    System.out.println("------------------------------------");
                    System.out.println("Masukkan Kode Barang yang dicari : ");
                    System.out.print("Kode Barang : ");
                    int cariKd = scanner.nextInt();
                    System.out.println("------------------------------------");
                    int posisi = gudang.FindKodeBrg(cariKd);
                    gudang.TampilKode(cariKd, posisi);
                    break;
                case 7: //Menu cari barang berdasarkan nama
                    System.out.println("------------------------------------");
                    System.out.println("Masukkan nama Barang yang dicari : ");
                    System.out.print("Nama Barang : ");
                    String cariNm = sc.nextLine();
                    System.out.println("------------------------------------");
                    int pos = gudang.FindNamaBrg(cariNm);
                    gudang.TampilName(cariNm, pos);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        }
    }
}