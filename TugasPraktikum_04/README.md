# Tugas Praktikum 04 PBO
Nama  : Indah Rahmadianti
NIM   : L0325029
Kelas : B Informatika PSDKU
Matkul: Pemrograman Berorientasi Objek

# Java Mini Library Management System

## 1. Deskripsi Program

**Java Mini Library Management System** merupakan program sederhana berbasis Java yang digunakan untuk mengelola data buku, anggota perpustakaan, proses peminjaman dan pengembalian buku, serta melakukan analisis terhadap koleksi dan aktivitas peminjaman.

Program ini dibuat untuk menerapkan berbagai konsep dasar **Pemrograman Berorientasi Objek (PBO)** dan fitur dasar Java, meliputi *Class*, *Object*, *Method*, *Package*, *Constructor*, *Variable*, tipe data *Primitive* dan *Reference*, struktur kontrol *Conditional* dan *Looping*, *Exception Handling*, *Assertion*, *Character*, serta manipulasi *String*.

Program tidak hanya berfungsi untuk menambah dan menampilkan data buku, tetapi juga menyediakan fitur pencarian buku, pembatasan jumlah peminjaman, pengembalian buku, serta laporan analisis perpustakaan.

---

## 2. Tujuan Program

Tujuan pembuatan program ini adalah:

1. Menerapkan konsep dasar *Object-Oriented Programming* menggunakan bahasa Java.
2. Mengelola data buku dan anggota menggunakan struktur data `ArrayList`.
3. Mengelola riwayat jumlah peminjaman menggunakan `HashMap`.
4. Menerapkan proses pencarian buku berdasarkan judul atau kategori.
5. Menerapkan proses peminjaman dan pengembalian buku.
6. Menerapkan *Exception Handling* untuk menangani kesalahan pada proses transaksi.
7. Menerapkan *Assertion* untuk memastikan data anggota valid sebelum transaksi.
8. Menerapkan manipulasi *String* dan *Character*.
9. Melakukan analisis sederhana terhadap koleksi dan aktivitas perpustakaan.
10. Menghasilkan laporan perpustakaan berdasarkan data yang tersimpan.

---

## 3. Fitur Program

Program memiliki beberapa menu utama:

| No. | Menu                 | Fungsi                                       |
| --- | -------------------- | -------------------------------------------- |
| 1   | Tambah Buku          | Menambahkan data buku baru                   |
| 2   | Daftar Buku          | Menampilkan seluruh buku                     |
| 3   | Cari Buku            | Mencari buku berdasarkan judul atau kategori |
| 4   | Pinjam Buku          | Melakukan transaksi peminjaman buku          |
| 5   | Kembalikan Buku      | Mengembalikan buku yang sedang dipinjam      |
| 6   | Laporan Perpustakaan | Menampilkan hasil analisis perpustakaan      |
| 7   | Keluar               | Mengakhiri program                           |

Selain itu, program memiliki beberapa aturan dalam proses peminjaman, yaitu buku harus tersedia dan setiap anggota maksimal meminjam tiga buku.

---

## 4. Struktur Program

Struktur *package* dan *class* yang digunakan adalah:

```text
library
├── model
│   ├── Book.java
│   └── Member.java
│
├── service
│   └── LibraryService.java
│
├── exception
│   ├── BookNotFoundException.java
│   └── BorrowLimitExceededException.java
│
└── main
    └── MainApp.java
```

### Penjelasan setiap file

#### `Book.java`

Berisi *class* `Book` yang digunakan untuk merepresentasikan data buku.

Atribut yang digunakan:

* `judul`
* `penulis`
* `tahunTerbit`
* `kategori`
* `statusKetersediaan`

Class ini juga memiliki *constructor*, *getter*, *setter*, dan method `toString()` untuk menampilkan informasi buku.

#### `Member.java`

Berisi *class* `Member` yang digunakan untuk merepresentasikan anggota perpustakaan.

Atribut yang digunakan:

* `id`
* `nama`
* `daftarPinjaman`

`daftarPinjaman` menggunakan `ArrayList<Book>` untuk menyimpan buku yang sedang dipinjam oleh anggota.

