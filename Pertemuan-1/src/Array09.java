import java.util.Scanner;
public class Array09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] nilaiMatkul = new double[8];
        String[] matKul = {"Pancasila", "Konsep Teknologi Informasi", "Critical Thinking dan Problem Solving", "Matematika Dasar", "Bahasa Inggris", "Dasar Pemrograman", "Praktikum Dasar Pemrograman", "Keselamatan dan Kesehatan Kerja"};
        String nilaiHuruf[] = new String[8];
        float nilaiSetara[] = new float[8];

        System.out.println("==============================");
        System.out.println("program Menghitung IP Semester");
        System.out.println("==============================");

        for (int i = 0; i < matKul.length; i++) {
            System.out.print("Masukkan nilai untuk MK " + matKul[i] + " : ");
            nilaiMatkul[i] = input.nextFloat();

            if (nilaiMatkul[i] <= 100 && nilaiMatkul[i] >= 0) {  
                if (nilaiMatkul[i] > 80 && nilaiMatkul[i] <= 100) {
                    nilaiSetara[i] = 4.00f;
                    nilaiHuruf[i] = "A";
                } else if (nilaiMatkul[i] > 73 && nilaiMatkul[i] <= 80) {
                    nilaiSetara[i] = 3.50f;
                    nilaiHuruf[i] = "B+";                       
                } else if (nilaiMatkul[i] > 65 && nilaiMatkul[i] <= 73) {
                    nilaiSetara[i] = 3.00f;
                    nilaiHuruf[i] = "B";
                } else if (nilaiMatkul[i] > 60 && nilaiMatkul[i] <= 65) {
                    nilaiSetara[i] = 2.50f;
                    nilaiHuruf[i] = "C+";
                } else if (nilaiMatkul[i] > 50 && nilaiMatkul[i] <= 60) {
                    nilaiSetara[i] = 2.00f;
                    nilaiHuruf[i] = "C";
                } else if (nilaiMatkul[i] > 39 && nilaiMatkul[i] <= 50) {
                    nilaiSetara[i] = 1.00f;
                    nilaiHuruf[i] = "D";
                } else if (nilaiMatkul[i] <= 39) {
                    nilaiSetara[i] = 0;
                    nilaiHuruf[i] = "E";
                } 
            } else {
                nilaiMatkul[i] = 0;
            }
        }

        System.out.println("==============================");
        System.out.println("Hasil Konversi Nilai");
        System.out.println("==============================");

        System.out.printf("%-43s%-18s%-18s%-18s%n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        
        for (int j = 0; j < matKul.length; j++) {
            System.out.printf("%-43s%-18.2f%-18s%-18.2f%n", matKul[j], nilaiMatkul[j], nilaiHuruf[j], nilaiSetara[j]);
        }
        
        int[] sks = {2, 2, 2, 3, 2, 2, 3, 2};
        int jmlSks = 0;
        float nilaiTotal = 0;

        for (int i = 0; i < sks.length; i++) {
            jmlSks += sks[i];
            nilaiTotal += (nilaiSetara[i] * sks[i]);
        }
        
        float ip = (nilaiTotal / jmlSks);
        System.out.println("==============================");
        System.out.printf("IP : %.2f", ip );

    }
}