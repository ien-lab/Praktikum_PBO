
package lab.kasir;

public class Pesanan {

    private double subtotal;

    public Pesanan() {
        subtotal = 0;
    }

    public void tambahItem(double harga, int jumlah) {
        if (harga <= 0 || jumlah <= 0) {
            throw new IllegalArgumentException(
                "Harga dan jumlah harus lebih dari nol!"
            );
        }

        subtotal += harga * jumlah;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double hitungTotal() {
        if (subtotal > 50000) {
            return subtotal - (subtotal * 0.10);
        }

        return subtotal;
    }

    public double getDiskon() {
        return subtotal > 50000 ? subtotal * 0.10 : 0;
    }

    public void reset() {
        subtotal = 0;
    }
}
