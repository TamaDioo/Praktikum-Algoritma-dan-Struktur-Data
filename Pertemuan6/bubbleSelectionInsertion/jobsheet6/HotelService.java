package Pertemuan6.bubbleSelectionInsertion.jobsheet6;

public class HotelService {
    Hotel[] rooms = new Hotel[5];
    int idx;

    void tambah(Hotel H) {
        if (idx < rooms.length) {
            rooms[idx] = H;
            idx++;
        } else {
            System.out.println("Data sudah penuh!!");
        }
    }

    void tampilAll() {
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Nama Penginapan : " + rooms[i].nama);
            System.out.println("Kota            : " + rooms[i].kota);
            System.out.println("Harga           : " + rooms[i].harga);
            System.out.println("Rating          : " + rooms[i].bintang);
            System.out.println("--------------------------");
        }
    }

    void bubbleSortHarga() {
        for (int i = 0; i < rooms.length-1; i++) {
            for (int j = 1; j < rooms.length-i; j++) {
                if (rooms[j].harga < rooms[j-1].harga) {
                    //Proses swap atau pertukaran
                    Hotel tmp = rooms[j];
                    rooms[j] = rooms[j-1];
                    rooms[j-1] = tmp;
                }
            }
        }   
    }

    void bubbleSortRating() {
        for (int i = 0; i < rooms.length-1; i++) {
            for (int j = 1; j < rooms.length-i; j++) {
                if (rooms[j].bintang > rooms[j-1].bintang) {
                    //Proses swap atau pertukaran
                    Hotel tmp = rooms[j];
                    rooms[j] = rooms[j-1];
                    rooms[j-1] = tmp;
                }
            }
        }  
    }

    void selectionSortHarga() {
        for (int i = 0; i < rooms.length-1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < rooms.length; j++) {
                if (rooms[j].harga < rooms[idxMin].harga) {
                    idxMin = j;
                }
            }
            //swap
            Hotel tmp = rooms[idxMin];
            rooms[idxMin] = rooms[i];
            rooms[i] = tmp;   
        }
    }

    void selectionSortRating() {
        for (int i = 0; i < rooms.length-1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < rooms.length; j++) {
                if (rooms[j].bintang > rooms[idxMin].bintang) {
                    idxMin = j;
                }
            }
            //swap
            Hotel tmp = rooms[idxMin];
            rooms[idxMin] = rooms[i];
            rooms[i] = tmp;   
        }
    }
}