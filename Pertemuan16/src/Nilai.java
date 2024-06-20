public class Nilai {
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    double nilai;

    public Nilai(Mahasiswa mahasiswa, MataKuliah mataKuliah, double nilai) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilai = nilai;
    }

    public double getNilai() {
        return nilai;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-42s%-10s%-5.2f%n", mahasiswa.nim, mahasiswa.nama, mataKuliah.nama, mataKuliah.sks, nilai);
    }
}