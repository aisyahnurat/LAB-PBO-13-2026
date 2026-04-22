public class Product {
    String jenis;
    String brand;
    int seriesNumber;
    double price;

    public Product(String jenis, String brand, int seriesNumber, double price) {
        this.jenis = jenis;
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }
    void displayInfo() {
        System.out.println("Jenis: " + jenis + "\nBrand: " + brand + "\nSerial Number: " + seriesNumber + "\nPrice: $" + price);
    }
}

class Smartphone extends Product {
    String warna;
    int storage;
    public Smartphone(String brand, int seriesNumber, String warna, int storage, double price) {
        super("Smartphone", brand, seriesNumber, price);
        this.warna = warna;
        this.storage = storage;
    }
    void displayInfo() {
        super.displayInfo();
        System.out.println("Warna: " + warna + "\nStorage: " + storage + "GB");
    }
}

class Laptop extends Product {
    String processorType;
    int ram;
    public Laptop(String brand, int seriesNumber, String processorType, int ram, double price) {
        super("Laptop", brand, seriesNumber, price);
        this.processorType = processorType;
        this.ram = ram;
    }
    void displayInfo() {
        super.displayInfo();
        System.out.println("Processor Type: " + processorType + "\nRAM: " + ram + "GB");
    }
}

class Camera extends Product {
    int resolution;
    String lensType;
    public Camera(String brand, int seriesNumber, int resolution, String lensType, double price) {
        super("Camera", brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }
    void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution + "MP" + "\nLens Type: " + lensType);
    }
}