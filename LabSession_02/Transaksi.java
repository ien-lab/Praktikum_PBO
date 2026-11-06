import java.text.NumberFormat;
import java.util.Locale;

public class Transaksi implements Pembayaran {
    private Produk[] daftarProduk;
    private int[] jumlahBarang;
    private int jumlahProduk;

    public Transaksi(int kapasitas) {
        daftarProduk = new Produk[kapasitas];
        jumlahBarang = new int[kapasitas];
        jumlahProduk = 0;
    }

    public void tambahProduk(Produk produk, int jumlah) {
        if (jumlahProduk < daftarProduk.length && jumlah > 0) {
            daftarProduk[jumlahProduk] = produk;
            jumlahBarang[jumlahProduk] = jumlah;
            jumlahProduk++;
        } else {
            System.out.println("Produk gagal ditambahkan!");
        }
    }

    public double hitungTotal() {
        double total = 0;

        for (int i = 0; i < jumlahProduk; i++) {
            total += daftarProduk[i].getHarga() * jumlahBarang[i];
        }

        return total;
    }

    public void tampilkanKeranjang() {
    System.out.println("\n========== STRUK BELANJA ==========");

    for (int i = 0; i < jumlahProduk; i++) {
        System.out.println("\nProduk       : " + daftarProduk[i].getNama());
        System.out.println("Harga        : " + formatRupiah(daftarProduk[i].getHarga()));
        System.out.println("Jumlah       : " + jumlahBarang[i]);
        System.out.println("Subtotal     : " + formatRupiah(
            daftarProduk[i].getHarga() * jumlahBarang[i]
        ));
    }

    System.out.println("\nTotal belanja: " + formatRupiah(hitungTotal()));
}

    @Override
    public void bayar(double total, String metode) {
        System.out.println("\n========== PEMBAYARAN ==========");
        System.out.println("Metode pembayaran: " + metode);
        System.out.println("Total pembayaran : Rp" + total);
        System.out.println("Pembayaran berhasil!");
    }

    public void prosesPembayaran(double total) {
        bayar(total, "Transfer Bank");
    }

    public void prosesPembayaran(double total, String metode) {
        bayar(total, metode);
    }
    
    private String formatRupiah(double nominal) {
    NumberFormat format = NumberFormat.getInstance(
        new Locale("id", "ID")
    );

    format.setMaximumFractionDigits(0);
    format.setMinimumFractionDigits(0);

    return "Rp" + format.format(nominal);
}
}
