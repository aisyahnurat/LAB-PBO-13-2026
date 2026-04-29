package TP_1_H071251087;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nama Karyawan Tetap: ");
        String namaTetap = input.nextLine();
        System.out.print("Masukkan Id " + namaTetap + ": ");
        int idTetap = input.nextInt();
        KaryawanTetap kt = new KaryawanTetap(namaTetap, idTetap);
        System.out.print("Total " + namaTetap + " masuk kerja (hari): ");
        int hadir = input.nextInt();
        for(int i = 0; i < hadir; i++) {
            kt.absen();
        }

        System.out.print("Masukkan Bonus Kinerja: Rp");
        double bonusKinerja = input.nextDouble();
        System.out.println("Total gaji yang " + kt.getNama() + "dapatkan: Rp" + kt.hitungGaji(bonusKinerja));

        System.out.println("------------------------------------------------------------");
        input.nextLine();

        System.out.print("Masukkan Nama Karyawan Kontrak: ");
        String namaKontrak = input.nextLine();
        System.out.print("Masukkan Id " + namaKontrak + ": ");
        int idKontrak = input.nextInt();
        KaryawanKontrak kk = new KaryawanKontrak(namaKontrak, idKontrak);
        System.out.print("Total " + namaKontrak + " masuk kerja (hari): ");
        int kehadiran = input.nextInt();
        for(int i = 0; i < kehadiran; i++) {
            kk.absen();
        }

        System.out.println("Total gaji yang " + kk.getNama() + "dapatkan: Rp" + kk.hitungGaji());
        input.close();
    }
}