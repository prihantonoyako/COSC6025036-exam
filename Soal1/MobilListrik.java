class MobilListrik implements Kendaraan {
	private double tarifDasar;
	private double tarifPerKm;
	
	MobilListrik() {
		this.tarifDasar = 5000;
		this.tarifPerKm = 2000;
	}

    @Override
    public double hitungTarif(double jarakKm) {
        return this.tarifDasar/2 + (this.tarifPerKm * jarakKm);
    }
}