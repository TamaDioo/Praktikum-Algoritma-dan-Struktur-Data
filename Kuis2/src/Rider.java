package Kuis2.src;

public class Rider {
    int nomor;
    String nama, tim, country, konstruktor;
    int poinMain, poinSprint, totalPoin;
    short posMain, posSprint;
    Rider next, prev;

    public Rider(int no, String nama, String country, String tim, String kons) {
        nomor = no;
        this.nama = nama;
        this.tim = tim;
        this.country = country;
        konstruktor = kons;
        this.poinMain = 0;
        this.poinSprint = 0;
        this.totalPoin = 0;
    }

    public void setPoinSprintRace(int poinSprintRace) {
        poinSprint += poinSprintRace;    
    }

    public void setPoinMainRace(int poinMainRace) {
        poinMain += poinMainRace;
    }

    public void updatePoinTotal() {
        this.totalPoin = poinMain + poinSprint;
    }

    public Rider getNext() {
        return next;
    }

    public void setNext(Rider next) {
        this.next = next;
    }

    public Rider getPrev() {
        return prev;
    }

    public void setPrev(Rider prev) {
        this.prev = prev;
    }

    public int cvrtposSR(short pos) {
        switch (pos) {
            case 1: return 12;
            case 2: return 9;
            case 3: return 7;
            case 4: return 6;
            case 5: return 5;
            case 6: return 4;
            case 7: return 3;
            case 8: return 2;
            case 9: return 1;
            default: return 0;
        }
    }

    public int cvrtposMR(short pos) {
        switch (pos) {
            case 1: return 25;
            case 2: return 20;
            case 3: return 16;
            case 4: return 13;
            case 5: return 11;
            case 6: return 10;
            case 7: return 9;
            case 8: return 8;
            case 9: return 7;
            case 10: return 6;
            case 11: return 5;
            case 12: return 4;
            case 13: return 3;
            case 14: return 2;
            case 15: return 1;
            default: return 0;
        }
    }
}