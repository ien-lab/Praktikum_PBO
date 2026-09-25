public class Produk {

    String nama;
    double harga;
    int stok;

    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilkanProduk() {
        System.out.println(
            "Nama  : " + nama
            + " | Harga: Rp" + String.format("%.0f", harga)
            + " | Stok: " + stok
        );
    }

    public double hitungTotal(int jumlah) {
        return harga * jumlah;
    }
}