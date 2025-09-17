package week04.marchel.id.ac.umn;

import java.util.Scanner;
import java.util.Arrays;


public class MainTutor{

    static MataKuliah[] matkuls = new MataKuliah[9];
    public static void seedData(){
        matkuls[0] = new MataKuliah("IF402", "Pemograman Berorientasi Objek", 3);
        matkuls[1] = new MataKuliah("IF100", "Dasar - dasar Pemograman", 3);
        matkuls[2] = new MataKuliah("IF534", "Kecerdasan Buatan", 3);
        matkuls[3] = new MataKuliah("CE121", "Linear Aljabar", 3);
        matkuls[4] = new MataKuliah("CE441", "Jaringan Komputer", 3);
        matkuls[5] = new MataKuliah("CE232", "Sistem Digital", 3);
        matkuls[6] = new MataKuliah("UM162", "Pancasila", 3);
        matkuls[7] = new MataKuliah("UM152", "Agama", 3);
        matkuls[8] = new MataKuliah("UM142", "Bahasa Indonesia", 3);
    }

    public static void mainMenu(){
        System.out.println("----- Daftar Mata Kuliah -----");
        System.out.println("1. Lihat semua mata kuliah");
        System.out.println("2. Lihat mata kuliah IF");
        System.out.println("3. Lihat mata kuliah CE");
        System.out.println("4. Lihat mata kuliah UM");

    }

    public static void showData() {
        System.out.println("Daftar Mata Kuliah");
        for (MataKuliah matkul : matkuls) {
            System.out.println("---------------------------------");
            System.out.println("Kode                 :" + matkul.getKode());
            System.out.println("Nama                 :" + matkul.getNama());
            System.out.println("Jumlah SKS           :" + matkul.getSks());
        }
    }
    public static void filterData(String kode) {
        for (MataKuliah matkul : matkuls) {
            if (matkul.getKode().contains(kode)) {
                System.out.println("Kode                 :" + matkul.getKode());
                System.out.println("Nama                 :" + matkul.getNama());
                System.out.println("Jumlah SKS           :" + matkul.getSks());
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        seedData();
        int menu;
        for (;;) {
            mainMenu();
            System.out.print("Pilihan : ");
            menu = in.nextInt();
            in.nextLine();
            switch (menu) {
                case 1:
                    showData();
                    System.out.print("Press enter to continue");
                    in.nextLine();
                    break;
                case 2:
                    filterData("IF");
                    break;
                case 3:
                    filterData("CE");
                    break;
                case 4:
                    filterData("UM");
                    break;
                default:
                    System.out.println("Input Tidak Valid");
            }
        }
    }

}