public class Main {
    public static void main(String[] args) {
        SmartLamp smartLamp = new SmartLamp("Philips", 10);
        smartLamp.cekFungsi();
        smartLamp.infoPower();
        smartLamp.prosesPerintah("Nyala");
        System.out.println("------------------------------------------------------------------");
        SmartCCTV smartCCTV = new SmartCCTV("Hikvision", 15);
        smartCCTV.cekFungsi();
        smartCCTV.infoPower();
        smartCCTV.hubungkanWifi();
        System.out.println("------------------------------------------------------------------");
        SmartSpeaker smartSpeaker = new SmartSpeaker("Google Nest", 30);
        smartSpeaker.cekFungsi();
        smartSpeaker.infoPower();
        smartSpeaker.hubungkanWifi();
        smartSpeaker.prosesPerintah("Mati");
    }
}
