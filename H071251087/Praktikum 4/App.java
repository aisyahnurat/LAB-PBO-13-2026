import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Product> daftarProduk = new ArrayList<>();
        daftarProduk.add(new Smartphone("Samsung", 111111, "Jet Black", 256, 1050.10));
        daftarProduk.add(new Smartphone("Xiaomi", 222222, "Mist Purple", 512, 268.31));
        daftarProduk.add(new Laptop("Lenovo", 333333, "Intel Core Ultra 7", 64, 2566.98));
        daftarProduk.add(new Laptop("Apple", 444444, "M5", 16, 933.41));
        daftarProduk.add(new Camera("Sony", 555555, 61, "Optical SteadyShot", 641.70));
        daftarProduk.add(new Camera("Fujifilm", 666666, 5, "Instax Mini Evo", 174.97));

        Scanner input = new Scanner(System.in);

        int pilihan = 0;
        while(pilihan != 4) {
            System.out.println("==== SELAMAT DATANG ====");
            System.out.println("1. Tambah Produk \n2. Tampilkan Semua Produk \n3. Beli Produk \n4. Keluar");
            System.out.print("Pilih Menu (1-4): ");
            pilihan = input.nextInt();

            switch(pilihan) {
                case 1:
                    input.nextLine();
                    System.out.print("Masukkan Brand Produk: ");
                    String brandBaru = input.nextLine();
                    System.out.print("Masukkan Nomor Seri Produk: ");
                    int snBaru = input.nextInt();
                    System.out.print("Masukkan Harga Produk: ");
                    double hargaBaru = input.nextDouble();

                    System.out.println("\nPilih Jenis Produk:");
                    System.out.println("1. Smartphone \n2. Laptop \n3. Camera");
                    System.out.print("Pilih Jenis Produk (1-3): ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    switch(jenis) {
                        case 1:
                            System.out.print("Masukkan Warna Produk: ");
                            String warna = input.nextLine();
                            System.out.print("Masukkan Storage Produk: ");
                            int storage = input.nextInt();
                            daftarProduk.add(new Smartphone(brandBaru, snBaru, warna, storage, hargaBaru));
                            break;

                        case 2:
                            System.out.print("Masukkan Proccessor Type Produk: ");
                            String psBaru = input.nextLine();
                            System.out.print("Masukkan RAM Produk: ");
                            int ram = input.nextInt();
                            daftarProduk.add(new Laptop(brandBaru, snBaru, psBaru, ram, hargaBaru));
                            break;

                        case 3:
                            System.out.print("Masukkan Resolusi Produk: ");
                            int resolusi = input.nextInt();
                            System.out.print("Masukkan Tipe Lensa Produk: ");
                            String lensa = input.nextLine();
                            daftarProduk.add(new Camera(brandBaru, snBaru, resolusi, lensa, hargaBaru));
                            break;

                        default:
                            System.out.println("Pilihan Jenis Tidak Valid. Gagal Menambahkan Produk.");
                    }
                    if (jenis >= 1 && jenis <= 3) {
                        System.out.println("Produk berhasil ditambahkan!");
                    }
                    break;


                case 2:
                    System.out.println("Daftar Produk:");
                    if (daftarProduk.isEmpty()) {
                        System.out.println("Belum ada produk yang tersedia.");
                    } else {
                        for (Product p : daftarProduk) {
                            p.displayInfo();
                            System.out.println("-------------------------------------------");
                        }
                    }
                    break;
                
                case 3:
                    System.out.print("Masukkan Nomor Seri Produk yang Ingin Dibeli: ");
                    int cariSN = input.nextInt();
                    boolean ditemukan = false;

                    for(Product p : daftarProduk) {
                        if (p.seriesNumber == cariSN) {
                            ditemukan = true;
                            System.out.println("Anda Telah Membeli Produk:");
                            System.out.println("Brand: " +  p.brand + "\nSerial Number: " + p.seriesNumber + "\nHarga: $" + p.price);
                            break;
                        }    
                    }

                        if (!ditemukan) {
                            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
                        }
                        break;
                
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
            }
        }
    }
}
