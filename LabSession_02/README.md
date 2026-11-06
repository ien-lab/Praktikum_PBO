# Lab Session 02 PBO
Nama  : Indah Rahmadianti
NIM   : L0325029
Kelas : B Informatika PSDKU
Matkul: Pemrograman Berorientasi Objek

## 1. Deskripsi Program

Saya memilih program Sistem Toko Online dimana ini adalah aplikasi sederhana berbasis Java yang dirancang untuk mensimulasikan proses pembelian produk secara online. Program ini memungkinkan pengguna untuk melihat katalog produk, memilih barang yang ingin dibeli, menentukan jumlah barang, menghitung total belanja secara otomatis, serta memilih metode pembayaran.

Studi kasus toko online dipilih karena memiliki hubungan yang logis antara objek produk, jenis produk, transaksi, dan proses pembayaran. Dengan demikian, setiap class memiliki tanggung jawab masing-masing sehingga program mempunyai struktur yang lebih terorganisasi dan mudah dikembangkan.

### Hubungan Antarclass

- `Produk` merupakan abstract superclass yang menjadi dasar bagi class `Elektronik` dan `Pakaian`.
- `Elektronik` dan `Pakaian` merupakan subclass yang mewarisi atribut dan method dari `Produk`.
- `Pembayaran` merupakan interface yang diimplementasikan oleh class `Transaksi`.
- `Transaksi` berhubungan dengan class `Produk` untuk menyimpan produk yang dipilih dan menghitung total belanja.
- `Main` menjadi class utama yang membuat objek dan menjalankan keseluruhan proses program.

## 2. Implementasi Konsep Object-Oriented Programming (OOP)

### A. Encapsulation

Encapsulation merupakan konsep OOP yang digunakan untuk melindungi data dalam suatu class agar tidak dapat diakses atau diubah secara langsung dari luar class.

Dalam program ini, encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut tertentu. Akses terhadap atribut dilakukan melalui method getter dan setter.

Contoh penerapannya terdapat pada class `Produk.java`:

```java
private String id;
private String nama;
private double harga;
```

Method getter digunakan untuk mengambil nilai atribut, sedangkan setter digunakan untuk mengubah nilai atribut.

Contohnya:

```java
public String getNama() {
    return nama;
}

public double getHarga() {
    return harga;
}

public void setHarga(double harga) {
    if (harga > 0) {
        this.harga = harga;
    }
}
```

Method `setHarga()` juga memiliki validasi agar harga hanya dapat diubah apabila nilainya lebih besar dari nol.

**Implementasi Encapsulation:**

| Komponen | Implementasi | Fungsi |
|---|---|---|
| Access Modifier | `private` | Melindungi atribut agar tidak diakses secara langsung dari luar class. |
| Getter | `getId()`, `getNama()`, `getHarga()` | Mengambil nilai atribut. |
| Setter | `setNama()`, `setHarga()` | Mengubah nilai atribut melalui method. |
| Validasi | `if (harga > 0)` | Memastikan perubahan harga memenuhi ketentuan. |

Dengan penerapan encapsulation, pengelolaan data produk menjadi lebih terkontrol dan keamanan data dalam program dapat lebih terjaga.

### B. Inheritance

Inheritance merupakan konsep pewarisan yang memungkinkan suatu class memperoleh atribut dan method dari class lain.

Pada program ini, class `Produk` bertindak sebagai superclass, sedangkan `Elektronik` dan `Pakaian` bertindak sebagai subclass.

Penerapan inheritance menggunakan keyword `extends`.

Contoh pada class `Elektronik.java`:

```java
public class Elektronik extends Produk {
    private int garansi;

    public Elektronik(String id, String nama,
                      double harga, int garansi) {
        super(id, nama, harga);
        this.garansi = garansi;
    }
}
```

Contoh pada class `Pakaian.java`:

