public class Gudang09 {
    Barang09[] tumpukan;
    int size, top;

    public Gudang09(int kapasitas) {
        size = kapasitas;
        tumpukan = new Barang09[size];
        top = -1;
    }

    public boolean cekKosong() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cekPenuh() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void tambahBarang(Barang09 brg) {
        if (!cekPenuh()) {
            top++;
            tumpukan[top] = brg;
            System.out.println("Barang " + brg.nama + " berhasil ditambahkan ke Gudang");
        } else {
            System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
        }
    }

    public Barang09 ambilBarang() {
        if (!cekKosong()) {
            Barang09 delete = tumpukan[top];
            top--;
            System.out.println("Barang " + delete.nama + " diambil dari Gudang");
            System.out.println("Kode unik dalam biner: " + konversiDesimalKeBiner(delete.kode));
            return delete;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }

    public Barang09 lihatBarangTeratas() {
        if (!cekKosong()) {
            Barang09 barangTeratas = tumpukan[top];
            System.out.println("Barang teratas: " + barangTeratas.nama);
            return barangTeratas;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }

    public void tampilkanBarang() {
        if (!cekKosong()) {
            System.out.println("Rincian tumpukan barang di Gudang:");
            for (int i = top; i >= 0; i--) {
            //for (int i = 0; i <= top; i++) {
                System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori); 
            }
        } else {
            System.out.println("Tumpukan barang kosong.");
        }
    }

    public String konversiDesimalKeBiner(int kode) {
        StackKonversi09 stack = new StackKonversi09();
        while (kode != 0) {
            int sisa = kode % 2;
            stack.push(sisa);
            kode = kode / 2;
        }
        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();   
        }
        return biner;
    }

    //Method untuk melihat barang terbawah
    public Barang09 lihatBarangTerbawah() {
        if (!cekKosong()) {
            Barang09 barangTerbawah = tumpukan[0]; //Karena posisi terbawah adalah pada indeks awal stack 
            System.out.println("Barang terbawah: " + barangTerbawah.nama);
            return barangTerbawah;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }

    //Method untuk mencari kode barang dalam tumpukan barang
    public int FindKodeBrg(int cari) {
        if (!cekKosong()) {
            int posisi = -1;
            for (int j = 0; j <= top; j++) {
                if (tumpukan[j].kode == cari) {
                    posisi = j;
                    break;
                } 
            }
            return posisi;     
        } else {
            return -2;
        }
    }

    //Method untuk mencari nama barang dalam tumpukan barang
    public int FindNamaBrg(String cari) {
        if (!cekKosong()) {
            int posisi = -1;
            for (int j = 0; j <= top; j++) {
                if (tumpukan[j].nama.equalsIgnoreCase(cari)) {
                    posisi = j;
                    break;
                } 
            }
            return posisi;     
        } else {
            return -2;
        }
    }

    //Method untuk menampilkan barang (untuk pencarian berdasarkan kode)
    public void TampilKode(int x, int pos) {
        if (pos == -2) {
            System.out.println("Tumpukan barang masih kosong.");
        } else if (pos == -1){
            System.out.println("Barang dengan kode " + x + " tidak ditemukan!");
        } else {
            System.out.printf("Barang dengan kode %d ditemukan!\nBerikut rinciannya:\n", x);
            System.out.println("Kode\t: " + tumpukan[pos].kode);
            System.out.println("Nama\t: " + tumpukan[pos].nama);
            System.out.println("Kategori: " + tumpukan[pos].kategori);
        }
    }

    //Method untuk menampilkan barang (untuk pencarian berdasarkan nama)
    public void TampilName(String y, int pos) {
        if (pos == -2) {
            System.out.println("Tumpukan barang masih kosong.");
        } else if (pos == -1){
            System.out.println("Barang dengan nama " + y + " tidak ditemukan!");
        } else {
            System.out.printf("Barang dengan nama %s ditemukan!\nBerikut rinciannya:\n", y);
            System.out.println("Kode\t: " + tumpukan[pos].kode);
            System.out.println("Nama\t: " + tumpukan[pos].nama);
            System.out.println("Kategori: " + tumpukan[pos].kategori);
        }
    }
}