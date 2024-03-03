public class Bola {
    int jari2;

    public Bola (int r) {
        jari2 = r;
    }

    public double hitungLuasPermukaan () {
        return 4 * Math.PI * Math.pow(jari2, 2);
    }

    public double hitungVolume() {
        return 4 * Math.PI * Math.pow(jari2, 3) / 3;
    }
}