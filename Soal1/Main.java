public class Main {
    public static void main(String[] args) {

        Kendaraan motor = new Motor();
        Kendaraan mobil = new Mobil();
        Kendaraan listrik = new MobilListrik();

        double jarak = 10;

        System.out.println("Tarif Motor: " +
            motor.hitungTarif(jarak));

        System.out.println("Tarif Mobil: " +
            mobil.hitungTarif(jarak));

        System.out.println("Tarif Mobil Listrik: " +
            listrik.hitungTarif(jarak));
    }
}