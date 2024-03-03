import java.util.Scanner;

public class ArrayBangunRuang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========================================================== ");
        System.out.println("program perhitungan luas permukaan dan volume bangun ruang ");
        System.out.println("========================================================== ");

        System.out.print("Masukkan jumlah bangun ruang kerucut: ");
        int krc = sc.nextInt();

        Kerucut[] krcArray = new Kerucut[krc];

        for (int i = 0; i < krcArray.length; i++) { 
            System.out.println("Kerucut ke-" + i);
            System.out.print("Masukkan jari-jari kerucut: ");
            int jari2 = sc.nextInt(); 
            System.out.print("Masukkan sisi miring kerucut: ");
            int sisiMrg = sc.nextInt(); 
            krcArray[i] = new Kerucut(jari2, sisiMrg);        
        }          
    
        System.out.println("============================================");

        System.out.print("Masukkan jumlah bangun ruang limas segi empat sama sisi: ");
        int lms = sc.nextInt();

        LimasSegiEmpat[] lmsArray = new LimasSegiEmpat[lms];

        for (int j = 0; j < lmsArray.length; j++) { 
            System.out.println("Limas segi empat sama sisi ke-" + j);
            System.out.print("Masukkan sisi alas limas segi empat sama sisi: ");
            int sisiAlas = sc.nextInt(); 
            System.out.print("Masukkan tinggi limas segi empat sama sisi: ");
            int tinggi = sc.nextInt(); 
            lmsArray[j] = new LimasSegiEmpat(sisiAlas, tinggi);        
        }          
    
        System.out.println("============================================");

        System.out.print("Masukkan jumlah bangun ruang bola: ");
        int bola = sc.nextInt();

        Bola[] bolaArray = new Bola[bola];

        for (int o = 0; o < bolaArray.length; o++) {
            System.out.println("Bola ke-" + o);
            System.out.print("Masukkan jari-jari bola: ");
            int jari2 = sc.nextInt(); 
            bolaArray[o] = new Bola(jari2);        
        }          
    
        System.out.println("============================================ ");
        System.out.println("Hasil perhitungan luas permukaan dan volume ");
        System.out.println("============================================ ");

        for (int k = 0; k < krcArray.length; k++) {
            System.out.printf("Luas permukaan kerucut ke %d: %.2f \n", k, krcArray[k].hitungLuasPermukaan());
            System.out.printf("Volume kerucut ke %d: %.2f \n", k, krcArray[k].hitungVolume());
        }

        System.out.println("============================================");

        for (int l = 0; l < lmsArray.length; l++) {
            System.out.printf("Luas permukaan limas segi empat sama sisi ke %d: %.2f \n", l, lmsArray[l].hitungLuasPermukaan());
            System.out.printf("Volume limas segi empat sama sisi ke %d: %.2f \n", l, lmsArray[l].hitungVolume());
        }
        
        System.out.println("============================================");

        for (int b = 0; b < bolaArray.length; b++) {
            System.out.printf("Luas permukaan bola ke %d: %.2f \n", b, bolaArray[b].hitungLuasPermukaan());
            System.out.printf("Volume bola ke %d: %.2f \n", b, bolaArray[b].hitungVolume());
        }

        sc.close();
    }
}