```java
public class Pakaian extends Produk {
    private String ukuran;

    public Pakaian(String id, String nama,
                   double harga, String ukuran) {
        super(id, nama, harga);
        this.ukuran = ukuran;
    }
}
```

Keyword `super()` digunakan untuk memanggil constructor milik superclass `Produk`, sehingga atribut dasar seperti ID, nama, dan harga dapat diinisialisasi tanpa harus mendeklarasikannya kembali pada setiap subclass.

**Implementasi Inheritance:**

| Komponen | Implementasi | Keterangan |
|---|---|---|
| Superclass | `Produk` | Menyimpan atribut dasar produk. |
| Subclass pertama | `Elektronik` | Mewarisi class Produk dan memiliki atribut garansi. |
| Subclass kedua | `Pakaian` | Mewarisi class Produk dan memiliki atribut ukuran. |
| Keyword | `extends` | Menunjukkan hubungan pewarisan antarclass. |
| Constructor | `super()` | Memanggil constructor superclass. |

Dengan inheritance, kedua jenis produk dapat menggunakan struktur dasar yang sama tanpa perlu menuliskan ulang atribut dan method yang sudah tersedia pada superclass.

### C. Polymorphism

Polymorphism merupakan konsep OOP yang memungkinkan suatu method atau referensi memiliki bentuk perilaku yang berbeda sesuai dengan objek yang menggunakannya.

Dalam program ini, polymorphism diterapkan melalui tiga bentuk, yaitu method overriding, method overloading, dan runtime polymorphism.

**1. Method Overriding**

Method overriding merupakan proses mendefinisikan kembali method dari superclass pada subclass dengan nama dan parameter yang sama.

Dalam program ini, method `tampilkanInfo()` yang dideklarasikan sebagai abstract method pada class `Produk` diimplementasikan kembali oleh class `Elektronik` dan `Pakaian`.

Contoh:

```java
@Override
public void tampilkanInfo() {
    System.out.println("Jenis : Elektronik");
    System.out.println("Nama  : " + getNama());
}
```

Pada class `Pakaian`, method yang sama digunakan untuk menampilkan informasi pakaian, termasuk ukuran produk.

Anotasi `@Override` menunjukkan bahwa method tersebut merupakan implementasi atau penggantian method yang berasal dari superclass.

**2. Method Overloading**

Method overloading merupakan penggunaan nama method yang sama dengan parameter yang berbeda.

Dalam program ini, method overloading diterapkan pada class `Transaksi`.

```java
public void prosesPembayaran(double total) {
    bayar(total, "Transfer Bank");
}

public void prosesPembayaran(double total, String metode) {
    bayar(total, metode);
}
```

Kedua method memiliki nama yang sama, yaitu `prosesPembayaran()`, tetapi mempunyai jumlah parameter yang berbeda.

Method pertama menerima total pembayaran dan secara otomatis menggunakan metode Transfer Bank. Method kedua menerima total pembayaran beserta metode pembayaran yang dipilih pengguna.

**3. Runtime Polymorphism**

Runtime polymorphism merupakan penerapan polymorphism yang memungkinkan pemanggilan method ditentukan berdasarkan jenis objek sebenarnya ketika program dijalankan.

Penerapannya terdapat pada class `Main`:

```java
Produk[] katalog = {
    produk1, produk2, produk3, produk4
};

for (Produk produk : katalog) {
    produk.tampilkanInfo();
}
```

Meskipun array menggunakan tipe referensi `Produk`, objek yang disimpan di dalamnya berasal dari subclass `Elektronik` dan `Pakaian`.

Ketika method `tampilkanInfo()` dipanggil, Java akan menjalankan implementasi sesuai dengan jenis objek sebenarnya.

**Implementasi Polymorphism:**

| Jenis | Implementasi | Fungsi |
|---|---|---|
| Overriding | `tampilkanInfo()` | Menampilkan informasi sesuai jenis produk. |
| Overloading | `prosesPembayaran(double)` | Memproses pembayaran dengan metode default. |
| Overloading | `prosesPembayaran(double, String)` | Memproses pembayaran dengan metode pilihan. |
| Runtime Polymorphism | `Produk[] katalog` | Menyimpan objek dari beberapa subclass dalam satu referensi superclass. |

