package TP_1_H071251087;

public abstract class Karyawan {
    private String nama;
    private int idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, int idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    void absen() {
        jumlahKehadiran++;
    }

    public String getNama() {
        return this.nama;
    }
    public int getIdKaryawan() {
        return this.idKaryawan;
    }
    public int getJumlahKehadiran() {
        return this.jumlahKehadiran;
    }

    public abstract double hitungGaji();
}

class KaryawanTetap extends Karyawan {
    private double gajiPokok = 3000000;
    private double tunjanganMakan = 40000;

    public KaryawanTetap(String nama, int idKaryawan) {
        super(nama, idKaryawan);
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
    }
    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}

class KaryawanKontrak extends Karyawan {
    private double upahPerHari = 100000;

    public KaryawanKontrak(String nama, int idKaryawan) {
        super(nama, idKaryawan);
    }
    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * getJumlahKehadiran();

        if (getJumlahKehadiran() > 20) {
            totalGaji += 500000;
        }
        return totalGaji;
    }
}