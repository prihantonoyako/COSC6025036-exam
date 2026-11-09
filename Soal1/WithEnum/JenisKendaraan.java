enum JenisKendaraan {
    MOTOR(5000, 2000),
    MOBIL(10000, 4000),
    MOBIL_LISTRIK(15000, 2500);

    private double tarifDasar;
    private double tarifPerKm;

    JenisKendaraan(double tarifDasar,
                   double tarifPerKm) {
        this.tarifDasar = tarifDasar;
        this.tarifPerKm = tarifPerKm;
    }

    public double hitungTarif(double jarakKm) {
        return tarifDasar + (tarifPerKm * jarakKm);
    }
}