#### `LibraryService.java`

Merupakan bagian utama yang menangani logika sistem perpustakaan.

Class ini mengelola:

* daftar buku
* daftar anggota
* penambahan buku
* pencarian buku
* peminjaman buku
* pengembalian buku
* analisis kategori
* jumlah transaksi peminjaman
* buku yang paling sering dipinjam
* anggota dengan jumlah pinjaman aktif terbanyak
* kategori dengan jumlah koleksi terbanyak
* laporan perpustakaan

#### `BookNotFoundException.java`

Merupakan *custom exception* yang digunakan untuk menangani kondisi ketika buku tidak ditemukan atau tidak dapat diproses dalam transaksi.

#### `BorrowLimitExceededException.java`

Merupakan *custom exception* yang digunakan ketika anggota telah mencapai batas maksimal tiga buku yang dapat dipinjam.

#### `MainApp.java`

Merupakan class utama yang menjalankan program.

Class ini menggunakan `Scanner` untuk menerima input pengguna dan menyediakan menu interaktif menggunakan `switch` dan `do-while`.

---

## 5. Konsep OOP yang Diterapkan

### 5.1 Class

Class merupakan rancangan yang digunakan untuk membuat objek.

Dalam program ini terdapat beberapa class, yaitu:

```java
Book
Member
LibraryService
MainApp
BookNotFoundException
BorrowLimitExceededException
```

Contohnya:

```java
public class Book {
    ...
}
```

Class `Book` menjadi rancangan untuk membuat objek buku.

---

### 5.2 Object

Object merupakan hasil *instance* dari suatu class.

Contohnya:

```java
Book bukuBaru = new Book(
    judul,
    penulis,
    tahun,
    kategori
);
```

Kode tersebut membuat sebuah objek `Book` berdasarkan data yang diberikan.

Program juga membuat objek anggota:

```java
new Member("M001", "Indah");
```

---

### 5.3 Method

Method merupakan bagian dari class yang digunakan untuk melakukan suatu tindakan atau mengolah data.

Contoh method yang terdapat dalam program:

```java
tambahBuku()
cariBuku()
pinjamBuku()
kembalikanBuku()
tampilkanLaporan()
analisisKategori()
```

Contohnya:

```java
public void tambahBuku(Book book) {
    daftarBuku.add(book);
}
```

Method tersebut digunakan untuk menambahkan objek buku ke dalam daftar buku.

---

### 5.4 Package

Program menggunakan beberapa *package* untuk mengelompokkan class berdasarkan fungsinya.

```text
library.model
library.service
library.exception
library.main
```

Pembagian tersebut membuat struktur program lebih terorganisasi dan memisahkan data, layanan, penanganan kesalahan, serta program utama.

---

### 5.5 Constructor

Constructor digunakan untuk memberikan nilai awal ketika objek dibuat.

Contoh pada `Book`:

```java
public Book(
    String judul,
    String penulis,
    int tahunTerbit,
    String kategori
) {
    this.judul = judul;
    this.penulis = penulis;
    this.tahunTerbit = tahunTerbit;
    this.kategori = kategori;
    this.statusKetersediaan = true;
}
```

Ketika objek `Book` dibuat, data buku langsung diinisialisasi melalui constructor tersebut.

---

### 5.6 Variable

Program menggunakan berbagai variabel untuk menyimpan data.

Contohnya:

```java
private String judul;
private String penulis;
private int tahunTerbit;
private String kategori;
private boolean statusKetersediaan;
```

Variabel tersebut digunakan untuk menyimpan informasi dari setiap objek buku.

---

## 6. Tipe Data yang Digunakan

### 6.1 Primitive Data Type

Program menggunakan beberapa tipe data *primitive*, yaitu:

```java
int
boolean
char
```

Contohnya:

```java
private int tahunTerbit;
private boolean statusKetersediaan;
```

dan:

```java
char kodeKategori;
```

`int` digunakan untuk bilangan bulat, `boolean` digunakan untuk kondisi benar atau salah, sedangkan `char` digunakan untuk menyimpan satu karakter.

