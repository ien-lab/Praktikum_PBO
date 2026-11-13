package model;

public class Mahasiswa {

    private String nama;
    private String nim;
    private double nilai;

    public static final double FINAL_PASSING_GRADE = 70.0;

    // Constructor
    public Mahasiswa(String nama, String nim, double nilai)
            throws NilaiInvalidException {

        nama = nama.trim().toUpperCase();
        nim = nim.trim();

        // Assertion untuk memastikan NIM tidak kosong
        assert !nim.isEmpty() : "NIM tidak boleh kosong!";

        // Validasi nama
        if (nama.isEmpty()) {
            throw new IllegalArgumentException(
                "Nama tidak boleh kosong!"
            );
        }

        // Validasi NIM
        if (nim.isEmpty()) {
            throw new IllegalArgumentException(
                "NIM tidak boleh kosong!"
            );
        }

        for (int i = 0; i < nim.length(); i++) {
            if (!Character.isDigit(nim.charAt(i))) {
                throw new IllegalArgumentException(
                    "NIM hanya boleh berisi angka!"
                );
            }
        }

        // Validasi nilai menggunakan Custom Exception
        if (nilai < 0 || nilai > 100) {
            throw new NilaiInvalidException(
                "Nilai harus berada di antara 0 sampai 100!"
            );
        }

        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public double getNilai() {
        return nilai;
    }

    // Menentukan grade
    public String getGrade() {

        if (nilai >= 85) {
            return "A";
        } else if (nilai >= 75) {
            return "B";
        } else if (nilai >= 70) {
            return "C";
        } else {
            return "D";
        }
    }

    // Menentukan status kelulusan
    public boolean isLulus() {
        return nilai >= FINAL_PASSING_GRADE;
    }

    // Menampilkan informasi mahasiswa
    public void tampilkanData() {

        System.out.println("Nama   : " + nama);
        System.out.println("NIM    : " + nim);
        System.out.println("Nilai  : " + nilai);
        System.out.println("Grade  : " + getGrade());
        System.out.println("Status : " +
            (isLulus() ? "LULUS" : "TIDAK LULUS"));
    }
}