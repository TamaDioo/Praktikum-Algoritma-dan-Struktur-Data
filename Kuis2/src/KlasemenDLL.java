package Kuis2.src;

public class KlasemenDLL {
    Rider head, tail;
    int size;

    public KlasemenDLL() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Rider pembalap) {
        if (isEmpty()) {
            head = pembalap;
        } else {
            pembalap.setNext(head);
            head.setPrev(pembalap);
            head = pembalap;
        }
    }

    public void addLast(Rider pembalap) {
        if (tail == null) {
            head = pembalap;
            tail = pembalap;
        } else {
            pembalap.setPrev(tail);
            tail.setNext(pembalap);
            tail = pembalap;
        }
    }

    public Rider findPembalapByNo(int id) {
        Rider current = head;
        while (current != null) {
            if (current.nomor == id) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void updatePoinSprintRace(int id, short pos) {
        Rider pembalap = findPembalapByNo(id);
        if (pembalap != null) {
            int poinSR = pembalap.cvrtposSR(pos);
            pembalap.setPoinSprintRace(poinSR);
            pembalap.updatePoinTotal();
        }
    }

    public void updatePoinMainRace(int id, short pos) {
        Rider pembalap = findPembalapByNo(id);
        if (pembalap != null) {
            int poinMR = pembalap.cvrtposMR(pos);
            pembalap.setPoinMainRace(poinMR);
            pembalap.updatePoinTotal();
        }
    }
    
    public Rider sortPembalapByPoinTotal() {
        Rider current = head;
        while (current != null) {
            Rider next = current.getNext();
            while (next != null) {
                if (current.totalPoin < next.totalPoin) {
                    // Swap total poin
                    // Swap poin Main Race
                    int tempMainPoin = current.poinMain;
                    current.poinMain = next.poinMain;
                    next.poinMain = tempMainPoin;
                    // Swap poin Sprint Race
                    int tempSprintPoin = current.poinSprint;
                    current.poinSprint = next.poinSprint;
                    next.poinSprint = tempSprintPoin;
                    int tempPoin = current.totalPoin;
                    current.totalPoin = next.totalPoin;
                    next.totalPoin = tempPoin;
                    // Swap nama
                    String tempNama = current.nama;
                    current.nama = next.nama;
                    next.nama = tempNama;
                    // Swap tim
                    String tempTim = current.tim;
                    current.tim = next.tim;
                    next.tim = tempTim;
                    // Swap country
                    String tempCountry = current.country;
                    current.country = next.country;
                    next.country = tempCountry;
                    // Swap konstruktor
                    String tempKons = current.konstruktor;
                    current.konstruktor = next.konstruktor;
                    next.konstruktor = tempKons;
                    
                }
                next = next.getNext();
            }
            current = current.getNext();
        }
        return head; 
    }

    void tampilkanKlasemen(KlasemenDLL listRider) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| Posisi | Pembalap                  | Kebangsaaan     | Tim                                 | Konstruktor | Grand Pix | Sprint Race | Total Poin |\n");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        int i = 1;
        Rider current = listRider.head;
        while (current != null) {
            System.out.printf("| %6d | %-25s | %-15s | %-35s | %-11s | %9d | %11d | %10d |\n", i, current.nama, current.country, current.tim, current.konstruktor, current.poinMain, current.poinSprint, current.totalPoin);
            i++;
            current = current.next;
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}