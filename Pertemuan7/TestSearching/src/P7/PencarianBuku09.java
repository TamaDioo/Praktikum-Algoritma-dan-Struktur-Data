package P7;

public class PencarianBuku09 {
    Buku09 listBk[] = new Buku09[5];
    int idx;

    void tambah(Buku09 m) {
        if (idx < listBk.length) {
            listBk[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    void tampil() {
        for (Buku09 m : listBk) {
            m.tampilDataBuku();
        }
    }

    public int FindSeqSearch(String cari) {
        int posisi = 2;
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].kodeBuku.equals(cari)) {
                posisi = j;
                break;
            } else {
                posisi = -1;
            }
        }
        return posisi;
    }

    public void Tampilposisi(String x, int pos) {
        if (pos != -1) {
            System.out.println("data : " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("data : " + x + " tidak ditemukan");
        }
    }

    public void TampilData(String x, int pos) {
        if (pos != -1) {
            System.out.println("Kode Buku\t : " + listBk[pos].kodeBuku);
            System.out.println("Judul\t\t : " + x);
            System.out.println("Tahun Terbit\t : " + listBk[pos].tahunTerbit);
            System.out.println("Pengarang\t : " + listBk[pos].pengarang);
            System.out.println("Stock\t\t : " + listBk[pos].stock);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    public int FindBinarySearch(String cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (listBk[mid].kodeBuku.equals(cari)) {
                return (mid);
            //Untuk membandingkan string menggunakan compareTo
            } else if (listBk[mid].kodeBuku.compareTo(cari) > 0) {
                return FindBinarySearch(cari, left, mid - 1);
            } else {
                return FindBinarySearch(cari, mid + 1, right);
            }
        } 
        return -1;
    }

    public Buku09 FindBuku(String cari) {
        int posisi = -1;
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].kodeBuku.equals(cari)) {
                posisi = j;
                break;
            } else {
                posisi = -1;
            }
        }
        if (posisi == -1) {
            return null; // Mengembalikan null jika kodeBuku tidak ditemukan
        } else {
            return listBk[posisi];
        }
    }

    public int FindJudulSeqSearch(String cariJdl) {
        int posisi = -1; // // Ubah posisi awal menjadi -1 
        int hitungHasil = 0; // Variabel untuk menghitung hasil pencarian judul buku yang lebih dari 1 hasil
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].judulBuku.equalsIgnoreCase(cariJdl)) {
                posisi = j;
                hitungHasil++; // increment 1 ke jumlahHasil jika judul ditemukan
            } 
        }
        // Memeriksa apakah hasil pencarian lebih dari satu
        if (hitungHasil > 1) {
            //Jika hasil pencarian lebih dari satu maka akan mencetak peringatan
            System.out.printf("Terdapat lebih dari satu hasil pencarian buku dengan judul %s !\n", cariJdl);
        }
        return posisi;
    }

    public Buku09 FindJudulBuku(String cariJdl) {
        int posisi = -1;
        int hitungHasil = 0; // Variabel untuk menghitung hasil pencarian judul buku yang lebih dari 1 hasil
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].judulBuku.equalsIgnoreCase(cariJdl)) {
                posisi = j;
                hitungHasil++; // increment 1 ke jumlahHasil jika judul ditemukan
            } 
        }

        // Memeriksa apakah hasil pencarian lebih dari satu
        if (hitungHasil > 1) {
            //Jika hasil pencarian lebih dari satu maka akan mencetak peringatan
            System.out.printf("Terdapat lebih dari satu hasil pencarian buku dengan judul %s !\n", cariJdl);
        }

        if (posisi == -1) {
            return null; // Mengembalikan null jika kodeBuku tidak ditemukan
        } else {
            return listBk[posisi];
        }
    }

    public int FindJdlBinSearch(String cariJdl, int left, int right) {
        int mid;
        int hitungHasil = 0; // Variabel untuk menghitung hasil pencarian judul buku yang lebih dari 1 hasil
        if (right >= left) {
            mid = (left + right) / 2;
            if (listBk[mid].judulBuku.equalsIgnoreCase(cariJdl)) {
                hitungHasil++; // increment 1 ke jumlahHasil jika judul ditemukan
                    
                // Mencari hasil pencarian di sebelah kiri mid
                int kiri = mid - 1;
                while ((mid - 1) >= left && listBk[kiri].judulBuku.equalsIgnoreCase(cariJdl)) {
                    hitungHasil++; // increment 1 ke jumlahHasil jika judul ditemukan
                    kiri--;
                }

                // Mencari hasil pencarian di sebelah kanan mid
                int kanan = mid + 1;
                while (kanan <= right && listBk[kanan].judulBuku.equalsIgnoreCase(cariJdl)) {
                    hitungHasil++; // increment 1 ke jumlahHasil jika judul ditemukan
                    kanan++;
                }

                // Memeriksa apakah hasil pencarian lebih dari satu
                if (hitungHasil > 1) {
                    System.out.printf("Terdapat lebih dari satu hasil pencarian buku dengan judul %s !\n", cariJdl);
                }

                return (mid);
            //Untuk membandingkan String menggunakan compareTo
            } else if (listBk[mid].judulBuku.compareToIgnoreCase(cariJdl) > 0) {
                return FindJdlBinSearch(cariJdl, left, mid - 1);
            } else {
                return FindJdlBinSearch(cariJdl, mid + 1, right);
            }
        } 
        return -1;
    }

    //Sorting kode buku menggunakan insertion sort (ascending)
    void insertionSortKodeBK() {
        for (int i = 1; i < listBk.length; i++) {
            Buku09 temp = listBk[i];
            int j = i;
            while (j > 0 && listBk[j - 1].kodeBuku.compareToIgnoreCase(temp.kodeBuku) > 0) {
                listBk[j] = listBk[j - 1];
                j--;
            }
            listBk[j] = temp;
        }
    }

    //Sorting judul buku menggunakan insertion sort (ascending)
    void selectionSortJdl() {
        for (int i = 0; i < listBk.length-1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < listBk.length; j++) {
                if (listBk[j].judulBuku.compareToIgnoreCase(listBk[idxMin].judulBuku) < 0) {
                    idxMin = j;
                }
            }
            //swap
            Buku09 tmp = listBk[idxMin];
            listBk[idxMin] = listBk[i];
            listBk[i] = tmp;   
        }
    }
}