import java.util.Scanner;

public class TP_3_H071251087 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan password: ");
        String password = input.nextLine();

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;
        boolean panjangCukup = password.length() >= 8;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(c)) {
                adaAngka = true;
            }
        }

        System.out.println("\n--- Hasil Validasi ---");
        if (panjangCukup && adaHurufBesar && adaHurufKecil && adaAngka) {
            System.out.println("Status: Password KUAT dan VALID.");
        } else {
            System.out.println("Status: Password LEMAH!");
            System.out.println("Kesalahan:");
            if (!panjangCukup) System.out.println("Minimal harus 8 karakter");
            if (!adaHurufBesar) System.out.println("Harus mengandung huruf BESAR");
            if (!adaHurufKecil) System.out.println("Harus mengandung huruf kecil");
            if (!adaAngka) System.out.println("Harus mengandung angka");
        }
    }
}