Dengan polymorphism, program menjadi lebih fleksibel karena satu method atau referensi dapat digunakan untuk menangani berbagai jenis objek.

### D. Abstract Class

Abstract class merupakan class yang tidak dapat dibuat objeknya secara langsung dan digunakan sebagai dasar bagi class turunannya.

Pada program ini, class `Produk` dideklarasikan sebagai abstract class:

```java
public abstract class Produk {
    private String id;
    private String nama;
    private double harga;

    public abstract void tampilkanInfo();
}
```

Class `Produk` memiliki abstract method `tampilkanInfo()` yang tidak mempunyai implementasi di dalam superclass.

Method tersebut wajib diimplementasikan oleh subclass, yaitu `Elektronik` dan `Pakaian`.

Setiap subclass memberikan implementasi yang berbeda sesuai dengan karakteristik produknya.

| Komponen | Implementasi | Keterangan |
|---|---|---|
| Abstract Class | `Produk` | Menjadi dasar pembentukan objek produk. |
| Abstract Method | `tampilkanInfo()` | Method yang harus diimplementasikan subclass. |
| Subclass | `Elektronik` | Menampilkan informasi produk elektronik. |
| Subclass | `Pakaian` | Menampilkan informasi produk pakaian. |

Penggunaan abstract class membantu menciptakan struktur dasar yang sama bagi seluruh jenis produk, tetapi tetap memberikan kebebasan kepada setiap subclass untuk menentukan perilakunya masing-masing.

### E. Interface

Interface merupakan struktur yang digunakan untuk menentukan kontrak berupa method yang harus diimplementasikan oleh class yang menggunakannya.

Dalam program ini, interface `Pembayaran` mendefinisikan method `bayar()`:

```java
public interface Pembayaran {
    void bayar(double total, String metode);
}
```

Interface tersebut kemudian diimplementasikan oleh class `Transaksi` menggunakan keyword `implements`.

```java
public class Transaksi implements Pembayaran {
    @Override
    public void bayar(double total, String metode) {
        System.out.println("Metode pembayaran: " + metode);
        System.out.println("Total pembayaran: " + total);
        System.out.println("Pembayaran berhasil!");
    }
}
```

Method `bayar()` merupakan implementasi dari kontrak yang telah dideklarasikan pada interface `Pembayaran`.

| Komponen | Implementasi | Keterangan |
|---|---|---|
| Interface | `Pembayaran` | Mendefinisikan kontrak pembayaran. |
| Abstract Method | `bayar(double total, String metode)` | Menentukan parameter pembayaran. |
| Implementasi | `Transaksi implements Pembayaran` | Menjalankan kontrak pembayaran. |
| Overriding | `@Override` pada `bayar()` | Mengimplementasikan method interface. |

Dengan interface, proses pembayaran memiliki struktur yang jelas dan dapat dikembangkan untuk mendukung metode pembayaran lainnya.

## 3. Implementasi Input dan Proses Program

Selain menerapkan konsep OOP, program juga menggunakan beberapa fitur dasar Java untuk menjalankan proses pembelian secara interaktif.

### A. Input Pengguna

Program menggunakan class `Scanner` untuk menerima masukan dari pengguna.

```java
Scanner input = new Scanner(System.in);
```

Input digunakan untuk menentukan jumlah jenis produk yang ingin dibeli, nomor produk yang dipilih, jumlah barang, dan metode pembayaran.

### B. Penggunaan Array

Array digunakan untuk menyimpan daftar produk yang tersedia dalam katalog.

```java
Produk[] katalog = {
    produk1, produk2, produk3, produk4
};
```

Pada class `Transaksi`, array `daftarProduk` digunakan untuk menyimpan produk yang dibeli, sedangkan array `jumlahBarang` digunakan untuk menyimpan kuantitas setiap produk.

