import java.util.Scanner;

public class TP_1_H071251087 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Masukkan Judul Film: ");
        String judul = input.nextLine();
        
        String[] kata = judul.split(" ");
        String hasil = "";

        for (String k : kata) {
            if (k.length() > 0) {
                String awal = k.substring(0, 1).toUpperCase();
                String sisa = k.substring(1).toLowerCase();

                hasil += awal + sisa + " ";
            }
        }
        System.out.println(hasil.trim());
    }
}
