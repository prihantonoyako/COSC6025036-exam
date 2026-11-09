class Motor implements Kendaraan {
	private double tarifDasar;
	private double tarifPerKm;
	
	Motor() {
		this.tarifDasar = 5000;
		this.tarifPerKm = 2000;
	}

    @Override
    public double hitungTarif(double jarakKm) {
        return this.tarifDasar + (this.tarifPerKm * jarakKm);
    }
}