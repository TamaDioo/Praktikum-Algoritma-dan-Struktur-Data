package Pertemuan11.minggu11;

public class Mahasiswa {
    int NIM;
    String nama;
    Mahasiswa next;

    Mahasiswa(int nim, String nama, Mahasiswa berikutnya) {
        NIM = nim;
        this.nama = nama;
        next = berikutnya;
    }

    Mahasiswa() {
        
    }
}