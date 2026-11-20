
package lab.kasir;

import javax.swing.SwingUtilities;

public class MainKasir {

    public static void main(String[] args) {

        // TAHAP 1: Pengujian logika pesanan
        System.out.println("==================================");
        System.out.println("      PENGUJIAN SISTEM KASIR");
        System.out.println("==================================");

        Pesanan pesanan = new Pesanan();

        pesanan.tambahItem(15000, 2);
        pesanan.tambahItem(5000, 3);

        System.out.println("Subtotal dua menu pertama: Rp "
                + pesanan.getSubtotal());

        pesanan.tambahItem(25000, 1);

        System.out.println("Subtotal akhir : Rp "
                + pesanan.getSubtotal());

        System.out.println("Diskon         : Rp "
                + pesanan.getDiskon());

        System.out.println("Total bayar    : Rp "
                + pesanan.hitungTotal());

        // TAHAP 2: Simulasi multithreading
        System.out.println("\n==================================");
        System.out.println("       SIMULASI DUA KASIR");
        System.out.println("==================================");

        Kasir dina = new Kasir("Dina", 5);
        Kasir eko = new Kasir("Eko", 4);

        dina.start();
        eko.start();

        try {

            dina.join();
            eko.join();

            System.out.println(
                "Semua pelanggan selesai dilayani."
            );

        } catch (InterruptedException e) {

            System.out.println(
                "Program utama mengalami gangguan."
            );

            Thread.currentThread().interrupt();
        }

        // TAHAP 3 DAN 4: Menjalankan aplikasi GUI
        System.out.println("\nMembuka aplikasi Kasir Kantin UNS...");

        SwingUtilities.invokeLater(() -> {
            new KasirFrame();
        });
    }
}
