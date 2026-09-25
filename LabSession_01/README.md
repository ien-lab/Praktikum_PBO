# Praktikum02_PBO
Nama  : Indah Rahmadianti
NIM   : L0325029
Kelas : B Informatika PSDKU
Matkul: Pemrograman Berorientasi Objek

# Deskripsi Sistem:
Sistem Toko Online merupakan program Java sederhana yang mensimulasikan proses pembelian produk secara online. Pengguna dapat melihat daftar produk beserta harga dan stok, memilih produk, menentukan jumlah pembelian, mendapatkan diskon berdasarkan total belanja, menghitung ongkir, serta melakukan pembayaran. Sistem juga melakukan pengecekan terhadap stok dan input pengguna sehingga transaksi dapat diproses dengan lebih aman. 

Penerapan materi pada program:
| No.   | Materi                  | Penerapan dalam Sistem                                                                                                                                                |
| ----- | ----------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **1** | **Class & Object**      | Class `Produk` digunakan untuk merepresentasikan produk. Object `produk1`, `produk2`, dan `produk3` dibuat berdasarkan class tersebut.                                |
| **2** | **Constructor**         | Constructor `Produk(String nama, double harga, int stok)` digunakan untuk memberikan nilai awal nama, harga, dan stok setiap produk.                                  |
| **3** | **Konstanta (`final`)** | Konstanta `ONGKIR`, `BATAS_DISKON`, dan `PERSEN_DISKON` digunakan untuk menyimpan nilai yang bersifat tetap selama program berjalan.                                  |
| **4** | **Kondisional**         | `if`, `else if`, dan `else` digunakan untuk mengecek pilihan produk, jumlah pembelian, ketersediaan stok, pemberian diskon, serta kecukupan uang pembayaran.          |
| **5** | **Looping**             | Perulangan `for` digunakan untuk menampilkan seluruh produk yang tersimpan dalam `ArrayList`.                                                                         |
| **6** | **Exception Handling**  | `try-catch` digunakan untuk menangani kesalahan ketika pengguna memasukkan input yang tidak sesuai, misalnya memasukkan huruf ketika program meminta angka.           |
| **7** | **Character & String**  | Tipe `char` digunakan pada `kategoriToko`, sedangkan `String` digunakan pada `namaToko`. Method `length()` dan `toUpperCase()` digunakan untuk memproses data String. |
| **8** | **Array/Collection**    | `ArrayList<Produk>` digunakan untuk menyimpan beberapa object produk dalam satu collection.                                                                           |
| **9** | **Object & Output**     | Object produk dibuat menggunakan `new Produk(...)` dan hasil proses ditampilkan menggunakan `System.out.println()`.                                                   |


# Output Program:
-----------------------------------------------
            Cihuyy Store
         Kategori: A
-----------------------------------------------
DAFTAR PRODUK:
1. Nama  : Laptop | Harga: Rp7500000 | Stok: 5
2. Nama  : Mouse | Harga: Rp150000 | Stok: 10
3. Nama  : Keyboard | Harga: Rp300000 | Stok: 8

Pilih nomor produk: 3
Produk dipilih: Keyboard
Masukkan jumlah yang ingin dibeli: 5

Selamat! Anda mendapatkan diskon 10%.

----------------------------------------------
              DETAIL PESANAN
----------------------------------------------
Produk          : Keyboard
Harga           : Rp300000
Jumlah          : 5
Subtotal        : Rp1500000
Diskon          : Rp150000
Setelah Diskon  : Rp1350000
Ongkir          : Rp10000
Total Bayar     : Rp1360000
_______________________________________________
Masukkan uang pembayaran: Rp1500000
Uang Bayar      : Rp1500000
Kembalian       : Rp140000
_______________________________________________
       PESANAN BERHASIL DIBUAT!
Terima kasih telah berbelanja di Cihuyy Store.