---

### 6.2 Reference Data Type

Program juga menggunakan tipe data *reference*, seperti:

```java
String
Book
Member
ArrayList
HashMap
Scanner
```

Contohnya:

```java
private ArrayList<Book> daftarBuku;
```

`ArrayList` digunakan untuk menyimpan kumpulan objek `Book`.

---

## 7. Struktur Data

Program menggunakan dua struktur data utama.

### ArrayList

`ArrayList` digunakan untuk menyimpan daftar buku, daftar anggota, dan daftar pinjaman anggota.

Contoh:

```java
private ArrayList<Book> daftarBuku;
private ArrayList<Member> daftarMember;
```

Daftar pinjaman anggota juga menggunakan:

```java
private ArrayList<Book> daftarPinjaman;
```

### HashMap

`HashMap` digunakan untuk menyimpan jumlah peminjaman berdasarkan judul buku.

```java
private HashMap<String, Integer> riwayatPeminjaman;
```

Contoh data yang dapat disimpan:

```text
"Laskar Pelangi" → 3
"Bumi" → 2
"Pemrograman Java" → 1
```

---

## 8. Struktur Kontrol

### 8.1 Conditional

Program menggunakan `if`, `else`, dan `switch`.

Contoh:

```java
if (buku == null) {
    throw new BookNotFoundException(
        "Buku tidak ditemukan."
    );
}
```

Kondisi tersebut digunakan untuk memeriksa apakah buku ditemukan.

Program juga menggunakan `switch` untuk menentukan menu berdasarkan pilihan pengguna.

---

### 8.2 Looping

Program menggunakan beberapa bentuk *looping*, seperti:

```java
for
do-while
```

Contoh:

```java
for (Book book : daftarBuku) {
    System.out.println(book);
}
```

Digunakan untuk menampilkan buku satu per satu.

Sedangkan `do-while` digunakan untuk menjaga agar menu utama terus ditampilkan sampai pengguna memilih menu keluar.

```java
do {
    ...
} while (pilihan != 7);
```

---

## 9. Exception Handling

Program menggunakan dua *custom exception*:

```text
BookNotFoundException
BorrowLimitExceededException
```

Contoh:

```java
try {
    library.pinjamBuku(idPinjam, judulPinjam);
} catch (BookNotFoundException |
         BorrowLimitExceededException e) {

    System.out.println(
        "Gagal meminjam: " + e.getMessage()
    );
}
```

*Exception handling* digunakan agar kesalahan pada proses peminjaman tidak menyebabkan program langsung berhenti.

Contoh kondisi yang ditangani:

1. Buku tidak ditemukan.
2. Buku sedang tidak tersedia.
3. Anggota telah mencapai batas maksimal tiga buku.

---

## 10. Assertion

Program menggunakan `assert` untuk memastikan anggota yang melakukan transaksi merupakan anggota yang valid.

Contoh:

```java
assert member != null : "Data anggota tidak valid.";
```

Jika data anggota tidak ditemukan, kondisi tersebut menunjukkan bahwa data anggota tidak valid.

Assertion digunakan sebagai pengecekan terhadap kondisi yang seharusnya terpenuhi sebelum proses transaksi dilakukan.

---

## 11. Manipulasi String

Program menerapkan beberapa operasi terhadap `String`.

### `toLowerCase()`

Digunakan dalam pencarian agar pencarian tidak bergantung pada huruf besar atau kecil.

```java
String kataKunci = keyword.toLowerCase();
```

Contohnya, kata:

```text
JAVA
Java
java
```

dapat diproses dalam bentuk huruf kecil.

### `contains()`

Digunakan untuk memeriksa apakah kata kunci terdapat dalam judul atau kategori.

```java
if (judul.contains(kataKunci) ||
    kategori.contains(kataKunci)) {
    ...
}
```

### `equalsIgnoreCase()`

Digunakan untuk membandingkan teks tanpa membedakan huruf besar dan kecil.

```java
member.getId().equalsIgnoreCase(id)
```

dan:

