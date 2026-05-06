import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.addItems(new Book("Sang Pemimpi", 101, "Andrea Hirata"));
        myLibrary.addItems(new Book("Tanah Para Bandit", 102, "Tere Liye"));
        myLibrary.addItems(new Book("Kesetiaan Mr. X", 103, "Keigo Higashino"));
        myLibrary.addItems(new DVD("Alice in Wonderland", 201, 108));
        myLibrary.addItems(new DVD("Alvin and The Chipmunks", 202, 92));

        Scanner input = new Scanner(System.in);
        int pilihan = 0;
        while(pilihan != 8) {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item \n2. Tambah Anggota \n3. Pinjam Item \n4. Kembalikan Item \n5. Lihat Status Perpustakaan \n6. Lihat Log Aktivitas \n7. Lihat Item yang Dipinjam Anggota \n8. Keluar");
            System.out.print("Pilih Menu (1-8): ");

            pilihan = input.nextInt();
            switch(pilihan) {
                case 1:
                    input.nextLine();
                    System.out.print("Pilih Jenis Item (Buku/DVD): ");
                    String jenis = input.nextLine();

                    if (jenis.equalsIgnoreCase("Buku")) {
                        System.out.print("Masukkan Judul Buku: ");
                        String judulBuku = input.nextLine();
                        System.out.print("Masukkan ID Buku: ");
                        int idBuku = input.nextInt();
                        input.nextLine();
                        System.out.print("Masukkan Penulis Buku: ");
                        String penulis = input.nextLine();
                        myLibrary.addItems(new Book(judulBuku, idBuku, penulis));
                        System.out.println("Item berhasil ditambahkan!");
                    } else if (jenis.equalsIgnoreCase("DVD")) {
                        System.out.print("Masukkan Judul DVD: ");
                        String judulDVD = input.nextLine();
                        System.out.print("Masukkan ID DVD: ");
                        int idDVD = input.nextInt();
                        System.out.print("Masukkan Durasi DVD: ");
                        int durasi = input.nextInt();
                        myLibrary.addItems(new DVD(judulDVD, idDVD, durasi));
                        System.out.println("Item berhasil ditambahkan!");
                    }
                    break;
                
                case 2:
                    input.nextLine();
                    System.out.print("Masukkan Nama Anggota: ");
                    String anggota = input.nextLine();
                    System.out.print("Masukkan ID Anggota: ");
                    int idAnggota = input.nextInt();
                    myLibrary.addMember(new Member(anggota, idAnggota));
                    break;

                case 3:
                    try {
                        System.out.print("Masukkan ID Anggota: ");
                        int idMember = input.nextInt();
                        Member peminjam = myLibrary.findMemberById(idMember);

                        if (peminjam == null) {
                            System.out.println("Gagal. Anggota dengan ID " + idMember + " tidak ditemukan.");
                            break;
                        }
                        System.out.print("Masukkan ID Item yang Ingin Dipinjam: ");
                        int idPinjam = input.nextInt();
                        LibraryItem itemDipinjam = myLibrary.findItemById(idPinjam);

                        System.out.print("Berapa hari durasi peminjaman? ");
                        int durasi = input.nextInt();
                        input.nextLine();
                        String pesan = peminjam.borrow(itemDipinjam, durasi);
                        System.out.println(pesan);
                    } catch (NoSuchElementException e) {
                    System.out.println("Error: " + e.getMessage());
                    } catch (IllegalStateException | IllegalArgumentException e) {
                    System.out.println("Gagal Pinjam: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Masukkan ID Anggota: ");
                        int idAgt = input.nextInt();
                        Member pengembali = myLibrary.findMemberById(idAgt);

                        if (pengembali == null) {
                        System.out.println("Error: Anggota tidak ditemukan!");
                        break;
                        }

                        System.out.print("Masukkan ID Item yang dikembalikan: ");
                        int idKembali = input.nextInt();
                        LibraryItem itemBalik = myLibrary.findItemById(idKembali);
                        System.out.print("Berapa hari keterlambatan? (0 jika tepat waktu): ");
                        int hariTerlambat = input.nextInt();
                        input.nextLine();
                        String statusKembali = pengembali.returnItem(itemBalik, hariTerlambat);
                        System.out.println(statusKembali);

                    } catch (Exception e) {
                    System.out.println("Gagal mengembalikan: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println(myLibrary.getLibraryStatus());
                    break;

                case 6:
                    myLibrary.getLogger().showLogs();
                    break;

                case 7:
                    System.out.print("Masukkan ID Anggota yang ingin dicek: ");
                    int idAgt = input.nextInt();
                    input.nextLine(); // Pembersih buffer
                    Member m = myLibrary.findMemberById(idAgt);
                    if (m != null) {
                        m.getBorroweditems(); 
                    } else {
                        System.out.println("Error: Anggota dengan ID " + idAgt + " tidak ditemukan.");
                    }
                    break;

                case 8:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
            }
        }
    }
}
