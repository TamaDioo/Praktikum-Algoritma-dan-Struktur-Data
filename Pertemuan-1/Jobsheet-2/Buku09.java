public class Buku09{
    String judul, pengarang;
    int halaman, stok, harga, terjual;

    void tampilInformasi() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa Stock: " + stok);
        System.out.println("Harga: Rp " + harga);
    }
    void terjual(int jml) {
        if (stok > 0 && jml <= stok)  {
            terjual = jml;
            stok -= jml;
        } else if (stok <= 0) {
            System.out.println("Stok kosong!");
        }else if (jml >= stok) {
            System.out.println("Jumlah buku yang terjual lebih banyak dari stok!");
        } 
    }
    
    void restock(int jml) {
        stok += jml;
    }

    void gantiHarga(int hrg) {
        harga = hrg;
    }

    int hitungHargaTotal() {
        return harga*terjual;
    }

    int hitungDiskon() {
        int hargaTotal = hitungHargaTotal();
        if (hargaTotal > 150000) {
            return (hargaTotal * 12 / 100) ;
        } else if (hargaTotal <= 150000 && hargaTotal >= 75000) {
            return (hargaTotal * 5 / 100);  
        } else {
            return 0;
        }
    }

    int hitungHargaBayar() {
        return hitungHargaTotal()-hitungDiskon();
    }

    public Buku09() {

    }

    public Buku09(String jud, String pg, int hal, int stok, int har) {
        judul = jud;
        pengarang = pg;
        halaman = hal;
        this.stok = stok;
        harga = har;
    }
}