package library.main;

import library.model.Book;
import library.model.Member;
import library.service.LibraryService;
import library.exception.BookNotFoundException;
import library.exception.BorrowLimitExceededException;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        LibraryService library = new LibraryService();

        // Data awal buku
        library.tambahBuku(
            new Book(
                "Laskar Pelangi",
                "Andrea Hirata",
                2005,
                "Novel"
            )
        );

        library.tambahBuku(
            new Book(
                "Bumi",
                "Tere Liye",
                2014,
                "Fantasi"
            )
        );

        library.tambahBuku(
            new Book(
                "Negeri 5 Menara",
                "Ahmad Fuadi",
                2009,
                "Novel"
            )
        );

        library.tambahBuku(
            new Book(
                "Pemrograman Java",
                "Budi Santoso",
                2023,
                "Teknologi"
            )
        );

        // Data awal anggota
        library.tambahMember(
            new Member("M001", "Indah")
        );

        library.tambahMember(
            new Member("M002", "Andi")
        );

        int pilihan;

        do {

            System.out.println("\n==============================");
            System.out.println("   SISTEM PERPUSTAKAAN MINI");
            System.out.println("==============================");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Daftar Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Pinjam Buku");
            System.out.println("5. Kembalikan Buku");
            System.out.println("6. Laporan Perpustakaan");
            System.out.println("7. Keluar");
            System.out.println("==============================");

            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    System.out.println("\n===== TAMBAH BUKU =====");

                    System.out.print("Judul: ");
                    String judul = input.nextLine();

                    System.out.print("Penulis: ");
                    String penulis = input.nextLine();

                    System.out.print("Tahun terbit: ");
                    int tahun = input.nextInt();
                    input.nextLine();

                    System.out.print("Kategori: ");
                    String kategori = input.nextLine();

                    // Character
                    char kodeKategori =
                            Character.toUpperCase(
                                kategori.charAt(0)
                            );

                    System.out.println(
                        "Kode kategori: "
                        + kodeKategori
                    );

                    Book bukuBaru =
                            new Book(
                                judul,
                                penulis,
                                tahun,
                                kategori
                            );

                    library.tambahBuku(bukuBaru);

                    System.out.println(
                        "Buku berhasil ditambahkan."
                    );

                    break;

                case 2:

                    library.tampilkanSemuaBuku();

                    break;

                case 3:

                    System.out.print(
                        "Masukkan judul/kategori: "
                    );

                    String keyword =
                            input.nextLine();

                    library.cariBuku(keyword);

                    break;

                case 4:

                    System.out.println(
                        "\n===== PEMINJAMAN BUKU ====="
                    );

                    System.out.print("ID Anggota: ");
                    String idPinjam =
                            input.nextLine();

                    System.out.print("Judul Buku: ");
                    String judulPinjam =
                            input.nextLine();

                    try {

                        library.pinjamBuku(
                            idPinjam,
                            judulPinjam
                        );

                    } catch (
                        BookNotFoundException |
                        BorrowLimitExceededException e
                    ) {

                        System.out.println(
                            "Gagal meminjam: "
                            + e.getMessage()
                        );
                    }

                    break;

                case 5:

                    System.out.println(
                        "\n===== PENGEMBALIAN BUKU ====="
                    );

                    System.out.print("ID Anggota: ");
                    String idKembali =
                            input.nextLine();

                    System.out.print("Judul Buku: ");
                    String judulKembali =
                            input.nextLine();

                    try {

                        library.kembalikanBuku(
                            idKembali,
                            judulKembali
                        );

                    } catch (
                        BookNotFoundException e
                    ) {

                        System.out.println(
                            "Gagal mengembalikan: "
                            + e.getMessage()
                        );
                    }

                    break;

                case 6:

                    library.tampilkanLaporan();

                    break;

                case 7:

                    System.out.println(
                        "Terima kasih telah menggunakan "
                        + "sistem perpustakaan."
                    );

                    break;

                default:

                    System.out.println(
                        "Pilihan menu tidak valid."
                    );
            }

        } while (pilihan != 7);

        input.close();
    }
}