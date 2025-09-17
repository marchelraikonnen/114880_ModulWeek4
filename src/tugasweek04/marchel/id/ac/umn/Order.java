package tugasweek04.marchel.id.ac.umn;

public class Order {
    private int id;
    private int jumlah;
    private Barang barang;
    public static int total;
    private int totalOrder;

    public Order() {
    }

    public Order(int id, Barang barang, int jumlah) {
        this.id = id;
        this.barang = barang;
        this.jumlah = jumlah;
        this.totalOrder = jumlah * barang.getHarga();
        Order.total = this.totalOrder;
    }

    public int getId() {
        return id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getTotal() {
        return totalOrder;
    }
}

