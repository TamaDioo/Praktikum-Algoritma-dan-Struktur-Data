public class ArraySegitiga {
    public static void main(String[] args) {
        Segitiga sgArray[] = new Segitiga[4];

        sgArray[0] = new Segitiga(10, 4);
        sgArray[1] = new Segitiga(20, 10);
        sgArray[2] = new Segitiga(15, 6);
        sgArray[3] = new Segitiga(25, 10);

        for (int i = 0; i < sgArray.length; i++) {
            System.out.printf("Luas segitiga ke %d: %.2f \n", i, sgArray[i].hitungLuas());
            System.out.printf("Keliling segitiga ke %d: %.2f \n", i, sgArray[i].hitungKeliling());
        }
    }
}