public abstract class PerangkatElektronik {
    String merek;
    int dayaListrik;

    public PerangkatElektronik(String merek, int dayaListrik) {
        this.merek = merek;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi();

    void infoPower() {
        System.out.println(merek + " sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }
}

class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    public SmartLamp(String merek, int dayaListrik) {
        super(merek, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Smart Lamp " + merek + " berfungsi dengan baik.");
    }
    void infoPower() {
        super.infoPower();
    }
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("Nyala")) {
            System.out.println("Lampu " + merek + " berpijar!");
        } else if (perintah.equalsIgnoreCase("Mati")) {
            System.out.println("Lampu " + merek + " tidak berpijar.");
        } else {
            System.out.println("Perintah tidak dikenali!");
        }
    }
}

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {
    public SmartCCTV(String merek, int dayaListrik) {
        super(merek, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Smart CCTV " + merek + " berfungsi dengan baik.");
    }
    void infoPower() {
        super.infoPower();
    }
    public void hubungkanWifi() {
        System.out.println(merek + " mengirim data ke server...");
    }
}

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
    public SmartSpeaker(String merek, int dayaListrik) {
        super(merek, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Smart Speaker " + merek + " berfungsi dengan baik.");
    }
    void infoPower() {
        super.infoPower();
    }
    public void hubungkanWifi() {
        System.out.println(merek + " mengirim data ke server...");
    }
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("Nyala")) {
            System.out.println("Speaker " + merek + " bersuara!");
        } else if (perintah.equalsIgnoreCase("Mati")) {
            System.out.println("Speaker " + merek + " tidak bersuara.");
        } else {
            System.out.println("Perintah tidak dikenali!");
        }
    }
}