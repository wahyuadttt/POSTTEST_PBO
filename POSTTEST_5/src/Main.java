import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Pembalap> listPembalap = new ArrayList<>();
    static ArrayList<Tim> listTim = new ArrayList<>();
    static ArrayList<JadwalBalap> listJadwal = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static void tampilkanMenuLogin() {
        System.out.println("\n+========================================+");
        System.out.println("|     SISTEM INFORMASI BALAPAN F1        |");
        System.out.println("+========================================+");
        System.out.println("|  1. Login sebagai Admin                |");
        System.out.println("|  2. Login tanpa Akun                   |");
        System.out.println("|  0. Keluar                             |");
        System.out.println("+========================================+");
        System.out.print("Pilih menu: ");
    }

    static boolean loginAdmin() {
        final String USERNAME_ADMIN = "admin";
        final String PASSWORD_ADMIN = "admin";
        int maxCoba = 3;

        System.out.println("\n--- Login Admin ---");
        for (int coba = 1; coba <= maxCoba; coba++) {
            System.out.print("Username : ");
            String username = scanner.nextLine();
            System.out.print("Password : ");
            String password = scanner.nextLine();

            if (username.equals(USERNAME_ADMIN) && password.equals(PASSWORD_ADMIN)) {
                System.out.println("Login berhasil! Selamat datang, Admin.");
                return true;
            } else {
                int sisa = maxCoba - coba;
                if (sisa > 0) {
                    System.out.println("Username atau password salah. Sisa percobaan: " + sisa);
                } else {
                    System.out.println("Login gagal. Terlalu banyak percobaan.");
                }
            }
        }
        return false;
    }

    static void tampilkanMenuAdmin() {
        System.out.println("\n+========================================+");
        System.out.println("|     SISTEM INFORMASI BALAPAN F1        |");
        System.out.println("+========================================+");
        System.out.println("|  1. Kelola Data Pembalap               |");
        System.out.println("|  2. Kelola Data Tim                    |");
        System.out.println("|  3. Kelola Data Jadwal Balapan         |");
        System.out.println("|  0. Logout                             |");
        System.out.println("+========================================+");
        System.out.print("Pilih menu: ");
    }

    static void tampilkanMenuUser() {
        System.out.println("\n+========================================+");
        System.out.println("|     SISTEM INFORMASI BALAPAN F1        |");
        System.out.println("+========================================+");
        System.out.println("|  1. Lihat Data Pembalap                |");
        System.out.println("|  2. Lihat Data Tim                     |");
        System.out.println("|  3. Lihat Jadwal Balapan               |");
        System.out.println("|  0. Logout                             |");
        System.out.println("+========================================+");
        System.out.print("Pilih menu: ");
    }

    static void tampilkanMenuCRUD(String namaData) {
        System.out.println("\n--- Menu " + namaData + " ---");
        System.out.println("1. Tambah ");
        System.out.println("2. Lihat Semua ");
        System.out.println("3. Ubah ");
        System.out.println("4. Hapus ");
        System.out.println("0. Kembali");
        System.out.print("Pilih menu: ");
    }

    static void menuPembalap() {
        boolean kembali = false;
        while (!kembali) {
            tampilkanMenuCRUD("Pembalap");
            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1": Pembalap.tambah(listPembalap, scanner); break;
                case "2": Pembalap.lihatSemua(listPembalap); break;
                case "3": Pembalap.ubah(listPembalap, scanner); break;
                case "4": Pembalap.hapus(listPembalap, scanner); break;
                case "0": kembali = true; break;
                default: System.out.println("Pilihan tidak valid."); break;
            }
        }
    }

    static void menuTim() {
        boolean kembali = false;
        while (!kembali) {
            tampilkanMenuCRUD("Tim");
            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1": Tim.tambah(listTim, scanner); break;
                case "2": Tim.lihatSemua(listTim); break;
                case "3": Tim.ubah(listTim, scanner); break;
                case "4": Tim.hapus(listTim, scanner); break;
                case "0": kembali = true; break;
                default: System.out.println("Pilihan tidak valid."); break;
            }
        }
    }

    static void menuJadwal() {
        boolean kembali = false;
        while (!kembali) {
            tampilkanMenuCRUD("Jadwal Balapan");
            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1": JadwalBalap.tambah(listJadwal, scanner); break;
                case "2": JadwalBalap.lihatSemua(listJadwal); break;
                case "3": JadwalBalap.ubah(listJadwal, scanner); break;
                case "4": JadwalBalap.hapus(listJadwal, scanner); break;
                case "0": kembali = true; break;
                default: System.out.println("Pilihan tidak valid."); break;
            }
        }
    }

    static void sesiAdmin() {
        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuAdmin();
            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1": menuPembalap(); break;
                case "2": menuTim(); break;
                case "3": menuJadwal(); break;
                case "0":
                    System.out.println("Logout berhasil.");
                    berjalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    static void sesiUser() {
        System.out.println("\nSelamat datang User!");
        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuUser();
            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1": Pembalap.lihatSemua(listPembalap); break;
                case "2": Tim.lihatSemua(listTim); break;
                case "3": JadwalBalap.lihatSemua(listJadwal); break;
                case "0":
                    System.out.println("Logout berhasil.");
                    berjalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuLogin();
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    boolean loginBerhasil = loginAdmin();
                    if (loginBerhasil) {
                        sesiAdmin();
                    }
                    break;
                case "2":
                    sesiUser();
                    break;
                case "0":
                    System.out.println("\nTerima kasih! Program selesai.");
                    berjalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }

        scanner.close();
    }
}