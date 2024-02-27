public class Fungsi09 {
    public static void main(String[] args) {
        int[][] stock = {
            {10, 5, 15, 7},
            {6, 11, 9, 12},
            {2, 10, 10, 5},
            {5, 7, 12, 9}
        };

        int[] harga = {75000, 50000, 60000, 10000};
        String[] jenisBunga = {"Aglonema", "Keladi", "Alocasia", "Mawar"};

        System.out.println("========================");
        System.out.println("Pendapatan setiap cabang");
        System.out.println("========================");
        System.out.println();
        tampilPendapatan(stock, harga, jenisBunga);
        System.out.println();
        tampilStokRG4(stock, jenisBunga);
    }

    public static void tampilPendapatan(int[][] x, int [] y, String[] jenis)  {
        System.out.printf("%-20s%-18s%-18s%-18s%-18s%-18s%n", "", jenis[0], jenis[1], jenis[2], jenis[3], "Total Pendapatan");
        for (int i = 0; i < x.length; i++) {
            int totalPendapatan = 0;
            for (int j = 0; j < x[i].length; j++) {
                totalPendapatan += x[i][j] * y[j];
            }
            System.out.printf("%-20s%-18s%-18s%-18s%-18s%-18s%n","RoyalGarden " + (i + 1), x[i][0], x[i][1], x[i][2], x[i][3], " Rp " + totalPendapatan);
        }
    }

    public static void tampilStokRG4(int[][] x, String[] jenis) {
        System.out.println("====================================");
        System.out.println("Stok awal bunga cabang RoyalGarden 4");
        System.out.println("====================================");
        for (int i = 0; i < x[3].length; i++) {
            System.out.println(jenis[i] + ": " + x[3][i]);
        }
        System.out.println();
        
        x[3][0] -= 1;
        x[3][1] -= 2;
        x[3][2] -= 0;
        x[3][3] -= 5;

        System.out.println("================================================================");
        System.out.println("Sisa stok bunga cabang RoyalGarden 4 setelah ada bunga yang mati");
        System.out.println("================================================================");

        for (int i = 0; i < x[3].length; i++) {
            System.out.println(jenis[i] + ": " + x[3][i]);
        }       
    }
}