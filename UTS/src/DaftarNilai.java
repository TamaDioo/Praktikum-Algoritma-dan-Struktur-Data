package UTS.src;

public class DaftarNilai {
    Nilai listNilai[] = new Nilai[17];
    int idx;

    void tambah(Nilai m) {
        if (idx < listNilai.length) {
            listNilai[idx] = m;
            idx++;
        } else {
            System.out.println("Nilai sudah penuh!");
        }
    }

    void tampil() {
        for (Nilai m : listNilai) {
            m.tampilNilai();
        }
        System.out.println();
    }

    public void Tampilposisi(int x, int pos) {
        if (pos != -1) {
            System.out.println("Nilai " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("Nilai " + x + " tidak ditemukan");
        }
    }

    public int FindBinarySearch(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listNilai[mid].nilai) {
                return (mid);
            } 

            int findLeft = FindBinarySearch(cari, left, mid - 1);
            if (findLeft != -1) {
                return findLeft;
            }

            int findRight = FindBinarySearch(cari, mid + 1, right);
            if (findRight != -1) {
                return findRight;
            }
        } 
        return -1;  
    }

    public int FindBinarySearchAsc(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listNilai[mid].nilai) {
                return (mid);
            } else if (listNilai[mid].nilai > cari) {
                return FindBinarySearchAsc(cari, left, mid - 1);
            } else {
                return FindBinarySearchAsc(cari, mid + 1, right);
            }
        } 
        return -1;
    }

    public int FindBinarySearchDesc(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listNilai[mid].nilai) {
                return (mid);
            } else if (listNilai[mid].nilai < cari) {
                return FindBinarySearchDesc(cari, left, mid - 1);
            } else {
                return FindBinarySearchDesc(cari, mid + 1, right);
            }
        } 
        return -1;
    }

    //Sorting secara ascending menggunakan selection sort
    void sortAscending() {
        for (int i = 0; i < listNilai.length-1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < listNilai.length; j++) {
                if (listNilai[j].nilai < listNilai[idxMin].nilai) {
                    idxMin = j;
                }
            }
            //proses swap/pertukaran
            Nilai tmp = listNilai[idxMin];
            listNilai[idxMin] = listNilai[i];
            listNilai[i] = tmp;   
        }
    }

    //Sorting secara descending menggunakan insertion sort
    void sortDescending() {
        for (int i = 1; i < listNilai.length; i++) {
            Nilai temp = listNilai[i];
            int j = i;
            while (j > 0 && listNilai[j - 1].nilai < temp.nilai) {
                listNilai[j] = listNilai[j - 1];
                j--;
            }
            listNilai[j] = temp;
        }
    }
}