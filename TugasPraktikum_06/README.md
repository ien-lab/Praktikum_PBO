# Tugas Praktikum 06
Nama  : Indah Rahmadianti
NIM   : L0325029
Kelas : B Informatika PSDKU
Matkul: Pemrograman Berorientasi Objek


## 1. Deskripsi Program

Program ini merupakan aplikasi sederhana berbasis Java dengan pendekatan procedural/fungsional yang digunakan untuk mengelola data nilai siswa. Program menerima input berupa nama dan nilai setiap siswa melalui keyboard, menentukan status kelulusan berdasarkan nilai yang diperoleh, kemudian menyimpan seluruh data ke dalam file teks bernama `laporan_nilai.txt`.

Setelah proses penyimpanan selesai, program membaca kembali isi file tersebut dan menampilkannya ke konsol. Program juga menghasilkan ringkasan berupa rata-rata nilai kelas serta jumlah siswa yang lulus dan tidak lulus.

## 2. Kesesuaian Kode 

Implementasi program telah disesuaikan dengan seluruh tahapan yang diminta dalam soal, yaitu:

1. **Input Console:** Menggunakan `Scanner` untuk menerima jumlah siswa, nama, dan nilai dari pengguna.
2. **Perulangan dan Penentuan Kelulusan:** Menggunakan `for` untuk membaca data setiap siswa serta `if-else` untuk menentukan status kelulusan. Siswa dinyatakan lulus apabila memperoleh nilai ≥ 70.
3. **Penulisan File:** Menggunakan `FileWriter` dan `BufferedWriter` untuk menyimpan data siswa beserta status kelulusan ke dalam `laporan_nilai.txt`.
4. **Ringkasan Nilai:** Menghitung rata-rata nilai kelas serta jumlah siswa yang lulus dan tidak lulus, kemudian menyimpannya pada bagian akhir file.
5. **Pembacaan File:** Menggunakan `FileReader` dan `BufferedReader` untuk membaca kembali isi file baris demi baris menggunakan `readLine()` hingga mencapai akhir file (`null`).
6. **Exception Handling:** Menggunakan `try-catch` untuk menangani kemungkinan kesalahan input/output file serta `try-with-resources` untuk memastikan stream ditutup secara otomatis.

Dengan demikian, program telah menerapkan seluruh kebutuhan utama yang tercantum dalam petunjuk pengerjaan.

## 3. Materi yang Diterapkan

Beberapa konsep pemrograman Java yang diterapkan dalam program ini meliputi:

- **Input/Output (I/O):** Proses menerima masukan dari keyboard dan menampilkan informasi ke konsol.
- **Scanner:** Membaca input pengguna dengan tipe data `String`, `int`, dan `double`.
- **Variabel dan Tipe Data:** Menggunakan variabel untuk menyimpan nama, nilai, jumlah siswa, rata-rata, dan status kelulusan.
- **Percabangan (If-Else):** Menentukan status kelulusan berdasarkan kondisi nilai siswa.
- **Perulangan (For dan While):** Mengulang proses input data siswa dan membaca isi file hingga baris terakhir.
- **File Handling:** Menggunakan `FileWriter`, `BufferedWriter`, `FileReader`, dan `BufferedReader` untuk mengelola file teks.
- **Exception Handling:** Menggunakan `try-catch` untuk menangani kesalahan yang mungkin terjadi selama proses pembacaan dan penulisan file.
- **Try-With-Resources:** Mengelola sumber daya secara otomatis agar writer dan reader ditutup setelah digunakan.
- **Operator Aritmatika:** Melakukan penjumlahan nilai dan menghitung rata-rata kelas.


## 4. Kesimpulan

Program ini menunjukkan penerapan konsep dasar pemrograman Java dalam pengelolaan data menggunakan input/output file. Melalui kombinasi percabangan, perulangan, pengolahan data, dan file handling, program dapat mengelola nilai siswa secara sederhana serta menyimpan hasilnya secara permanen dalam file teks. Implementasi ini juga memperlihatkan pentingnya exception handling dan pengelolaan sumber daya dalam pembuatan program yang lebih terstruktur dan aman.