public class Mahasiswa {
    String nama, nim;
    char jeniskelamin;
    double ipk;

    public double rataIpk(Mahasiswa[] mhs) {
        double total = 0;
        for (Mahasiswa x : mhs) {
            total += x.ipk;
        }

        return (total / mhs.length);
    }

    public void ipkTertinggi(Mahasiswa[] mhs) {
        double ipkTertinggi = 0;
        Mahasiswa ipkTerbesar = null;
        for (int i = 0; i < mhs.length; i++) {
            if (mhs[i].ipk > ipkTertinggi) {
                ipkTertinggi = mhs[i].ipk;
                ipkTerbesar = mhs[i];
            }
        }

        System.out.println("===============================");  
        System.out.println("Mahasiswa dengan IPK terbesar");
        System.out.printf("Nama : %s \n", ipkTerbesar.nama);
        System.out.printf("NIM : %s \n", ipkTerbesar.nim);
        System.out.printf("Jenis Kelamin : %s \n", ipkTerbesar.jeniskelamin);
        System.out.printf("Nilai IPK : %.2f \n", ipkTerbesar.ipk);
        System.out.println("===============================");  
    }
}