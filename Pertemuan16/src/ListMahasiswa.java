import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListMahasiswa {
    List<Mahasiswa> mahasiswas = new ArrayList<>();

    public void tambah(Mahasiswa... mahasiswa) {
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    public void update(int index, Mahasiswa mhs) {
        mahasiswas.set(index, mhs);
    }

    public void tampil() {
        mahasiswas.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    int linearSearch(String nim) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    int binarySearch(String nim) {
        List<String> sortedNimList = new ArrayList<>();
        for (Mahasiswa mhs : mahasiswas) {
            sortedNimList.add(mhs.nim);
        }
        Collections.sort(sortedNimList);
        return Collections.binarySearch(sortedNimList, nim);
    }

    public void sortAscending() { //Sorting berdasarkan nama
        Collections.sort(mahasiswas, (m1, m2) -> m1.nama.compareTo(m2.nama));
    }
    
    public void sortDescending() { //Sorting berdasarkan nama
        Collections.sort(mahasiswas, (m1, m2) -> m2.nama.compareTo(m1.nama)); 
    }

    public static void main(String[] args) {
        ListMahasiswa lm = new ListMahasiswa();
        Mahasiswa m = new Mahasiswa("201234", "Noureen", "021xx1");
        Mahasiswa m1 = new Mahasiswa("201235", "Akhleema", "021xx2");
        Mahasiswa m2 = new Mahasiswa("201236", "Shannum", "021xx3");

        lm.tambah(m, m1, m2);
        System.out.println("Sebelum diurutkan:");
        lm.tampil();
        System.out.println("");
        
        lm.sortAscending();
        System.out.println("Setelah diurutkan secara ascending berdasarkan nama:");
        lm.tampil();
        System.out.println("");
        
        lm.sortDescending();
        System.out.println("Setelah diurutkan secara descending berdasarkan nama:");
        lm.tampil();

        lm.update(lm.binarySearch("201235"), new Mahasiswa("201235", "Akhleema Lela"  , "021xx2"));
        System.out.println("");
        lm.tampil();
    }
}