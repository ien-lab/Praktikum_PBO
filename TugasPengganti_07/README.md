# Tugas Pengganti Pertemuan 07
Nama  : Indah Rahmadianti
NIM   : L0325029
Kelas : B Informatika PSDKU
Matkul: Pemrograman Berorientasi Objek


## Deskripsi Program
Program ini merupakan aplikasi sederhana berbasis Java yang dibuat untuk mengelola data nilai mahasiswa dengan menerapkan konsep Pemrograman Berorientasi Objek (OOP). Program memungkinkan pengguna memasukkan data mahasiswa melalui konsol, melakukan validasi data, menentukan grade dan status kelulusan, menghitung statistik nilai kelas, serta menyimpan hasil rekapitulasi ke dalam file teks `laporan_nilai.txt`.

## Kesesuaian Program dengan Petunjuk Tugas

Implementasi program telah disesuaikan dengan ketentuan pada soal Pengganti Pertemuan 7, yaitu menggabungkan materi perkuliahan dari Pertemuan 2 sampai Pertemuan 6 dalam satu program Java yang terstruktur.

Program menggunakan pemisahan package `model` untuk menyimpan kelas data dan `app` sebagai tempat kelas utama. Class `Mahasiswa` memiliki atribut nama, NIM, dan nilai, serta constructor untuk menginisialisasi objek. Konstanta `FINAL_PASSING_GRADE` digunakan sebagai standar nilai kelulusan.

Pada proses pengolahan data, program menerapkan percabangan `if-else` untuk menentukan grade dan status kelulusan mahasiswa. Perulangan digunakan untuk menerima, menelusuri, dan menghitung data mahasiswa, termasuk menghitung rata-rata nilai kelas.

Validasi dilakukan menggunakan Custom Exception `NilaiInvalidException` untuk membatasi nilai pada rentang 0–100, serta Assertion untuk memastikan NIM tidak kosong. Manipulasi String dilakukan menggunakan `trim()` dan `toUpperCase()`, sedangkan `Character.isDigit()` digunakan untuk memvalidasi bahwa NIM hanya terdiri dari angka.

Seluruh objek mahasiswa disimpan menggunakan `ArrayList<Mahasiswa>`. Setelah proses pengolahan selesai, program menggunakan `BufferedWriter` dan `FileWriter` untuk menyimpan daftar mahasiswa beserta statistik kelas ke dalam file `laporan_nilai.txt`. Penanganan kesalahan file dilakukan menggunakan mekanisme `try-catch-finally` dan *try-with-resources*.

Dengan demikian, program telah mengimplementasikan komponen utama yang diminta dalam petunjuk tugas.

## Materi yang Diterapkan

Berikut materi perkuliahan yang digunakan dalam program:

| No. | Materi | Implementasi |
|---|---|---|
| 1 | Package dan Class | Package `model` dan `app`, serta class `Mahasiswa` dan `Main`. |
| 2 | Constructor dan Variabel | Constructor untuk inisialisasi objek serta penggunaan `final` sebagai konstanta kelulusan. |
| 3 | Primitive dan Reference Types | Penggunaan `double`, `boolean`, `String`, dan objek `Mahasiswa`. |
| 4 | Conditional Statement | Penggunaan `if-else` untuk menentukan grade dan status kelulusan. |
| 5 | Looping | Penggunaan `for` dan *for-each* untuk input serta pengolahan data. |
| 6 | Exception Handling | Penggunaan `try-catch-finally` dan Custom Exception. |
| 7 | Assertion | Penggunaan `assert` untuk memastikan NIM tidak kosong. |
| 8 | String Manipulation | Penggunaan `trim()` dan `toUpperCase()`. |
| 9 | Character | Penggunaan `Character.isDigit()` untuk validasi NIM. |
| 10 | Collection Framework | Penggunaan `ArrayList<Mahasiswa>` beserta metode `add()` dan `size()`. |
| 11 | Console I/O | Penggunaan `Scanner` untuk menerima input pengguna. |
| 12 | File I/O | Penggunaan `BufferedWriter` dan `FileWriter` untuk menyimpan laporan. |

## Struktur Project

```text
PenggantiPertemuan7/
│
└── src/
    ├── model/
    │   ├── Mahasiswa.java
    │   └── NilaiInvalidException.java
    │
    └── app/
        └── Main.java
```

## Output Program

-==================================
   PROGRAM PENGELOLAAN NILAI
-==================================
Masukkan jumlah mahasiswa: 2

Data Mahasiswa ke-1
Nama mahasiswa : uu
NIM mahasiswa  : P01
Nilai mahasiswa: 77
Kesalahan data: NIM hanya boleh berisi angka!
Nama mahasiswa : uu
NIM mahasiswa  : 001
Nilai mahasiswa: 77
Data mahasiswa berhasil ditambahkan!

Data Mahasiswa ke-2
Nama mahasiswa : ii
NIM mahasiswa  : 002
Nilai mahasiswa: 87
Data mahasiswa berhasil ditambahkan!

-==================================
       REKAPITULASI NILAI
-==================================
Nama   : UU
NIM    : 001
Nilai  : 77.0
Grade  : B
Status : LULUS
.----------------------------------
Nama   : II
NIM    : 002
Nilai  : 87.0
Grade  : A
Status : LULUS
.----------------------------------

Jumlah mahasiswa : 2
Rata-rata nilai  : 82,00
Jumlah lulus     : 2
Jumlah tidak lulus: 0

Laporan berhasil disimpan ke laporan_nilai.txt
Program telah selesai dijalankan.

# Program menghasilkan dua bentuk keluaran:

1. **Console Output:** Menampilkan data mahasiswa, nilai, grade, status kelulusan, rata-rata nilai, serta jumlah mahasiswa yang lulus dan tidak lulus.
2. **File Output:** Menyimpan seluruh data dan statistik kelas secara permanen dalam file `laporan_nilai.txt`.

## Kesimpulan

Program Pengelolaan Nilai Mahasiswa berhasil mengintegrasikan berbagai materi Java dari Pertemuan 2 sampai Pertemuan 6 dalam satu aplikasi sederhana. Melalui program ini, konsep OOP, validasi data, manipulasi String, Collection Framework, serta File I/O diterapkan secara terpadu untuk menghasilkan sistem pengelolaan nilai mahasiswa yang terstruktur dan mudah digunakan.