public class Kerucut {
    int jari2, sisiMrg;

    public Kerucut (int r, int sMrg) {
        jari2 = r;
        sisiMrg = sMrg;
    }

    public double hitungLuasPermukaan () {
        return (Math.PI * Math.pow(jari2, 2) + (Math.PI * jari2 * sisiMrg)); 
    }

    public double hitungVolume() {
        double tinggi = (Math.sqrt(Math.pow(sisiMrg, 2) - Math.pow(jari2, 2)));
        return Math.PI * Math.pow(jari2, 2) * tinggi / 3;
    }
}