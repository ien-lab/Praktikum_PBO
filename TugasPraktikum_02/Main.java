import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah siswa: ");
        int jumlahSiswa = input.nextInt();
        input.nextLine();

        Student[] students = new Student[jumlahSiswa];

        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("\nData siswa ke-" + (i + 1) + ":");

            System.out.print("Masukkan nama: ");
            String name = input.nextLine();

            System.out.print("Masukkan nilai: ");
            double score = input.nextDouble();
            input.nextLine();

            students[i] = new Student(name, score);
        }

        for (int i = 0; i < jumlahSiswa; i++) {
            students[i].checkPassed();
        }

        double totalNilai = 0;
        int jumlahLulus = 0;
        int jumlahTidakLulus = 0;

        System.out.println("\n===== DAFTAR NILAI SISWA =====");

        for (int i = 0; i < jumlahSiswa; i++) {
            String status;

            if (students[i].passed) {
                status = "Lulus";
                jumlahLulus++;
            } else {
                status = "Tidak Lulus";
                jumlahTidakLulus++;
            }

            System.out.println(
                "Siswa: " + students[i].name
                + " - Nilai: " + students[i].score
                + " - " + status
            );

            totalNilai += students[i].score;
        }

        double rataRata = totalNilai / jumlahSiswa;

        System.out.printf("\nRata-rata nilai kelas: %.2f\n", rataRata);
        System.out.println("Jumlah siswa lulus: " + jumlahLulus);
        System.out.println("Jumlah siswa tidak lulus: " + jumlahTidakLulus);

        input.close();
    }
}