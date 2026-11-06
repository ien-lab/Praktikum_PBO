
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Elektronik produk1 = new Elektronik(
            "E001", "Laptop", 7500000, 24
        );

        Elektronik produk2 = new Elektronik(
            "E002", "Mouse Wireless", 150000, 12
        );

        Pakaian produk3 = new Pakaian(
            "P001", "Kaos Polos", 85000, "L"
        );

        Pakaian produk4 = new Pakaian(
            "P002", "Jaket Hoodie", 175000, "XL"
        );

        Produk[] katalog = {
            produk1, produk2, produk3, produk4
        };

        System.out.println("================================");
        System.out.println("       TOKO ONLINE JAVA");
        System.out.println("================================");

        System.out.println("\n========== KATALOG PRODUK ==========");

        for (int i = 0; i < katalog.length; i++) {
            System.out.println("\nNomor Produk: " + (i + 1));
            katalog[i].tampilkanInfo();
        }

        Transaksi transaksi = new Transaksi(10);

        System.out.print("\nBerapa jenis produk yang ingin dibeli? ");
        int jumlahPilihan = input.nextInt();

        if (jumlahPilihan <= 0 || jumlahPilihan > katalog.length) {
            System.out.println("Jumlah pilihan tidak valid!");
            input.close();
            return;
        }

        for (int i = 0; i < jumlahPilihan; i++) {

            System.out.print("\nPilih nomor produk: ");
            int pilihan = input.nextInt();

            if (pilihan < 1 || pilihan > katalog.length) {
                System.out.println("Nomor produk tidak tersedia!");
                i--;
                continue;
            }

            System.out.print("Masukkan jumlah barang: ");
            int jumlah = input.nextInt();

            if (jumlah <= 0) {
                System.out.println("Jumlah harus lebih dari 0!");
                i--;
                continue;
            }

            transaksi.tambahProduk(katalog[pilihan - 1], jumlah);
        }

        transaksi.tampilkanKeranjang();

        System.out.println("\nPilih metode pembayaran:");
        System.out.println("1. Transfer Bank");
        System.out.println("2. E-Wallet");
        System.out.println("3. COD");

        System.out.print("Pilihan: ");
        int metode = input.nextInt();

        double total = transaksi.hitungTotal();

        switch (metode) {
            case 1:
                transaksi.prosesPembayaran(total, "Transfer Bank");
                break;

            case 2:
                transaksi.prosesPembayaran(total, "E-Wallet");
                break;

            case 3:
                transaksi.prosesPembayaran(total, "COD");
                break;

            default:
                System.out.println("Metode pembayaran tidak tersedia!");
                input.close();
                return;
        }

        System.out.println("\nTerima kasih telah berbelanja!");

        input.close();
    }
}
