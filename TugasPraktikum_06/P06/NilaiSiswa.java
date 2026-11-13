
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class NilaiSiswa {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String nama;
        double nilai;
        double totalNilai = 0;
        double rataRata;

        int jumlahLulus = 0;
        int jumlahTidakLulus = 0;

        System.out.print("Masukkan jumlah siswa: ");
        int jumlahSiswa = input.nextInt();
        input.nextLine();

        // LANGKAH 1: INPUT DATA DAN MENULIS KE FILE
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("laporan_nilai.txt"))) {

            writer.write("===== LAPORAN NILAI SISWA =====");
            writer.newLine();
            writer.write("--------------------------------");
            writer.newLine();

            for (int i = 1; i <= jumlahSiswa; i++) {

                System.out.println("\nData Siswa ke-" + i);

                System.out.print("Nama siswa: ");
                nama = input.nextLine();

                System.out.print("Nilai siswa: ");
                nilai = input.nextDouble();
                input.nextLine();

                totalNilai += nilai;

                String status;

                if (nilai >= 70) {
                    status = "Lulus";
                    jumlahLulus++;
                } else {
                    status = "Tidak Lulus";
                    jumlahTidakLulus++;
                }

                // Menulis data siswa ke file
                writer.write("Nama   : " + nama);
                writer.newLine();

                writer.write("Nilai  : " + nilai);
                writer.newLine();

                writer.write("Status : " + status);
                writer.newLine();

                writer.write("--------------------------------");
                writer.newLine();
            }

            // Menghitung rata-rata nilai
            rataRata = totalNilai / jumlahSiswa;

            // Menulis ringkasan ke file
            writer.write("\n===== RINGKASAN NILAI =====");
            writer.newLine();

            writer.write("Rata-rata nilai kelas : " + rataRata);
            writer.newLine();

            writer.write("Jumlah siswa lulus    : " + jumlahLulus);
            writer.newLine();

            writer.write("Jumlah siswa tidak lulus : "
                    + jumlahTidakLulus);
            writer.newLine();

            System.out.println("\nData berhasil disimpan ke file.");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis file: "
                    + e.getMessage());
            input.close();
            return;
        }

        // LANGKAH 2: MEMBACA KEMBALI ISI FILE
        System.out.println("\n===== ISI FILE LAPORAN NILAI =====");

        try (BufferedReader reader = new BufferedReader(
                new FileReader("laporan_nilai.txt"))) {

            String baris;

            // Membaca file baris demi baris
            while ((baris = reader.readLine()) != null) {
                System.out.println(baris);
            }

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: "
                    + e.getMessage());
        }

        // LANGKAH 3: MENUTUP SCANNER
        input.close();

        System.out.println("\nProses pengelolaan nilai selesai.");
    }
}
