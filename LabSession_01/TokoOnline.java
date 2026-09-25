import java.util.ArrayList;
import java.util.Scanner;

public class TokoOnline {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final double ONGKIR = 10000;
        final double BATAS_DISKON = 1000000;
        final double PERSEN_DISKON = 0.10;

        char kategoriToko = 'A';
        String namaToko = "Indah Store";

        System.out.println(
            "Nama toko memiliki "
            + namaToko.length()
            + " karakter."
        );

        System.out.println(
            "Nama toko: "
            + namaToko.toUpperCase()
        );

        ArrayList<Produk> daftarProduk = new ArrayList<>();

        Produk produk1 = new Produk("Laptop", 7500000, 5);
        Produk produk2 = new Produk("Mouse", 150000, 10);
        Produk produk3 = new Produk("Keyboard", 300000, 8);

        daftarProduk.add(produk1);
        daftarProduk.add(produk2);
        daftarProduk.add(produk3);

        System.out.println("\n==========================================");
        System.out.println("            " + namaToko);
        System.out.println("         Kategori: " + kategoriToko);
        System.out.println("==========================================");

        System.out.println("\nDAFTAR PRODUK:");

        for (int i = 0; i < daftarProduk.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarProduk.get(i).tampilkanProduk();
        }

        try {

            System.out.print("\nPilih nomor produk: ");
            int pilihan = input.nextInt();

            if (pilihan < 1 || pilihan > daftarProduk.size()) {

                System.out.println(
                    "Pilihan produk tidak tersedia!"
                );

            } else {

                Produk produkDipilih =
                    daftarProduk.get(pilihan - 1);

                System.out.println(
                    "Produk dipilih: "
                    + produkDipilih.nama
                );

                System.out.print(
                    "Masukkan jumlah yang ingin dibeli: "
                );

                int jumlah = input.nextInt();

                if (jumlah <= 0) {

                    System.out.println(
                        "Jumlah pembelian harus lebih dari 0!"
                    );

                } else if (jumlah > produkDipilih.stok) {

                    System.out.println(
                        "Stok tidak mencukupi!"
                    );

                } else {

                    double subtotal =
                        produkDipilih.hitungTotal(jumlah);

                    double potongan = 0;

                    if (subtotal >= BATAS_DISKON) {

                        potongan =
                            subtotal * PERSEN_DISKON;

                        System.out.println(
                            "\nSelamat! Anda mendapatkan diskon 10%."
                        );

                    } else {

                        System.out.println(
                            "\nAnda belum mendapatkan diskon."
                        );
                    }

                    double setelahDiskon =
                        subtotal - potongan;

                    double totalBayar =
                        setelahDiskon + ONGKIR;

                    System.out.println(
                        "\n=========================================="
                    );

                    System.out.println(
                        "              DETAIL PESANAN"
                    );

                    System.out.println(
                        "=========================================="
                    );

                    System.out.println(
                        "Produk          : "
                        + produkDipilih.nama
                    );

                    System.out.println(
                        "Harga           : Rp"
                        + String.format(
                            "%.0f",
                            produkDipilih.harga
                        )
                    );

                    System.out.println(
                        "Jumlah          : "
                        + jumlah
                    );

                    System.out.println(
                        "Subtotal        : Rp"
                        + String.format(
                            "%.0f",
                            subtotal
                        )
                    );

                    System.out.println(
                        "Diskon          : Rp"
                        + String.format(
                            "%.0f",
                            potongan
                        )
                    );

                    System.out.println(
                        "Setelah Diskon  : Rp"
                        + String.format(
                            "%.0f",
                            setelahDiskon
                        )
                    );

                    System.out.println(
                        "Ongkir          : Rp"
                        + String.format(
                            "%.0f",
                            ONGKIR
                        )
                    );

                    System.out.println(
                        "Total Bayar     : Rp"
                        + String.format(
                            "%.0f",
                            totalBayar
                        )
                    );

                    System.out.println(
                        "=========================================="
                    );

                    System.out.print(
                        "Masukkan uang pembayaran: Rp"
                    );

                    double uangBayar = input.nextDouble();

                    if (uangBayar < totalBayar) {

                        System.out.println(
                            "Uang pembayaran tidak cukup!"
                        );

                    } else {

                        double kembalian =
                            uangBayar - totalBayar;

                        System.out.println(
                            "Uang Bayar      : Rp"
                            + String.format(
                                "%.0f",
                                uangBayar
                            )
                        );

                        System.out.println(
                            "Kembalian       : Rp"
                            + String.format(
                                "%.0f",
                                kembalian
                            )
                        );

                        System.out.println(
                            "=========================================="
                        );

                        System.out.println(
                            "       PESANAN BERHASIL DIBUAT!"
                        );

                        System.out.println(
                            "Terima kasih telah berbelanja di "
                            + namaToko + "."
                        );
                    }
                }
            }

        } catch (Exception e) {

            System.out.println(
                "\nError: Input harus berupa angka!"
            );
        }

        input.close();
    }
}