```java
book.getJudul().equalsIgnoreCase(judulBuku)
```

---

## 12. Manipulasi Character

Program juga menerapkan class `Character`.

```java
char kodeKategori =
    Character.toUpperCase(kategori.charAt(0));
```

`charAt(0)` mengambil karakter pertama dari kategori, sedangkan `Character.toUpperCase()` mengubah karakter tersebut menjadi huruf kapital.

Contohnya:

```text
Input kategori : novel
Karakter awal  : n
Kode kategori  : N
```

Dengan demikian, program telah menerapkan fitur `Character` sesuai dengan kebutuhan tugas.

---

# 13. Proses Peminjaman Buku

Proses peminjaman dilakukan dengan beberapa tahap:

```text
Input ID Anggota dan Judul Buku
            ↓
      Cari Anggota
            ↓
      Cari Buku
            ↓
   Buku ditemukan?
       ↓       ↓
      Tidak    Ya
       ↓       ↓
   Exception  Cek status
                  ↓
             Buku tersedia?
              ↓        ↓
             Tidak     Ya
              ↓        ↓
          Exception  Cek jumlah
                         ↓
                 Jumlah < 3?
                   ↓      ↓
                 Tidak    Ya
                   ↓      ↓
               Exception  Pinjam
                            ↓
                    Status = Dipinjam
                            ↓
                 Masuk daftar pinjaman
                            ↓
                    Riwayat + 1
```

Jika seluruh pengecekan berhasil, buku berhasil dipinjam.

---

# 14. Proses Pengembalian Buku

Pengembalian dilakukan dengan mencari buku pada daftar pinjaman anggota.

Jika buku ditemukan:

```java
buku.setStatusKetersediaan(true);
member.hapusPinjaman(buku);
```

Status buku berubah menjadi tersedia dan buku dihapus dari daftar pinjaman anggota.

---

# 15. Analisis dan Laporan

Program menyediakan laporan yang berisi:

### Total transaksi peminjaman

Menghitung jumlah seluruh transaksi peminjaman berdasarkan `riwayatPeminjaman`.

### Buku paling sering dipinjam

Mencari judul buku dengan jumlah peminjaman paling tinggi.

### Anggota paling aktif

Menampilkan anggota dengan jumlah buku yang sedang dipinjam paling banyak.

### Kategori paling populer

Menghitung kategori yang memiliki jumlah koleksi buku paling banyak.

### Jumlah buku per kategori

Menampilkan jumlah buku pada setiap kategori.

---

# 16. Contoh Output Program

## Menu Utama

```text
==============================
   SISTEM PERPUSTAKAAN MINI
==============================
1. Tambah Buku
2. Daftar Buku
3. Cari Buku
4. Pinjam Buku
5. Kembalikan Buku
6. Laporan Perpustakaan
7. Keluar
==============================
Pilih menu:
```

## Daftar Buku

```text
===== DAFTAR BUKU =====
-----------------------
Judul       : Laskar Pelangi
Penulis     : Andrea Hirata
Tahun Terbit: 2005
Kategori    : Novel
Status      : Tersedia

-----------------------
Judul       : Bumi
Penulis     : Tere Liye
Tahun Terbit: 2014
Kategori    : Fantasi
Status      : Tersedia
```

## Pencarian Buku

Contoh pengguna memasukkan:

```text
Masukkan judul/kategori: novel
```

Program akan menampilkan buku yang judul atau kategorinya mengandung kata `novel`.

## Peminjaman Berhasil

```text
===== PEMINJAMAN BUKU =====
ID Anggota: M001
Judul Buku: Laskar Pelangi
Buku berhasil dipinjam.
```

Setelah dipinjam, status buku berubah:

```text
Status      : Dipinjam
```

## Kesalahan Batas Peminjaman

Jika anggota sudah meminjam tiga buku:

```text
Gagal meminjam: Anggota sudah mencapai batas maksimal 3 buku.
```

## Laporan Perpustakaan

Contoh:

