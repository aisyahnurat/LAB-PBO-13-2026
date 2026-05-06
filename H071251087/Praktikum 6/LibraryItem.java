import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected boolean isBorrowed;
    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public int getId() {
    return this.itemId;
    }
    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);
    public String returnItem() {
        this.isBorrowed = false;
        return title + " dikembalikan.";
    }
}

class Book extends LibraryItem {
    private String author;
    private final int maxPinjam = 14;
    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku " + title + " oleh " + author + " dengan ID " + itemId + ".";
    }

    @Override
    public String borrowItem(int days) {
        if (days > maxPinjam || this.isBorrowed) {
            throw new IllegalArgumentException(title + " telah dipinjam dan belum dikembalikan.");
        }
        this.isBorrowed = true;
        return "Item " + title + " (Book) berhasil dipinjam selama " + days + " hari.";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}

class DVD extends LibraryItem {
    private double duration;
    private final int maxPinjam = 7;
    public DVD(String title, int itemId, double duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD " + title + " durasi " + duration + " (menit) dengan ID " + itemId + ".";
    }

    @Override
    public String borrowItem(int days) {
        if (days > maxPinjam || this.isBorrowed) {
            throw new IllegalArgumentException(title + " telah dipinjam dan belum dikembalikan.");
        }
        this.isBorrowed = true;
        return "Item " + title + " (DVD) berhasil dipinjam selama " + days + " hari.";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }
}

class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item " + item.title + " tidak tersedia (sudah dipinjam).");
        } else {
            String hasil = item.borrowItem(days);
            borrowedItems.add(item);
            return "Item " + item.title + " berhasil dipinjam selama " + days + " hari.";
        }
    }

    public String returnItem(LibraryItem item, int daysLate) {
        double denda = item.calculateFine(daysLate);
        item.returnItem();
        borrowedItems.remove(item);
        return "Item " + item.title + " berhasil dikembalikan dengan denda Rp" + denda;
    }

    public void getBorroweditems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("------------------------------------");
            System.out.println("Tidak ada item yang dipinjam.");
            System.out.println("------------------------------------");
        } else {
            System.out.println("===== Daftar Pinjaman " + name + " =====");
            for (int i = 0; i < borrowedItems.size(); i++) {
                System.out.println((i + 1) + ". " + borrowedItems.get(i).getDescription());
                System.out.println("=========================================");
            }
        }
    }
}

class LibraryLogger {
    private List<String> logs;
    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

    public void addLogs(String massage) {
        logs.add(massage);
    }

    public void showLogs() {
        System.out.println("=== RIWAYAT AKTIVITAS PERPUSTAKAAN ===");
        if (logs.isEmpty()) {
            System.out.println("Belum ada aktivitas tercatat.");
        } else {
            for (String log : logs) {
                System.out.println("[LOG]: " + log);
            }
        }
    }

    public String logActivity(String activity) {
        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = waktuSekarang.format(formatWaktu);
        String logLengkap = timestamp + " " + activity;
        logs.add(logLengkap);
        return logLengkap;
    }

    public String getLogs() {
    if (logs.isEmpty()) {
        return "Belum ada aktivitas.";
    }

    String header = "--------------------------------------------------------------------------------------------\n" +
                    "| Dipinjam pada       | Judul                          | Member     | Dikembalikan pada   |\n" +
                    "--------------------------------------------------------------------------------------------\n";
    
    String allLogs = header;
    for (String log : logs) {
        allLogs += log + "\n";
    }
    
    allLogs += "--------------------------------------------------------------------------------------------";
    return allLogs;
    }

    public void clearLogs() {
        this.logs.clear();
        System.out.println("Semua riwayat aktivitas telah dihapus.");
    }
}

class Library {
    private List<LibraryItem> items;
    private List<Member> member;
    private LibraryLogger logger;
    public Library() {
        this.items = new ArrayList<>();
        this.member = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public void addItems(LibraryItem item) {
        items.add(item);
        logger.logActivity(item.title + " berhasil ditambahkan.");
    }

    public void addMember(Member newMember) {
    member.add(newMember);
    logger.logActivity("Anggota baru: " + newMember.getName() + " berhasil ditambahkan.");
    }

    public Member findMemberById(int id) {
    for (Member m : this.member) { 
        if (m.getMemberId() == id) {
            return m;
        }
    }
    return null; 
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public LibraryLogger getLogger() {
    return this.logger;
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) {
            System.out.println("Koleksi perpustakaan masih kosong.");
        }
        String statusDetail = "=== DAFTAR KOLEKSI PERPUSTAKAAN ===\n";

        for (LibraryItem item : items) {
        String status;
        
        if (item.isBorrowed) {
            status = "Dipinjam";
        } else {
            status = "Tersedia";
        }
        
        statusDetail += item.getDescription() + " | Status: [" + status + "]\n";
        }
        return statusDetail;
    }
}