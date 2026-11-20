
package lab.kasir;

public class Kasir extends Thread {

    private String nama;
    private int jumlahPelanggan;

    public Kasir(String nama, int jumlahPelanggan) {
        this.nama = nama;
        this.jumlahPelanggan = jumlahPelanggan;
    }

    @Override
    public void run() {

        for (int i = 1; i <= jumlahPelanggan; i++) {

            System.out.println(
                "Kasir " + nama +
                " sedang melayani pelanggan ke-" + i
            );

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(
                    "Pelayanan kasir " + nama + " terganggu."
                );

                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(
            "Kasir " + nama + " telah menyelesaikan pelayanan."
        );
    }
}
