package Kuis2.src;

public class KlasemenMain {
    public static void main(String[] args) {
        Rider[] pembalap = new Rider[25];
        pembalap[0] = new Rider(1, "Francesco Bagnaia", "Italia", "Ducati Lenovo Team", "Ducati");
        pembalap[1] = new Rider(5, "Johann Zarco", "Prancis", "LCR Honda", "Honda");
        pembalap[2] = new Rider(10, "Luca Marini", "Italia", "Repsol Honda Team", "Honda");
        pembalap[3] = new Rider(12, "Maverick Viñales", "Spanyol", "Aprilia Racing", "Aprilia");
        pembalap[4] = new Rider(20, "Fabio Quartararo", "Prancis", "Monster Energy Yamaha MotoGP", "Yamaha");
        pembalap[5] = new Rider(21, "Franco Morbidelli", "Spanyol", "Prima Pramac Racing", "Ducati");
        pembalap[6] = new Rider(23, "Enea Bastianini", "Italia", "Ducati Lenovo Team", "Ducati");
        pembalap[7] = new Rider(25, "Raul Fernandez", "Spanyol", "Trackhouse Racing", "Aprilia");
        pembalap[8] = new Rider(30, "Takaaki Nakagami", "Jepang", "LCR Honda", "Honda");
        pembalap[9] = new Rider(31, "Pedro Acosta", "Spanyol","Red Bull GASGAS Tech3", "KTM");
        pembalap[10] = new Rider(32, "Lorenzo Savadori", "Italia", "Trackhouse Racing", "Aprilia");
        pembalap[11] = new Rider(33, "Brad Binder", "Afrika Selatan", "Red Bull KTM Factory Racing", "KTM");
        pembalap[12] = new Rider(54, "Stefan Bradl", "Jerman", "HRC Test Team", "Honda");
        pembalap[13] = new Rider(36, "Joan Mir", "Spanyol", "Repsol Honda Team", "Honda");
        pembalap[14] = new Rider(37, "Augusto Fernandez", "Spanyol", "Red Bull GASGAS Tech3", "KTM");
        pembalap[15] = new Rider(41, "Aleix Espargaro", "Spanyol", "Aprilia Racing", "Aprilia");
        pembalap[16] = new Rider(42, "Alex Rins", "Spanyol", "Monster Energy Yamaha MotoGP", "Yamaha");
        pembalap[17] = new Rider(43, "Jack Miller", "Inggris", "Red Bull KTM Factory Racing", "KTM");
        pembalap[18] = new Rider(49, "Fabio Di Giannantonio", "Italia", "Pertamina Enduro VR46 Racing Team", "Ducati");
        pembalap[19] = new Rider(51, "Michele Pirro", "Italia", "Prima Pramac Racing", "Ducati");
        pembalap[20] = new Rider(72, "Marco Bezzecchi", "Italia", "Pertamina Enduro VR46 Racing Team", "Ducati");
        pembalap[21] = new Rider(73, "Alex Marquez", "Spanyol", "Gresini Racing MotoGP", "Ducati");
        pembalap[21] = new Rider(93, "Marc Marquez", "Spanyol", "Gresini Racing MotoGP", "Ducati");
        pembalap[22] = new Rider(88, "Miguel Oliveira", "Portugal", "Trackhouse Racing", "Aprilia");
        pembalap[23] = new Rider(89, "Jorge Martin", "Spanyol", "Prima Pramac Racing", "Ducati");
        pembalap[24] = new Rider(26, "Dani Pedrosa", "Spanyol", "Red Bull KTM Factory Racing", "KTM");

        //Posisi finish para pembalap
        short posSR[] = {4, 10, 11, 9, 12, 13, 6, 14, 15, 8, 16, 2, 17, 18, 3, 19, 20, 21, 22, 23, 7, 5, 24, 1, 25};
        short posMR[] = {1, 12, 20, 10, 11, 18, 5, 22, 19, 9, 17, 2, 24, 13, 8, 22, 16, 7, 23, 14, 6, 4, 15, 3, 25};

        KlasemenDLL listPembalap = new KlasemenDLL();
        for (Rider rider : pembalap) {
            listPembalap.addLast(rider);
        }

        for (int i = 0; i < 25; i++) {
            Rider rider = pembalap[i];
            short pos = posSR[i];
            listPembalap.updatePoinSprintRace(rider.nomor, pos);
        }

        for (int i = 0; i < 25; i++) {
            Rider rider = pembalap[i];
            short pos2 = posMR[i];
            listPembalap.updatePoinMainRace(rider.nomor, pos2);
        }

        for (Rider rider : pembalap) {
            rider.updatePoinTotal();
        }
        
        listPembalap.sortPembalapByPoinTotal();

        System.out.println("\nKlasemen MotoGP Musim 2024 - After GP Qatar (Akumulasi Poin):");
        listPembalap.tampilkanKlasemen(listPembalap);

        //Posisi finish para pembalap untuk balapan kedua
        short posSR1[] = {4, 2, 12, 1, 9, 15, 6, 7, 8, 21, 10, 11, 25, 13, 14, 23, 16, 5, 18, 19, 20, 17, 22, 3, 24};
        short posMR1[] = {20, 15, 17, 19, 22, 18, 2, 7, 14, 3, 10, 4, 25, 12, 11, 8, 13, 5, 10, 19, 21, 16, 9, 1, 24};

        for (int i = 0; i < 25; i++) {
            Rider rider = pembalap[i];
            short pos3 = posSR1[i];
            listPembalap.updatePoinSprintRace(rider.nomor, pos3);
        }

        for (int i = 0; i < 25; i++) {
            Rider rider = pembalap[i];
            short pos4 = posMR1[i];
            listPembalap.updatePoinMainRace(rider.nomor, pos4);
        }

        for (Rider rider : pembalap) {
            rider.updatePoinTotal();
        }

        listPembalap.sortPembalapByPoinTotal();

        System.out.println("\nKlasemen MotoGP Musim 2024 - After GP Portugal (Akumulasi Poin):");
        listPembalap.tampilkanKlasemen(listPembalap);
    }
}