class Mobil implements Kendaraan {
	private double tarifDasar;
	private double tarifPerKm;
	
	Mobil() {
		this.tarifDasar = 7000;
		this.tarifPerKm = 4000;
	}

    @Override
    public double hitungTarif(double jarakKm) {
        return this.tarifDasar + (this.tarifPerKm * jarakKm);
    }
}