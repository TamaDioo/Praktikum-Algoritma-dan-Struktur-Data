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
            System.out.println("Kode Buku\t : " + x);
            System.out.println("Judul\t\t : " + listBk[pos].judulBuku);
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
        int posisi = 2;
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].judulBuku.equalsIgnoreCase(cariJdl)) {
                posisi = j;
                break;
            } else {
                posisi = -1;
            }
        }
        return posisi;
    }

    public Buku09 FindJudulBuku(String cariJdl) {
        int posisi = -1;
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].judulBuku.equalsIgnoreCase(cariJdl)) {
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

    public int FindJdlBinSearch(String cariJdl, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (listBk[mid].judulBuku.equals(cariJdl)) {
                return (mid);
            //Untuk membandingkan String menggunakan compareTo
            } else if (listBk[mid].judulBuku.compareTo(cariJdl) > 0) {
                return FindBinarySearch(cariJdl, left, mid - 1);
            } else {
                return FindBinarySearch(cariJdl, mid + 1, right);
            }
        } 
        return -1;
    }
}