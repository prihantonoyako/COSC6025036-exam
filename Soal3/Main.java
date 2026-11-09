class Graph {
    private int jumlahSimpul;
    private int[][] adjacencyList;
    private int[] jumlahTetangga;
    private int hopTerakhir;

    public Graph(int jumlahSimpul) {
        if (jumlahSimpul <= 0) {
            throw new IllegalArgumentException("Jumlah simpul harus lebih dari 0");
        }
        this.jumlahSimpul = jumlahSimpul;
        adjacencyList = new int[jumlahSimpul][2];
        jumlahTetangga = new int[jumlahSimpul];
    }

    private void perbesarKapasitas(int simpul) {
        int kapasitasBaru = adjacencyList[simpul].length * 2;
        int[] arrayBaru = new int[kapasitasBaru];
        for (int i = 0; i < jumlahTetangga[simpul]; i++) {
            arrayBaru[i] = adjacencyList[simpul][i];
        }
        adjacencyList[simpul] = arrayBaru;
    }

    public void tambahJalan(int asal, int tujuan) {
        if (asal < 0 || asal >= jumlahSimpul || tujuan < 0 || tujuan >= jumlahSimpul) {
            throw new IllegalArgumentException("Nomor simpul tidak valid");
        }
        if (jumlahTetangga[asal] == adjacencyList[asal].length) {
            perbesarKapasitas(asal);
        }
        if (jumlahTetangga[tujuan] == adjacencyList[tujuan].length) {
            perbesarKapasitas(tujuan);
        }
        adjacencyList[asal][jumlahTetangga[asal]++] = tujuan;
        adjacencyList[tujuan][jumlahTetangga[tujuan]++] = asal;
    }

    public int bfsCariTerdekat(int asal, boolean[] adalahDriver) {
        if (asal < 0 || asal >= jumlahSimpul || adalahDriver == null || adalahDriver.length != jumlahSimpul) {
            throw new IllegalArgumentException("Input pencarian tidak valid");
        }

        boolean[] dikunjungi = new boolean[jumlahSimpul];
        int[] queue = new int[jumlahSimpul];
        int[] hop = new int[jumlahSimpul];
        int depan = 0;
        int belakang = 0;
        hopTerakhir = -1;

        queue[belakang++] = asal;
        dikunjungi[asal] = true;
        hop[asal] = 0;

        while (depan < belakang) {
            int sekarang = queue[depan++];
            if (adalahDriver[sekarang]) {
                hopTerakhir = hop[sekarang];
                return sekarang;
            }

            for (int i = 0; i < jumlahTetangga[sekarang]; i++) {
                int tetangga = adjacencyList[sekarang][i];
                if (!dikunjungi[tetangga]) {
                    dikunjungi[tetangga] = true;
                    hop[tetangga] = hop[sekarang] + 1;
                    queue[belakang++] = tetangga;
                }
            }
        }
        return -1;
    }

    public int getHopTerakhir() {
        return hopTerakhir;
    }

    public void tampilkanGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < jumlahSimpul; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < jumlahTetangga[i]; j++) {
                System.out.print(adjacencyList[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph kota = new Graph(8);
        kota.tambahJalan(0, 1);
        kota.tambahJalan(0, 2);
        kota.tambahJalan(1, 3);
        kota.tambahJalan(2, 3);
        kota.tambahJalan(2, 4);
        kota.tambahJalan(3, 5);
        kota.tambahJalan(4, 6);
        kota.tambahJalan(5, 7);
        kota.tambahJalan(6, 7);

        kota.tampilkanGraph();

        boolean[] adalahDriver = new boolean[8];
        adalahDriver[4] = true;
        adalahDriver[7] = true;

        System.out.println("\nDaftar Driver:");
        System.out.println("Driver 1 berada di simpul 4");
        System.out.println("Driver 2 berada di simpul 7");

        System.out.println("\n=== Pencarian Pertama ===");
        int hasil1 = kota.bfsCariTerdekat(0, adalahDriver);
        tampilkanHasil(0, hasil1, kota.getHopTerakhir());

        System.out.println("\n=== Pencarian Kedua ===");
        int hasil2 = kota.bfsCariTerdekat(5, adalahDriver);
        tampilkanHasil(5, hasil2, kota.getHopTerakhir());
    }

    private static void tampilkanHasil(int asal, int tujuan, int hop) {
        System.out.println("Penumpang berada di simpul " + asal);
        if (tujuan == -1) {
            System.out.println("Driver tidak ditemukan");
        } else {
            System.out.println("Driver terdekat berada di simpul " + tujuan);
            System.out.println("Jarak: " + hop + " hop");
        }
    }
}
