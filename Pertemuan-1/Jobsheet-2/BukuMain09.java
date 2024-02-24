public class BukuMain09 {
    public static void main(String[] args) {
        Buku09 bk1 = new Buku09();
        bk1.judul = "Today Ends Tomorrow Comes";
        bk1.pengarang = "Denanda pratiwi";
        bk1.halaman = 198;
        bk1.stok = 13;
        bk1.harga = 71000;

        bk1.tampilInformasi();
        bk1.terjual(5);
        bk1.gantiHarga(60000);
        bk1.tampilInformasi();

        Buku09 bk2 = new Buku09("Self Reward", "Maheera Ayesha", 160, 29, 59000);
        bk2.terjual(11);
        bk2.tampilInformasi();

        Buku09 bukuDio = new Buku09("Sukses Dunia Akhirat", "Dio Andika", 399, 20, 56000);
        bukuDio.terjual(10);
        bukuDio.restock(5);
        bukuDio.tampilInformasi();
        System.out.println("Harga total               : Rp " + bukuDio.hitungHargaTotal());
        System.out.println("Diskon yang didapat       : Rp " + bukuDio.hitungDiskon());
        System.out.println("Total Harga bayar         : Rp " + bukuDio.hitungHargaBayar());
    }
}