### C. Penggunaan Perulangan

Perulangan `for` digunakan untuk menampilkan seluruh katalog produk dan memproses pilihan pembelian pengguna.

Contohnya:

```java
for (int i = 0; i < jumlahPilihan; i++) {
    // Proses pemilihan produk
}
```

Perulangan juga digunakan dalam class `Transaksi` untuk menghitung total belanja dan menampilkan isi keranjang.

### D. Penggunaan Percabangan

Percabangan `if-else` digunakan untuk memvalidasi jumlah pilihan produk dan jumlah barang agar sesuai dengan ketentuan.

Sementara itu, `switch-case` digunakan untuk menentukan metode pembayaran berdasarkan pilihan pengguna.

Pilihan metode pembayaran meliputi:

1. Transfer Bank.
2. E-Wallet.
3. Cash on Delivery (COD).

### E. Perhitungan Total Belanja

Total belanja dihitung dengan mengalikan harga setiap produk dengan jumlah barang yang dibeli, kemudian menjumlahkan seluruh subtotal.

Rumus yang digunakan:

**Subtotal = Harga Produk × Jumlah Barang**

**Total Belanja = Σ Subtotal Seluruh Produk**

Perhitungan tersebut diimplementasikan dalam method `hitungTotal()` pada class `Transaksi`.

### F. Format Mata Uang Rupiah

Program menggunakan `NumberFormat` dengan locale Indonesia untuk menampilkan nominal uang dalam format Rupiah.

```java
NumberFormat format = NumberFormat.getInstance(
    new Locale("id", "ID")
);
```

Format tersebut digunakan agar angka ditampilkan menggunakan pemisah ribuan berupa titik sehingga lebih mudah dibaca.

## 4. Contoh Output Program

Berikut merupakan gambaran hasil eksekusi program ketika pengguna memilih produk dan memasukkan jumlah barang sendiri.

```text
================================
       TOKO ONLINE JAVA
================================

Berapa jenis produk yang ingin dibeli? 1

Pilih nomor produk: 1
Masukkan jumlah barang: 2

========== STRUK BELANJA ==========

Produk       : Laptop
Harga        : Rp7.500.000
Jumlah       : 2
Subtotal     : Rp15.000.000

Total belanja: Rp15.000.000

Pilih metode pembayaran:
1. Transfer Bank
2. E-Wallet
3. COD

Pilihan: 1

========== PEMBAYARAN ==========
Metode pembayaran: Transfer Bank
Total pembayaran : Rp15.000.000
Pembayaran berhasil!

Terima kasih telah berbelanja!
```

Output tersebut menunjukkan bahwa program berhasil menerima input pengguna, memproses pilihan produk, menghitung total belanja berdasarkan kuantitas, dan menjalankan proses pembayaran.

## 5. Kesimpulan

Berdasarkan pengembangan program Sistem Toko Online, dapat disimpulkan bahwa konsep Object-Oriented Programming dapat diterapkan untuk membangun program yang terstruktur, terorganisasi, dan memiliki hubungan yang jelas antara setiap komponen.

Konsep encapsulation diterapkan untuk melindungi atribut dan mengatur akses data melalui getter dan setter. Inheritance digunakan untuk membentuk hubungan pewarisan antara class Produk dengan subclass Elektronik dan Pakaian. Polymorphism diterapkan melalui method overriding, method overloading, serta runtime polymorphism sehingga program dapat menangani berbagai jenis produk dengan perilaku yang berbeda.

Selain itu, abstract class Produk digunakan sebagai dasar pembentukan jenis produk, sedangkan interface Pembayaran digunakan untuk menentukan kontrak proses pembayaran yang harus dipenuhi oleh class Transaksi.

Program juga mengintegrasikan penggunaan Scanner, array, perulangan, percabangan, dan perhitungan aritmatika untuk mendukung proses pembelian secara interaktif.
