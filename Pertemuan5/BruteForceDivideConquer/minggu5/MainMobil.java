package Pertemuan5.BruteForceDivideConquer.minggu5;

public class MainMobil {
    public static void main(String[] args) {
        Mobil mobil[] = new Mobil[8];

        mobil[0] = new Mobil("BMW", "M2 Coupe", 2016, 6816, 728);
        mobil[1] = new Mobil("Ford", "Fiesta ST", 2014, 3921, 575);
        mobil[2] = new Mobil("Nissan", "370Z", 2009, 4360, 657);
        mobil[3] = new Mobil("Subaru", "BRZ", 2014, 4058, 609);
        mobil[4] = new Mobil("Subaru", "Impreza WRX STI", 2013, 6255, 703);
        mobil[5] = new Mobil("Toyota", "AE86 Trueno", 1986, 3700, 553);
        mobil[6] = new Mobil("Toyota", "86/GT86", 2014, 4180, 609);
        mobil[7] = new Mobil("Volkswagen", "Golf GTI", 2014, 4180, 631);

        //Karena saya membuat methodnya dalam class Mobil, maka saya bisa mengakses method melalui objek dalam array mobil.
        //Untuk indeks array of objek yang ingin diakses methodnya bebas asalkan masih dalam array of objek mobil.
        //Karena semua indeks outputnya sama kecuali jika indeks melebihi atau sama dengan panjang array of objek maka akan error.  
        System.out.println("Top acceleration tertinggi: " + mobil[3].maxAcceleration(mobil, 0, mobil.length - 1));
        System.out.println("Top acceleration teremdah: " + mobil[1].minAcceleration(mobil, 0, mobil.length - 1));
        System.out.println("Rata-rata top power dari seluruh mobil: " + mobil[4].topPower(mobil));
    }
}