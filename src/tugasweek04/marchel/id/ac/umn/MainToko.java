package tugasweek04.marchel.id.ac.umn;

import java.util.ArrayList;
import java.util.Scanner;

public class MainToko {
    static ArrayList<Barang> daftarBarang = new ArrayList<>();
    static ArrayList<Order> daftarOrder = new ArrayList<>();

    public static void seedData() {
        daftarBarang.add(new Barang(1, "Pulpen Easy Gel 0.5mm", 120, 2000));
        daftarBarang.add(new Barang(2, "Penggaris 30cm", 30, 5000));
        daftarBarang.add(new Barang(3, "Tipe-x Roller", 30, 7000));
        daftarBarang.add(new Barang(4, "Pensil Mekanik", 50, 5000));
        daftarBarang.add(new Barang(5, "Buku Tulis", 100, 6000));
    }

    public static void mainMenu() {
        System.out.println("------------Menu Toko Multiguna------------");
        System.out.println("1. Pesan Barang");
        System.out.println("2. Lihat Pesanan");
        System.out.print("Pilihan : ");
    }

    public static void showItems() {
        System.out.println("Daftar Barang Toko Multiguna");
        for (Barang b : daftarBarang) {
            System.out.println("ID    : " + b.getId());
            System.out.println("Nama  : " + b.getNama());
            System.out.println("Stock : " + b.getStock());
            System.out.println("Harga : " + b.getHarga());
            System.out.println("-----------------------------------------");
        }
    }

    public static Barang findBarangById(int id) {
        for (Barang b : daftarBarang) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public static void pesanBarang(Scanner in) {
        showItems();
        System.out.println("Ketik 0 untuk batal");
        System.out.print("Pesan Barang (ID) : ");
        int id = in.nextInt();
        in.nextLine();
        if (id == 0) return;
        Barang pilih = findBarangById(id);
        if (pilih == null) {
            System.out.println("ID Barang Tidak Sesuai Pilihan");
            return;
        }
        int qty;
        while (true) {
            System.out.print("Masukkan Jumlah : ");
            qty = in.nextInt();
            in.nextLine();
            if (qty <= 0) {
                System.out.println("Jumlah harus lebih dari 0");
                continue;
            }
            if (qty > pilih.getStock()) {
                System.out.println("Jumlah barang tidak sesuai stock");
                continue;
            }
            break;
        }
        int totalHarga = qty * pilih.getHarga();
        System.out.println(qty + " @ " + pilih.getNama() + " dengan total harga " + totalHarga);
        System.out.print("Masukkan jumlah uang : ");
        int uang = in.nextInt();
        in.nextLine();
        if (uang < totalHarga) {
            System.out.println("Jumlah uang tidak mencukupi");
            return;
        }
        pilih.minusStock(qty);
        Order order = new Order(pilih.getId(), pilih, qty);
        daftarOrder.add(order);
        System.out.println("Berhasil dipesan");
    }

    public static void lihatPesanan() {
        if (daftarOrder.isEmpty()) {
            System.out.println("Belum ada pesanan");
            return;
        }
        System.out.println("Daftar Pesanan Toko Multiguna");
        for (Order o : daftarOrder) {
            System.out.println("ID     : " + o.getBarang().getId());
            System.out.println("Nama   : " + o.getBarang().getNama());
            System.out.println("Jumlah : " + o.getJumlah());
            System.out.println("Total  : " + o.getTotal());
            System.out.println("-----------------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        seedData();
        for (;;) {
            mainMenu();
            int pilihan = in.nextInt();
            in.nextLine();
            switch (pilihan) {
                case 1:
                    pesanBarang(in);
                    break;
                case 2:
                    lihatPesanan();
                    break;
                default:
                    System.out.println("Input Tidak Valid");
            }
        }
    }
}

