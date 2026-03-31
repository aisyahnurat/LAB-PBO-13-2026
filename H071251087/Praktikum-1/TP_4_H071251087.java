import java.util.Scanner;

public class TP_4_H071251087 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Input : ");
        int n = input.nextInt();
        
        long hasil = hitungFaktorial(n);
        
        System.out.println("Output : " + hasil);
    }

    public static long hitungFaktorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * hitungFaktorial(n - 1);
        }
    }
}
