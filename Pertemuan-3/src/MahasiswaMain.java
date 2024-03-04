import java.util.Scanner;
public class MahasiswaMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        Mahasiswa[] mhsArray = new Mahasiswa[3];

        for (int i = 0; i < mhsArray.length; i++) { 
            mhsArray[i] = new Mahasiswa();
            System.out.printf("Masukkan data mahasiswa ke-%d \n", (i + 1));
            System.out.print("Masukkan nama : ");
            mhsArray[i].nama = input.nextLine(); 
            System.out.print("Masukkan NIM : ");
            mhsArray[i].nim = input.nextLine(); 
            System.out.print("Masukkan jenis kelamin : ");
            mhsArray[i].jeniskelamin = input.nextLine().toUpperCase().charAt(0); 
            System.out.print("Masukkan IPK : ");
            mhsArray[i].ipk = sc.nextDouble();  
            System.out.println("===============================");  
        }

        System.out.println();

        for (int j = 0; j < mhsArray.length; j++) {
            System.out.printf("Data Mahasiswa ke-%d \n", (j + 1));
            System.out.printf("Nama : %s \n", mhsArray[j].nama);
            System.out.printf("NIM : %s \n", mhsArray[j].nim);
            System.out.printf("Jenis Kelamin : %s \n", mhsArray[j].jeniskelamin);
            System.out.printf("Nilai IPK : %.2f \n", mhsArray[j].ipk);
            System.out.println("===============================");  
        }

        System.out.println();

        Mahasiswa mhs = new Mahasiswa();
        System.out.printf("Rata-rata IPK : %.2f \n", mhs.rataIpk(mhsArray));  
        System.out.println();  
        mhs.ipkTertinggi(mhsArray);

        input.close();
        sc.close();
    }
}