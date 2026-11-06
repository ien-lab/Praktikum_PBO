public class Pakaian extends Produk {
    private String ukuran;

    public Pakaian(String id, String nama,
                    double harga, String ukuran) {
        super(id, nama, harga);
        this.ukuran = ukuran;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Jenis       : Pakaian");
        System.out.println("ID Produk   : " + getId());
        System.out.println("Nama        : " + getNama());
        System.out.println("Harga       : Rp" + getHarga());
        System.out.println("Ukuran      : " + ukuran);
    }
}