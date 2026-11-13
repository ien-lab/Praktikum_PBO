package app;

import model.Mahasiswa;
import model.NilaiInvalidException;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Collection untuk menyimpan objek mahasiswa
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        System.out.println("==================================");
        System.out.println("   PROGRAM PENGELOLAAN NILAI");
        System.out.println("==================================");

        int jumlah;

        // Input jumlah mahasiswa
        while (true) {
            try {
                System.out.print("Masukkan jumlah mahasiswa: ");
                jumlah = Integer.parseInt(input.nextLine());

                if (jumlah <= 0) {
                    System.out.println(
                        "Jumlah mahasiswa harus lebih dari 0!"
                    );
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println(
                    "Input harus berupa bilangan bulat!"
                );
            }
        }

        // Input data mahasiswa
        for (int i = 0; i < jumlah; i++) {

            System.out.println("\nData Mahasiswa ke-" + (i + 1));

            while (true) {
                try {
                    System.out.print("Nama mahasiswa : ");
                    String nama = input.nextLine();

                    System.out.print("NIM mahasiswa  : ");
                    String nim = input.nextLine();

                    System.out.print("Nilai mahasiswa: ");
                    double nilai = Double.parseDouble(
                        input.nextLine()
                    );

                    // Membuat objek mahasiswa
                    Mahasiswa mhs = new Mahasiswa(
                        nama, nim, nilai
                    );

                    // Menambahkan objek ke ArrayList
                    daftarMahasiswa.add(mhs);

                    System.out.println(
                        "Data mahasiswa berhasil ditambahkan!"
                    );

                    break;

                } catch (NilaiInvalidException e) {
                    System.out.println(
                        "Kesalahan nilai: " + e.getMessage()
                    );

                } catch (NumberFormatException e) {
                    System.out.println(
                        "Nilai harus berupa angka!"
                    );

                } catch (IllegalArgumentException e) {
                    System.out.println(
                        "Kesalahan data: " + e.getMessage()
                    );
                }
            }
        }

        // Menghitung statistik kelas
        double totalNilai = 0;
        int jumlahLulus = 0;
        int jumlahTidakLulus = 0;

        System.out.println("\n==================================");
        System.out.println("       REKAPITULASI NILAI");
        System.out.println("==================================");

        for (Mahasiswa mhs : daftarMahasiswa) {

            mhs.tampilkanData();

            System.out.println("----------------------------------");

            totalNilai += mhs.getNilai();

            if (mhs.isLulus()) {
                jumlahLulus++;
            } else {
                jumlahTidakLulus++;
            }
        }

        double rataRata = totalNilai / daftarMahasiswa.size();

        // Menampilkan statistik kelas
        System.out.println("\nJumlah mahasiswa : "
                + daftarMahasiswa.size());

        System.out.println("Rata-rata nilai  : "
                + String.format("%.2f", rataRata));

        System.out.println("Jumlah lulus     : "
                + jumlahLulus);

        System.out.println("Jumlah tidak lulus: "
                + jumlahTidakLulus);

        // Menyimpan laporan ke file
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("laporan_nilai.txt"))) {

            writer.write("==================================");
            writer.newLine();
            writer.write("       LAPORAN NILAI MAHASISWA");
            writer.newLine();
            writer.write("==================================");
            writer.newLine();
            writer.newLine();

            // Menulis data mahasiswa
            for (Mahasiswa mhs : daftarMahasiswa) {

                writer.write("Nama   : " + mhs.getNama());
                writer.newLine();

                writer.write("NIM    : " + mhs.getNim());
                writer.newLine();

                writer.write("Nilai  : " + mhs.getNilai());
                writer.newLine();

                writer.write("Grade  : " + mhs.getGrade());
                writer.newLine();

                writer.write("Status : " +
                    (mhs.isLulus() ? "LULUS" : "TIDAK LULUS"));

                writer.newLine();
                writer.write("----------------------------------");
                writer.newLine();
            }

            // Menulis statistik kelas
            writer.newLine();
            writer.write("STATISTIK KELAS");
            writer.newLine();

            writer.write("Jumlah mahasiswa : "
                    + daftarMahasiswa.size());
            writer.newLine();

            writer.write("Rata-rata nilai  : "
                    + String.format("%.2f", rataRata));
            writer.newLine();

            writer.write("Jumlah lulus     : "
                    + jumlahLulus);
            writer.newLine();

            writer.write("Jumlah tidak lulus: "
                    + jumlahTidakLulus);
            writer.newLine();

            System.out.println(
                "\nLaporan berhasil disimpan ke laporan_nilai.txt"
            );

        } catch (IOException e) {

            System.out.println(
                "Terjadi kesalahan saat menyimpan file: "
                + e.getMessage()
            );

        } finally {

            input.close();

            System.out.println(
                "Program telah selesai dijalankan."
            );
        }
    }
}