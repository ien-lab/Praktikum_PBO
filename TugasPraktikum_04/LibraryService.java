package library.service;

import library.model.Book;
import library.model.Member;
import library.exception.BookNotFoundException;
import library.exception.BorrowLimitExceededException;

import java.util.ArrayList;
import java.util.HashMap;

public class LibraryService {

    private ArrayList<Book> daftarBuku;
    private ArrayList<Member> daftarMember;

    // Menyimpan jumlah peminjaman setiap buku
    private HashMap<String, Integer> riwayatPeminjaman;

    public LibraryService() {
        daftarBuku = new ArrayList<>();
        daftarMember = new ArrayList<>();
        riwayatPeminjaman = new HashMap<>();
    }

    // =========================
    // MANAJEMEN BUKU
    // =========================

    public void tambahBuku(Book book) {
        daftarBuku.add(book);
        riwayatPeminjaman.put(book.getJudul(), 0);
    }

    public void tampilkanSemuaBuku() {

        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada buku.");
            return;
        }

        System.out.println("\n===== DAFTAR BUKU =====");

        for (Book book : daftarBuku) {
            System.out.println("-----------------------");
            System.out.println(book);
        }
    }

    // =========================
    // MANAJEMEN MEMBER
    // =========================

    public void tambahMember(Member member) {
        daftarMember.add(member);
    }

    public Member cariMember(String id) {

        for (Member member : daftarMember) {
            if (member.getId().equalsIgnoreCase(id)) {
                return member;
            }
        }

        return null;
    }

    // =========================
    // PENCARIAN BUKU
    // =========================

    public void cariBuku(String keyword) {

        boolean ditemukan = false;

        // Manipulasi String
        String kataKunci = keyword.toLowerCase();

        System.out.println("\n===== HASIL PENCARIAN =====");

        for (Book book : daftarBuku) {

            String judul = book.getJudul().toLowerCase();
            String kategori = book.getKategori().toLowerCase();

            // String contains()
            if (judul.contains(kataKunci)
                    || kategori.contains(kataKunci)) {

                System.out.println("-----------------------");
                System.out.println(book);

                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    // =========================
    // PEMINJAMAN
    // =========================

    public void pinjamBuku(String idMember, String judulBuku)
            throws BookNotFoundException,
                   BorrowLimitExceededException {

        Member member = cariMember(idMember);

        // Assertion untuk memastikan data anggota valid
        assert member != null : "Data anggota tidak valid.";

        Book buku = cariBukuByJudul(judulBuku);

        if (buku == null) {
            throw new BookNotFoundException(
                "Buku dengan judul \"" + judulBuku +
                "\" tidak ditemukan."
            );
        }

        if (!buku.isTersedia()) {
            throw new BookNotFoundException(
                "Buku sedang dipinjam."
            );
        }

        if (member.jumlahPinjaman() >= 3) {
            throw new BorrowLimitExceededException(
                "Anggota sudah mencapai batas maksimal 3 buku."
            );
        }

        buku.setStatusKetersediaan(false);
        member.tambahPinjaman(buku);

        // Menambah jumlah riwayat peminjaman
        int jumlah = riwayatPeminjaman.get(buku.getJudul());
        riwayatPeminjaman.put(
            buku.getJudul(),
            jumlah + 1
        );

        System.out.println("Buku berhasil dipinjam.");
    }

    // =========================
    // PENGEMBALIAN
    // =========================

    public void kembalikanBuku(
            String idMember,
            String judulBuku)
            throws BookNotFoundException {

        Member member = cariMember(idMember);

        assert member != null : "Data anggota tidak valid.";

        Book buku = null;

        for (Book b : member.getDaftarPinjaman()) {

            if (b.getJudul().equalsIgnoreCase(judulBuku)) {
                buku = b;
                break;
            }
        }

        if (buku == null) {
            throw new BookNotFoundException(
                "Buku tersebut tidak sedang dipinjam oleh anggota."
            );
        }

        buku.setStatusKetersediaan(true);
        member.hapusPinjaman(buku);

        System.out.println("Buku berhasil dikembalikan.");
    }

    // =========================
    // CARI BUKU
    // =========================

    private Book cariBukuByJudul(String judul) {

        for (Book book : daftarBuku) {

            if (book.getJudul().equalsIgnoreCase(judul)) {
                return book;
            }
        }

        return null;
    }

    // =========================
    // ANALISIS KATEGORI
    // =========================

    public void analisisKategori() {

        HashMap<String, Integer> jumlahKategori =
                new HashMap<>();

        for (Book book : daftarBuku) {

            String kategori =
                    book.getKategori().toLowerCase();

            if (jumlahKategori.containsKey(kategori)) {

                int jumlah =
                        jumlahKategori.get(kategori);

                jumlahKategori.put(
                        kategori,
                        jumlah + 1
                );

            } else {

                jumlahKategori.put(kategori, 1);
            }
        }

        System.out.println("\n===== JUMLAH BUKU PER KATEGORI =====");

        for (String kategori : jumlahKategori.keySet()) {

            System.out.println(
                    kategori + " : "
                    + jumlahKategori.get(kategori)
                    + " buku"
            );
        }
    }

    // =========================
    // BUKU PALING SERING DIPINJAM
    // =========================

    public String bukuPalingSeringDipinjam() {

        String bukuTerpopuler = "-";
        int jumlahTertinggi = 0;

        for (String judul : riwayatPeminjaman.keySet()) {

            int jumlah = riwayatPeminjaman.get(judul);

            if (jumlah > jumlahTertinggi) {
                jumlahTertinggi = jumlah;
                bukuTerpopuler = judul;
            }
        }

        return bukuTerpopuler +
               " (" + jumlahTertinggi +
               " kali)";
    }

    // =========================
    // ANGGOTA PALING AKTIF
    // =========================

    public String anggotaPalingAktif() {

        String anggotaTeraktif = "-";
        int jumlahTertinggi = 0;

        for (Member member : daftarMember) {

            int jumlah =
                    member.jumlahPinjaman();

            if (jumlah > jumlahTertinggi) {
                jumlahTertinggi = jumlah;
                anggotaTeraktif =
                        member.getNama();
            }
        }

        return anggotaTeraktif +
               " (" + jumlahTertinggi +
               " buku sedang dipinjam)";
    }

    // =========================
    // TOTAL PINJAMAN
    // =========================

    public int totalPinjaman() {

        int total = 0;

        for (int jumlah : riwayatPeminjaman.values()) {
            total += jumlah;
        }

        return total;
    }

    // =========================
    // KATEGORI PALING POPULER
    // =========================

    public String kategoriPalingPopuler() {

        HashMap<String, Integer> jumlahKategori =
                new HashMap<>();

        for (Book book : daftarBuku) {

            String kategori =
                    book.getKategori().toLowerCase();

            jumlahKategori.put(
                    kategori,
                    jumlahKategori.getOrDefault(kategori, 0) + 1
            );
        }

        String kategoriTerpopuler = "-";
        int jumlahTerbanyak = 0;

        for (String kategori : jumlahKategori.keySet()) {

            int jumlah =
                    jumlahKategori.get(kategori);

            if (jumlah > jumlahTerbanyak) {

                jumlahTerbanyak = jumlah;
                kategoriTerpopuler = kategori;
            }
        }

        return kategoriTerpopuler +
               " (" + jumlahTerbanyak +
               " buku)";
    }

    // =========================
    // LAPORAN
    // =========================

    public void tampilkanLaporan() {

        System.out.println("\n==============================");
        System.out.println("     LAPORAN PERPUSTAKAAN");
        System.out.println("==============================");

        System.out.println(
                "Total transaksi peminjaman : "
                + totalPinjaman()
        );

        System.out.println(
                "Buku paling sering dipinjam : "
                + bukuPalingSeringDipinjam()
        );

        System.out.println(
                "Anggota paling aktif : "
                + anggotaPalingAktif()
        );

        System.out.println(
                "Kategori paling populer : "
                + kategoriPalingPopuler()
        );

        analisisKategori();
    }

    // Getter daftar member
    public ArrayList<Member> getDaftarMember() {
        return daftarMember;
    }
}