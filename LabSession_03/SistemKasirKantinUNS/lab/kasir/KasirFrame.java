
package lab.kasir;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class KasirFrame extends JFrame {

    private JTextField txtMenu;
    private JTextField txtHarga;
    private JTextField txtJumlah;

    private JTextArea areaStruk;

    private JLabel lblSubtotal;
    private JLabel lblDiskon;
    private JLabel lblTotal;
    private JLabel lblStatus;

    private JButton btnTambah;
    private JButton btnHitung;
    private JButton btnCetak;

    private Pesanan pesanan;

    public KasirFrame() {

        pesanan = new Pesanan();

        setTitle("Sistem Kasir Kantin UNS");
        setSize(650, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Judul aplikasi
        JLabel judul = new JLabel("KASIR KANTIN UNS");
        judul.setFont(new Font("Arial", Font.BOLD, 23));
        judul.setBounds(180, 15, 300, 35);
        add(judul);

        JLabel subJudul = new JLabel(
            "Sistem Pengelolaan Transaksi Kantin"
        );
        subJudul.setBounds(190, 50, 300, 25);
        add(subJudul);

        // Form input
        JLabel lblMenu = new JLabel("Nama Menu");
        lblMenu.setBounds(40, 100, 100, 25);
        add(lblMenu);

        txtMenu = new JTextField();
        txtMenu.setBounds(150, 100, 430, 30);
        add(txtMenu);

        JLabel lblHarga = new JLabel("Harga (Rp)");
        lblHarga.setBounds(40, 145, 100, 25);
        add(lblHarga);

        txtHarga = new JTextField();
        txtHarga.setBounds(150, 145, 430, 30);
        add(txtHarga);

        JLabel lblJumlah = new JLabel("Jumlah");
        lblJumlah.setBounds(40, 190, 100, 25);
        add(lblJumlah);

        txtJumlah = new JTextField();
        txtJumlah.setBounds(150, 190, 430, 30);
        add(txtJumlah);

        // Tombol transaksi
        btnTambah = new JButton("Tambah Item");
        btnTambah.setBounds(150, 235, 130, 35);
        add(btnTambah);

        btnHitung = new JButton("Hitung Total");
        btnHitung.setBounds(295, 235, 130, 35);
        add(btnHitung);

        btnCetak = new JButton("Cetak Struk");
        btnCetak.setBounds(440, 235, 140, 35);
        add(btnCetak);

        // Area struk
        JLabel lblStruk = new JLabel("DETAIL TRANSAKSI");
        lblStruk.setFont(new Font("Arial", Font.BOLD, 14));
        lblStruk.setBounds(40, 290, 200, 25);
        add(lblStruk);

        areaStruk = new JTextArea();
        areaStruk.setEditable(false);
        areaStruk.setFont(new Font("Monospaced", Font.PLAIN, 12));

        areaStruk.setText(
            "          KANTIN UNS\n" +
            "====================================\n" +
            "Daftar pesanan pelanggan\n\n"
        );

        JScrollPane scroll = new JScrollPane(areaStruk);
        scroll.setBounds(40, 320, 540, 115);
        add(scroll);

        // Informasi pembayaran
        lblSubtotal = new JLabel("Subtotal : Rp 0");
        lblSubtotal.setBounds(40, 450, 250, 25);
        add(lblSubtotal);

        lblDiskon = new JLabel("Diskon : Rp 0");
        lblDiskon.setBounds(40, 475, 250, 25);
        add(lblDiskon);

        lblTotal = new JLabel("TOTAL BAYAR : Rp 0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 17));
        lblTotal.setBounds(320, 455, 270, 35);
        add(lblTotal);

        // Status aplikasi
        lblStatus = new JLabel("Status: Siap menerima transaksi.");
        lblStatus.setBounds(40, 520, 500, 25);
        add(lblStatus);

        // Aksi tombol tambah
        btnTambah.addActionListener(e -> tambahItem());

        // Aksi tombol hitung
        btnHitung.addActionListener(e -> hitungTotal());

        // Aksi tombol cetak
        btnCetak.addActionListener(e -> cetakStruk());

        setVisible(true);
    }

    // Format angka menjadi Rupiah
    private String formatRupiah(double nilai) {

        NumberFormat format =
            NumberFormat.getNumberInstance(new Locale("id", "ID"));

        format.setMaximumFractionDigits(0);
        format.setMinimumFractionDigits(0);

        return "Rp " + format.format(nilai);
    }

    // Menambahkan item ke pesanan
    private void tambahItem() {

        try {

            String namaMenu = txtMenu.getText().trim();
            String hargaInput = txtHarga.getText().trim();
            String jumlahInput = txtJumlah.getText().trim();

            if (namaMenu.isEmpty() ||
                hargaInput.isEmpty() ||
                jumlahInput.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Semua kolom harus diisi!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            double harga = Double.parseDouble(hargaInput);
            int jumlah = Integer.parseInt(jumlahInput);

            if (harga <= 0 || jumlah <= 0) {
                throw new IllegalArgumentException(
                    "Harga dan jumlah harus lebih dari nol!"
                );
            }

            pesanan.tambahItem(harga, jumlah);

            double totalItem = harga * jumlah;

            areaStruk.append(
                namaMenu + " x " + jumlah +
                " = " + formatRupiah(totalItem) + "\n"
            );

            lblSubtotal.setText(
                "Subtotal : " + formatRupiah(pesanan.getSubtotal())
            );

            lblStatus.setText(
                "Status: Item berhasil ditambahkan."
            );

            // Kosongkan form
            txtMenu.setText("");
            txtHarga.setText("");
            txtJumlah.setText("");

            txtMenu.requestFocus();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Harga harus berupa angka dan jumlah harus bilangan bulat!",
                "Input Tidak Valid",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    // Menghitung total pembayaran
    private void hitungTotal() {

        if (pesanan.getSubtotal() == 0) {

            JOptionPane.showMessageDialog(
                this,
                "Belum ada item dalam transaksi!",
                "Informasi",
                JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        double subtotal = pesanan.getSubtotal();
        double diskon = pesanan.getDiskon();
        double total = pesanan.hitungTotal();

        lblSubtotal.setText(
            "Subtotal : " + formatRupiah(subtotal)
        );

        lblDiskon.setText(
            "Diskon : " + formatRupiah(diskon)
        );

        lblTotal.setText(
            "TOTAL BAYAR : " + formatRupiah(total)
        );

        areaStruk.append(
            "------------------------------------\n" +
            "Subtotal : " + formatRupiah(subtotal) + "\n" +
            "Diskon   : " + formatRupiah(diskon) + "\n" +
            "TOTAL    : " + formatRupiah(total) + "\n"
        );

        lblStatus.setText(
            "Status: Perhitungan pembayaran berhasil."
        );
    }

    // Mencetak struk menggunakan thread baru
    private void cetakStruk() {

        if (pesanan.getSubtotal() == 0) {

            JOptionPane.showMessageDialog(
                this,
                "Tidak ada transaksi untuk dicetak!",
                "Informasi",
                JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        btnCetak.setEnabled(false);
        lblStatus.setText("Status: Mencetak struk...");

        Thread threadCetak = new Thread(() -> {

            try {

                Thread.sleep(2000);

                SwingUtilities.invokeLater(() -> {

                    lblStatus.setText(
                        "Status: Struk selesai dicetak."
                    );

                    btnCetak.setEnabled(true);

                    JOptionPane.showMessageDialog(
                        this,
                        "Struk transaksi berhasil dicetak!",
                        "Cetak Struk",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                });

            } catch (InterruptedException ex) {

                Thread.currentThread().interrupt();

                SwingUtilities.invokeLater(() -> {
                    lblStatus.setText(
                        "Status: Proses cetak terganggu."
                    );

                    btnCetak.setEnabled(true);
                });
            }
        });

        threadCetak.start();
    }
}
