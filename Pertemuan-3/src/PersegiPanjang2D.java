import java.util.Scanner;

public class PersegiPanjang2D {
    public static void main(String[] args) {
        PersegiPanjang[][] ppArray = new PersegiPanjang[3][2];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j= 0; j < 2; j++) {
                ppArray[i][j] = new PersegiPanjang();
                System.out.println("Persegi panjang pada baris ke-" + i + " kolom ke-" + j);
                System.out.print("Masukkan panjang: ");
                ppArray[i][j].panjang = sc.nextInt();
                System.out.print("Masukkan lebar: ");
                ppArray[i][j].lebar = sc.nextInt();
            }          
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Persegi panjang pada baris ke-" + i + " kolom ke -" +j);
                System.out.println("panjang: " + ppArray[i][j].panjang + ", lebar: " + ppArray[i][j].lebar);
            }      
        }

        sc.close();
        
    }
}