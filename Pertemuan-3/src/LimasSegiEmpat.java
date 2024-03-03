public class LimasSegiEmpat {
    int sisiAlas, tinggi;

    public LimasSegiEmpat(int s, int t) {
        sisiAlas = s;
        tinggi = t;
    }

    public double hitungLuasPermukaan () {
        double tgSg = Math.sqrt(Math.pow(tinggi, 2) + Math.pow(sisiAlas / 2, 2));
        return (Math.pow(sisiAlas, 2)) + (4 * (0.5 * sisiAlas * tgSg));
    }

    public double hitungVolume() {
        return (Math.pow(sisiAlas, 2)) * tinggi / 3;
    }
}