```text
==============================
     LAPORAN PERPUSTAKAAN
==============================
Total transaksi peminjaman : 3
Buku paling sering dipinjam : Laskar Pelangi (2 kali)
Anggota paling aktif : Indah (2 buku sedang dipinjam)
Kategori paling populer : novel (2 buku)

===== JUMLAH BUKU PER KATEGORI =====
novel : 2 buku
fantasi : 1 buku
teknologi : 1 buku
```

Output dapat berbeda sesuai dengan transaksi yang dilakukan selama program dijalankan.

---

# 17. Kesesuaian Program dengan Perintah Tugas

| Perintah Tugas                                                                          | Implementasi dalam Program                          |
| --------------------------------------------------------------------------------------- | --------------------------------------------------- |
| Class `Book` dengan atribut judul, penulis, tahun terbit, kategori, status ketersediaan | `Book.java`                                         |
| Constructor pada `Book`                                                                 | Constructor `Book(...)`                             |
| Penyimpanan buku menggunakan `ArrayList`                                                | `ArrayList<Book> daftarBuku`                        |
| Pencarian berdasarkan judul/kategori                                                    | Method `cariBuku()`                                 |
| `toLowerCase()`                                                                         | Digunakan pada pencarian                            |
| `contains()`                                                                            | Digunakan pada pencarian judul/kategori             |
| Menghitung buku setiap kategori                                                         | `analisisKategori()`                                |
| Class `Member`                                                                          | `Member.java`                                       |
| ID dan nama member                                                                      | Atribut `id` dan `nama`                             |
| Daftar pinjaman                                                                         | `ArrayList<Book> daftarPinjaman`                    |
| Peminjaman buku                                                                         | `pinjamBuku()`                                      |
| Pengembalian buku                                                                       | `kembalikanBuku()`                                  |
| Buku tidak ditemukan                                                                    | `BookNotFoundException`                             |
| Batas peminjaman maksimal 3 buku                                                        | `BorrowLimitExceededException`                      |
| Assertion data member                                                                   | `assert member != null`                             |
| Buku paling sering dipinjam                                                             | `bukuPalingSeringDipinjam()`                        |
| Total peminjaman                                                                        | `totalPinjaman()`                                   |
| Anggota paling aktif                                                                    | `anggotaPalingAktif()`                              |
| Kategori paling populer                                                                 | `kategoriPalingPopuler()`                           |
| Interaksi dengan pengguna                                                               | `Scanner`                                           |
| Menu utama                                                                              | `switch`                                            |
| Perulangan menu                                                                         | `do-while`                                          |
| Minimal 2 *custom exception*                                                            | 2 class exception                                   |
| Primitive data type                                                                     | `int`, `boolean`, `char`                            |
| Reference data type                                                                     | `String`, `Book`, `Member`, `ArrayList`, `HashMap`  |
| Character                                                                               | `Character.toUpperCase()`                           |
| String manipulation                                                                     | `toLowerCase()`, `contains()`, `equalsIgnoreCase()` |
| Conditional                                                                             | `if`, `switch`                                      |
| Looping                                                                                 | `for`, `do-while`                                   |
| Package                                                                                 | `model`, `service`, `exception`, `main`             |

---

# 18. Kesimpulan

Program **Java Mini Library Management System** memiliki beberapa class yang dipisahkan berdasarkan fungsinya menggunakan *package*, menggunakan *constructor* dan *object* untuk membentuk data buku dan anggota, serta menggunakan *method* untuk menjalankan berbagai proses sistem.

Selain pengelolaan data buku dan anggota, program juga menerapkan proses peminjaman dan pengembalian dengan validasi, *custom exception*, dan *assertion*. Penggunaan `ArrayList` dan `HashMap` memungkinkan data buku, anggota, daftar pinjaman, serta riwayat peminjaman dikelola secara terstruktur.

Program juga menyediakan fitur pencarian menggunakan manipulasi `String`, penggunaan `Character`, struktur kontrol berupa *conditional* dan *looping*, serta analisis berupa total transaksi, buku yang paling sering dipinjam, anggota dengan jumlah pinjaman aktif terbanyak, dan jumlah koleksi berdasarkan kategori.

