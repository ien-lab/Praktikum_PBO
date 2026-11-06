public class Elektronik extends Produk {
    private int garansi;

    public Elektronik(String id, String nama,
                      double harga, int garansi) {
        super(id, nama, harga);
        this.garansi = garansi;
    }

    public int getGaransi() {
        return garansi;
    }

    public void setGaransi(int garansi) {
        this.garansi = garansi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Jenis       : Elektronik");
        System.out.println("ID Produk   : " + getId());
        System.out.println("Nama        : " + getNama());
        System.out.println("Harga       : Rp" + getHarga());
        System.out.println("Garansi     : " + garansi + " bulan");
    }
}