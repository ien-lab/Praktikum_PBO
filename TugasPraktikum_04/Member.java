package library.model;

import java.util.ArrayList;

public class Member {
    private String id;
    private String nama;
    private ArrayList<Book> daftarPinjaman;

    public Member(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.daftarPinjaman = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public ArrayList<Book> getDaftarPinjaman() {
        return daftarPinjaman;
    }

    public void tambahPinjaman(Book book) {
        daftarPinjaman.add(book);
    }

    public void hapusPinjaman(Book book) {
        daftarPinjaman.remove(book);
    }

    public int jumlahPinjaman() {
        return daftarPinjaman.size();
    }

    @Override
    public String toString() {
        return id + " - " + nama +
               " | Jumlah Pinjaman: " + daftarPinjaman.size();
    }
}