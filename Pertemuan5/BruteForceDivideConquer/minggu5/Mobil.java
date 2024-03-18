package Pertemuan5.BruteForceDivideConquer.minggu5;

public class Mobil {
    String merk, tipe;
    int tahun, top_accel, top_power;

    public Mobil(String merk, String tipe, int tahun, int top_accel, int top_power) {
        this.merk = merk;
        this.tipe = tipe;
        this.tahun = tahun;
        this.top_accel = top_accel;
        this.top_power = top_power;
    }
 
    //Method untuk mencari top_acceleration tertinggi menggunakan Divide and Conquer
    int maxAcceleration(Mobil[] mbl, int left, int right) {
        if (left == right) {
            return mbl[left].top_accel;
        }
        
        int mid = (left + right) / 2;
        int maxLeft = maxAcceleration(mbl, left, mid);
        int maxRight = maxAcceleration(mbl, mid + 1, right);
        
        if (maxLeft > maxRight) {
            return maxLeft;
        } else {
            return maxRight;
        }
    }
    
    //Method untuk mencari top_acceleration terendah menggunakan Divide and Conquer
    int minAcceleration(Mobil[] mbl, int left, int right) {
        if (left == right) {
            return mbl[left].top_accel;
        }
        
        int mid = (left + right) / 2;
        int minLeft = minAcceleration(mbl, left, mid);
        int minRight = minAcceleration(mbl, mid + 1, right);
        
        if (minLeft < minRight) {
            return minLeft;
        } else {
            return minRight;
        }
    }

    //Method untuk menghitung rata-rata top power dari seluruh mobil
    double topPower(Mobil mbl[]) {
        int sum = 0;
        for (int j = 0; j < mbl.length; j++) {
            sum += mbl[j].top_power;
        }
        return (double) sum / mbl.length;
    }  
}