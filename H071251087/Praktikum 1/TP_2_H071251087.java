import java.util.Scanner;

public class TP_2_H071251087 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String tanggalInput = input.nextLine(); // Contoh: 17-08-45

        String[] bagian = tanggalInput.split("-");

        if (bagian.length == 3) {
            String hari = bagian[0];
            int indeksBulan = Integer.parseInt(bagian[1]) - 1;
            String tahunSingkat = bagian[2];
            
            String tahunLengkap;
            if (Integer.parseInt(tahunSingkat) > 30) {
                tahunLengkap = "19" + tahunSingkat;
            } else {
                tahunLengkap = "20" + tahunSingkat;
            }

            int hariInt = Integer.parseInt(hari);

            if (indeksBulan >= 0 && indeksBulan < 12) {
                System.out.println("Hasil konversi: " + hariInt + " " + namaBulan[indeksBulan] + " " + tahunLengkap);
            } else {
                System.out.println("Format bulan tidak valid!");
            }
        } else {
            System.out.println("Format salah! Gunakan dd-mm-yy (contoh: 17-08-45)");
        }
    }
}
