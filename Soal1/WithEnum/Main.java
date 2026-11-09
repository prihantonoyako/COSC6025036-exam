public class Main {
    public static void main(String[] args) {

        double jarak = 10;

        for (JenisKendaraan kendaraan : JenisKendaraan.values()) {

            System.out.println(
                kendaraan + " = Rp" +
                kendaraan.hitungTarif(jarak)
            );
        }
    }
}